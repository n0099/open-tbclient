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
    private View aiW;
    private int aiX;
    private ViewGroup.LayoutParams aiY;
    private Runnable aiZ;
    private FrameLayout aja;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajb = w.e.cp_bg_line_d;
    private boolean ajc = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajd = null;
    private int aje = 0;

    public static k t(Activity activity) {
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
        if (this.ajc) {
            if (i != this.mSkinType && this.aja != null) {
                com.baidu.tbadk.core.util.aq.k(this.aja, this.ajb);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aiZ != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aiZ);
            this.aiZ = null;
        }
        if (this.aiW != null) {
            this.aiW.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajd);
            this.aiW.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajd = null;
        }
        this.aiW = null;
        this.aja = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajb = i;
        this.ajc = z;
        this.aja = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.aq.k(this.aja, i);
        } else {
            com.baidu.tbadk.core.util.aq.e(this.aja, i, 0);
        }
        this.aiW = this.aja.getChildAt(0);
        if (this.aiW != null) {
            this.ajd = new l(this);
            this.aiW.getViewTreeObserver().addOnGlobalLayoutListener(this.ajd);
            this.aiY = this.aiW.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vX() {
        if (this.aiW != null) {
            int height = this.aiW.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int vY = vY();
            if (this.aje > 0 && this.aje <= this.aiY.height) {
                vY -= this.aje;
            }
            if (vY != this.aiX) {
                int i = this.mScreenHeight;
                int i2 = i - vY;
                if (i2 == 0) {
                    this.aiY.height = i;
                    vZ();
                } else {
                    this.aiY.height = i - i2;
                    dd(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.aiX = vY;
            }
        }
    }

    private int vY() {
        Rect rect = new Rect();
        this.aiW.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aje = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ() {
        this.aiW.requestLayout();
    }

    private void dd(int i) {
        if (this.aiZ != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.aiZ);
            this.aiZ = null;
        }
        this.aiZ = new m(this);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.aiZ, i);
    }
}
