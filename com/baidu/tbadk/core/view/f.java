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
    private View bYS;
    private ViewGroup.LayoutParams bYT;
    private Runnable bYU;
    private FrameLayout bYV;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bYW = R.color.cp_bg_line_d;
    private boolean bYX = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bYY = 0;

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

    public void iG(int i) {
        if (this.bYX) {
            if (i != this.mSkinType && this.bYV != null) {
                am.l(this.bYV, this.bYW);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bYU != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bYU);
            this.bYU = null;
        }
        if (this.bYS != null) {
            this.bYS.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bYS = null;
        this.bYV = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bYW = i;
        this.bYX = z;
        this.bYV = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.l(this.bYV, i);
        } else {
            am.h(this.bYV, i, 0);
        }
        this.bYS = this.bYV.getChildAt(0);
        if (this.bYS != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.akp();
                }
            };
            this.bYS.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bYT = this.bYS.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        if (this.bYS != null) {
            int height = this.bYS.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int akq = akq();
            if (this.bYY > 0 && this.bYY <= this.bYT.height) {
                akq -= this.bYY;
            }
            if (akq != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - akq;
                if (i2 == 0) {
                    this.bYT.height = i;
                    akr();
                } else {
                    this.bYT.height = i - i2;
                    iH(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = akq;
            }
        }
    }

    private int akq() {
        Rect rect = new Rect();
        this.bYS.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bYY = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        this.bYS.requestLayout();
    }

    private void iH(int i) {
        if (this.bYU != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bYU);
            this.bYU = null;
        }
        this.bYU = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.akr();
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.bYU, i);
    }
}
