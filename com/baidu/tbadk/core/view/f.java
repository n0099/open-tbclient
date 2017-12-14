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
    private View alv;
    private int alw;
    private ViewGroup.LayoutParams alx;
    private Runnable aly;
    private FrameLayout alz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int alA = d.C0096d.cp_bg_line_d;
    private boolean alB = false;
    private ViewTreeObserver.OnGlobalLayoutListener alC = null;
    private int alD = 0;

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
        b(activity, d.C0096d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0096d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dj(int i) {
        if (this.alB) {
            if (i != this.mSkinType && this.alz != null) {
                aj.k(this.alz, this.alA);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aly != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aly);
            this.aly = null;
        }
        if (this.alv != null) {
            this.alv.getViewTreeObserver().removeGlobalOnLayoutListener(this.alC);
            this.alv.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.alC = null;
        }
        this.alv = null;
        this.alz = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.alA = i;
        this.alB = z;
        this.alz = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.alz, i);
        } else {
            aj.e(this.alz, i, 0);
        }
        this.alv = this.alz.getChildAt(0);
        if (this.alv != null) {
            this.alC = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.wj();
                }
            };
            this.alv.getViewTreeObserver().addOnGlobalLayoutListener(this.alC);
            this.alx = this.alv.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj() {
        if (this.alv != null) {
            int height = this.alv.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wk = wk();
            if (this.alD > 0 && this.alD <= this.alx.height) {
                wk -= this.alD;
            }
            if (wk != this.alw) {
                int i = this.mScreenHeight;
                int i2 = i - wk;
                if (i2 == 0) {
                    this.alx.height = i;
                    wl();
                } else {
                    this.alx.height = i - i2;
                    dk(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.alw = wk;
            }
        }
    }

    private int wk() {
        Rect rect = new Rect();
        this.alv.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.alD = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl() {
        this.alv.requestLayout();
    }

    private void dk(int i) {
        if (this.aly != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.aly);
            this.aly = null;
        }
        this.aly = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.wl();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.aly, i);
    }
}
