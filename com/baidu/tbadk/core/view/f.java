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
    private View bYY;
    private ViewGroup.LayoutParams bYZ;
    private Runnable bZa;
    private FrameLayout bZb;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bZc = R.color.cp_bg_line_d;
    private boolean bZd = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bZe = 0;

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
        if (this.bZd) {
            if (i != this.mSkinType && this.bZb != null) {
                am.l(this.bZb, this.bZc);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bZa != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bZa);
            this.bZa = null;
        }
        if (this.bYY != null) {
            this.bYY.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bYY = null;
        this.bZb = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bZc = i;
        this.bZd = z;
        this.bZb = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.l(this.bZb, i);
        } else {
            am.h(this.bZb, i, 0);
        }
        this.bYY = this.bZb.getChildAt(0);
        if (this.bYY != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.akr();
                }
            };
            this.bYY.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bYZ = this.bYY.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        if (this.bYY != null) {
            int height = this.bYY.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int aks = aks();
            if (this.bZe > 0 && this.bZe <= this.bYZ.height) {
                aks -= this.bZe;
            }
            if (aks != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - aks;
                if (i2 == 0) {
                    this.bYZ.height = i;
                    akt();
                } else {
                    this.bYZ.height = i - i2;
                    iH(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = aks;
            }
        }
    }

    private int aks() {
        Rect rect = new Rect();
        this.bYY.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bZe = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akt() {
        this.bYY.requestLayout();
    }

    private void iH(int i) {
        if (this.bZa != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.bZa);
            this.bZa = null;
        }
        this.bZa = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.akt();
            }
        };
        com.baidu.adp.lib.g.e.iK().postDelayed(this.bZa, i);
    }
}
