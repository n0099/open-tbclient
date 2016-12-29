package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k {
    private View aeU;
    private int aeV;
    private ViewGroup.LayoutParams aeW;
    private Runnable aeX;
    private FrameLayout aeY;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aeZ = r.d.cp_bg_line_d;
    private boolean afa = false;
    private ViewTreeObserver.OnGlobalLayoutListener afb = null;
    private int afc = 0;

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

    public void df(int i) {
        if (this.afa) {
            if (i != this.mSkinType && this.aeY != null) {
                com.baidu.tbadk.core.util.ar.l(this.aeY, this.aeZ);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aeX != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aeX);
            this.aeX = null;
        }
        if (this.aeU != null) {
            this.aeU.getViewTreeObserver().removeGlobalOnLayoutListener(this.afb);
            this.aeU.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.afb = null;
        }
        this.aeU = null;
        this.aeY = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aeZ = i;
        this.afa = z;
        this.aeY = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.ar.l(this.aeY, i);
        } else {
            com.baidu.tbadk.core.util.ar.e(this.aeY, i, 0);
        }
        this.aeU = this.aeY.getChildAt(0);
        if (this.aeU != null) {
            this.afb = new l(this);
            this.aeU.getViewTreeObserver().addOnGlobalLayoutListener(this.afb);
            this.aeW = this.aeU.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        if (this.aeU != null) {
            int height = this.aeU.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wb = wb();
            if (this.afc > 0 && this.afc <= this.aeW.height) {
                wb -= this.afc;
            }
            if (wb != this.aeV) {
                int i = this.mScreenHeight;
                int i2 = i - wb;
                if (i2 == 0) {
                    this.aeW.height = i;
                    wc();
                } else {
                    this.aeW.height = i - i2;
                    dg(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.aeV = wb;
            }
        }
    }

    private int wb() {
        Rect rect = new Rect();
        this.aeU.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.afc = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc() {
        this.aeU.requestLayout();
    }

    private void dg(int i) {
        if (this.aeX != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aeX);
            this.aeX = null;
        }
        this.aeX = new m(this);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.aeX, i);
    }
}
