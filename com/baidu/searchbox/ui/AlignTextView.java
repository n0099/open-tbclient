package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class AlignTextView extends TextView {
    public Align mAlign;
    public boolean mFirstCalc;
    public float mLineSpacingAdd;
    public float mLineSpacingMultiplier;
    public List<String> mLines;
    public int mOriginalHeight;
    public int mOriginalLineCount;
    public int mOriginalPaddingBottom;
    public boolean mSetPaddingFromMe;
    public List<Integer> mTailLines;
    public float mTextHeight;
    public float mTextLineSpaceExtra;
    public int mWidth;

    /* loaded from: classes4.dex */
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

    public void setAlign(Align align) {
        this.mAlign = align;
        invalidate();
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843287});
        this.mLineSpacingAdd = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mOriginalPaddingBottom = getPaddingBottom();
        obtainStyledAttributes.recycle();
    }

    private void calc(Paint paint, String str) {
        if (str.length() == 0) {
            this.mLines.add("\n");
            return;
        }
        int measureText = (int) (this.mWidth / paint.measureText("中"));
        int i = measureText + 1;
        int i2 = 0;
        StringBuilder sb = new StringBuilder(str.substring(0, Math.min(i, str.length())));
        while (true) {
            if (i >= str.length()) {
                break;
            }
            if (paint.measureText(str.substring(i2, i + 1)) > this.mWidth) {
                this.mLines.add(sb.toString());
                sb = new StringBuilder();
                if (str.length() - i > measureText) {
                    int i3 = i + measureText;
                    sb.append(str.substring(i, i3));
                    i2 = i;
                    i = i3 - 1;
                } else {
                    this.mLines.add(str.substring(i));
                    break;
                }
            } else {
                sb.append(str.charAt(i));
            }
            i++;
        }
        if (sb.length() > 0) {
            this.mLines.add(sb.toString());
        }
        this.mTailLines.add(Integer.valueOf(this.mLines.size() - 1));
    }

    private void measureTextViewHeight(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mOriginalLineCount = textView.getLineCount();
        this.mOriginalHeight = textView.getMeasuredHeight();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
        if (r14 == com.baidu.searchbox.ui.AlignTextView.Align.ALIGN_RIGHT) goto L12;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.mWidth = getMeasuredWidth();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        float f = 2.0f;
        if ((getGravity() & 16) == 16) {
            textSize += (this.mTextHeight - textSize) / 2.0f;
        }
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        this.mWidth = (this.mWidth - paddingLeft) - getPaddingRight();
        int i = 0;
        int i2 = 0;
        while (i2 < this.mLines.size()) {
            float f2 = i2;
            float f3 = (this.mTextHeight * f2) + textSize;
            String str = this.mLines.get(i2);
            float f4 = paddingLeft;
            float measureText = this.mWidth - paint.measureText(str);
            float length = measureText / (str.length() - 1);
            if (this.mTailLines.contains(Integer.valueOf(i2))) {
                length = 0.0f;
                Align align = this.mAlign;
                if (align == Align.ALIGN_CENTER) {
                    measureText /= f;
                }
                f4 += measureText;
            }
            int i3 = 0;
            while (i3 < str.length()) {
                int i4 = i3 + 1;
                canvas.drawText(str.substring(i3, i4), paint.measureText(str.substring(i, i3)) + (i3 * length) + f4, paddingTop + f3 + (this.mTextLineSpaceExtra * f2), paint);
                i3 = i4;
                i = 0;
            }
            i2++;
            f = 2.0f;
            i = 0;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
            float f = (this.mOriginalHeight * 1.0f) / this.mOriginalLineCount;
            this.mTextHeight = f;
            float f2 = ((this.mLineSpacingMultiplier - 1.0f) * f) + this.mLineSpacingAdd;
            this.mTextLineSpaceExtra = f2;
            this.mSetPaddingFromMe = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.mOriginalPaddingBottom + ((int) ((f2 + f) * (this.mLines.size() - this.mOriginalLineCount))));
            this.mFirstCalc = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.mSetPaddingFromMe) {
            this.mOriginalPaddingBottom = i4;
        }
        this.mSetPaddingFromMe = false;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mFirstCalc = true;
        super.setText(charSequence, bufferType);
    }
}
