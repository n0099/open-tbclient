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
    private View bQb;
    private ViewGroup.LayoutParams bQc;
    private Runnable bQd;
    private FrameLayout bQe;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int bQf = d.C0277d.cp_bg_line_d;
    private boolean bQg = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int bQh = 0;

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
        if (this.bQg) {
            if (i != this.mSkinType && this.bQe != null) {
                al.l(this.bQe, this.bQf);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.bQd != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQd);
            this.bQd = null;
        }
        if (this.bQb != null) {
            this.bQb.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.bQb = null;
        this.bQe = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.bQf = i;
        this.bQg = z;
        this.bQe = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.l(this.bQe, i);
        } else {
            al.f(this.bQe, i, 0);
        }
        this.bQb = this.bQe.getChildAt(0);
        if (this.bQb != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.f.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    f.this.aem();
                }
            };
            this.bQb.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.bQc = this.bQb.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aem() {
        if (this.bQb != null) {
            int height = this.bQb.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int aen = aen();
            if (this.bQh > 0 && this.bQh <= this.bQc.height) {
                aen -= this.bQh;
            }
            if (aen != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - aen;
                if (i2 == 0) {
                    this.bQc.height = i;
                    aeo();
                } else {
                    this.bQc.height = i - i2;
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
        this.bQb.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.bQh = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeo() {
        this.bQb.requestLayout();
    }

    private void hN(int i) {
        if (this.bQd != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.bQd);
            this.bQd = null;
        }
        this.bQd = new Runnable() { // from class: com.baidu.tbadk.core.view.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.aeo();
            }
        };
        com.baidu.adp.lib.g.e.jH().postDelayed(this.bQd, i);
    }
}
