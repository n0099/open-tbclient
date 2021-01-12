package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class bh {
    private View eZp;
    private ViewTreeObserver eZq;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.bh.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            bh.this.possiblyResizeChildOfContent();
        }
    };
    private int usableHeightPrevious;

    public static bh ad(@NonNull Activity activity) {
        bh bhVar = new bh(activity);
        bhVar.arx();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return bhVar;
    }

    private bh(@NonNull Activity activity) {
        this.eZp = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void bsD() {
        if ((this.eZq == null || !this.eZq.isAlive()) && this.eZp != null) {
            this.eZq = this.eZp.getViewTreeObserver();
        }
    }

    private void arx() {
        bsD();
        if (this.eZq != null && this.eZq.isAlive()) {
            this.eZq.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    private void bsE() {
        bsD();
        if (this.eZq != null && this.eZq.isAlive()) {
            this.eZq.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onPause() {
        bsE();
    }

    public void onResume() {
        arx();
    }

    public void onDestroy() {
        bsE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.eZp != null) {
            Rect rect = new Rect();
            this.eZp.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.usableHeightPrevious) {
                int height = this.eZp.getRootView().getHeight();
                int i2 = height - rect.bottom;
                int i3 = (height - i) - i2;
                if (i3 > height / 4) {
                    this.eZp.getLayoutParams().height = height - i3;
                } else {
                    this.eZp.getLayoutParams().height = height - i2;
                }
                this.eZp.requestLayout();
                this.usableHeightPrevious = i;
            }
        }
    }
}
