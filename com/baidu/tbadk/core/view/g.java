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
    private ViewGroup.LayoutParams aZA;
    private Runnable aZB;
    private FrameLayout aZC;
    private View aZy;
    private int aZz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aZD = d.C0107d.cp_bg_line_d;
    private boolean aZE = false;
    private ViewTreeObserver.OnGlobalLayoutListener HX = null;
    private int aZF = 0;

    public static g u(Activity activity) {
        return new g(activity);
    }

    public static g a(Activity activity, boolean z) {
        return new g(activity, z);
    }

    public static g a(Activity activity, int i, boolean z) {
        return new g(activity, i, z);
    }

    private g(Activity activity) {
        b(activity, d.C0107d.cp_bg_line_d, true);
    }

    private g(Activity activity, boolean z) {
        b(activity, d.C0107d.cp_bg_line_d, z);
    }

    private g(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void gg(int i) {
        if (this.aZE) {
            if (i != this.mSkinType && this.aZC != null) {
                aj.t(this.aZC, this.aZD);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aZB != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aZB);
            this.aZB = null;
        }
        if (this.aZy != null) {
            this.aZy.getViewTreeObserver().removeGlobalOnLayoutListener(this.HX);
            this.HX = null;
        }
        this.aZy = null;
        this.aZC = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aZD = i;
        this.aZE = z;
        this.aZC = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.aZC, i);
        } else {
            aj.g(this.aZC, i, 0);
        }
        this.aZy = this.aZC.getChildAt(0);
        if (this.aZy != null) {
            this.HX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.g.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g.this.Dy();
                }
            };
            this.aZy.getViewTreeObserver().addOnGlobalLayoutListener(this.HX);
            this.aZA = this.aZy.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy() {
        if (this.aZy != null) {
            int height = this.aZy.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Dz = Dz();
            if (this.aZF > 0 && this.aZF <= this.aZA.height) {
                Dz -= this.aZF;
            }
            if (Dz != this.aZz) {
                int i = this.mScreenHeight;
                int i2 = i - Dz;
                if (i2 == 0) {
                    this.aZA.height = i;
                    DA();
                } else {
                    this.aZA.height = i - i2;
                    gh(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.aZz = Dz;
            }
        }
    }

    private int Dz() {
        Rect rect = new Rect();
        this.aZy.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aZF = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        this.aZy.requestLayout();
    }

    private void gh(int i) {
        if (this.aZB != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aZB);
            this.aZB = null;
        }
        this.aZB = new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.DA();
            }
        };
        com.baidu.adp.lib.g.e.nr().postDelayed(this.aZB, i);
    }
}
