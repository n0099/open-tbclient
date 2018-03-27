package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class g {
    private View bbh;
    private int bbi;
    private ViewGroup.LayoutParams bbj;
    private Runnable bbk;
    private FrameLayout bbl;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int bbm = d.C0141d.cp_bg_line_d;
    private boolean bbn = false;
    private ViewTreeObserver.OnGlobalLayoutListener HQ = null;
    private int bbo = 0;

    public static g x(Activity activity) {
        return new g(activity);
    }

    public static g a(Activity activity, boolean z) {
        return new g(activity, z);
    }

    public static g a(Activity activity, int i, boolean z) {
        return new g(activity, i, z);
    }

    private g(Activity activity) {
        b(activity, d.C0141d.cp_bg_line_d, true);
    }

    private g(Activity activity, boolean z) {
        b(activity, d.C0141d.cp_bg_line_d, z);
    }

    private g(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void gi(int i) {
        if (this.bbn) {
            if (i != this.mSkinType && this.bbl != null) {
                aj.t(this.bbl, this.bbm);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bbk != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbk);
            this.bbk = null;
        }
        if (this.bbh != null) {
            this.bbh.getViewTreeObserver().removeGlobalOnLayoutListener(this.HQ);
            this.HQ = null;
        }
        this.bbh = null;
        this.bbl = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bbm = i;
        this.bbn = z;
        this.bbl = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.bbl, i);
        } else {
            aj.g(this.bbl, i, 0);
        }
        this.bbh = this.bbl.getChildAt(0);
        if (this.bbh != null) {
            this.HQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.g.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g.this.DU();
                }
            };
            this.bbh.getViewTreeObserver().addOnGlobalLayoutListener(this.HQ);
            this.bbj = this.bbh.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DU() {
        if (this.bbh != null) {
            int height = this.bbh.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DV = DV();
            if (this.bbo > 0 && this.bbo <= this.bbj.height) {
                DV -= this.bbo;
            }
            if (DV != this.bbi) {
                int i = this.mScreenHeight;
                int i2 = i - DV;
                if (i2 == 0) {
                    this.bbj.height = i;
                    DW();
                } else {
                    this.bbj.height = i - i2;
                    gj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.bbi = DV;
            }
        }
    }

    private int DV() {
        Rect rect = new Rect();
        this.bbh.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bbo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DW() {
        this.bbh.requestLayout();
    }

    private void gj(int i) {
        if (this.bbk != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbk);
            this.bbk = null;
        }
        this.bbk = new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.DW();
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.bbk, i);
    }
}
