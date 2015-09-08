package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class q {
    private View aeq;
    private int aer;
    private ViewGroup.LayoutParams aes;
    private Runnable aet;
    private int mScreenHeight;

    public static void r(Activity activity) {
        new q(activity);
    }

    public static void a(Activity activity, boolean z) {
        new q(activity, z);
    }

    private q(Activity activity) {
        b(activity, true);
    }

    private q(Activity activity, boolean z) {
        b(activity, z);
    }

    private void b(Activity activity, boolean z) {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.i(frameLayout, i.c.usual_page_bg);
        } else {
            al.d(frameLayout, i.c.usual_page_bg, 0);
        }
        this.aeq = frameLayout.getChildAt(0);
        this.aeq.getViewTreeObserver().addOnGlobalLayoutListener(new r(this));
        this.aes = this.aeq.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA() {
        int height = this.aeq.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int vB = vB();
        if (vB != this.aer) {
            int i = this.mScreenHeight;
            int i2 = i - vB;
            if (i2 > i / 4) {
                this.aes.height = i - i2;
                cI(200);
            } else {
                this.aes.height = i;
                vC();
            }
            this.aer = vB;
        }
    }

    private int vB() {
        Rect rect = new Rect();
        this.aeq.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC() {
        this.aeq.requestLayout();
    }

    private void cI(int i) {
        if (this.aet != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.aet);
            this.aet = null;
        }
        this.aet = new s(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.aet, i);
    }
}
