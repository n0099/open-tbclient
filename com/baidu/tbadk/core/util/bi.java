package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class bi {
    private View fbE;
    private ViewTreeObserver fbF;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.bi.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            bi.this.possiblyResizeChildOfContent();
        }
    };
    private int usableHeightPrevious;

    public static bi X(@NonNull Activity activity) {
        bi biVar = new bi(activity);
        biVar.arV();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return biVar;
    }

    private bi(@NonNull Activity activity) {
        this.fbE = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void bsX() {
        if ((this.fbF == null || !this.fbF.isAlive()) && this.fbE != null) {
            this.fbF = this.fbE.getViewTreeObserver();
        }
    }

    private void arV() {
        bsX();
        if (this.fbF != null && this.fbF.isAlive()) {
            this.fbF.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    private void bsY() {
        bsX();
        if (this.fbF != null && this.fbF.isAlive()) {
            this.fbF.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onPause() {
        bsY();
    }

    public void onResume() {
        arV();
    }

    public void onDestroy() {
        bsY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.fbE != null) {
            Rect rect = new Rect();
            this.fbE.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.usableHeightPrevious) {
                int height = this.fbE.getRootView().getHeight();
                int i2 = height - rect.bottom;
                int i3 = (height - i) - i2;
                if (i3 > height / 4) {
                    this.fbE.getLayoutParams().height = height - i3;
                } else {
                    this.fbE.getLayoutParams().height = height - i2;
                }
                this.fbE.requestLayout();
                this.usableHeightPrevious = i;
            }
        }
    }
}
