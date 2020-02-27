package com.baidu.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class e {
    private FrameLayout content;
    private ViewGroup.LayoutParams frameLayoutParams;
    private Runnable mDealyResizeRunnable;
    private View mResizeViewGroup;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int backColor = R.color.cp_bg_line_d;
    private boolean isAutoChangeNightMode = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int mExcludeHeight = 0;

    public static e ae(Activity activity) {
        return new e(activity);
    }

    public static e f(Activity activity, boolean z) {
        return new e(activity, z);
    }

    public static e a(Activity activity, int i, boolean z) {
        return new e(activity, i, z);
    }

    private e(Activity activity) {
        init(activity, R.color.cp_bg_line_d, true);
    }

    private e(Activity activity, boolean z) {
        init(activity, R.color.cp_bg_line_d, z);
    }

    private e(Activity activity, int i, boolean z) {
        init(activity, i, z);
    }

    public void onSkinTypeChanged(int i) {
        if (this.isAutoChangeNightMode) {
            if (i != this.mSkinType && this.content != null) {
                am.setBackgroundColor(this.content, this.backColor);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.mDealyResizeRunnable != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mDealyResizeRunnable);
            this.mDealyResizeRunnable = null;
        }
        if (this.mResizeViewGroup != null) {
            this.mResizeViewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mGlobalLayoutListener = null;
        }
        this.mResizeViewGroup = null;
        this.content = null;
    }

    private void init(Activity activity, int i, boolean z) {
        this.backColor = i;
        this.isAutoChangeNightMode = z;
        this.content = (FrameLayout) activity.findViewById(16908290);
        if (z) {
            am.setBackgroundColor(this.content, i);
        } else {
            am.setBackgroundColor(this.content, i, 0);
        }
        this.mResizeViewGroup = this.content.getChildAt(0);
        if (this.mResizeViewGroup != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tbadk.core.view.e.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    e.this.possiblyResizeChildOfContent();
                }
            };
            this.mResizeViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
            this.frameLayoutParams = this.mResizeViewGroup.getLayoutParams();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        if (this.mResizeViewGroup != null) {
            int height = this.mResizeViewGroup.getHeight();
            if (height > this.mScreenHeight) {
                this.mScreenHeight = height;
            }
            int computeUsableHeight = computeUsableHeight();
            if (this.mExcludeHeight > 0 && this.mExcludeHeight <= this.frameLayoutParams.height) {
                computeUsableHeight -= this.mExcludeHeight;
            }
            if (computeUsableHeight != this.usableHeightPrevious) {
                int i = this.mScreenHeight;
                int i2 = i - computeUsableHeight;
                if (i2 == 0) {
                    this.frameLayoutParams.height = i;
                    resizeForSoftInput();
                } else {
                    this.frameLayoutParams.height = i - i2;
                    dealyResize(200);
                    if (TbadkCoreApplication.getInst().isKeyboardHeightCanSet(i2) && i2 < (this.mScreenHeight * 2) / 3 && TbadkCoreApplication.getInst().getKeyboardHeight() != i2) {
                        TbadkCoreApplication.getInst().setKeyboardHeight(i2);
                    }
                }
                this.usableHeightPrevious = computeUsableHeight;
            }
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mResizeViewGroup.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    public void setExcludeHeight(int i) {
        this.mExcludeHeight = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeForSoftInput() {
        this.mResizeViewGroup.requestLayout();
    }

    private void dealyResize(int i) {
        if (this.mDealyResizeRunnable != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.mDealyResizeRunnable);
            this.mDealyResizeRunnable = null;
        }
        this.mDealyResizeRunnable = new Runnable() { // from class: com.baidu.tbadk.core.view.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.resizeForSoftInput();
            }
        };
        com.baidu.adp.lib.f.e.gx().postDelayed(this.mDealyResizeRunnable, i);
    }
}
