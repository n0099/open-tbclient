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
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class EMTextView extends TextView {
    private a eUl;

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
            if (this.eUl == null) {
                this.eUl = new a(this);
            }
            spannableStringBuilder.setSpan(this.eUl, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements LineHeightSpan {
        private WeakReference<TextView> eUm;
        private ViewGroup.MarginLayoutParams eUn;
        private int eUo = 0;
        private int eUp = 0;
        private int eUq = 0;
        private int eUr = 0;
        private int textSize;

        public a(TextView textView) {
            this.eUm = new WeakReference<>(textView);
            init();
        }

        public TextView bqG() {
            if (this.eUm == null || this.eUm.get() == null) {
                return null;
            }
            return this.eUm.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            bqH();
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, this.textSize);
            TextView bqG = bqG();
            if (bqG == null || (bqG.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            TextView bqG = bqG();
            if (bqG != null) {
                this.textSize = (int) bqG.getTextSize();
            }
            this.eUn = bqJ();
            if (this.eUn != null) {
                this.eUo = this.eUn.topMargin;
                this.eUp = this.eUn.bottomMargin;
            }
            this.eUq = 0;
            this.eUr = 0;
        }

        public void bqH() {
            if (bqI()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams bqJ = bqJ();
            if (bqJ != null) {
                bqJ.topMargin -= this.eUq;
                bqJ.bottomMargin -= this.eUr;
                TextView bqG = bqG();
                if (bqG != null) {
                    this.textSize = (int) bqG.getTextSize();
                }
                this.eUq = 0;
                this.eUr = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams bqJ = bqJ();
            if (bqJ != null) {
                this.eUo = bqJ.topMargin;
                this.eUp = bqJ.bottomMargin;
                this.eUq = fontMetricsInt.top - fontMetricsInt.ascent;
                this.eUr = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                bqJ.topMargin += this.eUq;
                bqJ.bottomMargin += this.eUr;
            }
        }

        public boolean bqI() {
            ViewGroup.MarginLayoutParams bqJ;
            if (this.eUn == null || (bqJ = bqJ()) == null || this.eUn != bqJ) {
                return true;
            }
            return ((this.eUo + this.eUq == bqJ.topMargin) && (this.eUp + this.eUr == bqJ.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams bqJ() {
            TextView bqG = bqG();
            if (bqG == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = bqG.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
