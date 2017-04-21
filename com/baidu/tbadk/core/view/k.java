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
    private View ajJ;
    private int ajK;
    private ViewGroup.LayoutParams ajL;
    private Runnable ajM;
    private FrameLayout ajN;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajO = w.e.cp_bg_line_d;
    private boolean ajP = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajQ = null;
    private int ajR = 0;

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
        if (this.ajP) {
            if (i != this.mSkinType && this.ajN != null) {
                com.baidu.tbadk.core.util.aq.k(this.ajN, this.ajO);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ajM != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ajM);
            this.ajM = null;
        }
        if (this.ajJ != null) {
            this.ajJ.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajQ);
            this.ajJ.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajQ = null;
        }
        this.ajJ = null;
        this.ajN = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajO = i;
        this.ajP = z;
        this.ajN = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.aq.k(this.ajN, i);
        } else {
            com.baidu.tbadk.core.util.aq.e(this.ajN, i, 0);
        }
        this.ajJ = this.ajN.getChildAt(0);
        if (this.ajJ != null) {
            this.ajQ = new l(this);
            this.ajJ.getViewTreeObserver().addOnGlobalLayoutListener(this.ajQ);
            this.ajL = this.ajJ.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        if (this.ajJ != null) {
            int height = this.ajJ.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wO = wO();
            if (this.ajR > 0 && this.ajR <= this.ajL.height) {
                wO -= this.ajR;
            }
            if (wO != this.ajK) {
                int i = this.mScreenHeight;
                int i2 = i - wO;
                if (i2 == 0) {
                    this.ajL.height = i;
                    wP();
                } else {
                    this.ajL.height = i - i2;
                    dg(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.ajK = wO;
            }
        }
    }

    private int wO() {
        Rect rect = new Rect();
        this.ajJ.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ajR = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wP() {
        this.ajJ.requestLayout();
    }

    private void dg(int i) {
        if (this.ajM != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ajM);
            this.ajM = null;
        }
        this.ajM = new m(this);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.ajM, i);
    }
}
