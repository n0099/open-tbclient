package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private View akc;
    private int akd;
    private ViewGroup.LayoutParams ake;
    private Runnable akf;
    private FrameLayout akg;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int akh = d.e.cp_bg_line_d;
    private boolean aki = false;
    private ViewTreeObserver.OnGlobalLayoutListener akj = null;
    private int akk = 0;

    public static e t(Activity activity) {
        return new e(activity);
    }

    public static e a(Activity activity, boolean z) {
        return new e(activity, z);
    }

    public static e a(Activity activity, int i, boolean z) {
        return new e(activity, i, z);
    }

    private e(Activity activity) {
        b(activity, d.e.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, d.e.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dg(int i) {
        if (this.aki) {
            if (i != this.mSkinType && this.akg != null) {
                ai.k(this.akg, this.akh);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.akf != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akf);
            this.akf = null;
        }
        if (this.akc != null) {
            this.akc.getViewTreeObserver().removeGlobalOnLayoutListener(this.akj);
            this.akc.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.akj = null;
        }
        this.akc = null;
        this.akg = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.akh = i;
        this.aki = z;
        this.akg = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            ai.k(this.akg, i);
        } else {
            ai.e(this.akg, i, 0);
        }
        this.akc = this.akg.getChildAt(0);
        if (this.akc != null) {
            this.akj = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wv();
                }
            };
            this.akc.getViewTreeObserver().addOnGlobalLayoutListener(this.akj);
            this.ake = this.akc.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv() {
        if (this.akc != null) {
            int height = this.akc.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int ww = ww();
            if (this.akk > 0 && this.akk <= this.ake.height) {
                ww -= this.akk;
            }
            if (ww != this.akd) {
                int i = this.mScreenHeight;
                int i2 = i - ww;
                if (i2 == 0) {
                    this.ake.height = i;
                    wx();
                } else {
                    this.ake.height = i - i2;
                    dh(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.akd = ww;
            }
        }
    }

    private int ww() {
        Rect rect = new Rect();
        this.akc.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.akk = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        this.akc.requestLayout();
    }

    private void dh(int i) {
        if (this.akf != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akf);
            this.akf = null;
        }
        this.akf = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wx();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.akf, i);
    }
}
