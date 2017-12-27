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
public class f {
    private int aZA;
    private ViewGroup.LayoutParams aZB;
    private Runnable aZC;
    private FrameLayout aZD;
    private View aZz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aZE = d.C0108d.cp_bg_line_d;
    private boolean aZF = false;
    private ViewTreeObserver.OnGlobalLayoutListener HX = null;
    private int aZG = 0;

    public static f u(Activity activity) {
        return new f(activity);
    }

    public static f a(Activity activity, boolean z) {
        return new f(activity, z);
    }

    public static f a(Activity activity, int i, boolean z) {
        return new f(activity, i, z);
    }

    private f(Activity activity) {
        b(activity, d.C0108d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0108d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void gi(int i) {
        if (this.aZF) {
            if (i != this.mSkinType && this.aZD != null) {
                aj.t(this.aZD, this.aZE);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aZC != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aZC);
            this.aZC = null;
        }
        if (this.aZz != null) {
            this.aZz.getViewTreeObserver().removeGlobalOnLayoutListener(this.HX);
            this.HX = null;
        }
        this.aZz = null;
        this.aZD = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aZE = i;
        this.aZF = z;
        this.aZD = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.aZD, i);
        } else {
            aj.g(this.aZD, i, 0);
        }
        this.aZz = this.aZD.getChildAt(0);
        if (this.aZz != null) {
            this.HX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.DH();
                }
            };
            this.aZz.getViewTreeObserver().addOnGlobalLayoutListener(this.HX);
            this.aZB = this.aZz.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DH() {
        if (this.aZz != null) {
            int height = this.aZz.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DI = DI();
            if (this.aZG > 0 && this.aZG <= this.aZB.height) {
                DI -= this.aZG;
            }
            if (DI != this.aZA) {
                int i = this.mScreenHeight;
                int i2 = i - DI;
                if (i2 == 0) {
                    this.aZB.height = i;
                    DJ();
                } else {
                    this.aZB.height = i - i2;
                    gj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.aZA = DI;
            }
        }
    }

    private int DI() {
        Rect rect = new Rect();
        this.aZz.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aZG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DJ() {
        this.aZz.requestLayout();
    }

    private void gj(int i) {
        if (this.aZC != null) {
            com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aZC);
            this.aZC = null;
        }
        this.aZC = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.DJ();
            }
        };
        com.baidu.adp.lib.g.e.nr().postDelayed(this.aZC, i);
    }
}
