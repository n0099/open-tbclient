package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class VerticalScrollTextSwitcher extends TextSwitcher implements ViewSwitcher.ViewFactory {
    private int mTextColor;
    private float mTextSize;

    public VerticalScrollTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        textView.setGravity(16);
        textView.setTextColor(this.mTextColor);
        textView.setTextSize(0, this.mTextSize);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        return textView;
    }

    private void init(AttributeSet attributeSet) {
        initAttrs(attributeSet);
        initAnimation();
        setFactory(this);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_VerticalScrollTextSwitcher);
        this.mTextColor = obtainStyledAttributes.getColor(a.k.sdk_VerticalScrollTextSwitcher_sdk_vsts_text_color, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_VerticalScrollTextSwitcher_sdk_vsts_text_size, 20);
        obtainStyledAttributes.recycle();
    }

    private void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        translateAnimation.setInterpolator(new LinearInterpolator());
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation2.setDuration(1000L);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        setInAnimation(translateAnimation);
        setOutAnimation(translateAnimation2);
    }
}
