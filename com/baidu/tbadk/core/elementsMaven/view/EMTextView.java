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
    private a eYW;

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
            if (this.eYW == null) {
                this.eYW = new a(this);
            }
            spannableStringBuilder.setSpan(this.eYW, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements LineHeightSpan {
        private WeakReference<TextView> eYX;
        private ViewGroup.MarginLayoutParams eYY;
        private int eYZ = 0;
        private int eZa = 0;
        private int eZb = 0;
        private int eZc = 0;
        private int textSize;

        public a(TextView textView) {
            this.eYX = new WeakReference<>(textView);
            init();
        }

        public TextView buA() {
            if (this.eYX == null || this.eYX.get() == null) {
                return null;
            }
            return this.eYX.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            buB();
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, this.textSize);
            TextView buA = buA();
            if (buA == null || (buA.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            TextView buA = buA();
            if (buA != null) {
                this.textSize = (int) buA.getTextSize();
            }
            this.eYY = buD();
            if (this.eYY != null) {
                this.eYZ = this.eYY.topMargin;
                this.eZa = this.eYY.bottomMargin;
            }
            this.eZb = 0;
            this.eZc = 0;
        }

        public void buB() {
            if (buC()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams buD = buD();
            if (buD != null) {
                buD.topMargin -= this.eZb;
                buD.bottomMargin -= this.eZc;
                TextView buA = buA();
                if (buA != null) {
                    this.textSize = (int) buA.getTextSize();
                }
                this.eZb = 0;
                this.eZc = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams buD = buD();
            if (buD != null) {
                this.eYZ = buD.topMargin;
                this.eZa = buD.bottomMargin;
                this.eZb = fontMetricsInt.top - fontMetricsInt.ascent;
                this.eZc = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                buD.topMargin += this.eZb;
                buD.bottomMargin += this.eZc;
            }
        }

        public boolean buC() {
            ViewGroup.MarginLayoutParams buD;
            if (this.eYY == null || (buD = buD()) == null || this.eYY != buD) {
                return true;
            }
            return ((this.eYZ + this.eZb == buD.topMargin) && (this.eZa + this.eZc == buD.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams buD() {
            TextView buA = buA();
            if (buA == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = buA.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
