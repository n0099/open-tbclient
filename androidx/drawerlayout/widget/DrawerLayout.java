package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements Openable {
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    public static final boolean ALLOW_EDGE_LOCK = false;
    public static final boolean CAN_HIDE_DESCENDANTS;
    public static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    public static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    public static final int MIN_DRAWER_MARGIN = 64;
    public static final int MIN_FLING_VELOCITY = 400;
    public static final int PEEK_DELAY = 160;
    public static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final String TAG = "DrawerLayout";
    public static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    public static boolean sEdgeSizeUsingSystemGestureInsets;
    public final AccessibilityViewCommand mActionDismiss;
    public final ChildAccessibilityDelegate mChildAccessibilityDelegate;
    public Rect mChildHitRect;
    public Matrix mChildInvertedMatrix;
    public boolean mChildrenCanceledTouch;
    public boolean mDrawStatusBarBackground;
    public float mDrawerElevation;
    public int mDrawerState;
    public boolean mFirstLayout;
    public boolean mInLayout;
    public float mInitialMotionX;
    public float mInitialMotionY;
    public Object mLastInsets;
    public final ViewDragCallback mLeftCallback;
    public final ViewDragHelper mLeftDragger;
    @Nullable
    public DrawerListener mListener;
    public List<DrawerListener> mListeners;
    public int mLockModeEnd;
    public int mLockModeLeft;
    public int mLockModeRight;
    public int mLockModeStart;
    public int mMinDrawerMargin;
    public final ArrayList<View> mNonDrawerViews;
    public final ViewDragCallback mRightCallback;
    public final ViewDragHelper mRightDragger;
    public int mScrimColor;
    public float mScrimOpacity;
    public Paint mScrimPaint;
    public Drawable mShadowEnd;
    public Drawable mShadowLeft;
    public Drawable mShadowLeftResolved;
    public Drawable mShadowRight;
    public Drawable mShadowRightResolved;
    public Drawable mShadowStart;
    public Drawable mStatusBarBackground;
    public CharSequence mTitleLeft;
    public CharSequence mTitleRight;
    public static final int[] THEME_ATTRS = {16843828};
    public static final int[] LAYOUT_ATTRS = {16842931};

    /* loaded from: classes.dex */
    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view2);

        void onDrawerOpened(@NonNull View view2);

        void onDrawerSlide(@NonNull View view2, float f);

        void onDrawerStateChanged(int i);
    }

    /* loaded from: classes.dex */
    public static abstract class SimpleDrawerListener implements DrawerListener {
        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view2) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view2, float f) {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i) {
        }
    }

    /* loaded from: classes.dex */
    public class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final Rect mTmpRect = new Rect();

        public AccessibilityDelegate() {
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.includeChildForAccessibility(childAt)) {
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View findVisibleDrawer = DrawerLayout.this.findVisibleDrawer();
                if (findVisibleDrawer != null) {
                    CharSequence drawerTitle = DrawerLayout.this.getDrawerTitle(DrawerLayout.this.getDrawerViewAbsoluteGravity(findVisibleDrawer));
                    if (drawerTitle != null) {
                        text.add(drawerTitle);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.CAN_HIDE_DESCENDANTS) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
                super.onInitializeAccessibilityNodeInfo(view2, obtain);
                accessibilityNodeInfoCompat.setSource(view2);
                ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view2);
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
                }
                copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
                obtain.recycle();
                addChildrenForAccessibility(accessibilityNodeInfoCompat, (ViewGroup) view2);
            }
            accessibilityNodeInfoCompat.setClassName(DrawerLayout.ACCESSIBILITY_CLASS_NAME);
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setFocused(false);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
            if (!DrawerLayout.CAN_HIDE_DESCENDANTS && !DrawerLayout.includeChildForAccessibility(view2)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int FLAG_IS_CLOSING = 4;
        public static final int FLAG_IS_OPENED = 1;
        public static final int FLAG_IS_OPENING = 2;
        public int gravity;
        public boolean isPeeking;
        public float onScreen;
        public int openState;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            this(i, i2);
            this.gravity = i3;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = 0;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }
    }

    /* loaded from: classes.dex */
    public class ViewDragCallback extends ViewDragHelper.Callback {
        public final int mAbsGravity;
        public ViewDragHelper mDragger;
        public final Runnable mPeekRunnable = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.peekDrawer();
            }
        };

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean onEdgeLock(int i) {
            return false;
        }

        public ViewDragCallback(int i) {
            this.mAbsGravity = i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeDragStarted(int i, int i2) {
            View findDrawerWithGravity;
            if ((i & 1) == 1) {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
            } else {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
            }
            if (findDrawerWithGravity != null && DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) == 0) {
                this.mDragger.captureChildView(findDrawerWithGravity, i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view2, int i) {
            ((LayoutParams) view2.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view2, int i) {
            if (DrawerLayout.this.isDrawerView(view2) && DrawerLayout.this.checkDrawerViewAbsoluteGravity(view2, this.mAbsGravity) && DrawerLayout.this.getDrawerLockMode(view2) == 0) {
                return true;
            }
            return false;
        }

        private void closeOtherDrawer() {
            int i = 3;
            if (this.mAbsGravity == 3) {
                i = 5;
            }
            View findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(i);
            if (findDrawerWithGravity != null) {
                DrawerLayout.this.closeDrawer(findDrawerWithGravity);
            }
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view2, int i, int i2) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view2, 3)) {
                return Math.max(-view2.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view2.getWidth(), Math.min(i, width));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view2, int i, int i2) {
            return view2.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view2) {
            if (DrawerLayout.this.isDrawerView(view2)) {
                return view2.getWidth();
            }
            return 0;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            DrawerLayout.this.updateDrawerState(i, this.mDragger.getCapturedView());
        }

        public void setDragger(ViewDragHelper viewDragHelper) {
            this.mDragger = viewDragHelper;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view2, int i, int i2, int i3, int i4) {
            float width;
            int i5;
            int width2 = view2.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view2, 3)) {
                width = i + width2;
            } else {
                width = DrawerLayout.this.getWidth() - i;
            }
            float f = width / width2;
            DrawerLayout.this.setDrawerViewOffset(view2, f);
            if (f == 0.0f) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            view2.setVisibility(i5);
            DrawerLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view2, float f, float f2) {
            int i;
            float drawerViewOffset = DrawerLayout.this.getDrawerViewOffset(view2);
            int width = view2.getWidth();
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(view2, 3)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 <= 0 && (i2 != 0 || drawerViewOffset <= 0.5f)) {
                    i = -width;
                } else {
                    i = 0;
                }
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f < 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.mDragger.settleCapturedViewAt(i, view2.getTop());
            DrawerLayout.this.invalidate();
        }

        public void peekDrawer() {
            boolean z;
            View findDrawerWithGravity;
            int width;
            int edgeSize = this.mDragger.getEdgeSize();
            int i = 0;
            if (this.mAbsGravity == 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(3);
                if (findDrawerWithGravity != null) {
                    i = -findDrawerWithGravity.getWidth();
                }
                width = i + edgeSize;
            } else {
                findDrawerWithGravity = DrawerLayout.this.findDrawerWithGravity(5);
                width = DrawerLayout.this.getWidth() - edgeSize;
            }
            if (findDrawerWithGravity != null) {
                if (((z && findDrawerWithGravity.getLeft() < width) || (!z && findDrawerWithGravity.getLeft() > width)) && DrawerLayout.this.getDrawerLockMode(findDrawerWithGravity) == 0) {
                    this.mDragger.smoothSlideViewTo(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
                    ((LayoutParams) findDrawerWithGravity.getLayoutParams()).isPeeking = true;
                    DrawerLayout.this.invalidate();
                    closeOtherDrawer();
                    DrawerLayout.this.cancelChildViewTouch();
                }
            }
        }
    }

    static {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (Build.VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        CAN_HIDE_DESCENDANTS = z;
        if (Build.VERSION.SDK_INT >= 21) {
            z2 = true;
        } else {
            z2 = false;
        }
        SET_DRAWER_SHADOW_FROM_ELEVATION = z2;
        if (Build.VERSION.SDK_INT < 29) {
            z3 = false;
        }
        sEdgeSizeUsingSystemGestureInsets = z3;
    }

    /* loaded from: classes.dex */
    public static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
            if (!DrawerLayout.includeChildForAccessibility(view2)) {
                accessibilityNodeInfoCompat.setParent(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.drawerlayout.widget.DrawerLayout.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        };
        public int lockModeEnd;
        public int lockModeLeft;
        public int lockModeRight;
        public int lockModeStart;
        public int openDrawerGravity;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.openDrawerGravity = 0;
            this.openDrawerGravity = parcel.readInt();
            this.lockModeLeft = parcel.readInt();
            this.lockModeRight = parcel.readInt();
            this.lockModeStart = parcel.readInt();
            this.lockModeEnd = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.openDrawerGravity);
            parcel.writeInt(this.lockModeLeft);
            parcel.writeInt(this.lockModeRight);
            parcel.writeInt(this.lockModeStart);
            parcel.writeInt(this.lockModeEnd);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
            this.openDrawerGravity = 0;
        }
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public static String gravityToString(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    public static boolean hasOpaqueBackground(View view2) {
        Drawable background = view2.getBackground();
        if (background == null || background.getOpacity() != -1) {
            return false;
        }
        return true;
    }

    public static boolean includeChildForAccessibility(View view2) {
        if (ViewCompat.getImportantForAccessibility(view2) != 4 && ViewCompat.getImportantForAccessibility(view2) != 2) {
            return true;
        }
        return false;
    }

    private void updateChildAccessibilityAction(View view2) {
        ViewCompat.removeAccessibilityAction(view2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS.getId());
        if (isDrawerOpen(view2) && getDrawerLockMode(view2) != 2) {
            ViewCompat.replaceAccessibilityAction(view2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, this.mActionDismiss);
        }
    }

    public void addDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener == null) {
            return;
        }
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(drawerListener);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
            return true;
        }
        return false;
    }

    public void closeDrawer(int i) {
        closeDrawer(i, true);
    }

    public View findDrawerWithGravity(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((getDrawerViewAbsoluteGravity(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getDrawerLockMode(@NonNull View view2) {
        if (isDrawerView(view2)) {
            return getDrawerLockMode(((LayoutParams) view2.getLayoutParams()).gravity);
        }
        throw new IllegalArgumentException("View " + view2 + " is not a drawer");
    }

    @Nullable
    public CharSequence getDrawerTitle(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            return this.mTitleLeft;
        }
        if (absoluteGravity == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    public int getDrawerViewAbsoluteGravity(View view2) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) view2.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    public float getDrawerViewOffset(View view2) {
        return ((LayoutParams) view2.getLayoutParams()).onScreen;
    }

    public boolean isContentView(View view2) {
        if (((LayoutParams) view2.getLayoutParams()).gravity == 0) {
            return true;
        }
        return false;
    }

    public boolean isDrawerOpen(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerOpen(findDrawerWithGravity);
        }
        return false;
    }

    public boolean isDrawerView(View view2) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((LayoutParams) view2.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(view2));
        if ((absoluteGravity & 3) != 0 || (absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    public boolean isDrawerVisible(int i) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            return isDrawerVisible(findDrawerWithGravity);
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Object obj;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            if (Build.VERSION.SDK_INT >= 21 && (obj = this.mLastInsets) != null) {
                i = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        resolveShadowDrawables();
    }

    public void openDrawer(int i) {
        openDrawer(i, true);
    }

    public void removeDrawerListener(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener == null || (list = this.mListeners) == null) {
            return;
        }
        list.remove(drawerListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            closeDrawers(true);
        }
    }

    public void setDrawerElevation(float f) {
        this.mDrawerElevation = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt)) {
                ViewCompat.setElevation(childAt, this.mDrawerElevation);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.mListener;
        if (drawerListener2 != null) {
            removeDrawerListener(drawerListener2);
        }
        if (drawerListener != null) {
            addDrawerListener(drawerListener);
        }
        this.mListener = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setScrimColor(@ColorInt int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = ContextCompat.getDrawable(getContext(), i);
        } else {
            drawable = null;
        }
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.mStatusBarBackground = new ColorDrawable(i);
        invalidate();
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040287);
    }

    private void mirror(Drawable drawable, int i) {
        if (drawable != null && DrawableCompat.isAutoMirrored(drawable)) {
            DrawableCompat.setLayoutDirection(drawable, i);
        }
    }

    private void updateChildrenImportantForAccessibility(View view2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !isDrawerView(childAt)) || (z && childAt == view2)) {
                ViewCompat.setImportantForAccessibility(childAt, 1);
            } else {
                ViewCompat.setImportantForAccessibility(childAt, 4);
            }
        }
    }

    public boolean checkDrawerViewAbsoluteGravity(View view2, int i) {
        if ((getDrawerViewAbsoluteGravity(view2) & i) == i) {
            return true;
        }
        return false;
    }

    public void closeDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            closeDrawer(findDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }

    public void dispatchOnDrawerSlide(View view2, float f) {
        List<DrawerListener> list = this.mListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mListeners.get(size).onDrawerSlide(view2, f);
            }
        }
    }

    public void moveDrawerToOffset(View view2, float f) {
        float drawerViewOffset = getDrawerViewOffset(view2);
        float width = view2.getWidth();
        int i = ((int) (width * f)) - ((int) (drawerViewOffset * width));
        if (!checkDrawerViewAbsoluteGravity(view2, 3)) {
            i = -i;
        }
        view2.offsetLeftAndRight(i);
        setDrawerViewOffset(view2, f);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && hasVisibleDrawer()) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View findVisibleDrawer = findVisibleDrawer();
            if (findVisibleDrawer != null && getDrawerLockMode(findVisibleDrawer) == 0) {
                closeDrawers();
            }
            if (findVisibleDrawer != null) {
                return true;
            }
            return false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void openDrawer(int i, boolean z) {
        View findDrawerWithGravity = findDrawerWithGravity(i);
        if (findDrawerWithGravity != null) {
            openDrawer(findDrawerWithGravity, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(i));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setChildInsets(Object obj, boolean z) {
        boolean z2;
        this.mLastInsets = obj;
        this.mDrawStatusBarBackground = z;
        if (!z && getBackground() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setDrawerLockMode(int i, @NonNull View view2) {
        if (isDrawerView(view2)) {
            setDrawerLockMode(i, ((LayoutParams) view2.getLayoutParams()).gravity);
            return;
        }
        throw new IllegalArgumentException("View " + view2 + " is not a drawer with appropriate layout_gravity");
    }

    public void setDrawerShadow(@DrawableRes int i, int i2) {
        setDrawerShadow(ContextCompat.getDrawable(getContext(), i), i2);
    }

    public void setDrawerTitle(int i, @Nullable CharSequence charSequence) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 3) {
            this.mTitleLeft = charSequence;
        } else if (absoluteGravity == 5) {
            this.mTitleRight = charSequence;
        }
    }

    public void setDrawerViewOffset(View view2, float f) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (f == layoutParams.onScreen) {
            return;
        }
        layoutParams.onScreen = f;
        dispatchOnDrawerSlide(view2, f);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
        this.mScrimColor = -1728053248;
        this.mScrimPaint = new Paint();
        this.mFirstLayout = true;
        this.mLockModeLeft = 3;
        this.mLockModeRight = 3;
        this.mLockModeStart = 3;
        this.mLockModeEnd = 3;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        this.mActionDismiss = new AccessibilityViewCommand() { // from class: androidx.drawerlayout.widget.DrawerLayout.1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view2, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                if (DrawerLayout.this.isDrawerOpen(view2) && DrawerLayout.this.getDrawerLockMode(view2) != 2) {
                    DrawerLayout.this.closeDrawer(view2);
                    return true;
                }
                return false;
            }
        };
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        this.mLeftCallback = new ViewDragCallback(3);
        this.mRightCallback = new ViewDragCallback(5);
        ViewDragHelper create = ViewDragHelper.create(this, 1.0f, this.mLeftCallback);
        this.mLeftDragger = create;
        create.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(f2);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        ViewDragHelper create2 = ViewDragHelper.create(this, 1.0f, this.mRightCallback);
        this.mRightDragger = create2;
        create2.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(f2);
        this.mRightCallback.setDragger(this.mRightDragger);
        setFocusableInTouchMode(true);
        ViewCompat.setImportantForAccessibility(this, 1);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: androidx.drawerlayout.widget.DrawerLayout.2
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        boolean z;
                        DrawerLayout drawerLayout = (DrawerLayout) view2;
                        if (windowInsets.getSystemWindowInsetTop() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        drawerLayout.setChildInsets(windowInsets, z);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(THEME_ATTRS);
                try {
                    this.mStatusBarBackground = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.drawerlayout.R.styleable.DrawerLayout, i, 0);
        try {
            if (obtainStyledAttributes2.hasValue(0)) {
                this.mDrawerElevation = obtainStyledAttributes2.getDimension(0, 0.0f);
            } else {
                this.mDrawerElevation = getResources().getDimension(R.dimen.obfuscated_res_0x7f0702a4);
            }
            obtainStyledAttributes2.recycle();
            this.mNonDrawerViews = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        int height = getHeight();
        boolean isContentView = isContentView(view2);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (isContentView) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view2 && childAt.getVisibility() == 0 && hasOpaqueBackground(childAt) && isDrawerView(childAt) && childAt.getHeight() >= height) {
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view2, j);
        canvas.restoreToCount(save);
        float f = this.mScrimOpacity;
        if (f > 0.0f && isContentView) {
            int i4 = this.mScrimColor;
            this.mScrimPaint.setColor((i4 & 16777215) | (((int) ((((-16777216) & i4) >>> 24) * f)) << 24));
            canvas.drawRect(i, 0.0f, width, getHeight(), this.mScrimPaint);
        } else if (this.mShadowLeftResolved != null && checkDrawerViewAbsoluteGravity(view2, 3)) {
            int intrinsicWidth = this.mShadowLeftResolved.getIntrinsicWidth();
            int right2 = view2.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.mLeftDragger.getEdgeSize(), 1.0f));
            this.mShadowLeftResolved.setBounds(right2, view2.getTop(), intrinsicWidth + right2, view2.getBottom());
            this.mShadowLeftResolved.setAlpha((int) (max * 255.0f));
            this.mShadowLeftResolved.draw(canvas);
        } else if (this.mShadowRightResolved != null && checkDrawerViewAbsoluteGravity(view2, 5)) {
            int intrinsicWidth2 = this.mShadowRightResolved.getIntrinsicWidth();
            int left2 = view2.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.mRightDragger.getEdgeSize(), 1.0f));
            this.mShadowRightResolved.setBounds(left2 - intrinsicWidth2, view2.getTop(), left2, view2.getBottom());
            this.mShadowRightResolved.setAlpha((int) (max2 * 255.0f));
            this.mShadowRightResolved.draw(canvas);
        }
        return drawChild;
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view2) {
        if (!view2.getMatrix().isIdentity()) {
            MotionEvent transformedMotionEvent = getTransformedMotionEvent(motionEvent, view2);
            boolean dispatchGenericMotionEvent = view2.dispatchGenericMotionEvent(transformedMotionEvent);
            transformedMotionEvent.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view2.getLeft();
        float scrollY = getScrollY() - view2.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view2.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view2) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view2.getLeft(), getScrollY() - view2.getTop());
        Matrix matrix = view2.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.mChildInvertedMatrix == null) {
                this.mChildInvertedMatrix = new Matrix();
            }
            matrix.invert(this.mChildInvertedMatrix);
            obtain.transform(this.mChildInvertedMatrix);
        }
        return obtain;
    }

    private boolean hasPeekingDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isPeeking) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        if (findVisibleDrawer() != null) {
            return true;
        }
        return false;
    }

    private Drawable resolveLeftShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowStart;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (layoutDirection == 0) {
            Drawable drawable = this.mShadowEnd;
            if (drawable != null) {
                mirror(drawable, layoutDirection);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                mirror(drawable2, layoutDirection);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        this.mShadowLeftResolved = resolveLeftShadow();
        this.mShadowRightResolved = resolveRightShadow();
    }

    public void cancelChildViewTouch() {
        if (!this.mChildrenCanceledTouch) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    @Override // androidx.customview.widget.Openable
    public void close() {
        if (getDrawerLockMode(GravityCompat.START) != 2) {
            closeDrawer(GravityCompat.START);
        }
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).onScreen);
        }
        this.mScrimOpacity = f;
        boolean continueSettling = this.mLeftDragger.continueSettling(true);
        boolean continueSettling2 = this.mRightDragger.continueSettling(true);
        if (continueSettling || continueSettling2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public View findOpenDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).openState & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public View findVisibleDrawer() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (isDrawerView(childAt) && isDrawerVisible(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public float getDrawerElevation() {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    @Override // androidx.customview.widget.Openable
    public boolean isOpen() {
        return isDrawerOpen(GravityCompat.START);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    @Override // androidx.customview.widget.Openable
    public void open() {
        if (getDrawerLockMode(GravityCompat.START) != 1) {
            openDrawer(GravityCompat.START);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    private boolean isInBoundsOfChild(float f, float f2, View view2) {
        if (this.mChildHitRect == null) {
            this.mChildHitRect = new Rect();
        }
        view2.getHitRect(this.mChildHitRect);
        return this.mChildHitRect.contains((int) f, (int) f2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view2, i, layoutParams);
        if (findOpenDrawer() == null && !isDrawerView(view2)) {
            ViewCompat.setImportantForAccessibility(view2, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view2, 4);
        }
        if (!CAN_HIDE_DESCENDANTS) {
            ViewCompat.setAccessibilityDelegate(view2, this.mChildAccessibilityDelegate);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (isDrawerView(childAt)) {
                if (isDrawerOpen(childAt)) {
                    childAt.addFocusables(arrayList, i, i2);
                    z = true;
                }
            } else {
                this.mNonDrawerViews.add(childAt);
            }
        }
        if (!z) {
            int size = this.mNonDrawerViews.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view2 = this.mNonDrawerViews.get(i4);
                if (view2.getVisibility() == 0) {
                    view2.addFocusables(arrayList, i, i2);
                }
            }
        }
        this.mNonDrawerViews.clear();
    }

    public void closeDrawer(@NonNull View view2) {
        closeDrawer(view2, true);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean isDrawerOpen(@NonNull View view2) {
        if (isDrawerView(view2)) {
            if ((((LayoutParams) view2.getLayoutParams()).openState & 1) == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view2 + " is not a drawer");
    }

    public void openDrawer(@NonNull View view2) {
        openDrawer(view2, true);
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.mStatusBarBackground = drawable;
        invalidate();
    }

    public void closeDrawer(@NonNull View view2, boolean z) {
        if (isDrawerView(view2)) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.onScreen = 0.0f;
                layoutParams.openState = 0;
            } else if (z) {
                layoutParams.openState |= 4;
                if (checkDrawerViewAbsoluteGravity(view2, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view2, -view2.getWidth(), view2.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view2, getWidth(), view2.getTop());
                }
            } else {
                moveDrawerToOffset(view2, 0.0f);
                updateDrawerState(0, view2);
                view2.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view2 + " is not a sliding drawer");
    }

    public void openDrawer(@NonNull View view2, boolean z) {
        if (isDrawerView(view2)) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.mFirstLayout) {
                layoutParams.onScreen = 1.0f;
                layoutParams.openState = 1;
                updateChildrenImportantForAccessibility(view2, true);
                updateChildAccessibilityAction(view2);
            } else if (z) {
                layoutParams.openState |= 2;
                if (checkDrawerViewAbsoluteGravity(view2, 3)) {
                    this.mLeftDragger.smoothSlideViewTo(view2, 0, view2.getTop());
                } else {
                    this.mRightDragger.smoothSlideViewTo(view2, getWidth() - view2.getWidth(), view2.getTop());
                }
            } else {
                moveDrawerToOffset(view2, 1.0f);
                updateDrawerState(0, view2);
                view2.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view2 + " is not a sliding drawer");
    }

    public void closeDrawers(boolean z) {
        boolean smoothSlideViewTo;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (isDrawerView(childAt) && (!z || layoutParams.isPeeking)) {
                int width = childAt.getWidth();
                if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                    smoothSlideViewTo = this.mLeftDragger.smoothSlideViewTo(childAt, -width, childAt.getTop());
                } else {
                    smoothSlideViewTo = this.mRightDragger.smoothSlideViewTo(childAt, getWidth(), childAt.getTop());
                }
                z2 |= smoothSlideViewTo;
                layoutParams.isPeeking = false;
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() != 10 && this.mScrimOpacity > 0.0f) {
            int childCount = getChildCount();
            if (childCount != 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                for (int i = childCount - 1; i >= 0; i--) {
                    View childAt = getChildAt(i);
                    if (isInBoundsOfChild(x, y, childAt) && !isContentView(childAt) && dispatchTransformedGenericPointerEvent(motionEvent, childAt)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public int getDrawerLockMode(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        if (i != 3) {
            if (i != 5) {
                if (i != 8388611) {
                    if (i == 8388613) {
                        int i6 = this.mLockModeEnd;
                        if (i6 != 3) {
                            return i6;
                        }
                        if (layoutDirection == 0) {
                            i5 = this.mLockModeRight;
                        } else {
                            i5 = this.mLockModeLeft;
                        }
                        if (i5 != 3) {
                            return i5;
                        }
                        return 0;
                    }
                    return 0;
                }
                int i7 = this.mLockModeStart;
                if (i7 != 3) {
                    return i7;
                }
                if (layoutDirection == 0) {
                    i4 = this.mLockModeLeft;
                } else {
                    i4 = this.mLockModeRight;
                }
                if (i4 != 3) {
                    return i4;
                }
                return 0;
            }
            int i8 = this.mLockModeRight;
            if (i8 != 3) {
                return i8;
            }
            if (layoutDirection == 0) {
                i3 = this.mLockModeEnd;
            } else {
                i3 = this.mLockModeStart;
            }
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        int i9 = this.mLockModeLeft;
        if (i9 != 3) {
            return i9;
        }
        if (layoutDirection == 0) {
            i2 = this.mLockModeStart;
        } else {
            i2 = this.mLockModeEnd;
        }
        if (i2 != 3) {
            return i2;
        }
        return 0;
    }

    public void dispatchOnDrawerClosed(View view2) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if ((layoutParams.openState & 1) == 1) {
            layoutParams.openState = 0;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerClosed(view2);
                }
            }
            updateChildrenImportantForAccessibility(view2, false);
            updateChildAccessibilityAction(view2);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    public void dispatchOnDrawerOpened(View view2) {
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if ((layoutParams.openState & 1) == 0) {
            layoutParams.openState = 1;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerOpened(view2);
                }
            }
            updateChildrenImportantForAccessibility(view2, true);
            updateChildAccessibilityAction(view2);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public boolean isDrawerVisible(@NonNull View view2) {
        if (isDrawerView(view2)) {
            if (((LayoutParams) view2.getLayoutParams()).onScreen > 0.0f) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("View " + view2 + " is not a drawer");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View findDrawerWithGravity;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i = savedState.openDrawerGravity;
        if (i != 0 && (findDrawerWithGravity = findDrawerWithGravity(i)) != null) {
            openDrawer(findDrawerWithGravity);
        }
        int i2 = savedState.lockModeLeft;
        if (i2 != 3) {
            setDrawerLockMode(i2, 3);
        }
        int i3 = savedState.lockModeRight;
        if (i3 != 3) {
            setDrawerLockMode(i3, 5);
        }
        int i4 = savedState.lockModeStart;
        if (i4 != 3) {
            setDrawerLockMode(i4, GravityCompat.START);
        }
        int i5 = savedState.lockModeEnd;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388613);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        boolean shouldInterceptTouchEvent = this.mLeftDragger.shouldInterceptTouchEvent(motionEvent) | this.mRightDragger.shouldInterceptTouchEvent(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.mLeftDragger.checkTouchSlop(3)) {
                        this.mLeftCallback.removeCallbacks();
                        this.mRightCallback.removeCallbacks();
                    }
                }
                z = false;
            }
            closeDrawers(true);
            this.mChildrenCanceledTouch = false;
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mScrimOpacity > 0.0f && (findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x, (int) y)) != null && isContentView(findTopChildUnder)) {
                z = true;
            } else {
                z = false;
            }
            this.mChildrenCanceledTouch = false;
        }
        if (shouldInterceptTouchEvent || z || hasPeekingDrawer() || this.mChildrenCanceledTouch) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (getDrawerLockMode(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mLeftDragger.processTouchEvent(motionEvent);
        this.mRightDragger.processTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    closeDrawers(true);
                    this.mChildrenCanceledTouch = false;
                }
            } else {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                View findTopChildUnder = this.mLeftDragger.findTopChildUnder((int) x, (int) y);
                if (findTopChildUnder != null && isContentView(findTopChildUnder)) {
                    float f = x - this.mInitialMotionX;
                    float f2 = y - this.mInitialMotionY;
                    int touchSlop = this.mLeftDragger.getTouchSlop();
                    if ((f * f) + (f2 * f2) < touchSlop * touchSlop) {
                        View findOpenDrawer = findOpenDrawer();
                        if (findOpenDrawer != null) {
                        }
                    }
                }
                z = true;
                closeDrawers(z);
            }
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.mInitialMotionX = x2;
            this.mInitialMotionY = y2;
            this.mChildrenCanceledTouch = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        int i5;
        float f;
        int i6;
        boolean z2;
        int i7;
        this.mInLayout = true;
        int i8 = i3 - i;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (isContentView(childAt)) {
                    int i10 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    childAt.layout(i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, childAt.getMeasuredWidth() + i10, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (checkDrawerViewAbsoluteGravity(childAt, 3)) {
                        float f2 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.onScreen * f2));
                        f = (measuredWidth + i6) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i8 - i5) / f3;
                        i6 = i8 - ((int) (layoutParams.onScreen * f3));
                    }
                    if (f != layoutParams.onScreen) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int i11 = layoutParams.gravity & 112;
                    if (i11 != 16) {
                        if (i11 != 80) {
                            int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                        } else {
                            int i13 = i4 - i2;
                            childAt.layout(i6, (i13 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i13 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        }
                    } else {
                        int i14 = i4 - i2;
                        int i15 = (i14 - measuredHeight) / 2;
                        int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        if (i15 < i16) {
                            i15 = i16;
                        } else {
                            int i17 = i15 + measuredHeight;
                            int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i17 > i14 - i18) {
                                i15 = (i14 - i18) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i15, measuredWidth + i6, measuredHeight + i15);
                    }
                    if (z2) {
                        setDrawerViewOffset(childAt, f);
                    }
                    if (layoutParams.onScreen > 0.0f) {
                        i7 = 0;
                    } else {
                        i7 = 4;
                    }
                    if (childAt.getVisibility() != i7) {
                        childAt.setVisibility(i7);
                    }
                }
            }
        }
        if (sEdgeSizeUsingSystemGestureInsets && (rootWindowInsets = getRootWindowInsets()) != null) {
            Insets systemGestureInsets = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = this.mLeftDragger;
            viewDragHelper.setEdgeSize(Math.max(viewDragHelper.getDefaultEdgeSize(), systemGestureInsets.left));
            ViewDragHelper viewDragHelper2 = this.mRightDragger;
            viewDragHelper2.setEdgeSize(Math.max(viewDragHelper2.getDefaultEdgeSize(), systemGestureInsets.right));
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i3 = 0;
        if (this.mLastInsets != null && ViewCompat.getFitsSystemWindows(this)) {
            z = true;
        } else {
            z = false;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int childCount = getChildCount();
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.gravity, layoutDirection);
                    if (ViewCompat.getFitsSystemWindows(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.mLastInsets;
                            if (absoluteGravity == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i3, windowInsets.getSystemWindowInsetBottom());
                            } else if (absoluteGravity == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i3, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.mLastInsets;
                        if (absoluteGravity == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i3, windowInsets2.getSystemWindowInsetBottom());
                        } else if (absoluteGravity == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i3, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (isContentView(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, 1073741824));
                } else if (isDrawerView(childAt)) {
                    if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
                        float elevation = ViewCompat.getElevation(childAt);
                        float f = this.mDrawerElevation;
                        if (elevation != f) {
                            ViewCompat.setElevation(childAt, f);
                        }
                    }
                    int drawerViewAbsoluteGravity = getDrawerViewAbsoluteGravity(childAt) & 7;
                    if (drawerViewAbsoluteGravity == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((z2 && z3) || (!z2 && z4)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(drawerViewAbsoluteGravity) + " but this " + TAG + " already has a drawer view along that edge");
                    }
                    if (z2) {
                        z3 = true;
                    } else {
                        z4 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i, this.mMinDrawerMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams).height));
                    i4++;
                    i3 = 0;
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i4++;
            i3 = 0;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z2 = true;
            if (layoutParams.openState == 1) {
                z = true;
            } else {
                z = false;
            }
            if (layoutParams.openState != 2) {
                z2 = false;
            }
            if (z || z2) {
                savedState.openDrawerGravity = layoutParams.gravity;
                break;
            }
        }
        savedState.lockModeLeft = this.mLockModeLeft;
        savedState.lockModeRight = this.mLockModeRight;
        savedState.lockModeStart = this.mLockModeStart;
        savedState.lockModeEnd = this.mLockModeEnd;
        return savedState;
    }

    public void setDrawerLockMode(int i, int i2) {
        View findDrawerWithGravity;
        ViewDragHelper viewDragHelper;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 8388611) {
                    if (i2 == 8388613) {
                        this.mLockModeEnd = i;
                    }
                } else {
                    this.mLockModeStart = i;
                }
            } else {
                this.mLockModeRight = i;
            }
        } else {
            this.mLockModeLeft = i;
        }
        if (i != 0) {
            if (absoluteGravity == 3) {
                viewDragHelper = this.mLeftDragger;
            } else {
                viewDragHelper = this.mRightDragger;
            }
            viewDragHelper.cancel();
        }
        if (i != 1) {
            if (i == 2 && (findDrawerWithGravity = findDrawerWithGravity(absoluteGravity)) != null) {
                openDrawer(findDrawerWithGravity);
                return;
            }
            return;
        }
        View findDrawerWithGravity2 = findDrawerWithGravity(absoluteGravity);
        if (findDrawerWithGravity2 != null) {
            closeDrawer(findDrawerWithGravity2);
        }
    }

    public void updateDrawerState(int i, View view2) {
        int viewDragState = this.mLeftDragger.getViewDragState();
        int viewDragState2 = this.mRightDragger.getViewDragState();
        int i2 = 2;
        if (viewDragState != 1 && viewDragState2 != 1) {
            if (viewDragState != 2 && viewDragState2 != 2) {
                i2 = 0;
            }
        } else {
            i2 = 1;
        }
        if (view2 != null && i == 0) {
            float f = ((LayoutParams) view2.getLayoutParams()).onScreen;
            if (f == 0.0f) {
                dispatchOnDrawerClosed(view2);
            } else if (f == 1.0f) {
                dispatchOnDrawerOpened(view2);
            }
        }
        if (i2 != this.mDrawerState) {
            this.mDrawerState = i2;
            List<DrawerListener> list = this.mListeners;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).onDrawerStateChanged(i2);
                }
            }
        }
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        if (SET_DRAWER_SHADOW_FROM_ELEVATION) {
            return;
        }
        if ((i & GravityCompat.START) == 8388611) {
            this.mShadowStart = drawable;
        } else if ((i & 8388613) == 8388613) {
            this.mShadowEnd = drawable;
        } else if ((i & 3) == 3) {
            this.mShadowLeft = drawable;
        } else if ((i & 5) == 5) {
            this.mShadowRight = drawable;
        } else {
            return;
        }
        resolveShadowDrawables();
        invalidate();
    }
}
