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
    private View bbf;
    private int bbg;
    private ViewGroup.LayoutParams bbh;
    private Runnable bbi;
    private FrameLayout bbj;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int bbk = d.C0141d.cp_bg_line_d;
    private boolean bbl = false;
    private ViewTreeObserver.OnGlobalLayoutListener HQ = null;
    private int bbm = 0;

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
        if (this.bbl) {
            if (i != this.mSkinType && this.bbj != null) {
                aj.t(this.bbj, this.bbk);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bbi != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbi);
            this.bbi = null;
        }
        if (this.bbf != null) {
            this.bbf.getViewTreeObserver().removeGlobalOnLayoutListener(this.HQ);
            this.HQ = null;
        }
        this.bbf = null;
        this.bbj = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bbk = i;
        this.bbl = z;
        this.bbj = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.bbj, i);
        } else {
            aj.g(this.bbj, i, 0);
        }
        this.bbf = this.bbj.getChildAt(0);
        if (this.bbf != null) {
            this.HQ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.g.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g.this.DT();
                }
            };
            this.bbf.getViewTreeObserver().addOnGlobalLayoutListener(this.HQ);
            this.bbh = this.bbf.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT() {
        if (this.bbf != null) {
            int height = this.bbf.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DU = DU();
            if (this.bbm > 0 && this.bbm <= this.bbh.height) {
                DU -= this.bbm;
            }
            if (DU != this.bbg) {
                int i = this.mScreenHeight;
                int i2 = i - DU;
                if (i2 == 0) {
                    this.bbh.height = i;
                    DV();
                } else {
                    this.bbh.height = i - i2;
                    gj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.bbg = DU;
            }
        }
    }

    private int DU() {
        Rect rect = new Rect();
        this.bbf.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bbm = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DV() {
        this.bbf.requestLayout();
    }

    private void gj(int i) {
        if (this.bbi != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbi);
            this.bbi = null;
        }
        this.bbi = new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.DV();
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.bbi, i);
    }
}
