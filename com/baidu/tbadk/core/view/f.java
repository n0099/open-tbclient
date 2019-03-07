package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class f {
    private View bPX;
    private ViewGroup.LayoutParams bPY;
    private Runnable bPZ;
    private FrameLayout bQa;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bQb = d.C0236d.cp_bg_line_d;
    private boolean bQc = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bQd = 0;

    public static f aa(Activity activity) {
        return new f(activity);
    }

    public static f f(Activity activity, boolean z) {
        return new f(activity, z);
    }

    public static f a(Activity activity, int i, boolean z) {
        return new f(activity, i, z);
    }

    private f(Activity activity) {
        b(activity, d.C0236d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0236d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void hN(int i) {
        if (this.bQc) {
            if (i != this.mSkinType && this.bQa != null) {
                al.l(this.bQa, this.bQb);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bPZ != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bPZ);
            this.bPZ = null;
        }
        if (this.bPX != null) {
            this.bPX.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bPX = null;
        this.bQa = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bQb = i;
        this.bQc = z;
        this.bQa = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bQa, i);
        } else {
            al.f(this.bQa, i, 0);
        }
        this.bPX = this.bQa.getChildAt(0);
        if (this.bPX != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.aep();
                }
            };
            this.bPX.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bPY = this.bPX.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        if (this.bPX != null) {
            int height = this.bPX.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int aeq = aeq();
            if (this.bQd > 0 && this.bQd <= this.bPY.height) {
                aeq -= this.bQd;
            }
            if (aeq != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - aeq;
                if (i2 == 0) {
                    this.bPY.height = i;
                    aer();
                } else {
                    this.bPY.height = i - i2;
                    hO(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = aeq;
            }
        }
    }

    private int aeq() {
        Rect rect = new Rect();
        this.bPX.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bQd = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        this.bPX.requestLayout();
    }

    private void hO(int i) {
        if (this.bPZ != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bPZ);
            this.bPZ = null;
        }
        this.bPZ = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.aer();
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.bPZ, i);
    }
}
