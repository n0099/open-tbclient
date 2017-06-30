package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private View ajE;
    private int ajF;
    private ViewGroup.LayoutParams ajG;
    private Runnable ajH;
    private FrameLayout ajI;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajJ = w.e.cp_bg_line_d;
    private boolean ajK = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajL = null;
    private int ajM = 0;

    public static k t(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, w.e.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, w.e.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void de(int i) {
        if (this.ajK) {
            if (i != this.mSkinType && this.ajI != null) {
                com.baidu.tbadk.core.util.as.k(this.ajI, this.ajJ);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ajH != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.ajH);
            this.ajH = null;
        }
        if (this.ajE != null) {
            this.ajE.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajL);
            this.ajE.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajL = null;
        }
        this.ajE = null;
        this.ajI = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajJ = i;
        this.ajK = z;
        this.ajI = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.as.k(this.ajI, i);
        } else {
            com.baidu.tbadk.core.util.as.e(this.ajI, i, 0);
        }
        this.ajE = this.ajI.getChildAt(0);
        if (this.ajE != null) {
            this.ajL = new l(this);
            this.ajE.getViewTreeObserver().addOnGlobalLayoutListener(this.ajL);
            this.ajG = this.ajE.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo() {
        if (this.ajE != null) {
            int height = this.ajE.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wp = wp();
            if (this.ajM > 0 && this.ajM <= this.ajG.height) {
                wp -= this.ajM;
            }
            if (wp != this.ajF) {
                int i = this.mScreenHeight;
                int i2 = i - wp;
                if (i2 == 0) {
                    this.ajG.height = i;
                    wq();
                } else {
                    this.ajG.height = i - i2;
                    df(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.ajF = wp;
            }
        }
    }

    private int wp() {
        Rect rect = new Rect();
        this.ajE.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ajM = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        this.ajE.requestLayout();
    }

    private void df(int i) {
        if (this.ajH != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.ajH);
            this.ajH = null;
        }
        this.ajH = new m(this);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.ajH, i);
    }
}
