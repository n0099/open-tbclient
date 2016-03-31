package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k {
    private int afA;
    private ViewGroup.LayoutParams afB;
    private Runnable afC;
    private FrameLayout afD;
    private View afz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int afE = t.d.usual_page_bg;
    private boolean afF = false;
    private ViewTreeObserver.OnGlobalLayoutListener afG = null;

    public static k l(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, t.d.usual_page_bg, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, t.d.usual_page_bg, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void de(int i) {
        if (this.afF) {
            if (i != this.mSkinType && this.afD != null) {
                at.l(this.afD, this.afE);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.afC != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.afC);
            this.afC = null;
        }
        if (this.afz != null) {
            this.afz.getViewTreeObserver().removeGlobalOnLayoutListener(this.afG);
            this.afz.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.afG = null;
        }
        this.afz = null;
        this.afD = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.afE = i;
        this.afF = z;
        this.afD = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            at.l(frameLayout, i);
        } else {
            at.d(frameLayout, i, 0);
        }
        this.afz = frameLayout.getChildAt(0);
        if (this.afz != null) {
            this.afG = new l(this);
            this.afz.getViewTreeObserver().addOnGlobalLayoutListener(this.afG);
            this.afB = this.afz.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.afz != null) {
            int height = this.afz.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int xl = xl();
            if (xl != this.afA) {
                int i = this.mScreenHeight;
                int i2 = i - xl;
                if (i2 == 0) {
                    this.afB.height = i;
                    xm();
                } else {
                    this.afB.height = i - i2;
                    df(200);
                    if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m411getInst().setKeyboardHeight(i2);
                    }
                }
                this.afA = xl;
            }
        }
    }

    private int xl() {
        Rect rect = new Rect();
        this.afz.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm() {
        this.afz.requestLayout();
    }

    private void df(int i) {
        if (this.afC != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.afC);
            this.afC = null;
        }
        this.afC = new m(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.afC, i);
    }
}
