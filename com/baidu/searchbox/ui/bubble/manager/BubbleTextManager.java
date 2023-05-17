package com.baidu.searchbox.ui.bubble.manager;

import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.ui.bubble.views.BubbleTextView;
@Keep
/* loaded from: classes4.dex */
public class BubbleTextManager extends BubbleBaseManager {
    public static final String TAG = "BubbleTextManager";
    public BubbleTextView mTextViews;

    public BubbleTextManager() {
        this(new BubbleTextView());
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void onShow() {
        BubbleTextView bubbleTextView = this.mTextViews;
        CharSequence charSequence = bubbleTextView.mShowText;
        int textColor = bubbleTextView.getTextColor();
        BubbleTextView bubbleTextView2 = this.mTextViews;
        bubbleTextView.setBubbleText(charSequence, textColor, bubbleTextView2.mUnit, bubbleTextView2.mSize, bubbleTextView2.isBold);
    }

    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public void showBubble() {
        BubbleTextView bubbleTextView = this.mTextViews;
        if (bubbleTextView != null && bubbleTextView.isValidate()) {
            super.showBubble();
        }
    }

    public BubbleTextManager(BubbleTextView bubbleTextView) {
        super(bubbleTextView);
        this.mTextViews = bubbleTextView;
    }

    public void onNightModeChanged(boolean z) {
        int bgColorDay;
        if (z) {
            bgColorDay = this.mViews.getBgColorNight();
        } else {
            bgColorDay = this.mViews.getBgColorDay();
        }
        updateBubble(bgColorDay);
    }

    public void setIsBold(boolean z) {
        this.mTextViews.isBold = z;
    }

    public void setTextColor(@ColorInt int i) {
        this.mTextViews.setTextColor(i, i);
    }

    public void updateBubble(int i) {
        try {
            if (!isDismissed()) {
                this.mViews.updateBubble(i, this.mTextViews.getTextColor());
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager
    public BubbleTextView getViews() {
        return this.mTextViews;
    }

    public void setFontSizew(int i, float f) {
        BubbleTextView bubbleTextView = this.mTextViews;
        bubbleTextView.mUnit = i;
        bubbleTextView.mSize = FontSizeHelper.getScaledSize(0, f);
    }
}
