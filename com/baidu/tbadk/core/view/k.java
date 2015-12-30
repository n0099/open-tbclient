package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class k {
    private View afn;
    private int afo;
    private ViewGroup.LayoutParams afp;
    private Runnable afq;
    private FrameLayout afr;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int afs = n.d.usual_page_bg;
    private boolean aft = false;
    private ViewTreeObserver.OnGlobalLayoutListener afu = null;

    public static k r(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, n.d.usual_page_bg, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, n.d.usual_page_bg, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void cK(int i) {
        if (this.aft) {
            if (i != this.mSkinType && this.afr != null) {
                as.j(this.afr, this.afs);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.afq != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.afq);
            this.afq = null;
        }
        if (this.afn != null) {
            this.afn.getViewTreeObserver().removeGlobalOnLayoutListener(this.afu);
            this.afn.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.afu = null;
        }
        this.afn = null;
        this.afr = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.afs = i;
        this.aft = z;
        this.afr = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            as.j(frameLayout, i);
        } else {
            as.d(frameLayout, i, 0);
        }
        this.afn = frameLayout.getChildAt(0);
        if (this.afn != null) {
            this.afu = new l(this);
            this.afn.getViewTreeObserver().addOnGlobalLayoutListener(this.afu);
            this.afp = this.afn.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vJ() {
        if (this.afn != null) {
            int height = this.afn.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int vK = vK();
            if (vK != this.afo) {
                int i = this.mScreenHeight;
                int i2 = i - vK;
                if (i2 == 0) {
                    this.afp.height = i;
                    vL();
                } else {
                    this.afp.height = i - i2;
                    cL(200);
                    if (TbadkCoreApplication.m411getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m411getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m411getInst().setKeyboardHeight(i2);
                    }
                }
                this.afo = vK;
            }
        }
    }

    private int vK() {
        Rect rect = new Rect();
        this.afn.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL() {
        this.afn.requestLayout();
    }

    private void cL(int i) {
        if (this.afq != null) {
            TbadkCoreApplication.m411getInst().handler.removeCallbacks(this.afq);
            this.afq = null;
        }
        this.afq = new m(this);
        TbadkCoreApplication.m411getInst().handler.postDelayed(this.afq, i);
    }
}
