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
    private View aHm;
    private ViewGroup.LayoutParams aHn;
    private Runnable aHo;
    private FrameLayout aHp;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aHq = e.d.cp_bg_line_d;
    private boolean aHr = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aHs = 0;

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
        if (this.aHr) {
            if (i != this.mSkinType && this.aHp != null) {
                al.j(this.aHp, this.aHq);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aHo != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHo);
            this.aHo = null;
        }
        if (this.aHm != null) {
            this.aHm.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aHm = null;
        this.aHp = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aHq = i;
        this.aHr = z;
        this.aHp = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aHp, i);
        } else {
            al.e(this.aHp, i, 0);
        }
        this.aHm = this.aHp.getChildAt(0);
        if (this.aHm != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.EQ();
                }
            };
            this.aHm.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aHn = this.aHm.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        if (this.aHm != null) {
            int height = this.aHm.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ER = ER();
            if (this.aHs > 0 && this.aHs <= this.aHn.height) {
                ER -= this.aHs;
            }
            if (ER != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - ER;
                if (i2 == 0) {
                    this.aHn.height = i;
                    ES();
                } else {
                    this.aHn.height = i - i2;
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
        this.aHm.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aHs = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ES() {
        this.aHm.requestLayout();
    }

    private void ek(int i) {
        if (this.aHo != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHo);
            this.aHo = null;
        }
        this.aHo = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.ES();
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aHo, i);
    }
}
