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
    private View ajI;
    private int ajJ;
    private ViewGroup.LayoutParams ajK;
    private Runnable ajL;
    private FrameLayout ajM;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajN = w.e.cp_bg_line_d;
    private boolean ajO = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajP = null;
    private int ajQ = 0;

    public static k r(Activity activity) {
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

    public void df(int i) {
        if (this.ajO) {
            if (i != this.mSkinType && this.ajM != null) {
                com.baidu.tbadk.core.util.aq.k(this.ajM, this.ajN);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ajL != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.ajL);
            this.ajL = null;
        }
        if (this.ajI != null) {
            this.ajI.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajP);
            this.ajI.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajP = null;
        }
        this.ajI = null;
        this.ajM = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajN = i;
        this.ajO = z;
        this.ajM = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.aq.k(this.ajM, i);
        } else {
            com.baidu.tbadk.core.util.aq.e(this.ajM, i, 0);
        }
        this.ajI = this.ajM.getChildAt(0);
        if (this.ajI != null) {
            this.ajP = new l(this);
            this.ajI.getViewTreeObserver().addOnGlobalLayoutListener(this.ajP);
            this.ajK = this.ajI.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        if (this.ajI != null) {
            int height = this.ajI.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wO = wO();
            if (this.ajQ > 0 && this.ajQ <= this.ajK.height) {
                wO -= this.ajQ;
            }
            if (wO != this.ajJ) {
                int i = this.mScreenHeight;
                int i2 = i - wO;
                if (i2 == 0) {
                    this.ajK.height = i;
                    wP();
                } else {
                    this.ajK.height = i - i2;
                    dg(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.ajJ = wO;
            }
        }
    }

    private int wO() {
        Rect rect = new Rect();
        this.ajI.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ajQ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP() {
        this.ajI.requestLayout();
    }

    private void dg(int i) {
        if (this.ajL != null) {
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.ajL);
            this.ajL = null;
        }
        this.ajL = new m(this);
        com.baidu.adp.lib.g.h.fR().postDelayed(this.ajL, i);
    }
}
