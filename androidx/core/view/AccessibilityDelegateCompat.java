package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    public static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate mBridge;
    public final View.AccessibilityDelegate mOriginalDelegate;

    /* loaded from: classes.dex */
    public static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
        public final AccessibilityDelegateCompat mCompat;

        public AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.mCompat = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        @RequiresApi(16)
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view2) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view2);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onInitializeAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            this.mCompat.onPopulateAccessibilityEvent(view2, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view2, int i) {
            this.mCompat.sendAccessibilityEvent(view2, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
            this.mCompat.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(view2));
            wrap.setHeading(ViewCompat.isAccessibilityHeading(view2));
            wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(view2));
            wrap.setStateDescription(ViewCompat.getStateDescription(view2));
            this.mCompat.onInitializeAccessibilityNodeInfo(view2, wrap);
            wrap.addSpansToExtras(accessibilityNodeInfo.getText(), view2);
            List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = AccessibilityDelegateCompat.getActionList(view2);
            for (int i = 0; i < actionList.size(); i++) {
                wrap.addAction(actionList.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
            return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            return this.mCompat.performAccessibilityAction(view2, i, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new AccessibilityDelegateAdapter(this);
    }

    public static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view2) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = (List) view2.getTag(R.id.obfuscated_res_0x7f09248e);
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT >= 16 && (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view2)) != null) {
            return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
        }
        return null;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view2) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpans = AccessibilityNodeInfoCompat.getClickableSpans(view2.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpans != null && i < clickableSpans.length; i++) {
                if (clickableSpan.equals(clickableSpans[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i, View view2) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view2.getTag(R.id.obfuscated_res_0x7f09248f);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (isSpanStillValid(clickableSpan, view2)) {
                clickableSpan.onClick(view2);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view2, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view2, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat.unwrap());
    }

    public void onPopulateAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view2, accessibilityEvent);
    }

    public void sendAccessibilityEvent(View view2, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view2, i);
    }

    public void sendAccessibilityEventUnchecked(View view2, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view2, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view2, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
        List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> actionList = getActionList(view2);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= actionList.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = actionList.get(i2);
            if (accessibilityActionCompat.getId() == i) {
                z = accessibilityActionCompat.perform(view2, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.mOriginalDelegate.performAccessibilityAction(view2, i, bundle);
        }
        if (!z && i == R.id.obfuscated_res_0x7f090054) {
            return performClickableSpanAction(bundle.getInt(AccessibilityClickableSpanCompat.SPAN_ID, -1), view2);
        }
        return z;
    }
}
