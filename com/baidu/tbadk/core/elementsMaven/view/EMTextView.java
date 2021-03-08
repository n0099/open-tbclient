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
    private a eYa;

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
            if (this.eYa == null) {
                this.eYa = new a(this);
            }
            spannableStringBuilder.setSpan(this.eYa, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements LineHeightSpan {
        private WeakReference<TextView> eYb;
        private ViewGroup.MarginLayoutParams eYc;
        private int eYd = 0;
        private int eYe = 0;
        private int eYf = 0;
        private int eYg = 0;
        private int textSize;

        public a(TextView textView) {
            this.eYb = new WeakReference<>(textView);
            init();
        }

        public TextView bra() {
            if (this.eYb == null || this.eYb.get() == null) {
                return null;
            }
            return this.eYb.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            brb();
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, this.textSize);
            TextView bra = bra();
            if (bra == null || (bra.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            TextView bra = bra();
            if (bra != null) {
                this.textSize = (int) bra.getTextSize();
            }
            this.eYc = brd();
            if (this.eYc != null) {
                this.eYd = this.eYc.topMargin;
                this.eYe = this.eYc.bottomMargin;
            }
            this.eYf = 0;
            this.eYg = 0;
        }

        public void brb() {
            if (brc()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams brd = brd();
            if (brd != null) {
                brd.topMargin -= this.eYf;
                brd.bottomMargin -= this.eYg;
                TextView bra = bra();
                if (bra != null) {
                    this.textSize = (int) bra.getTextSize();
                }
                this.eYf = 0;
                this.eYg = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams brd = brd();
            if (brd != null) {
                this.eYd = brd.topMargin;
                this.eYe = brd.bottomMargin;
                this.eYf = fontMetricsInt.top - fontMetricsInt.ascent;
                this.eYg = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                brd.topMargin += this.eYf;
                brd.bottomMargin += this.eYg;
            }
        }

        public boolean brc() {
            ViewGroup.MarginLayoutParams brd;
            if (this.eYc == null || (brd = brd()) == null || this.eYc != brd) {
                return true;
            }
            return ((this.eYd + this.eYf == brd.topMargin) && (this.eYe + this.eYg == brd.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams brd() {
            TextView bra = bra();
            if (bra == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = bra.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
