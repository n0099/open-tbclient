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
    private View bXQ;
    private ViewGroup.LayoutParams bXR;
    private Runnable bXS;
    private FrameLayout bXT;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bXU = R.color.cp_bg_line_d;
    private boolean bXV = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bXW = 0;

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
        if (this.bXV) {
            if (i != this.mSkinType && this.bXT != null) {
                al.l(this.bXT, this.bXU);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bXS != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.bXS);
            this.bXS = null;
        }
        if (this.bXQ != null) {
            this.bXQ.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bXQ = null;
        this.bXT = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bXU = i;
        this.bXV = z;
        this.bXT = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bXT, i);
        } else {
            al.h(this.bXT, i, 0);
        }
        this.bXQ = this.bXT.getChildAt(0);
        if (this.bXQ != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.ajl();
                }
            };
            this.bXQ.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bXR = this.bXQ.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajl() {
        if (this.bXQ != null) {
            int height = this.bXQ.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ajm = ajm();
            if (this.bXW > 0 && this.bXW <= this.bXR.height) {
                ajm -= this.bXW;
            }
            if (ajm != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - ajm;
                if (i2 == 0) {
                    this.bXR.height = i;
                    ajn();
                } else {
                    this.bXR.height = i - i2;
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
        this.bXQ.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bXW = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajn() {
        this.bXQ.requestLayout();
    }

    private void iB(int i) {
        if (this.bXS != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.bXS);
            this.bXS = null;
        }
        this.bXS = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.ajn();
            }
        };
        com.baidu.adp.lib.g.e.iB().postDelayed(this.bXS, i);
    }
}
