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
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class h {
    private View aHn;
    private ViewGroup.LayoutParams aHo;
    private Runnable aHp;
    private FrameLayout aHq;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aHr = e.d.cp_bg_line_d;
    private boolean aHs = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aHt = 0;

    public static h C(Activity activity) {
        return new h(activity);
    }

    public static h d(Activity activity, boolean z) {
        return new h(activity, z);
    }

    public static h a(Activity activity, int i, boolean z) {
        return new h(activity, i, z);
    }

    private h(Activity activity) {
        b(activity, e.d.cp_bg_line_d, true);
    }

    private h(Activity activity, boolean z) {
        b(activity, e.d.cp_bg_line_d, z);
    }

    private h(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void ej(int i) {
        if (this.aHs) {
            if (i != this.mSkinType && this.aHq != null) {
                al.j(this.aHq, this.aHr);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aHp != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHp);
            this.aHp = null;
        }
        if (this.aHn != null) {
            this.aHn.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aHn = null;
        this.aHq = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aHr = i;
        this.aHs = z;
        this.aHq = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aHq, i);
        } else {
            al.e(this.aHq, i, 0);
        }
        this.aHn = this.aHq.getChildAt(0);
        if (this.aHn != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.EQ();
                }
            };
            this.aHn.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aHo = this.aHn.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        if (this.aHn != null) {
            int height = this.aHn.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ER = ER();
            if (this.aHt > 0 && this.aHt <= this.aHo.height) {
                ER -= this.aHt;
            }
            if (ER != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - ER;
                if (i2 == 0) {
                    this.aHo.height = i;
                    ES();
                } else {
                    this.aHo.height = i - i2;
                    ek(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = ER;
            }
        }
    }

    private int ER() {
        Rect rect = new Rect();
        this.aHn.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aHt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES() {
        this.aHn.requestLayout();
    }

    private void ek(int i) {
        if (this.aHp != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHp);
            this.aHp = null;
        }
        this.aHp = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.ES();
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aHp, i);
    }
}
