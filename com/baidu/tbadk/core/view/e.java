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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private FrameLayout avA;
    private View avw;
    private int avx;
    private ViewGroup.LayoutParams avy;
    private Runnable avz;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int avB = d.C0142d.cp_bg_line_d;
    private boolean avC = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int avD = 0;

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
        b(activity, d.C0142d.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, d.C0142d.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dl(int i) {
        if (this.avC) {
            if (i != this.mSkinType && this.avA != null) {
                am.j(this.avA, this.avB);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.avz != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.avz);
            this.avz = null;
        }
        if (this.avw != null) {
            this.avw.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.avw = null;
        this.avA = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.avB = i;
        this.avC = z;
        this.avA = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.j(this.avA, i);
        } else {
            am.e(this.avA, i, 0);
        }
        this.avw = this.avA.getChildAt(0);
        if (this.avw != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.Au();
                }
            };
            this.avw.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.avy = this.avw.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Au() {
        if (this.avw != null) {
            int height = this.avw.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Av = Av();
            if (this.avD > 0 && this.avD <= this.avy.height) {
                Av -= this.avD;
            }
            if (Av != this.avx) {
                int i = this.mScreenHeight;
                int i2 = i - Av;
                if (i2 == 0) {
                    this.avy.height = i;
                    Aw();
                } else {
                    this.avy.height = i - i2;
                    dm(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.avx = Av;
            }
        }
    }

    private int Av() {
        Rect rect = new Rect();
        this.avw.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.avD = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        this.avw.requestLayout();
    }

    private void dm(int i) {
        if (this.avz != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.avz);
            this.avz = null;
        }
        this.avz = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.Aw();
            }
        };
        com.baidu.adp.lib.g.e.im().postDelayed(this.avz, i);
    }
}
