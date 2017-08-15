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
    private ViewGroup.LayoutParams alA;
    private Runnable alB;
    private FrameLayout alC;
    private View aly;
    private int alz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int alD = d.e.cp_bg_line_d;
    private boolean alE = false;
    private ViewTreeObserver.OnGlobalLayoutListener alF = null;
    private int alG = 0;

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
        if (this.alE) {
            if (i != this.mSkinType && this.alC != null) {
                ai.k(this.alC, this.alD);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.alB != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.alB);
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
            ai.k(this.alC, i);
        } else {
            ai.e(this.alC, i, 0);
        }
        this.aly = this.alC.getChildAt(0);
        if (this.aly != null) {
            this.alF = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wF();
                }
            };
            this.aly.getViewTreeObserver().addOnGlobalLayoutListener(this.alF);
            this.alA = this.aly.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF() {
        if (this.aly != null) {
            int height = this.aly.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wG = wG();
            if (this.alG > 0 && this.alG <= this.alA.height) {
                wG -= this.alG;
            }
            if (wG != this.alz) {
                int i = this.mScreenHeight;
                int i2 = i - wG;
                if (i2 == 0) {
                    this.alA.height = i;
                    wH();
                } else {
                    this.alA.height = i - i2;
                    dj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.alz = wG;
            }
        }
    }

    private int wG() {
        Rect rect = new Rect();
        this.aly.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.alG = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH() {
        this.aly.requestLayout();
    }

    private void dj(int i) {
        if (this.alB != null) {
            com.baidu.adp.lib.g.e.ga().removeCallbacks(this.alB);
            this.alB = null;
        }
        this.alB = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wH();
            }
        };
        com.baidu.adp.lib.g.e.ga().postDelayed(this.alB, i);
    }
}
