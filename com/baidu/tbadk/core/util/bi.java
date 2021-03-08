package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class bi {
    private View fde;
    private ViewTreeObserver fdf;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.bi.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            bi.this.possiblyResizeChildOfContent();
        }
    };
    private int usableHeightPrevious;

    public static bi X(@NonNull Activity activity) {
        bi biVar = new bi(activity);
        biVar.arY();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return biVar;
    }

    private bi(@NonNull Activity activity) {
        this.fde = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void bta() {
        if ((this.fdf == null || !this.fdf.isAlive()) && this.fde != null) {
            this.fdf = this.fde.getViewTreeObserver();
        }
    }

    private void arY() {
        bta();
        if (this.fdf != null && this.fdf.isAlive()) {
            this.fdf.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    private void btb() {
        bta();
        if (this.fdf != null && this.fdf.isAlive()) {
            this.fdf.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onPause() {
        btb();
    }

    public void onResume() {
        arY();
    }

    public void onDestroy() {
        btb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.fde != null) {
            Rect rect = new Rect();
            this.fde.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.usableHeightPrevious) {
                int height = this.fde.getRootView().getHeight();
                int i2 = height - rect.bottom;
                int i3 = (height - i) - i2;
                if (i3 > height / 4) {
                    this.fde.getLayoutParams().height = height - i3;
                } else {
                    this.fde.getLayoutParams().height = height - i2;
                }
                this.fde.requestLayout();
                this.usableHeightPrevious = i;
            }
        }
    }
}
