package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.FocusStrategy;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: android.support.v4.widget.ExploreByTouchHelper.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.valueAt(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.v4.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    private int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    protected abstract int getVirtualViewAt(float f, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    protected abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(view) == 0) {
            ViewCompat.setImportantForAccessibility(view, 1);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
            switch (motionEvent.getAction()) {
                case 7:
                case 9:
                    int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                    updateHoveredVirtualView(virtualViewAt);
                    return virtualViewAt != Integer.MIN_VALUE;
                case 8:
                default:
                    return false;
                case 10:
                    if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
                        updateHoveredVirtualView(Integer.MIN_VALUE);
                        return true;
                    }
                    return false;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        int i = 0;
                        while (i < repeatCount && moveFocus(keyToDirection, null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    }
                    return false;
                case 23:
                case 66:
                    if (KeyEventCompat.hasNoModifiers(keyEvent) && keyEvent.getRepeatCount() == 0) {
                        clickKeyboardFocusedVirtualView();
                        return true;
                    }
                    return false;
                case 61:
                    if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                        return moveFocus(2, null);
                    }
                    if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                        return moveFocus(1, null);
                    }
                    return false;
                default:
                    return false;
            }
        }
        return false;
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private static int keyToDirection(int i) {
        switch (i) {
            case 19:
                return 33;
            case 20:
            default:
                return TransportMediator.KEYCODE_MEDIA_RECORD;
            case 21:
                return 17;
            case 22:
                return 66;
        }
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).getBoundsInParent(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i2 == Integer.MIN_VALUE ? null : allNodes.get(i2);
        switch (i) {
            case 1:
            case 2:
                accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, i, ViewCompat.getLayoutDirection(this.mHost) == 1, false);
                break;
            case 17:
            case 33:
            case 66:
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                Rect rect2 = new Rect();
                if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
                    getBoundsInParent(this.mKeyboardFocusedVirtualViewId, rect2);
                } else if (rect != null) {
                    rect2.set(rect);
                } else {
                    guessPreviouslyFocusedRect(this.mHost, i, rect2);
                }
                accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, rect2, i);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat == null ? Integer.MIN_VALUE : allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat)));
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.put(i, createNodeForChild(i));
        }
        return sparseArrayCompat;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        switch (i) {
            case 17:
                rect.set(width, 0, width, height);
                break;
            case 33:
                rect.set(0, height, width, height);
                break;
            case 66:
                rect.set(-1, 0, -1, height);
                break;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                rect.set(0, -1, width, -1);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        return this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i, 2048);
            AccessibilityEventCompat.setContentChangeTypes(createEvent, i2);
            ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent);
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    protected void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    private void updateHoveredVirtualView(int i) {
        if (this.mHoveredVirtualViewId != i) {
            int i2 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        switch (i) {
            case -1:
                return createEventForHost(i2);
            default:
                return createEventForChild(i, i2);
        }
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        ViewCompat.onInitializeAccessibilityEvent(this.mHost, obtain);
        return obtain;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(obtain);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        asRecord.getText().add(obtainAccessibilityNodeInfo.getText());
        asRecord.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        asRecord.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        asRecord.setPassword(obtainAccessibilityNodeInfo.isPassword());
        asRecord.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        asRecord.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        asRecord.setClassName(obtainAccessibilityNodeInfo.getClassName());
        asRecord.setSource(this.mHost, i);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        return i == -1 ? createNodeForHost() : createNodeForChild(i);
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            obtain.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return obtain;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName("android.view.View");
        obtain.setBoundsInParent(INVALID_PARENT_BOUNDS);
        obtain.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        obtain.setSource(this.mHost, i);
        obtain.setParent(this.mHost);
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            obtain.setAccessibilityFocused(true);
            obtain.addAction(128);
        } else {
            obtain.setAccessibilityFocused(false);
            obtain.addAction(64);
        }
        boolean z = this.mKeyboardFocusedVirtualViewId == i;
        if (z) {
            obtain.addAction(2);
        } else if (obtain.isFocusable()) {
            obtain.addAction(1);
        }
        obtain.setFocused(z);
        if (intersectVisibleToUser(this.mTempParentRect)) {
            obtain.setVisibleToUser(true);
            obtain.setBoundsInParent(this.mTempParentRect);
        }
        obtain.getBoundsInScreen(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
            this.mHost.getLocationOnScreen(this.mTempGlobalRect);
            obtain.getBoundsInParent(this.mTempScreenRect);
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            obtain.setBoundsInScreen(this.mTempScreenRect);
        }
        return obtain;
    }

    boolean performAction(int i, int i2, Bundle bundle) {
        switch (i) {
            case -1:
                return performActionForHost(i2, bundle);
            default:
                return performActionForChild(i, i2, bundle);
        }
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        switch (i2) {
            case 1:
                return requestKeyboardFocusForVirtualView(i);
            case 2:
                return clearKeyboardFocusForVirtualView(i);
            case 64:
                return requestAccessibilityFocus(i);
            case 128:
                return clearAccessibilityFocus(i);
            default:
                return onPerformActionForVirtualView(i, i2, bundle);
        }
    }

    private boolean intersectVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty()) {
            return false;
        }
        if (this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (ViewCompat.getAlpha(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null && this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            return rect.intersect(this.mTempVisibleRect);
        }
        return false;
    }

    private boolean requestAccessibilityFocus(int i) {
        if (this.mManager.isEnabled() && AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager) && this.mAccessibilityFocusedVirtualViewId != i) {
            if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
                clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return false;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        if ((this.mHost.isFocused() || this.mHost.requestFocus()) && this.mKeyboardFocusedVirtualViewId != i) {
            if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return false;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    protected void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* loaded from: classes2.dex */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i));
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i, i2, bundle);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }
    }
}
