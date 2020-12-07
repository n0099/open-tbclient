package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class bi {
    private View eUB;
    private ViewTreeObserver eUC;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.bi.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            bi.this.possiblyResizeChildOfContent();
        }
    };
    private int usableHeightPrevious;

    public static bi ab(@NonNull Activity activity) {
        bi biVar = new bi(activity);
        biVar.aua();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return biVar;
    }

    private bi(@NonNull Activity activity) {
        this.eUB = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void buc() {
        if ((this.eUC == null || !this.eUC.isAlive()) && this.eUB != null) {
            this.eUC = this.eUB.getViewTreeObserver();
        }
    }

    private void aua() {
        buc();
        if (this.eUC != null && this.eUC.isAlive()) {
            this.eUC.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    private void bud() {
        buc();
        if (this.eUC != null && this.eUC.isAlive()) {
            this.eUC.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onPause() {
        bud();
    }

    public void onResume() {
        aua();
    }

    public void onDestroy() {
        bud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.eUB != null) {
            Rect rect = new Rect();
            this.eUB.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.usableHeightPrevious) {
                int height = this.eUB.getRootView().getHeight();
                int i2 = height - rect.bottom;
                int i3 = (height - i) - i2;
                if (i3 > height / 4) {
                    this.eUB.getLayoutParams().height = height - i3;
                } else {
                    this.eUB.getLayoutParams().height = height - i2;
                }
                this.eUB.requestLayout();
                this.usableHeightPrevious = i;
            }
        }
    }
}
