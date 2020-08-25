package com.baidu.live.tbadk.core.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class KeyboardAdjust {
    private static final int TIME_RESIZE_DEALY_LONG = 200;
    private FrameLayout content;
    private ViewGroup.LayoutParams frameLayoutParams;
    private Runnable mDealyResizeRunnable;
    private View mResizeViewGroup;
    private int mScreenHeight;
    private int usableHeightPrevious;
    private int mSkinType = 3;
    private int backColor = a.d.sdk_cp_bg_line_d;
    private boolean isAutoChangeNightMode = false;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = null;
    private int mExcludeHeight = 0;

    public static KeyboardAdjust assistActivity(Activity activity) {
        return new KeyboardAdjust(activity);
    }

    public static KeyboardAdjust assistActivity(Activity activity, boolean z) {
        return new KeyboardAdjust(activity, z);
    }

    public static KeyboardAdjust assistActivity(Activity activity, int i, boolean z) {
        return new KeyboardAdjust(activity, i, z);
    }

    private KeyboardAdjust(Activity activity) {
        init(activity, a.d.sdk_cp_bg_line_d, true);
    }

    private KeyboardAdjust(Activity activity, boolean z) {
        init(activity, a.d.sdk_cp_bg_line_d, z);
    }

    private KeyboardAdjust(Activity activity, int i, boolean z) {
        init(activity, i, z);
    }

    public void onSkinTypeChanged(int i) {
        if (this.isAutoChangeNightMode) {
            if (i != this.mSkinType && this.content != null) {
                SkinManager.setBackgroundColor(this.content, this.backColor);
            }
            this.mSkinType = i;
        }
    }

    public void onDestory() {
        if (this.mDealyResizeRunnable != null) {
            SafeHandler.getInst().removeCallbacks(this.mDealyResizeRunnable);
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
            SkinManager.setBackgroundColor(this.content, i);
        } else {
            SkinManager.setBackgroundColor(this.content, i, 0);
        }
        this.mResizeViewGroup = this.content.getChildAt(0);
        if (this.mResizeViewGroup != null) {
            this.mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.tbadk.core.view.KeyboardAdjust.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    KeyboardAdjust.this.possiblyResizeChildOfContent();
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
            SafeHandler.getInst().removeCallbacks(this.mDealyResizeRunnable);
            this.mDealyResizeRunnable = null;
        }
        this.mDealyResizeRunnable = new Runnable() { // from class: com.baidu.live.tbadk.core.view.KeyboardAdjust.2
            @Override // java.lang.Runnable
            public void run() {
                KeyboardAdjust.this.resizeForSoftInput();
            }
        };
        SafeHandler.getInst().postDelayed(this.mDealyResizeRunnable, i);
    }
}
