package com.baidu.searchbox.ui.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
/* loaded from: classes3.dex */
public abstract class BdClickableSpan extends ClickableSpan implements ITouchableSpan {
    public boolean isNeedUnderLine = false;
    public boolean mIsPressed;
    @ColorInt
    public int mNormalBgColor;
    @ColorInt
    public int mNormalTextColor;
    @ColorInt
    public int mPressedBgColor;
    @ColorInt
    public int mPressedTextColor;

    public abstract void onSpanClick(View view2);

    public BdClickableSpan(int i, int i2, int i3, int i4) {
        this.mNormalBgColor = i;
        this.mPressedBgColor = i2;
        this.mNormalTextColor = i3;
        this.mPressedTextColor = i4;
    }

    @Override // android.text.style.ClickableSpan, com.baidu.searchbox.ui.span.ITouchableSpan
    public void onClick(View view2) {
        if (ViewCompat.isAttachedToWindow(view2)) {
            onSpanClick(view2);
        }
    }

    @Override // com.baidu.searchbox.ui.span.ITouchableSpan
    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        int i;
        int i2;
        if (this.mIsPressed) {
            i = this.mPressedTextColor;
        } else {
            i = this.mNormalTextColor;
        }
        textPaint.setColor(i);
        if (this.mIsPressed) {
            i2 = this.mPressedBgColor;
        } else {
            i2 = this.mNormalBgColor;
        }
        textPaint.bgColor = i2;
        textPaint.setUnderlineText(this.isNeedUnderLine);
    }
}
