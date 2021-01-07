package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class bh {
    private View fdY;
    private ViewTreeObserver fdZ;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.util.bh.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            bh.this.possiblyResizeChildOfContent();
        }
    };
    private int usableHeightPrevious;

    public static bh ad(@NonNull Activity activity) {
        bh bhVar = new bh(activity);
        bhVar.avs();
        UtilHelper.setTranslucentVirtualNavigation(activity);
        return bhVar;
    }

    private bh(@NonNull Activity activity) {
        this.fdY = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
    }

    private void bwx() {
        if ((this.fdZ == null || !this.fdZ.isAlive()) && this.fdY != null) {
            this.fdZ = this.fdY.getViewTreeObserver();
        }
    }

    private void avs() {
        bwx();
        if (this.fdZ != null && this.fdZ.isAlive()) {
            this.fdZ.addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    private void bwy() {
        bwx();
        if (this.fdZ != null && this.fdZ.isAlive()) {
            this.fdZ.removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    public void onPause() {
        bwy();
    }

    public void onResume() {
        avs();
    }

    public void onDestroy() {
        bwy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.fdY != null) {
            Rect rect = new Rect();
            this.fdY.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != this.usableHeightPrevious) {
                int height = this.fdY.getRootView().getHeight();
                int i2 = height - rect.bottom;
                int i3 = (height - i) - i2;
                if (i3 > height / 4) {
                    this.fdY.getLayoutParams().height = height - i3;
                } else {
                    this.fdY.getLayoutParams().height = height - i2;
                }
                this.fdY.requestLayout();
                this.usableHeightPrevious = i;
            }
        }
    }
}
