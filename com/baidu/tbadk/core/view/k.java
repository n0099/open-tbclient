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
    private View aju;
    private int ajv;
    private ViewGroup.LayoutParams ajw;
    private Runnable ajx;
    private FrameLayout ajy;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajz = w.e.cp_bg_line_d;
    private boolean ajA = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajB = null;
    private int ajC = 0;

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

    public void dc(int i) {
        if (this.ajA) {
            if (i != this.mSkinType && this.ajy != null) {
                com.baidu.tbadk.core.util.aq.k(this.ajy, this.ajz);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ajx != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.ajx);
            this.ajx = null;
        }
        if (this.aju != null) {
            this.aju.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajB);
            this.aju.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajB = null;
        }
        this.aju = null;
        this.ajy = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajz = i;
        this.ajA = z;
        this.ajy = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.aq.k(this.ajy, i);
        } else {
            com.baidu.tbadk.core.util.aq.e(this.ajy, i, 0);
        }
        this.aju = this.ajy.getChildAt(0);
        if (this.aju != null) {
            this.ajB = new l(this);
            this.aju.getViewTreeObserver().addOnGlobalLayoutListener(this.ajB);
            this.ajw = this.aju.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wr() {
        if (this.aju != null) {
            int height = this.aju.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ws = ws();
            if (this.ajC > 0 && this.ajC <= this.ajw.height) {
                ws -= this.ajC;
            }
            if (ws != this.ajv) {
                int i = this.mScreenHeight;
                int i2 = i - ws;
                if (i2 == 0) {
                    this.ajw.height = i;
                    wt();
                } else {
                    this.ajw.height = i - i2;
                    dd(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.ajv = ws;
            }
        }
    }

    private int ws() {
        Rect rect = new Rect();
        this.aju.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ajC = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wt() {
        this.aju.requestLayout();
    }

    private void dd(int i) {
        if (this.ajx != null) {
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.ajx);
            this.ajx = null;
        }
        this.ajx = new m(this);
        com.baidu.adp.lib.g.h.fM().postDelayed(this.ajx, i);
    }
}
