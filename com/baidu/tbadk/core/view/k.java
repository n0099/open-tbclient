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
    private View aef;
    private int aeg;
    private ViewGroup.LayoutParams aeh;
    private Runnable aei;
    private FrameLayout aej;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aek = r.e.cp_bg_line_d;
    private boolean ael = false;
    private ViewTreeObserver.OnGlobalLayoutListener aem = null;
    private int aen = 0;

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
        b(activity, r.e.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, r.e.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dg(int i) {
        if (this.ael) {
            if (i != this.mSkinType && this.aej != null) {
                com.baidu.tbadk.core.util.ap.k(this.aej, this.aek);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aei != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aei);
            this.aei = null;
        }
        if (this.aef != null) {
            this.aef.getViewTreeObserver().removeGlobalOnLayoutListener(this.aem);
            this.aef.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.aem = null;
        }
        this.aef = null;
        this.aej = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aek = i;
        this.ael = z;
        this.aej = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.ap.k(this.aej, i);
        } else {
            com.baidu.tbadk.core.util.ap.e(this.aej, i, 0);
        }
        this.aef = this.aej.getChildAt(0);
        if (this.aef != null) {
            this.aem = new l(this);
            this.aef.getViewTreeObserver().addOnGlobalLayoutListener(this.aem);
            this.aeh = this.aef.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU() {
        if (this.aef != null) {
            int height = this.aef.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int vV = vV();
            if (this.aen > 0 && this.aen <= this.aeh.height) {
                vV -= this.aen;
            }
            if (vV != this.aeg) {
                int i = this.mScreenHeight;
                int i2 = i - vV;
                if (i2 == 0) {
                    this.aeh.height = i;
                    vW();
                } else {
                    this.aeh.height = i - i2;
                    dh(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.aeg = vV;
            }
        }
    }

    private int vV() {
        Rect rect = new Rect();
        this.aef.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aen = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW() {
        this.aef.requestLayout();
    }

    private void dh(int i) {
        if (this.aei != null) {
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.aei);
            this.aei = null;
        }
        this.aei = new m(this);
        com.baidu.adp.lib.g.h.eE().postDelayed(this.aei, i);
    }
}
