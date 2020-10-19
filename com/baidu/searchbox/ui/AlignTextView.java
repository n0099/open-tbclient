package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes10.dex */
public class AlignTextView extends TextView {
    private Align mAlign;
    private boolean mFirstCalc;
    private float mLineSpacingAdd;
    private float mLineSpacingMultiplier;
    private List<String> mLines;
    private int mOriginalHeight;
    private int mOriginalLineCount;
    private int mOriginalPaddingBottom;
    private boolean mSetPaddingFromMe;
    private List<Integer> mTailLines;
    private float mTextHeight;
    private float mTextLineSpaceExtra;
    private int mWidth;

    /* loaded from: classes10.dex */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public AlignTextView(Context context) {
        super(context);
        this.mTextLineSpaceExtra = 0.0f;
        this.mLines = new ArrayList();
        this.mTailLines = new ArrayList();
        this.mAlign = Align.ALIGN_LEFT;
        this.mFirstCalc = true;
        this.mLineSpacingMultiplier = 1.0f;
        this.mLineSpacingAdd = 0.0f;
        this.mOriginalHeight = 0;
        this.mOriginalLineCount = 0;
        this.mOriginalPaddingBottom = 0;
        this.mSetPaddingFromMe = false;
        setTextIsSelectable(false);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextLineSpaceExtra = 0.0f;
        this.mLines = new ArrayList();
        this.mTailLines = new ArrayList();
        this.mAlign = Align.ALIGN_LEFT;
        this.mFirstCalc = true;
        this.mLineSpacingMultiplier = 1.0f;
        this.mLineSpacingAdd = 0.0f;
        this.mOriginalHeight = 0;
        this.mOriginalLineCount = 0;
        this.mOriginalPaddingBottom = 0;
        this.mSetPaddingFromMe = false;
        setTextIsSelectable(false);
        this.mLineSpacingMultiplier = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.mLineSpacingAdd = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.mOriginalPaddingBottom = getPaddingBottom();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mFirstCalc) {
            this.mWidth = getMeasuredWidth();
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            this.mLines.clear();
            this.mTailLines.clear();
            for (String str : charSequence.split("\\n")) {
                calc(paint, str);
            }
            measureTextViewHeight(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            this.mTextHeight = (this.mOriginalHeight * 1.0f) / this.mOriginalLineCount;
            this.mTextLineSpaceExtra = (this.mTextHeight * (this.mLineSpacingMultiplier - 1.0f)) + this.mLineSpacingAdd;
            this.mSetPaddingFromMe = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), ((int) ((this.mTextLineSpaceExtra + this.mTextHeight) * (this.mLines.size() - this.mOriginalLineCount))) + this.mOriginalPaddingBottom);
            this.mFirstCalc = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.mWidth = getMeasuredWidth();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        float f = (getGravity() & 16) == 16 ? textSize + ((this.mTextHeight - textSize) / 2.0f) : textSize;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        this.mWidth = (this.mWidth - paddingLeft) - getPaddingRight();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mLines.size()) {
                float f2 = (i2 * this.mTextHeight) + f;
                String str = this.mLines.get(i2);
                float f3 = paddingLeft;
                float measureText = this.mWidth - paint.measureText(str);
                float length = measureText / (str.length() - 1);
                if (this.mTailLines.contains(Integer.valueOf(i2))) {
                    length = 0.0f;
                    if (this.mAlign == Align.ALIGN_CENTER) {
                        f3 += measureText / 2.0f;
                    } else if (this.mAlign == Align.ALIGN_RIGHT) {
                        f3 += measureText;
                    }
                }
                for (int i3 = 0; i3 < str.length(); i3++) {
                    canvas.drawText(str.substring(i3, i3 + 1), paint.measureText(str.substring(0, i3)) + (i3 * length) + f3, paddingTop + f2 + (this.mTextLineSpaceExtra * i2), paint);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setAlign(Align align) {
        this.mAlign = align;
        invalidate();
    }

    private void calc(Paint paint, String str) {
        StringBuilder sb;
        int i = 0;
        if (str.length() == 0) {
            this.mLines.add("\n");
            return;
        }
        int measureText = (int) (this.mWidth / paint.measureText("中"));
        StringBuilder sb2 = new StringBuilder(str.substring(0, Math.min(measureText + 1, str.length())));
        int i2 = measureText + 1;
        while (true) {
            if (i2 >= str.length()) {
                sb = sb2;
                break;
            }
            if (paint.measureText(str.substring(i, i2 + 1)) > this.mWidth) {
                this.mLines.add(sb2.toString());
                sb = new StringBuilder();
                if (str.length() - i2 > measureText) {
                    sb.append(str.substring(i2, i2 + measureText));
                    sb2 = sb;
                    i = i2;
                    i2 = (i2 + measureText) - 1;
                } else {
                    this.mLines.add(str.substring(i2));
                    break;
                }
            } else {
                sb2.append(str.charAt(i2));
            }
            i2++;
        }
        if (sb.length() > 0) {
            this.mLines.add(sb.toString());
        }
        this.mTailLines.add(Integer.valueOf(this.mLines.size() - 1));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mFirstCalc = true;
        super.setText(charSequence, bufferType);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.mSetPaddingFromMe) {
            this.mOriginalPaddingBottom = i4;
        }
        this.mSetPaddingFromMe = false;
        super.setPadding(i, i2, i3, i4);
    }

    private void measureTextViewHeight(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mOriginalLineCount = textView.getLineCount();
        this.mOriginalHeight = textView.getMeasuredHeight();
    }
}
