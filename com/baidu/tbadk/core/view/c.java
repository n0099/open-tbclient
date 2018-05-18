package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class c {
    private View amC;
    private int amD;
    private ViewGroup.LayoutParams amE;
    private Runnable amF;
    private FrameLayout amG;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int amH = d.C0126d.cp_bg_line_d;
    private boolean amI = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int amJ = 0;

    public static c x(Activity activity) {
        return new c(activity);
    }

    public static c a(Activity activity, boolean z) {
        return new c(activity, z);
    }

    public static c a(Activity activity, int i, boolean z) {
        return new c(activity, i, z);
    }

    private c(Activity activity) {
        b(activity, d.C0126d.cp_bg_line_d, true);
    }

    private c(Activity activity, boolean z) {
        b(activity, d.C0126d.cp_bg_line_d, z);
    }

    private c(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void di(int i) {
        if (this.amI) {
            if (i != this.mSkinType && this.amG != null) {
                ak.j(this.amG, this.amH);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.amF != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.amF);
            this.amF = null;
        }
        if (this.amC != null) {
            this.amC.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.amC = null;
        this.amG = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.amH = i;
        this.amI = z;
        this.amG = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            ak.j(this.amG, i);
        } else {
            ak.e(this.amG, i, 0);
        }
        this.amC = this.amG.getChildAt(0);
        if (this.amC != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.c.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    c.this.wE();
                }
            };
            this.amC.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.amE = this.amC.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wE() {
        if (this.amC != null) {
            int height = this.amC.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wF = wF();
            if (this.amJ > 0 && this.amJ <= this.amE.height) {
                wF -= this.amJ;
            }
            if (wF != this.amD) {
                int i = this.mScreenHeight;
                int i2 = i - wF;
                if (i2 == 0) {
                    this.amE.height = i;
                    wG();
                } else {
                    this.amE.height = i - i2;
                    dj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.amD = wF;
            }
        }
    }

    private int wF() {
        Rect rect = new Rect();
        this.amC.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.amJ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG() {
        this.amC.requestLayout();
    }

    private void dj(int i) {
        if (this.amF != null) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.amF);
            this.amF = null;
        }
        this.amF = new Runnable() { // from class: com.baidu.tbadk.core.view.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.wG();
            }
        };
        com.baidu.adp.lib.g.e.fw().postDelayed(this.amF, i);
    }
}
