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
    private View bbr;
    private int bbs;
    private ViewGroup.LayoutParams bbt;
    private Runnable bbu;
    private FrameLayout bbv;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int bbw = d.C0140d.cp_bg_line_d;
    private boolean bbx = false;
    private ViewTreeObserver.OnGlobalLayoutListener HW = null;
    private int bby = 0;

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
        b(activity, d.C0140d.cp_bg_line_d, true);
    }

    private g(Activity activity, boolean z) {
        b(activity, d.C0140d.cp_bg_line_d, z);
    }

    private g(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void gi(int i) {
        if (this.bbx) {
            if (i != this.mSkinType && this.bbv != null) {
                aj.t(this.bbv, this.bbw);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bbu != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbu);
            this.bbu = null;
        }
        if (this.bbr != null) {
            this.bbr.getViewTreeObserver().removeGlobalOnLayoutListener(this.HW);
            this.HW = null;
        }
        this.bbr = null;
        this.bbv = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bbw = i;
        this.bbx = z;
        this.bbv = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.bbv, i);
        } else {
            aj.g(this.bbv, i, 0);
        }
        this.bbr = this.bbv.getChildAt(0);
        if (this.bbr != null) {
            this.HW = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.g.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g.this.DU();
                }
            };
            this.bbr.getViewTreeObserver().addOnGlobalLayoutListener(this.HW);
            this.bbt = this.bbr.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DU() {
        if (this.bbr != null) {
            int height = this.bbr.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DV = DV();
            if (this.bby > 0 && this.bby <= this.bbt.height) {
                DV -= this.bby;
            }
            if (DV != this.bbs) {
                int i = this.mScreenHeight;
                int i2 = i - DV;
                if (i2 == 0) {
                    this.bbt.height = i;
                    DW();
                } else {
                    this.bbt.height = i - i2;
                    gj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.bbs = DV;
            }
        }
    }

    private int DV() {
        Rect rect = new Rect();
        this.bbr.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bby = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DW() {
        this.bbr.requestLayout();
    }

    private void gj(int i) {
        if (this.bbu != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.bbu);
            this.bbu = null;
        }
        this.bbu = new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.DW();
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.bbu, i);
    }
}
