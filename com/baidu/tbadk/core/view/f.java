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
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class f {
    private View bXP;
    private ViewGroup.LayoutParams bXQ;
    private Runnable bXR;
    private FrameLayout bXS;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bXT = R.color.cp_bg_line_d;
    private boolean bXU = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bXV = 0;

    public static f ac(Activity activity) {
        return new f(activity);
    }

    public static f f(Activity activity, boolean z) {
        return new f(activity, z);
    }

    public static f a(Activity activity, int i, boolean z) {
        return new f(activity, i, z);
    }

    private f(Activity activity) {
        b(activity, R.color.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, R.color.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void iA(int i) {
        if (this.bXU) {
            if (i != this.mSkinType && this.bXS != null) {
                al.l(this.bXS, this.bXT);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bXR != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.bXR);
            this.bXR = null;
        }
        if (this.bXP != null) {
            this.bXP.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bXP = null;
        this.bXS = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bXT = i;
        this.bXU = z;
        this.bXS = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bXS, i);
        } else {
            al.h(this.bXS, i, 0);
        }
        this.bXP = this.bXS.getChildAt(0);
        if (this.bXP != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.ajl();
                }
            };
            this.bXP.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bXQ = this.bXP.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajl() {
        if (this.bXP != null) {
            int height = this.bXP.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ajm = ajm();
            if (this.bXV > 0 && this.bXV <= this.bXQ.height) {
                ajm -= this.bXV;
            }
            if (ajm != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - ajm;
                if (i2 == 0) {
                    this.bXQ.height = i;
                    ajn();
                } else {
                    this.bXQ.height = i - i2;
                    iB(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = ajm;
            }
        }
    }

    private int ajm() {
        Rect rect = new Rect();
        this.bXP.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bXV = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajn() {
        this.bXP.requestLayout();
    }

    private void iB(int i) {
        if (this.bXR != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.bXR);
            this.bXR = null;
        }
        this.bXR = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.ajn();
            }
        };
        com.baidu.adp.lib.g.e.iB().postDelayed(this.bXR, i);
    }
}
