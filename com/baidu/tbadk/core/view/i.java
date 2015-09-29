package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i {
    private View adC;
    private int adD;
    private ViewGroup.LayoutParams adE;
    private Runnable adF;
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
            am.j(frameLayout, i.c.usual_page_bg);
        } else {
            am.d(frameLayout, i.c.usual_page_bg, 0);
        }
        this.adC = frameLayout.getChildAt(0);
        this.adC.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        this.adE = this.adC.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs() {
        int height = this.adC.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int vt = vt();
        if (vt != this.adD) {
            int i = this.mScreenHeight;
            int i2 = i - vt;
            if (i2 > i / 4) {
                this.adE.height = i - i2;
                cJ(200);
            } else {
                this.adE.height = i;
                vu();
            }
            this.adD = vt;
        }
    }

    private int vt() {
        Rect rect = new Rect();
        this.adC.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu() {
        this.adC.requestLayout();
    }

    private void cJ(int i) {
        if (this.adF != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.adF);
            this.adF = null;
        }
        this.adF = new k(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.adF, i);
    }
}
