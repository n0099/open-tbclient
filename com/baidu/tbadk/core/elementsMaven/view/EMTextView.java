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
    private a eWB;

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
            if (this.eWB == null) {
                this.eWB = new a(this);
            }
            spannableStringBuilder.setSpan(this.eWB, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements LineHeightSpan {
        private WeakReference<TextView> eWC;
        private ViewGroup.MarginLayoutParams eWD;
        private int eWE = 0;
        private int eWF = 0;
        private int eWG = 0;
        private int eWH = 0;
        private int textSize;

        public a(TextView textView) {
            this.eWC = new WeakReference<>(textView);
            init();
        }

        public TextView bqZ() {
            if (this.eWC == null || this.eWC.get() == null) {
                return null;
            }
            return this.eWC.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            bra();
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, this.textSize);
            TextView bqZ = bqZ();
            if (bqZ == null || (bqZ.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            TextView bqZ = bqZ();
            if (bqZ != null) {
                this.textSize = (int) bqZ.getTextSize();
            }
            this.eWD = brc();
            if (this.eWD != null) {
                this.eWE = this.eWD.topMargin;
                this.eWF = this.eWD.bottomMargin;
            }
            this.eWG = 0;
            this.eWH = 0;
        }

        public void bra() {
            if (brb()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams brc = brc();
            if (brc != null) {
                brc.topMargin -= this.eWG;
                brc.bottomMargin -= this.eWH;
                TextView bqZ = bqZ();
                if (bqZ != null) {
                    this.textSize = (int) bqZ.getTextSize();
                }
                this.eWG = 0;
                this.eWH = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams brc = brc();
            if (brc != null) {
                this.eWE = brc.topMargin;
                this.eWF = brc.bottomMargin;
                this.eWG = fontMetricsInt.top - fontMetricsInt.ascent;
                this.eWH = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                brc.topMargin += this.eWG;
                brc.bottomMargin += this.eWH;
            }
        }

        public boolean brb() {
            ViewGroup.MarginLayoutParams brc;
            if (this.eWD == null || (brc = brc()) == null || this.eWD != brc) {
                return true;
            }
            return ((this.eWE + this.eWG == brc.topMargin) && (this.eWF + this.eWH == brc.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams brc() {
            TextView bqZ = bqZ();
            if (bqZ == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = bqZ.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
