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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class f {
    private View bQa;
    private ViewGroup.LayoutParams bQb;
    private Runnable bQc;
    private FrameLayout bQd;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bQe = d.C0277d.cp_bg_line_d;
    private boolean bQf = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bQg = 0;

    public static f aa(Activity activity) {
        return new f(activity);
    }

    public static f f(Activity activity, boolean z) {
        return new f(activity, z);
    }

    public static f a(Activity activity, int i, boolean z) {
        return new f(activity, i, z);
    }

    private f(Activity activity) {
        b(activity, d.C0277d.cp_bg_line_d, true);
    }

    private f(Activity activity, boolean z) {
        b(activity, d.C0277d.cp_bg_line_d, z);
    }

    private f(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void hM(int i) {
        if (this.bQf) {
            if (i != this.mSkinType && this.bQd != null) {
                al.l(this.bQd, this.bQe);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bQc != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQc);
            this.bQc = null;
        }
        if (this.bQa != null) {
            this.bQa.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bQa = null;
        this.bQd = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bQe = i;
        this.bQf = z;
        this.bQd = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bQd, i);
        } else {
            al.f(this.bQd, i, 0);
        }
        this.bQa = this.bQd.getChildAt(0);
        if (this.bQa != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.aem();
                }
            };
            this.bQa.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bQb = this.bQa.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aem() {
        if (this.bQa != null) {
            int height = this.bQa.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int aen = aen();
            if (this.bQg > 0 && this.bQg <= this.bQb.height) {
                aen -= this.bQg;
            }
            if (aen != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - aen;
                if (i2 == 0) {
                    this.bQb.height = i;
                    aeo();
                } else {
                    this.bQb.height = i - i2;
                    hN(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = aen;
            }
        }
    }

    private int aen() {
        Rect rect = new Rect();
        this.bQa.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bQg = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeo() {
        this.bQa.requestLayout();
    }

    private void hN(int i) {
        if (this.bQc != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQc);
            this.bQc = null;
        }
        this.bQc = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.aeo();
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.bQc, i);
    }
}
