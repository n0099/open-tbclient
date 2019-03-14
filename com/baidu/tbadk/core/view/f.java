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
    private View bPY;
    private ViewGroup.LayoutParams bPZ;
    private Runnable bQa;
    private FrameLayout bQb;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bQc = d.C0277d.cp_bg_line_d;
    private boolean bQd = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bQe = 0;

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
        b(activity, d.C0277d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0277d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void hN(int i) {
        if (this.bQd) {
            if (i != this.mSkinType && this.bQb != null) {
                al.l(this.bQb, this.bQc);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bQa != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQa);
            this.bQa = null;
        }
        if (this.bPY != null) {
            this.bPY.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bPY = null;
        this.bQb = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bQc = i;
        this.bQd = z;
        this.bQb = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bQb, i);
        } else {
            al.f(this.bQb, i, 0);
        }
        this.bPY = this.bQb.getChildAt(0);
        if (this.bPY != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.aep();
                }
            };
            this.bPY.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bPZ = this.bPY.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        if (this.bPY != null) {
            int height = this.bPY.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int aeq = aeq();
            if (this.bQe > 0 && this.bQe <= this.bPZ.height) {
                aeq -= this.bQe;
            }
            if (aeq != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - aeq;
                if (i2 == 0) {
                    this.bPZ.height = i;
                    aer();
                } else {
                    this.bPZ.height = i - i2;
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
        this.bPY.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bQe = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        this.bPY.requestLayout();
    }

    private void hO(int i) {
        if (this.bQa != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQa);
            this.bQa = null;
        }
        this.bQa = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.aer();
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.bQa, i);
    }
}
