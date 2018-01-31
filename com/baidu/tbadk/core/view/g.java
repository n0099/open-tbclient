package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class g {
    private View aZG;
    private int aZH;
    private ViewGroup.LayoutParams aZI;
    private Runnable aZJ;
    private FrameLayout aZK;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int aZL = d.C0108d.cp_bg_line_d;
    private boolean aZM = false;
    private ViewTreeObserver.OnGlobalLayoutListener HX = null;
    private int aZN = 0;

    public static g w(Activity activity) {
        return new g(activity);
    }

    public static g a(Activity activity, boolean z) {
        return new g(activity, z);
    }

    public static g a(Activity activity, int i, boolean z) {
        return new g(activity, i, z);
    }

    private g(Activity activity) {
        b(activity, d.C0108d.cp_bg_line_d, true);
    }

    private g(Activity activity, boolean z) {
        b(activity, d.C0108d.cp_bg_line_d, z);
    }

    private g(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void gg(int i) {
        if (this.aZM) {
            if (i != this.mSkinType && this.aZK != null) {
                aj.t(this.aZK, this.aZL);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aZJ != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.aZJ);
            this.aZJ = null;
        }
        if (this.aZG != null) {
            this.aZG.getViewTreeObserver().removeGlobalOnLayoutListener(this.HX);
            this.HX = null;
        }
        this.aZG = null;
        this.aZK = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aZL = i;
        this.aZM = z;
        this.aZK = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.t(this.aZK, i);
        } else {
            aj.g(this.aZK, i, 0);
        }
        this.aZG = this.aZK.getChildAt(0);
        if (this.aZG != null) {
            this.HX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.g.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g.this.DA();
                }
            };
            this.aZG.getViewTreeObserver().addOnGlobalLayoutListener(this.HX);
            this.aZI = this.aZG.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DA() {
        if (this.aZG != null) {
            int height = this.aZG.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DB = DB();
            if (this.aZN > 0 && this.aZN <= this.aZI.height) {
                DB -= this.aZN;
            }
            if (DB != this.aZH) {
                int i = this.mScreenHeight;
                int i2 = i - DB;
                if (i2 == 0) {
                    this.aZI.height = i;
                    DC();
                } else {
                    this.aZI.height = i - i2;
                    gh(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.aZH = DB;
            }
        }
    }

    private int DB() {
        Rect rect = new Rect();
        this.aZG.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aZN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DC() {
        this.aZG.requestLayout();
    }

    private void gh(int i) {
        if (this.aZJ != null) {
            com.baidu.adp.lib.g.e.ns().removeCallbacks(this.aZJ);
            this.aZJ = null;
        }
        this.aZJ = new Runnable() { // from class: com.baidu.tbadk.core.view.g.2
            @Override // java.lang.Runnable
            public void run() {
                g.this.DC();
            }
        };
        com.baidu.adp.lib.g.e.ns().postDelayed(this.aZJ, i);
    }
}
