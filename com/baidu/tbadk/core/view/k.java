package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k {
    private View aeS;
    private int aeT;
    private ViewGroup.LayoutParams aeU;
    private Runnable aeV;
    private FrameLayout aeW;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aeX = t.d.cp_bg_line_d;
    private boolean aeY = false;
    private ViewTreeObserver.OnGlobalLayoutListener aeZ = null;
    private int afa = 0;

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
        b(activity, t.d.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, t.d.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dc(int i) {
        if (this.aeY) {
            if (i != this.mSkinType && this.aeW != null) {
                com.baidu.tbadk.core.util.av.l(this.aeW, this.aeX);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aeV != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aeV);
            this.aeV = null;
        }
        if (this.aeS != null) {
            this.aeS.getViewTreeObserver().removeGlobalOnLayoutListener(this.aeZ);
            this.aeS.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.aeZ = null;
        }
        this.aeS = null;
        this.aeW = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aeX = i;
        this.aeY = z;
        this.aeW = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.av.l(this.aeW, i);
        } else {
            com.baidu.tbadk.core.util.av.e(this.aeW, i, 0);
        }
        this.aeS = this.aeW.getChildAt(0);
        if (this.aeS != null) {
            this.aeZ = new l(this);
            this.aeS.getViewTreeObserver().addOnGlobalLayoutListener(this.aeZ);
            this.aeU = this.aeS.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY() {
        if (this.aeS != null) {
            int height = this.aeS.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int vZ = vZ();
            if (this.afa > 0 && this.afa <= this.aeU.height) {
                vZ -= this.afa;
            }
            if (vZ != this.aeT) {
                int i = this.mScreenHeight;
                int i2 = i - vZ;
                if (i2 == 0) {
                    this.aeU.height = i;
                    wa();
                } else {
                    this.aeU.height = i - i2;
                    dd(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.aeT = vZ;
            }
        }
    }

    private int vZ() {
        Rect rect = new Rect();
        this.aeS.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.afa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        this.aeS.requestLayout();
    }

    private void dd(int i) {
        if (this.aeV != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aeV);
            this.aeV = null;
        }
        this.aeV = new m(this);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.aeV, i);
    }
}
