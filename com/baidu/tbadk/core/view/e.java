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
    private View avc;
    private int avd;
    private ViewGroup.LayoutParams ave;
    private Runnable avf;
    private FrameLayout avg;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int avh = d.C0140d.cp_bg_line_d;
    private boolean avi = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int avj = 0;

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
        b(activity, d.C0140d.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        b(activity, d.C0140d.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dn(int i) {
        if (this.avi) {
            if (i != this.mSkinType && this.avg != null) {
                am.j(this.avg, this.avh);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.avf != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.avf);
            this.avf = null;
        }
        if (this.avc != null) {
            this.avc.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.avc = null;
        this.avg = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.avh = i;
        this.avi = z;
        this.avg = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.j(this.avg, i);
        } else {
            am.e(this.avg, i, 0);
        }
        this.avc = this.avg.getChildAt(0);
        if (this.avc != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.Ak();
                }
            };
            this.avc.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.ave = this.avc.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ak() {
        if (this.avc != null) {
            int height = this.avc.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Al = Al();
            if (this.avj > 0 && this.avj <= this.ave.height) {
                Al -= this.avj;
            }
            if (Al != this.avd) {
                int i = this.mScreenHeight;
                int i2 = i - Al;
                if (i2 == 0) {
                    this.ave.height = i;
                    Am();
                } else {
                    this.ave.height = i - i2;
                    m14do(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.avd = Al;
            }
        }
    }

    private int Al() {
        Rect rect = new Rect();
        this.avc.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.avj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am() {
        this.avc.requestLayout();
    }

    /* renamed from: do  reason: not valid java name */
    private void m14do(int i) {
        if (this.avf != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.avf);
            this.avf = null;
        }
        this.avf = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.Am();
            }
        };
        com.baidu.adp.lib.g.e.in().postDelayed(this.avf, i);
    }
}
