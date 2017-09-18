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
    private View akQ;
    private int akR;
    private ViewGroup.LayoutParams akS;
    private Runnable akT;
    private FrameLayout akU;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int akV = d.e.cp_bg_line_d;
    private boolean akW = false;
    private ViewTreeObserver.OnGlobalLayoutListener akX = null;
    private int akY = 0;

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
        if (this.akW) {
            if (i != this.mSkinType && this.akU != null) {
                aj.k(this.akU, this.akV);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.akT != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.akT);
            this.akT = null;
        }
        if (this.akQ != null) {
            this.akQ.getViewTreeObserver().removeGlobalOnLayoutListener(this.akX);
            this.akQ.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.akX = null;
        }
        this.akQ = null;
        this.akU = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.akV = i;
        this.akW = z;
        this.akU = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.akU, i);
        } else {
            aj.e(this.akU, i, 0);
        }
        this.akQ = this.akU.getChildAt(0);
        if (this.akQ != null) {
            this.akX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wD();
                }
            };
            this.akQ.getViewTreeObserver().addOnGlobalLayoutListener(this.akX);
            this.akS = this.akQ.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD() {
        if (this.akQ != null) {
            int height = this.akQ.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wE = wE();
            if (this.akY > 0 && this.akY <= this.akS.height) {
                wE -= this.akY;
            }
            if (wE != this.akR) {
                int i = this.mScreenHeight;
                int i2 = i - wE;
                if (i2 == 0) {
                    this.akS.height = i;
                    wF();
                } else {
                    this.akS.height = i - i2;
                    dk(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.akR = wE;
            }
        }
    }

    private int wE() {
        Rect rect = new Rect();
        this.akQ.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.akY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF() {
        this.akQ.requestLayout();
    }

    private void dk(int i) {
        if (this.akT != null) {
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.akT);
            this.akT = null;
        }
        this.akT = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wF();
            }
        };
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.akT, i);
    }
}
