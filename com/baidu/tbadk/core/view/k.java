package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k {
    private View afZ;
    private int aga;
    private ViewGroup.LayoutParams agb;
    private Runnable agc;
    private FrameLayout agd;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int agf = t.d.usual_page_bg;
    private boolean agg = false;
    private ViewTreeObserver.OnGlobalLayoutListener agh = null;

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
        b(activity, t.d.usual_page_bg, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, t.d.usual_page_bg, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void db(int i) {
        if (this.agg) {
            if (i != this.mSkinType && this.agd != null) {
                ar.l(this.agd, this.agf);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.agc != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.agc);
            this.agc = null;
        }
        if (this.afZ != null) {
            this.afZ.getViewTreeObserver().removeGlobalOnLayoutListener(this.agh);
            this.afZ.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.agh = null;
        }
        this.afZ = null;
        this.agd = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.agf = i;
        this.agg = z;
        this.agd = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            ar.l(frameLayout, i);
        } else {
            ar.d(frameLayout, i, 0);
        }
        this.afZ = frameLayout.getChildAt(0);
        if (this.afZ != null) {
            this.agh = new l(this);
            this.afZ.getViewTreeObserver().addOnGlobalLayoutListener(this.agh);
            this.agb = this.afZ.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wR() {
        if (this.afZ != null) {
            int height = this.afZ.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wS = wS();
            if (wS != this.aga) {
                int i = this.mScreenHeight;
                int i2 = i - wS;
                if (i2 == 0) {
                    this.agb.height = i;
                    wT();
                } else {
                    this.agb.height = i - i2;
                    dc(200);
                    if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m411getInst().setKeyboardHeight(i2);
                    }
                }
                this.aga = wS;
            }
        }
    }

    private int wS() {
        Rect rect = new Rect();
        this.afZ.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wT() {
        this.afZ.requestLayout();
    }

    private void dc(int i) {
        if (this.agc != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.agc);
            this.agc = null;
        }
        this.agc = new m(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.agc, i);
    }
}
