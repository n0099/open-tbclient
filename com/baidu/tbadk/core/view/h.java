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
    private View aDM;
    private ViewGroup.LayoutParams aDN;
    private Runnable aDO;
    private FrameLayout aDP;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aDQ = e.d.cp_bg_line_d;
    private boolean aDR = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aDS = 0;

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

    public void dV(int i) {
        if (this.aDR) {
            if (i != this.mSkinType && this.aDP != null) {
                al.j(this.aDP, this.aDQ);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aDO != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aDO);
            this.aDO = null;
        }
        if (this.aDM != null) {
            this.aDM.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aDM = null;
        this.aDP = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aDQ = i;
        this.aDR = z;
        this.aDP = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aDP, i);
        } else {
            al.e(this.aDP, i, 0);
        }
        this.aDM = this.aDP.getChildAt(0);
        if (this.aDM != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.DM();
                }
            };
            this.aDM.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aDN = this.aDM.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DM() {
        if (this.aDM != null) {
            int height = this.aDM.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int DN = DN();
            if (this.aDS > 0 && this.aDS <= this.aDN.height) {
                DN -= this.aDS;
            }
            if (DN != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - DN;
                if (i2 == 0) {
                    this.aDN.height = i;
                    DO();
                } else {
                    this.aDN.height = i - i2;
                    dW(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = DN;
            }
        }
    }

    private int DN() {
        Rect rect = new Rect();
        this.aDM.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aDS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DO() {
        this.aDM.requestLayout();
    }

    private void dW(int i) {
        if (this.aDO != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aDO);
            this.aDO = null;
        }
        this.aDO = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.DO();
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aDO, i);
    }
}
