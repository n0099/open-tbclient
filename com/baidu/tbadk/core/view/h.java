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
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class h {
    private View ayn;
    private ViewGroup.LayoutParams ayo;
    private Runnable ayp;
    private FrameLayout ayq;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int ayr = e.d.cp_bg_line_d;
    private boolean ays = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int ayt = 0;

    public static h z(Activity activity) {
        return new h(activity);
    }

    public static h d(Activity activity, boolean z) {
        return new h(activity, z);
    }

    public static h a(Activity activity, int i, boolean z) {
        return new h(activity, i, z);
    }

    private h(Activity activity) {
        b(activity, e.d.cp_bg_line_d, true);
    }

    private h(Activity activity, boolean z) {
        b(activity, e.d.cp_bg_line_d, z);
    }

    private h(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dx(int i) {
        if (this.ays) {
            if (i != this.mSkinType && this.ayq != null) {
                al.j(this.ayq, this.ayr);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.ayp != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.ayp);
            this.ayp = null;
        }
        if (this.ayn != null) {
            this.ayn.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.ayn = null;
        this.ayq = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.ayr = i;
        this.ays = z;
        this.ayq = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.ayq, i);
        } else {
            al.e(this.ayq, i, 0);
        }
        this.ayn = this.ayq.getChildAt(0);
        if (this.ayn != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.h.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    h.this.Bw();
                }
            };
            this.ayn.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.ayo = this.ayn.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        if (this.ayn != null) {
            int height = this.ayn.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Bx = Bx();
            if (this.ayt > 0 && this.ayt <= this.ayo.height) {
                Bx -= this.ayt;
            }
            if (Bx != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - Bx;
                if (i2 == 0) {
                    this.ayo.height = i;
                    By();
                } else {
                    this.ayo.height = i - i2;
                    dy(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = Bx;
            }
        }
    }

    private int Bx() {
        Rect rect = new Rect();
        this.ayn.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.ayt = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void By() {
        this.ayn.requestLayout();
    }

    private void dy(int i) {
        if (this.ayp != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.ayp);
            this.ayp = null;
        }
        this.ayp = new Runnable() { // from class: com.baidu.tbadk.core.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                h.this.By();
            }
        };
        com.baidu.adp.lib.g.e.jt().postDelayed(this.ayp, i);
    }
}
