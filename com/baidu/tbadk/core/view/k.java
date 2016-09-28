package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k {
    private View afd;
    private int afe;
    private ViewGroup.LayoutParams aff;
    private Runnable afg;
    private FrameLayout afh;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int afi = r.d.cp_bg_line_d;
    private boolean afj = false;
    private ViewTreeObserver.OnGlobalLayoutListener afk = null;
    private int afl = 0;

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
        b(activity, r.d.cp_bg_line_d, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, r.d.cp_bg_line_d, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dc(int i) {
        if (this.afj) {
            if (i != this.mSkinType && this.afh != null) {
                av.l(this.afh, this.afi);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.afg != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.afg);
            this.afg = null;
        }
        if (this.afd != null) {
            this.afd.getViewTreeObserver().removeGlobalOnLayoutListener(this.afk);
            this.afd.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.afk = null;
        }
        this.afd = null;
        this.afh = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.afi = i;
        this.afj = z;
        this.afh = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            av.l(this.afh, i);
        } else {
            av.e(this.afh, i, 0);
        }
        this.afd = this.afh.getChildAt(0);
        if (this.afd != null) {
            this.afk = new l(this);
            this.afd.getViewTreeObserver().addOnGlobalLayoutListener(this.afk);
            this.aff = this.afd.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm() {
        if (this.afd != null) {
            int height = this.afd.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wn = wn();
            if (this.afl > 0 && this.afl <= this.aff.height) {
                wn -= this.afl;
            }
            if (wn != this.afe) {
                int i = this.mScreenHeight;
                int i2 = i - wn;
                if (i2 == 0) {
                    this.aff.height = i;
                    wo();
                } else {
                    this.aff.height = i - i2;
                    dd(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.afe = wn;
            }
        }
    }

    private int wn() {
        Rect rect = new Rect();
        this.afd.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.afl = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo() {
        this.afd.requestLayout();
    }

    private void dd(int i) {
        if (this.afg != null) {
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.afg);
            this.afg = null;
        }
        this.afg = new m(this);
        com.baidu.adp.lib.h.h.eG().postDelayed(this.afg, i);
    }
}
