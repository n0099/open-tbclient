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
    private View aeg;
    private int aeh;
    private ViewGroup.LayoutParams aei;
    private Runnable aej;
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
            al.j(frameLayout, i.c.usual_page_bg);
        } else {
            al.d(frameLayout, i.c.usual_page_bg, 0);
        }
        this.aeg = frameLayout.getChildAt(0);
        this.aeg.getViewTreeObserver().addOnGlobalLayoutListener(new r(this));
        this.aei = this.aeg.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vv() {
        int height = this.aeg.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int vw = vw();
        if (vw != this.aeh) {
            int i = this.mScreenHeight;
            int i2 = i - vw;
            if (i2 > i / 4) {
                this.aei.height = i - i2;
                cC(200);
            } else {
                this.aei.height = i;
                vx();
            }
            this.aeh = vw;
        }
    }

    private int vw() {
        Rect rect = new Rect();
        this.aeg.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vx() {
        this.aeg.requestLayout();
    }

    private void cC(int i) {
        if (this.aej != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.aej);
            this.aej = null;
        }
        this.aej = new s(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.aej, i);
    }
}
