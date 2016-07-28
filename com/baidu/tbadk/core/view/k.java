package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class k {
    private View acc;
    private int acd;
    private ViewGroup.LayoutParams ace;
    private Runnable acf;
    private FrameLayout acg;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ach = u.d.cp_bg_line_d;
    private boolean aci = false;
    private ViewTreeObserver.OnGlobalLayoutListener acj = null;
    private int ack = 0;

    public static k n(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, u.d.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, u.d.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void cO(int i) {
        if (this.aci) {
            if (i != this.mSkinType && this.acg != null) {
                av.l(this.acg, this.ach);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.acf != null) {
            TbadkCoreApplication.m10getInst().handler.removeCallbacks(this.acf);
            this.acf = null;
        }
        if (this.acc != null) {
            this.acc.getViewTreeObserver().removeGlobalOnLayoutListener(this.acj);
            this.acc.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.acj = null;
        }
        this.acc = null;
        this.acg = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ach = i;
        this.aci = z;
        this.acg = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            av.l(frameLayout, i);
        } else {
            av.e(frameLayout, i, 0);
        }
        this.acc = frameLayout.getChildAt(0);
        if (this.acc != null) {
            this.acj = new l(this);
            this.acc.getViewTreeObserver().addOnGlobalLayoutListener(this.acj);
            this.ace = this.acc.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU() {
        if (this.acc != null) {
            int height = this.acc.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int uV = uV();
            if (this.ack > 0 && this.ack <= this.ace.height) {
                uV -= this.ack;
            }
            if (uV != this.acd) {
                int i = this.mScreenHeight;
                int i2 = i - uV;
                if (i2 == 0) {
                    this.ace.height = i;
                    uW();
                } else {
                    this.ace.height = i - i2;
                    cP(200);
                    if (TbadkCoreApplication.m10getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m10getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m10getInst().setKeyboardHeight(i2);
                    }
                }
                this.acd = uV;
            }
        }
    }

    private int uV() {
        Rect rect = new Rect();
        this.acc.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ack = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW() {
        this.acc.requestLayout();
    }

    private void cP(int i) {
        if (this.acf != null) {
            TbadkCoreApplication.m10getInst().handler.removeCallbacks(this.acf);
            this.acf = null;
        }
        this.acf = new m(this);
        TbadkCoreApplication.m10getInst().handler.postDelayed(this.acf, i);
    }
}
