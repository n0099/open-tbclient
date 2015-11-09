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
    private View adI;
    private int adJ;
    private ViewGroup.LayoutParams adK;
    private Runnable adL;
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
        this.adI = frameLayout.getChildAt(0);
        this.adI.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        this.adK = this.adI.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt() {
        int height = this.adI.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int vu = vu();
        if (vu != this.adJ) {
            int i = this.mScreenHeight;
            int i2 = i - vu;
            if (i2 > i / 4) {
                this.adK.height = i - i2;
                cJ(200);
            } else {
                this.adK.height = i;
                vv();
            }
            this.adJ = vu;
        }
    }

    private int vu() {
        Rect rect = new Rect();
        this.adI.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vv() {
        this.adI.requestLayout();
    }

    private void cJ(int i) {
        if (this.adL != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.adL);
            this.adL = null;
        }
        this.adL = new k(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.adL, i);
    }
}
