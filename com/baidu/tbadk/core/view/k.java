package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k {
    private View afB;
    private int afC;
    private ViewGroup.LayoutParams afD;
    private Runnable afE;
    private FrameLayout afF;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int afG = r.d.cp_bg_line_d;
    private boolean afH = false;
    private ViewTreeObserver.OnGlobalLayoutListener afI = null;
    private int afJ = 0;

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
        b(activity, r.d.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, r.d.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dd(int i) {
        if (this.afH) {
            if (i != this.mSkinType && this.afF != null) {
                at.l(this.afF, this.afG);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.afE != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.afE);
            this.afE = null;
        }
        if (this.afB != null) {
            this.afB.getViewTreeObserver().removeGlobalOnLayoutListener(this.afI);
            this.afB.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.afI = null;
        }
        this.afB = null;
        this.afF = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.afG = i;
        this.afH = z;
        this.afF = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            at.l(this.afF, i);
        } else {
            at.e(this.afF, i, 0);
        }
        this.afB = this.afF.getChildAt(0);
        if (this.afB != null) {
            this.afI = new l(this);
            this.afB.getViewTreeObserver().addOnGlobalLayoutListener(this.afI);
            this.afD = this.afB.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq() {
        if (this.afB != null) {
            int height = this.afB.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wr = wr();
            if (this.afJ > 0 && this.afJ <= this.afD.height) {
                wr -= this.afJ;
            }
            if (wr != this.afC) {
                int i = this.mScreenHeight;
                int i2 = i - wr;
                if (i2 == 0) {
                    this.afD.height = i;
                    ws();
                } else {
                    this.afD.height = i - i2;
                    de(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.afC = wr;
            }
        }
    }

    private int wr() {
        Rect rect = new Rect();
        this.afB.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.afJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws() {
        this.afB.requestLayout();
    }

    private void de(int i) {
        if (this.afE != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.afE);
            this.afE = null;
        }
        this.afE = new m(this);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.afE, i);
    }
}
