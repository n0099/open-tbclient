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
    private ViewGroup.LayoutParams alA;
    private Runnable alB;
    private FrameLayout alC;
    private View aly;
    private int alz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int alD = d.C0095d.cp_bg_line_d;
    private boolean alE = false;
    private ViewTreeObserver.OnGlobalLayoutListener alF = null;
    private int alG = 0;

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
        b(activity, d.C0095d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0095d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dj(int i) {
        if (this.alE) {
            if (i != this.mSkinType && this.alC != null) {
                aj.k(this.alC, this.alD);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.alB != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.alB);
            this.alB = null;
        }
        if (this.aly != null) {
            this.aly.getViewTreeObserver().removeGlobalOnLayoutListener(this.alF);
            this.aly.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.alF = null;
        }
        this.aly = null;
        this.alC = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.alD = i;
        this.alE = z;
        this.alC = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.alC, i);
        } else {
            aj.e(this.alC, i, 0);
        }
        this.aly = this.alC.getChildAt(0);
        if (this.aly != null) {
            this.alF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.wj();
                }
            };
            this.aly.getViewTreeObserver().addOnGlobalLayoutListener(this.alF);
            this.alA = this.aly.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj() {
        if (this.aly != null) {
            int height = this.aly.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wk = wk();
            if (this.alG > 0 && this.alG <= this.alA.height) {
                wk -= this.alG;
            }
            if (wk != this.alz) {
                int i = this.mScreenHeight;
                int i2 = i - wk;
                if (i2 == 0) {
                    this.alA.height = i;
                    wl();
                } else {
                    this.alA.height = i - i2;
                    dk(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.alz = wk;
            }
        }
    }

    private int wk() {
        Rect rect = new Rect();
        this.aly.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.alG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl() {
        this.aly.requestLayout();
    }

    private void dk(int i) {
        if (this.alB != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.alB);
            this.alB = null;
        }
        this.alB = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.wl();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.alB, i);
    }
}
