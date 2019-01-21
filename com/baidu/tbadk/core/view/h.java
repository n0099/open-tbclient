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
    private View aHQ;
    private ViewGroup.LayoutParams aHR;
    private Runnable aHS;
    private FrameLayout aHT;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int aHU = e.d.cp_bg_line_d;
    private boolean aHV = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int aHW = 0;

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
        if (this.aHV) {
            if (i != this.mSkinType && this.aHT != null) {
                al.j(this.aHT, this.aHU);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.aHS != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHS);
            this.aHS = null;
        }
        if (this.aHQ != null) {
            this.aHQ.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.aHQ = null;
        this.aHT = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.aHU = i;
        this.aHV = z;
        this.aHT = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.aHT, i);
        } else {
            al.e(this.aHT, i, 0);
        }
        this.aHQ = this.aHT.getChildAt(0);
        if (this.aHQ != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.Fd();
                }
            };
            this.aHQ.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.aHR = this.aHQ.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.aHQ != null) {
            int height = this.aHQ.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Fe = Fe();
            if (this.aHW > 0 && this.aHW <= this.aHR.height) {
                Fe -= this.aHW;
            }
            if (Fe != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - Fe;
                if (i2 == 0) {
                    this.aHR.height = i;
                    Ff();
                } else {
                    this.aHR.height = i - i2;
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
        this.aHQ.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.aHW = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ff() {
        this.aHQ.requestLayout();
    }

    private void ek(int i) {
        if (this.aHS != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.aHS);
            this.aHS = null;
        }
        this.aHS = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.Ff();
            }
        };
        com.baidu.adp.lib.g.e.jG().postDelayed(this.aHS, i);
    }
}
