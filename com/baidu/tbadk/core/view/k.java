package com.baidu.tbadk.core.view;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class k {
    private View aaY;
    private int aaZ;
    private ViewGroup.LayoutParams aba;
    private Runnable abb;
    private FrameLayout abc;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int abd = t.d.usual_page_bg;
    private boolean abe = false;
    private ViewTreeObserver.OnGlobalLayoutListener abf = null;

    public static k l(Activity activity) {
        return new k(activity);
    }

    public static k a(Activity activity, boolean z) {
        return new k(activity, z);
    }

    public static k a(Activity activity, int i, boolean z) {
        return new k(activity, i, z);
    }

    private k(Activity activity) {
        b(activity, t.d.usual_page_bg, true);
    }

    private k(Activity activity, boolean z) {
        b(activity, t.d.usual_page_bg, z);
    }

    private k(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void cM(int i) {
        if (this.abe) {
            if (i != this.mSkinType && this.abc != null) {
                com.baidu.tbadk.core.util.at.l(this.abc, this.abd);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.abb != null) {
            TbadkCoreApplication.m11getInst().handler.removeCallbacks(this.abb);
            this.abb = null;
        }
        if (this.aaY != null) {
            this.aaY.getViewTreeObserver().removeGlobalOnLayoutListener(this.abf);
            this.aaY.getViewTreeObserver().addOnGlobalLayoutListener(null);
            this.abf = null;
        }
        this.aaY = null;
        this.abc = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.abd = i;
        this.abe = z;
        this.abc = (FrameLayout) activity.findViewById(16908290);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            com.baidu.tbadk.core.util.at.l(frameLayout, i);
        } else {
            com.baidu.tbadk.core.util.at.e(frameLayout, i, 0);
        }
        this.aaY = frameLayout.getChildAt(0);
        if (this.aaY != null) {
            this.abf = new l(this);
            this.aaY.getViewTreeObserver().addOnGlobalLayoutListener(this.abf);
            this.aba = this.aaY.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uU() {
        if (this.aaY != null) {
            int height = this.aaY.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int uV = uV();
            if (uV != this.aaZ) {
                int i = this.mScreenHeight;
                int i2 = i - uV;
                if (i2 == 0) {
                    this.aba.height = i;
                    uW();
                } else {
                    this.aba.height = i - i2;
                    cN(200);
                    if (TbadkCoreApplication.m11getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.m11getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.m11getInst().setKeyboardHeight(i2);
                    }
                }
                this.aaZ = uV;
            }
        }
    }

    private int uV() {
        Rect rect = new Rect();
        this.aaY.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW() {
        this.aaY.requestLayout();
    }

    private void cN(int i) {
        if (this.abb != null) {
            TbadkCoreApplication.m11getInst().handler.removeCallbacks(this.abb);
            this.abb = null;
        }
        this.abb = new m(this);
        TbadkCoreApplication.m11getInst().handler.postDelayed(this.abb, i);
    }
}
