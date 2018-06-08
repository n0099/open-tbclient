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
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class d {
    private View auK;
    private int auL;
    private ViewGroup.LayoutParams auM;
    private Runnable auN;
    private FrameLayout auO;
    private int mScreenHeight;
    private int mSkinType = 3;
    private int auP = d.C0141d.cp_bg_line_d;
    private boolean auQ = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int auR = 0;

    public static d w(Activity activity) {
        return new d(activity);
    }

    public static d a(Activity activity, boolean z) {
        return new d(activity, z);
    }

    public static d a(Activity activity, int i, boolean z) {
        return new d(activity, i, z);
    }

    private d(Activity activity) {
        b(activity, d.C0141d.cp_bg_line_d, true);
    }

    private d(Activity activity, boolean z) {
        b(activity, d.C0141d.cp_bg_line_d, z);
    }

    private d(Activity activity, int i, boolean z) {
        b(activity, i, z);
    }

    public void dk(int i) {
        if (this.auQ) {
            if (i != this.mSkinType && this.auO != null) {
                al.j(this.auO, this.auP);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.auN != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.auN);
            this.auN = null;
        }
        if (this.auK != null) {
            this.auK.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.auK = null;
        this.auO = null;
    }

    private void b(Activity activity, int i, boolean z) {
        this.auP = i;
        this.auQ = z;
        this.auO = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            al.j(this.auO, i);
        } else {
            al.e(this.auO, i, 0);
        }
        this.auK = this.auO.getChildAt(0);
        if (this.auK != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.d.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    d.this.Af();
                }
            };
            this.auK.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.auM = this.auK.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af() {
        if (this.auK != null) {
            int height = this.auK.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int Ag = Ag();
            if (this.auR > 0 && this.auR <= this.auM.height) {
                Ag -= this.auR;
            }
            if (Ag != this.auL) {
                int i = this.mScreenHeight;
                int i2 = i - Ag;
                if (i2 == 0) {
                    this.auM.height = i;
                    Ah();
                } else {
                    this.auM.height = i - i2;
                    dl(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.auL = Ag;
            }
        }
    }

    private int Ag() {
        Rect rect = new Rect();
        this.auK.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.auR = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
        this.auK.requestLayout();
    }

    private void dl(int i) {
        if (this.auN != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.auN);
            this.auN = null;
        }
        this.auN = new Runnable() { // from class: com.baidu.tbadk.core.view.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.Ah();
            }
        };
        com.baidu.adp.lib.g.e.im().postDelayed(this.auN, i);
    }
}
