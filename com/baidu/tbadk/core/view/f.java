package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class f {
    private View bZR;
    private ViewGroup.LayoutParams bZS;
    private Runnable bZT;
    private FrameLayout bZU;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bZV = R.color.cp_bg_line_d;
    private boolean bZW = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bZX = 0;

    public static f af(Activity activity) {
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

    public void iJ(int i) {
        if (this.bZW) {
            if (i != this.mSkinType && this.bZU != null) {
                am.l(this.bZU, this.bZV);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bZT != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bZT);
            this.bZT = null;
        }
        if (this.bZR != null) {
            this.bZR.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bZR = null;
        this.bZU = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bZV = i;
        this.bZW = z;
        this.bZU = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.l(this.bZU, i);
        } else {
            am.h(this.bZU, i, 0);
        }
        this.bZR = this.bZU.getChildAt(0);
        if (this.bZR != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.akD();
                }
            };
            this.bZR.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bZS = this.bZR.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akD() {
        if (this.bZR != null) {
            int height = this.bZR.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int akE = akE();
            if (this.bZX > 0 && this.bZX <= this.bZS.height) {
                akE -= this.bZX;
            }
            if (akE != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - akE;
                if (i2 == 0) {
                    this.bZS.height = i;
                    akF();
                } else {
                    this.bZS.height = i - i2;
                    iK(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = akE;
            }
        }
    }

    private int akE() {
        Rect rect = new Rect();
        this.bZR.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bZX = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        this.bZR.requestLayout();
    }

    private void iK(int i) {
        if (this.bZT != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bZT);
            this.bZT = null;
        }
        this.bZT = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.akF();
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.bZT, i);
    }
}
