package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i {
    private View adD;
    private int adE;
    private ViewGroup.LayoutParams adF;
    private Runnable adG;
    private int mScreenHeight;

    public static void r(Activity activity) {
        new i(activity);
    }

    public static void a(Activity activity, boolean z) {
        new i(activity, z);
    }

    private i(Activity activity) {
        b(activity, true);
    }

    private i(Activity activity, boolean z) {
        b(activity, z);
    }

    private void b(Activity activity, boolean z) {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            an.j(frameLayout, i.c.usual_page_bg);
        } else {
            an.d(frameLayout, i.c.usual_page_bg, 0);
        }
        this.adD = frameLayout.getChildAt(0);
        this.adD.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        this.adF = this.adD.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs() {
        int height = this.adD.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int vt = vt();
        if (vt != this.adE) {
            int i = this.mScreenHeight;
            int i2 = i - vt;
            if (i2 > i / 4) {
                this.adF.height = i - i2;
                cJ(200);
            } else {
                this.adF.height = i;
                vu();
            }
            this.adE = vt;
        }
    }

    private int vt() {
        Rect rect = new Rect();
        this.adD.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu() {
        this.adD.requestLayout();
    }

    private void cJ(int i) {
        if (this.adG != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.adG);
            this.adG = null;
        }
        this.adG = new k(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.adG, i);
    }
}
