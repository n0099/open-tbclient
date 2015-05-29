package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t {
    private View Zf;
    private int Zg;
    private ViewGroup.LayoutParams Zh;
    private Runnable Zi;
    private int mScreenHeight;

    public static void r(Activity activity) {
        new t(activity);
    }

    private t(Activity activity) {
        this.Zf = (View) ((FrameLayout) activity.findViewById(16908290)).getParent();
        this.Zf.getViewTreeObserver().addOnGlobalLayoutListener(new u(this));
        this.Zh = this.Zf.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur() {
        int height = this.Zf.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int us = us();
        if (us != this.Zg) {
            int i = this.mScreenHeight;
            int i2 = i - us;
            if (i2 > i / 4) {
                this.Zh.height = i - i2;
                cu(200);
            } else {
                this.Zh.height = i;
                ut();
            }
            this.Zg = us;
        }
    }

    private int us() {
        Rect rect = new Rect();
        this.Zf.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ut() {
        this.Zf.requestLayout();
    }

    private void cu(int i) {
        if (this.Zi != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.Zi);
            this.Zi = null;
        }
        this.Zi = new v(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.Zi, i);
    }
}
