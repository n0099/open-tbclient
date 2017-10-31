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
    private View alb;
    private int alc;
    private ViewGroup.LayoutParams ald;
    private Runnable ale;
    private FrameLayout alf;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int alg = d.C0080d.cp_bg_line_d;
    private boolean alh = false;
    private ViewTreeObserver.OnGlobalLayoutListener ali = null;
    private int alj = 0;

    public static e u(Activity activity) {
        return new e(activity);
    }

    public static e a(Activity activity, boolean z) {
        return new e(activity, z);
    }

    public static e a(Activity activity, int i, boolean z) {
        return new e(activity, i, z);
    }

    private e(Activity activity) {
        b(activity, d.C0080d.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, d.C0080d.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dj(int i) {
        if (this.alh) {
            if (i != this.mSkinType && this.alf != null) {
                aj.k(this.alf, this.alg);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ale != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ale);
            this.ale = null;
        }
        if (this.alb != null) {
            this.alb.getViewTreeObserver().removeGlobalOnLayoutListener(this.ali);
            this.alb.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ali = null;
        }
        this.alb = null;
        this.alf = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.alg = i;
        this.alh = z;
        this.alf = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.alf, i);
        } else {
            aj.e(this.alf, i, 0);
        }
        this.alb = this.alf.getChildAt(0);
        if (this.alb != null) {
            this.ali = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wh();
                }
            };
            this.alb.getViewTreeObserver().addOnGlobalLayoutListener(this.ali);
            this.ald = this.alb.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh() {
        if (this.alb != null) {
            int height = this.alb.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wi = wi();
            if (this.alj > 0 && this.alj <= this.ald.height) {
                wi -= this.alj;
            }
            if (wi != this.alc) {
                int i = this.mScreenHeight;
                int i2 = i - wi;
                if (i2 == 0) {
                    this.ald.height = i;
                    wj();
                } else {
                    this.ald.height = i - i2;
                    dk(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.alc = wi;
            }
        }
    }

    private int wi() {
        Rect rect = new Rect();
        this.alb.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.alj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj() {
        this.alb.requestLayout();
    }

    private void dk(int i) {
        if (this.ale != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ale);
            this.ale = null;
        }
        this.ale = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wj();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ale, i);
    }
}
