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
    private View abr;
    private int abt;
    private ViewGroup.LayoutParams abu;
    private Runnable abv;
    private FrameLayout abw;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int abx = u.d.cp_bg_line_d;
    private boolean aby = false;
    private ViewTreeObserver.OnGlobalLayoutListener abz = null;
    private int abA = 0;

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
        if (this.aby) {
            if (i != this.mSkinType && this.abw != null) {
                av.l(this.abw, this.abx);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.abv != null) {
            TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.abv);
            this.abv = null;
        }
        if (this.abr != null) {
            this.abr.getViewTreeObserver().removeGlobalOnLayoutListener(this.abz);
            this.abr.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.abz = null;
        }
        this.abr = null;
        this.abw = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.abx = i;
        this.aby = z;
        this.abw = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            av.l(frameLayout, i);
        } else {
            av.e(frameLayout, i, 0);
        }
        this.abr = frameLayout.getChildAt(0);
        if (this.abr != null) {
            this.abz = new l(this);
            this.abr.getViewTreeObserver().addOnGlobalLayoutListener(this.abz);
            this.abu = this.abr.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU() {
        if (this.abr != null) {
            int height = this.abr.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int uV = uV();
            if (this.abA > 0 && this.abA <= this.abu.height) {
                uV -= this.abA;
            }
            if (uV != this.abt) {
                int i = this.mScreenHeight;
                int i2 = i - uV;
                if (i2 == 0) {
                    this.abu.height = i;
                    uW();
                } else {
                    this.abu.height = i - i2;
                    cP(200);
                    if (TbadkCoreApplication.m9getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m9getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m9getInst().setKeyboardHeight(i2);
                    }
                }
                this.abt = uV;
            }
        }
    }

    private int uV() {
        Rect rect = new Rect();
        this.abr.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.abA = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW() {
        this.abr.requestLayout();
    }

    private void cP(int i) {
        if (this.abv != null) {
            TbadkCoreApplication.m9getInst().handler.removeCallbacks(this.abv);
            this.abv = null;
        }
        this.abv = new m(this);
        TbadkCoreApplication.m9getInst().handler.postDelayed(this.abv, i);
    }
}
