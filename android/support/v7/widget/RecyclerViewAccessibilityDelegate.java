package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* loaded from: classes2.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    final RecyclerView SF;
    final AccessibilityDelegateCompat TG = new AccessibilityDelegateCompat() { // from class: android.support.v7.widget.RecyclerViewAccessibilityDelegate.1
        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!RecyclerViewAccessibilityDelegate.this.shouldIgnore() && RecyclerViewAccessibilityDelegate.this.SF.getLayoutManager() != null) {
                RecyclerViewAccessibilityDelegate.this.SF.getLayoutManager().a(view, accessibilityNodeInfoCompat);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (!RecyclerViewAccessibilityDelegate.this.shouldIgnore() && RecyclerViewAccessibilityDelegate.this.SF.getLayoutManager() != null) {
                return RecyclerViewAccessibilityDelegate.this.SF.getLayoutManager().a(view, i, bundle);
            }
            return false;
        }
    };

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.SF = recyclerView;
    }

    boolean shouldIgnore() {
        return this.SF.hasPendingAdapterUpdates();
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (!shouldIgnore() && this.SF.getLayoutManager() != null) {
            return this.SF.getLayoutManager().performAccessibilityAction(i, bundle);
        }
        return false;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
        if (!shouldIgnore() && this.SF.getLayoutManager() != null) {
            this.SF.getLayoutManager().a(accessibilityNodeInfoCompat);
        }
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.TG;
    }
}
