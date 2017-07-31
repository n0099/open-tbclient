package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private FrameLayout alA;
    private View alw;
    private int alx;
    private ViewGroup.LayoutParams aly;
    private Runnable alz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int alB = d.e.cp_bg_line_d;
    private boolean alC = false;
    private ViewTreeObserver.OnGlobalLayoutListener alD = null;
    private int alE = 0;

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

    public void di(int i) {
        if (this.alC) {
            if (i != this.mSkinType && this.alA != null) {
                ai.k(this.alA, this.alB);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.alz != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.alz);
            this.alz = null;
        }
        if (this.alw != null) {
            this.alw.getViewTreeObserver().removeGlobalOnLayoutListener(this.alD);
            this.alw.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.alD = null;
        }
        this.alw = null;
        this.alA = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.alB = i;
        this.alC = z;
        this.alA = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            ai.k(this.alA, i);
        } else {
            ai.e(this.alA, i, 0);
        }
        this.alw = this.alA.getChildAt(0);
        if (this.alw != null) {
            this.alD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wF();
                }
            };
            this.alw.getViewTreeObserver().addOnGlobalLayoutListener(this.alD);
            this.aly = this.alw.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF() {
        if (this.alw != null) {
            int height = this.alw.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wG = wG();
            if (this.alE > 0 && this.alE <= this.aly.height) {
                wG -= this.alE;
            }
            if (wG != this.alx) {
                int i = this.mScreenHeight;
                int i2 = i - wG;
                if (i2 == 0) {
                    this.aly.height = i;
                    wH();
                } else {
                    this.aly.height = i - i2;
                    dj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.alx = wG;
            }
        }
    }

    private int wG() {
        Rect rect = new Rect();
        this.alw.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.alE = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        this.alw.requestLayout();
    }

    private void dj(int i) {
        if (this.alz != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.alz);
            this.alz = null;
        }
        this.alz = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wH();
            }
        };
        com.baidu.adp.lib.g.e.ga().postDelayed(this.alz, i);
    }
}
