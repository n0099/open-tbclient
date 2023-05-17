package com.baidu.searchbox.ui.bubble;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import com.baidu.searchbox.ui.bubble.builder.BubbleJumpArrowBuilder;
import com.baidu.searchbox.ui.bubble.builder.BubbleTextBuilder;
import com.baidu.searchbox.ui.bubble.manager.BubbleButtonManager;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
/* loaded from: classes4.dex */
public class BubbleManager extends BubbleButtonManager implements View.OnClickListener {
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleManager";

    /* loaded from: classes4.dex */
    public enum BubbleStyle {
        TextOnly,
        TextWithJumpArrow
    }

    @Keep
    /* loaded from: classes4.dex */
    public interface OnAnchorClickListener {
        void onAnchorClick();
    }

    /* loaded from: classes4.dex */
    public interface OnBtnClickListener {
        void onBtnClick();
    }

    /* loaded from: classes4.dex */
    public interface OnBubbleEventListener {
        void onBubbleClick();

        void onBubbleDismiss();

        void onBubbleShow();
    }

    /* loaded from: classes4.dex */
    public interface OnBubbleSmartEventListener extends OnBubbleEventListener {
        void onBubbleAutoDismiss();
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        public BubbleManager mBubbleManager;

        public Builder() {
            this(new BubbleManager());
        }

        public BubbleManager build() {
            return this.mBubbleManager;
        }

        public Builder setForceShowLeftEndPoint() {
            this.mBubbleManager.mLocation.isShowLeftEndPoint = true;
            return this;
        }

        public Builder(BubbleManager bubbleManager) {
            this.mBubbleManager = bubbleManager;
        }

        public Builder enableAnchorClk(boolean z) {
            this.mBubbleManager.enableAnchorClk(z);
            return this;
        }

        public Builder enableAnimation(boolean z) {
            this.mBubbleManager.enableAnimation(z);
            return this;
        }

        public Builder enableBgClk(boolean z) {
            this.mBubbleManager.enableBgClk(z);
            return this;
        }

        public Builder enableClkDismiss(boolean z) {
            this.mBubbleManager.enableClkDismiss(z);
            return this;
        }

        public Builder isAutoDetectShowPosition(boolean z) {
            this.mBubbleManager.mLocation.mIsAutoDetectShowPosition = z;
            return this;
        }

        public Builder setAnchor(View view2) {
            this.mBubbleManager.mViews.setAnchor(view2);
            return this;
        }

        public Builder setAutoDismiss(boolean z) {
            this.mBubbleManager.setAutoDismiss(z);
            return this;
        }

        public Builder setAutoDismissInterval(int i) {
            this.mBubbleManager.setAutoDismissInterval(i);
            return this;
        }

        @Deprecated
        public Builder setBackground(@ColorInt int i) {
            this.mBubbleManager.mViews.setDayModeBackground(i);
            return this;
        }

        public Builder setBtnText(CharSequence charSequence) {
            this.mBubbleManager.setBtnText(charSequence);
            return this;
        }

        public Builder setDayModeBackgroundColor(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "#CC000000";
            }
            try {
                this.mBubbleManager.mViews.setDayModeBackground(Color.parseColor(str));
                return this;
            } catch (Exception unused) {
                this.mBubbleManager.mViews.setDayModeBackground(Color.parseColor("#CC000000"));
                return this;
            }
        }

        public Builder setForceShowPosition(BubblePosition bubblePosition) {
            this.mBubbleManager.mLocation.mIsAutoDetectShowPosition = false;
            this.mBubbleManager.mLocation.mBubbleForceShowPosition = bubblePosition;
            return this;
        }

        public Builder setNightBackgroundColor(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "#CC000000";
            }
            try {
                this.mBubbleManager.mViews.setNightModeBackground(Color.parseColor(str));
                return this;
            } catch (Exception unused) {
                this.mBubbleManager.mViews.setNightModeBackground(Color.parseColor("#CC000000"));
                return this;
            }
        }

        public Builder setOffsetOfArrow(float f) {
            this.mBubbleManager.setOffsetOfArrow(f);
            return this;
        }

        public Builder setOnAnchorClickListener(OnAnchorClickListener onAnchorClickListener) {
            this.mBubbleManager.setOnAnchorEventListener(onAnchorClickListener);
            return this;
        }

        public Builder setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
            this.mBubbleManager.setOnBtnClickListener(onBtnClickListener);
            return this;
        }

        public Builder setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
            this.mBubbleManager.setOnBubbleEventListener(onBubbleEventListener);
            return this;
        }

        public Builder setPaddingBetweenAnchor(float f) {
            this.mBubbleManager.mLocation.setPaddingBetweenAnchor(f);
            return this;
        }

        public Builder setText(CharSequence charSequence) {
            this.mBubbleManager.setText(charSequence);
            return this;
        }

        public Builder setTextColor(@ColorInt int i) {
            this.mBubbleManager.setTextColor(i);
            return this;
        }

        public Builder setAnchorAndRootView(View view2, ViewGroup viewGroup) {
            this.mBubbleManager.mViews.setAnchorAndRootView(view2, viewGroup);
            return this;
        }

        public Builder setBtnFontSize(int i, float f) {
            this.mBubbleManager.mButtonViews.setBtnFontSizew(i, f);
            return this;
        }

        public Builder setFontSize(int i, float f) {
            this.mBubbleManager.setFontSizew(i, f);
            return this;
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void dismissBubble() {
        super.dismissBubble();
    }

    public View getBubbleView() {
        return this.mViews.mBubbleView;
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public OnBubbleEventListener getOnBubbleEventListener() {
        return super.getOnBubbleEventListener();
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public boolean isDismissed() {
        return super.isDismissed();
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager, com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void showBubble() {
        super.showBubble();
    }

    public static <T> T newBuilder(Class<T> cls) {
        if (cls != BubbleTextBuilder.class && cls != BubbleJumpArrowBuilder.class) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        onClickCore(view2);
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleTextManager
    public void onNightModeChanged(boolean z) {
        int bgColorDay;
        BubbleBaseView bubbleBaseView = this.mViews;
        if (bubbleBaseView != null) {
            if (z) {
                bgColorDay = bubbleBaseView.getBgColorNight();
            } else {
                bgColorDay = bubbleBaseView.getBgColorDay();
            }
            updateBubble(bgColorDay);
        }
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void setOnBubbleEventListener(OnBubbleEventListener onBubbleEventListener) {
        super.setOnBubbleEventListener(onBubbleEventListener);
    }
}
