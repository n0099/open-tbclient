package com.baidu.apollon.statusbar;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public class ImmersiveKeyboardAdjust {
    public ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    public int usableHeightPrevious;

    /* JADX INFO: Access modifiers changed from: private */
    public int computeUsableHeight(View view) {
        if (view == null) {
            return 0;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void attachActivity(final View view) {
        if (view == null) {
            return;
        }
        if (this.globalLayoutListener == null) {
            this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.apollon.statusbar.ImmersiveKeyboardAdjust.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view2;
                    int computeUsableHeight = ImmersiveKeyboardAdjust.this.computeUsableHeight(view);
                    if (computeUsableHeight == ImmersiveKeyboardAdjust.this.usableHeightPrevious || (view2 = view) == null) {
                        return;
                    }
                    view2.getLayoutParams().height = computeUsableHeight;
                    view.requestLayout();
                    ImmersiveKeyboardAdjust.this.usableHeightPrevious = computeUsableHeight;
                }
            };
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.globalLayoutListener);
    }

    public void detachActivity(View view) {
        if (view == null) {
            return;
        }
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (this.globalLayoutListener != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.globalLayoutListener);
                }
            }
        }
        this.globalLayoutListener = null;
        this.usableHeightPrevious = 0;
    }
}
