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
    private View aCW;
    private ViewGroup.LayoutParams aCX;
    private Runnable aCY;
    private FrameLayout aCZ;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aDa = e.d.cp_bg_line_d;
    private boolean aDb = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aDc = 0;

    public static h B(Activity activity) {
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

    public void dH(int i) {
        if (this.aDb) {
            if (i != this.mSkinType && this.aCZ != null) {
                al.j(this.aCZ, this.aDa);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aCY != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aCY);
            this.aCY = null;
        }
        if (this.aCW != null) {
            this.aCW.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aCW = null;
        this.aCZ = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aDa = i;
        this.aDb = z;
        this.aCZ = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aCZ, i);
        } else {
            al.e(this.aCZ, i, 0);
        }
        this.aCW = this.aCZ.getChildAt(0);
        if (this.aCW != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.DC();
                }
            };
            this.aCW.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aCX = this.aCW.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        if (this.aCW != null) {
            int height = this.aCW.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DD = DD();
            if (this.aDc > 0 && this.aDc <= this.aCX.height) {
                DD -= this.aDc;
            }
            if (DD != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - DD;
                if (i2 == 0) {
                    this.aCX.height = i;
                    DE();
                } else {
                    this.aCX.height = i - i2;
                    dI(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = DD;
            }
        }
    }

    private int DD() {
        Rect rect = new Rect();
        this.aCW.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aDc = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE() {
        this.aCW.requestLayout();
    }

    private void dI(int i) {
        if (this.aCY != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.aCY);
            this.aCY = null;
        }
        this.aCY = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.DE();
            }
        };
        com.baidu.adp.lib.g.e.jI().postDelayed(this.aCY, i);
    }
}
