package com.baidu.tbadk.core.elementsMaven.view;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class EMTextView extends TextView {
    private a eHN;

    public EMTextView(Context context) {
        this(context, null);
    }

    public EMTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView
    @Deprecated
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        super.setText(charSequence, bufferType);
        if (charSequence != null) {
            if (charSequence instanceof SpannableStringBuilder) {
                spannableStringBuilder = (SpannableStringBuilder) charSequence;
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            if (this.eHN == null) {
                this.eHN = new a(this);
            }
            spannableStringBuilder.setSpan(this.eHN, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* loaded from: classes.dex */
    static class a implements LineHeightSpan {
        private ViewGroup.MarginLayoutParams eHO;
        private int eHP = 0;
        private int eHQ = 0;
        private int eHR = 0;
        private int eHS = 0;
        private int textSize;
        private TextView textView;

        public a(TextView textView) {
            this.textView = textView;
            init();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            boE();
            com.baidu.tbadk.core.elementsMaven.a.a.a(fontMetricsInt, this.textSize);
            if (this.textView == null || (this.textView.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            if (this.textView != null) {
                this.textSize = (int) this.textView.getTextSize();
            }
            this.eHO = boG();
            if (this.eHO != null) {
                this.eHP = this.eHO.topMargin;
                this.eHQ = this.eHO.bottomMargin;
            }
            this.eHR = 0;
            this.eHS = 0;
        }

        public void boE() {
            if (boF()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams boG = boG();
            if (boG != null) {
                boG.topMargin -= this.eHR;
                boG.bottomMargin -= this.eHS;
                this.textSize = (int) this.textView.getTextSize();
                this.eHR = 0;
                this.eHS = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams boG = boG();
            if (boG != null) {
                this.eHP = boG.topMargin;
                this.eHQ = boG.bottomMargin;
                this.eHR = fontMetricsInt.top - fontMetricsInt.ascent;
                this.eHS = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                boG.topMargin += this.eHR;
                boG.bottomMargin += this.eHS;
            }
        }

        public boolean boF() {
            ViewGroup.MarginLayoutParams boG;
            if (this.eHO == null || (boG = boG()) == null || this.eHO != boG) {
                return true;
            }
            return ((this.eHP + this.eHR == boG.topMargin) && (this.eHQ + this.eHS == boG.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams boG() {
            if (this.textView == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = this.textView.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
