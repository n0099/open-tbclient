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
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private View avb;
    private ViewGroup.LayoutParams avc;
    private Runnable avd;
    private FrameLayout ave;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int avf = f.d.cp_bg_line_d;
    private boolean avg = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int avh = 0;

    public static e w(Activity activity) {
        return new e(activity);
    }

    public static e a(Activity activity, boolean z) {
        return new e(activity, z);
    }

    public static e a(Activity activity, int i, boolean z) {
        return new e(activity, i, z);
    }

    private e(Activity activity) {
        b(activity, f.d.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, f.d.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dm(int i) {
        if (this.avg) {
            if (i != this.mSkinType && this.ave != null) {
                am.j(this.ave, this.avf);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.avd != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.avd);
            this.avd = null;
        }
        if (this.avb != null) {
            this.avb.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.avb = null;
        this.ave = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.avf = i;
        this.avg = z;
        this.ave = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.j(this.ave, i);
        } else {
            am.e(this.ave, i, 0);
        }
        this.avb = this.ave.getChildAt(0);
        if (this.avb != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.Ai();
                }
            };
            this.avb.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.avc = this.avb.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai() {
        if (this.avb != null) {
            int height = this.avb.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Aj = Aj();
            if (this.avh > 0 && this.avh <= this.avc.height) {
                Aj -= this.avh;
            }
            if (Aj != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - Aj;
                if (i2 == 0) {
                    this.avc.height = i;
                    Ak();
                } else {
                    this.avc.height = i - i2;
                    dn(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = Aj;
            }
        }
    }

    private int Aj() {
        Rect rect = new Rect();
        this.avb.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.avh = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ak() {
        this.avb.requestLayout();
    }

    private void dn(int i) {
        if (this.avd != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.avd);
            this.avd = null;
        }
        this.avd = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.Ak();
            }
        };
        com.baidu.adp.lib.g.e.in().postDelayed(this.avd, i);
    }
}
