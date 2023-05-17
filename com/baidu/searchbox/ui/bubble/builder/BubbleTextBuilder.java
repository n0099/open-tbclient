package com.baidu.searchbox.ui.bubble.builder;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.manager.BubbleTextManager;
@Keep
/* loaded from: classes4.dex */
public class BubbleTextBuilder extends BubbleBuilder {
    public BubbleTextManager mManager;

    public BubbleTextBuilder() {
        this(new BubbleTextManager());
    }

    public BubbleTextBuilder(BubbleTextManager bubbleTextManager) {
        super(bubbleTextManager);
        this.mManager = bubbleTextManager;
    }

    public BubbleTextBuilder isMiniBubble(boolean z) {
        this.mManager.getViews().isMiniBubble(z);
        return this;
    }

    public BubbleTextBuilder setBubbleAlpha(float f) {
        this.mManager.setBubbleAlpha(f);
        return this;
    }

    public BubbleTextBuilder setIsBold(boolean z) {
        this.mManager.setIsBold(z);
        return this;
    }

    public BubbleTextBuilder setSpan(SpannableStringBuilder spannableStringBuilder) {
        this.mManager.getViews().setText(spannableStringBuilder);
        return this;
    }

    public BubbleTextBuilder setText(CharSequence charSequence) {
        this.mManager.getViews().setText(charSequence);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextManager build() {
        return this.mManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setForceShowLeftEndPoint() {
        super.setForceShowLeftEndPoint();
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableAnchorClk(boolean z) {
        super.enableAnchorClk(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableAnimation(boolean z) {
        super.enableAnimation(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableBgClk(boolean z) {
        super.enableBgClk(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder enableClkDismiss(boolean z) {
        super.enableClkDismiss(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder isAutoDetectShowPosition(boolean z) {
        super.isAutoDetectShowPosition(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAnchorView(View view2) {
        super.setAnchorView(view2);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAutoDismiss(boolean z) {
        super.setAutoDismiss(z);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAutoDismissInterval(int i) {
        super.setAutoDismissInterval(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setForceShowPosition(BubblePosition bubblePosition) {
        super.setForceShowPosition(bubblePosition);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOffsetOfArrow(float f) {
        super.setOffsetOfArrow(f);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOnAnchorClickListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        super.setOnAnchorClickListener(onAnchorClickListener);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        super.setOnBubbleEventListener(onBubbleEventListener);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setPaddingBetweenAnchor(float f) {
        super.setPaddingBetweenAnchor(f);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setShadowDayColor(int i) {
        super.setShadowDayColor(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setShadowIsDeviate(boolean z) {
        super.setShadowIsDeviate(z);
        return this;
    }

    public BubbleTextBuilder setFontSize(int i, float f) {
        this.mManager.setFontSizew(i, f);
        return this;
    }

    public BubbleTextBuilder setTextColor(int i, int i2) {
        try {
            this.mManager.getViews().setTextColor(i, i2);
            return this;
        } catch (Exception unused) {
            this.mManager.getViews().setTextColor(Color.parseColor("#CC000000"), Color.parseColor("#CC000000"));
            return this;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setAnchorAndRootView(View view2, ViewGroup viewGroup) {
        super.setAnchorAndRootView(view2, viewGroup);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setBackgroundColor(int i, int i2) {
        super.setBackgroundColor(i, i2);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ui.bubble.builder.BubbleBuilder
    public BubbleTextBuilder setBackgroundColor(String str, String str2) {
        super.setBackgroundColor(str, str2);
        return this;
    }

    public BubbleTextBuilder setTextColor(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "#FFFFFF";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "#666666";
        }
        try {
            this.mManager.getViews().setTextColor(Color.parseColor(str), Color.parseColor(str2));
            return this;
        } catch (Exception unused) {
            this.mManager.getViews().setTextColor(Color.parseColor("#CC000000"), Color.parseColor("#CC000000"));
            return this;
        }
    }
}
