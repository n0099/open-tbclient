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
public class e {
    private View akR;
    private int akS;
    private ViewGroup.LayoutParams akT;
    private Runnable akU;
    private FrameLayout akV;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int akW = d.e.cp_bg_line_d;
    private boolean akX = false;
    private ViewTreeObserver.OnGlobalLayoutListener akY = null;
    private int akZ = 0;

    public static e t(Activity activity) {
        return new e(activity);
    }

    public static e a(Activity activity, boolean z) {
        return new e(activity, z);
    }

    public static e a(Activity activity, int i, boolean z) {
        return new e(activity, i, z);
    }

    private e(Activity activity) {
        b(activity, d.e.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, d.e.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dj(int i) {
        if (this.akX) {
            if (i != this.mSkinType && this.akV != null) {
                aj.k(this.akV, this.akW);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.akU != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akU);
            this.akU = null;
        }
        if (this.akR != null) {
            this.akR.getViewTreeObserver().removeGlobalOnLayoutListener(this.akY);
            this.akR.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.akY = null;
        }
        this.akR = null;
        this.akV = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.akW = i;
        this.akX = z;
        this.akV = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.akV, i);
        } else {
            aj.e(this.akV, i, 0);
        }
        this.akR = this.akV.getChildAt(0);
        if (this.akR != null) {
            this.akY = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wh();
                }
            };
            this.akR.getViewTreeObserver().addOnGlobalLayoutListener(this.akY);
            this.akT = this.akR.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        if (this.akR != null) {
            int height = this.akR.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wi = wi();
            if (this.akZ > 0 && this.akZ <= this.akT.height) {
                wi -= this.akZ;
            }
            if (wi != this.akS) {
                int i = this.mScreenHeight;
                int i2 = i - wi;
                if (i2 == 0) {
                    this.akT.height = i;
                    wj();
                } else {
                    this.akT.height = i - i2;
                    dk(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.akS = wi;
            }
        }
    }

    private int wi() {
        Rect rect = new Rect();
        this.akR.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.akZ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj() {
        this.akR.requestLayout();
    }

    private void dk(int i) {
        if (this.akU != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akU);
            this.akU = null;
        }
        this.akU = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wj();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.akU, i);
    }
}
