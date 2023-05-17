package com.baidu.searchbox.ui.bubble.builder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
/* loaded from: classes4.dex */
public abstract class BubbleBuilder<T> {
    public BubbleBaseManager mBaseManager;
    public BubbleBaseView mBaseViews;

    public BubbleBuilder(BubbleBaseManager bubbleBaseManager) {
        this.mBaseViews = bubbleBaseManager.getViews();
        this.mBaseManager = bubbleBaseManager;
    }

    public BubbleBuilder<T> enableAnchorClk(boolean z) {
        this.mBaseManager.enableAnchorClk(z);
        return this;
    }

    public BubbleBuilder<T> enableAnimation(boolean z) {
        this.mBaseManager.enableAnimation(z);
        return this;
    }

    public BubbleBuilder<T> enableBgClk(boolean z) {
        this.mBaseManager.enableBgClk(z);
        return this;
    }

    public BubbleBuilder<T> enableClkDismiss(boolean z) {
        this.mBaseManager.enableClkDismiss(z);
        return this;
    }

    public BubbleBuilder<T> isAutoDetectShowPosition(boolean z) {
        this.mBaseManager.getLocation().mIsAutoDetectShowPosition = z;
        return this;
    }

    public BubbleBuilder<T> setAnchorView(View view2) {
        this.mBaseViews.setAnchor(view2);
        return this;
    }

    public BubbleBuilder<T> setAutoDismiss(boolean z) {
        this.mBaseManager.setAutoDismiss(z);
        return this;
    }

    public BubbleBuilder<T> setAutoDismissInterval(int i) {
        this.mBaseManager.setAutoDismissInterval(i);
        return this;
    }

    public BubbleBuilder<T> setForceShowPosition(BubblePosition bubblePosition) {
        this.mBaseManager.getLocation().mIsAutoDetectShowPosition = false;
        this.mBaseManager.getLocation().mBubbleForceShowPosition = bubblePosition;
        return this;
    }

    public BubbleBuilder<T> setOffsetOfArrow(float f) {
        this.mBaseManager.setOffsetOfArrow(f);
        return this;
    }

    public BubbleBuilder<T> setOnAnchorClickListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        this.mBaseManager.setOnAnchorEventListener(onAnchorClickListener);
        return this;
    }

    public BubbleBuilder<T> setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        this.mBaseManager.setOnBubbleEventListener(onBubbleEventListener);
        return this;
    }

    public BubbleBuilder<T> setPaddingBetweenAnchor(float f) {
        this.mBaseManager.getLocation().setPaddingBetweenAnchor(f);
        return this;
    }

    public BubbleBuilder<T> setShadowDayColor(int i) {
        if (i != -1000) {
            try {
                this.mBaseViews.setDayModeShadowColor(i);
            } catch (Exception unused) {
                this.mBaseViews.setDayModeShadowColor(-1000);
            }
        }
        return this;
    }

    public BubbleBuilder<T> setShadowIsDeviate(boolean z) {
        this.mBaseViews.setIsShadowDeviate(z);
        return this;
    }

    public BubbleBaseManager build() {
        return this.mBaseManager;
    }

    public BubbleBaseView getViews() {
        return this.mBaseViews;
    }

    public BubbleBuilder<T> setForceShowLeftEndPoint() {
        this.mBaseManager.getLocation().isShowLeftEndPoint = true;
        return this;
    }

    public BubbleBuilder<T> setAnchorAndRootView(View view2, ViewGroup viewGroup) {
        this.mBaseViews.setAnchorAndRootView(view2, viewGroup);
        return this;
    }

    public BubbleBuilder<T> setBackgroundColor(int i, int i2) {
        if (i != -1000) {
            try {
                this.mBaseViews.setDayModeBackground(i);
            } catch (Exception unused) {
                this.mBaseViews.setDayModeBackground(-1000);
                return this;
            }
        }
        if (i2 != -1000) {
            try {
                this.mBaseViews.setNightModeBackground(i2);
            } catch (Exception unused2) {
                this.mBaseViews.setNightModeBackground(-1000);
            }
        }
        return this;
    }

    public BubbleBuilder<T> setBackgroundColor(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mBaseViews.setDayModeBackground(Color.parseColor(str));
            } catch (Exception unused) {
                this.mBaseViews.setDayModeBackground(-1000);
                return this;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.mBaseViews.setNightModeBackground(Color.parseColor(str2));
            } catch (Exception unused2) {
                this.mBaseViews.setNightModeBackground(-1000);
            }
        }
        return this;
    }
}
