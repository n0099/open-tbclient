package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private View akF;
    private int akG;
    private ViewGroup.LayoutParams akH;
    private Runnable akI;
    private FrameLayout akJ;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int akK = d.e.cp_bg_line_d;
    private boolean akL = false;
    private ViewTreeObserver.OnGlobalLayoutListener akM = null;
    private int akN = 0;

    public static e u(Activity activity) {
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

    public void di(int i) {
        if (this.akL) {
            if (i != this.mSkinType && this.akJ != null) {
                aj.k(this.akJ, this.akK);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.akI != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akI);
            this.akI = null;
        }
        if (this.akF != null) {
            this.akF.getViewTreeObserver().removeGlobalOnLayoutListener(this.akM);
            this.akF.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.akM = null;
        }
        this.akF = null;
        this.akJ = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.akK = i;
        this.akL = z;
        this.akJ = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            aj.k(this.akJ, i);
        } else {
            aj.e(this.akJ, i, 0);
        }
        this.akF = this.akJ.getChildAt(0);
        if (this.akF != null) {
            this.akM = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.wa();
                }
            };
            this.akF.getViewTreeObserver().addOnGlobalLayoutListener(this.akM);
            this.akH = this.akF.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        if (this.akF != null) {
            int height = this.akF.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int wb = wb();
            if (this.akN > 0 && this.akN <= this.akH.height) {
                wb -= this.akN;
            }
            if (wb != this.akG) {
                int i = this.mScreenHeight;
                int i2 = i - wb;
                if (i2 == 0) {
                    this.akH.height = i;
                    wc();
                } else {
                    this.akH.height = i - i2;
                    dj(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.akG = wb;
            }
        }
    }

    private int wb() {
        Rect rect = new Rect();
        this.akF.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.akN = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc() {
        this.akF.requestLayout();
    }

    private void dj(int i) {
        if (this.akI != null) {
            com.baidu.adp.lib.g.e.fP().removeCallbacks(this.akI);
            this.akI = null;
        }
        this.akI = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.wc();
            }
        };
        com.baidu.adp.lib.g.e.fP().postDelayed(this.akI, i);
    }
}
