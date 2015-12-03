package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j {
    private View aeF;
    private int aeG;
    private ViewGroup.LayoutParams aeH;
    private Runnable aeI;
    private int mScreenHeight;

    public static void r(Activity activity) {
        new j(activity);
    }

    public static void a(Activity activity, boolean z) {
        new j(activity, z);
    }

    private j(Activity activity) {
        b(activity, true);
    }

    private j(Activity activity, boolean z) {
        b(activity, z);
    }

    private void b(Activity activity, boolean z) {
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            as.j(frameLayout, n.c.usual_page_bg);
        } else {
            as.d(frameLayout, n.c.usual_page_bg, 0);
        }
        this.aeF = frameLayout.getChildAt(0);
        this.aeF.getViewTreeObserver().addOnGlobalLayoutListener(new k(this));
        this.aeH = this.aeF.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vZ() {
        int height = this.aeF.getHeight();
        if (height > this.mScreenHeight) {
            this.mScreenHeight = height;
        }
        int wa = wa();
        if (wa != this.aeG) {
            int i = this.mScreenHeight;
            int i2 = i - wa;
            if (i2 > i / 4) {
                this.aeH.height = i - i2;
                cR(200);
            } else {
                this.aeH.height = i;
                wb();
            }
            this.aeG = wa;
        }
    }

    private int wa() {
        Rect rect = new Rect();
        this.aeF.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb() {
        this.aeF.requestLayout();
    }

    private void cR(int i) {
        if (this.aeI != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.aeI);
            this.aeI = null;
        }
        this.aeI = new l(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.aeI, i);
    }
}
