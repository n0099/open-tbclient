package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k {
    private View ajg;
    private int ajh;
    private ViewGroup.LayoutParams aji;
    private Runnable ajj;
    private FrameLayout ajk;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int ajl = w.e.cp_bg_line_d;
    private boolean ajm = false;
    private ViewTreeObserver.OnGlobalLayoutListener ajn = null;
    private int ajo = 0;

    public static k r(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, w.e.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, w.e.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void db(int i) {
        if (this.ajm) {
            if (i != this.mSkinType && this.ajk != null) {
                com.baidu.tbadk.core.util.aq.k(this.ajk, this.ajl);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ajj != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ajj);
            this.ajj = null;
        }
        if (this.ajg != null) {
            this.ajg.getViewTreeObserver().removeGlobalOnLayoutListener(this.ajn);
            this.ajg.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.ajn = null;
        }
        this.ajg = null;
        this.ajk = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ajl = i;
        this.ajm = z;
        this.ajk = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.aq.k(this.ajk, i);
        } else {
            com.baidu.tbadk.core.util.aq.e(this.ajk, i, 0);
        }
        this.ajg = this.ajk.getChildAt(0);
        if (this.ajg != null) {
            this.ajn = new l(this);
            this.ajg.getViewTreeObserver().addOnGlobalLayoutListener(this.ajn);
            this.aji = this.ajg.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        if (this.ajg != null) {
            int height = this.ajg.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wb = wb();
            if (this.ajo > 0 && this.ajo <= this.aji.height) {
                wb -= this.ajo;
            }
            if (wb != this.ajh) {
                int i = this.mScreenHeight;
                int i2 = i - wb;
                if (i2 == 0) {
                    this.aji.height = i;
                    wc();
                } else {
                    this.aji.height = i - i2;
                    dc(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.ajh = wb;
            }
        }
    }

    private int wb() {
        Rect rect = new Rect();
        this.ajg.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ajo = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc() {
        this.ajg.requestLayout();
    }

    private void dc(int i) {
        if (this.ajj != null) {
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.ajj);
            this.ajj = null;
        }
        this.ajj = new m(this);
        com.baidu.adp.lib.g.h.fS().postDelayed(this.ajj, i);
    }
}
