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
    private View aHP;
    private ViewGroup.LayoutParams aHQ;
    private Runnable aHR;
    private FrameLayout aHS;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aHT = e.d.cp_bg_line_d;
    private boolean aHU = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aHV = 0;

    public static h D(Activity activity) {
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
        if (this.aHU) {
            if (i != this.mSkinType && this.aHS != null) {
                al.j(this.aHS, this.aHT);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aHR != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHR);
            this.aHR = null;
        }
        if (this.aHP != null) {
            this.aHP.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aHP = null;
        this.aHS = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aHT = i;
        this.aHU = z;
        this.aHS = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aHS, i);
        } else {
            al.e(this.aHS, i, 0);
        }
        this.aHP = this.aHS.getChildAt(0);
        if (this.aHP != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.Fd();
                }
            };
            this.aHP.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aHQ = this.aHP.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.aHP != null) {
            int height = this.aHP.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Fe = Fe();
            if (this.aHV > 0 && this.aHV <= this.aHQ.height) {
                Fe -= this.aHV;
            }
            if (Fe != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - Fe;
                if (i2 == 0) {
                    this.aHQ.height = i;
                    Ff();
                } else {
                    this.aHQ.height = i - i2;
                    ek(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = Fe;
            }
        }
    }

    private int Fe() {
        Rect rect = new Rect();
        this.aHP.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aHV = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff() {
        this.aHP.requestLayout();
    }

    private void ek(int i) {
        if (this.aHR != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHR);
            this.aHR = null;
        }
        this.aHR = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.Ff();
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aHR, i);
    }
}
