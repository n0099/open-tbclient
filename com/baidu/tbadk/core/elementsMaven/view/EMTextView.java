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
    private a eOX;

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
            if (this.eOX == null) {
                this.eOX = new a(this);
            }
            spannableStringBuilder.setSpan(this.eOX, 0, charSequence.length(), 33);
            super.setText(spannableStringBuilder, bufferType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements LineHeightSpan {
        private WeakReference<TextView> eOY;
        private ViewGroup.MarginLayoutParams eOZ;
        private int ePa = 0;
        private int ePb = 0;
        private int ePc = 0;
        private int ePd = 0;
        private int textSize;

        public a(TextView textView) {
            this.eOY = new WeakReference<>(textView);
            init();
        }

        public TextView brX() {
            if (this.eOY == null || this.eOY.get() == null) {
                return null;
            }
            return this.eOY.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            brY();
            com.baidu.tbadk.core.elementsMaven.view.a.a(fontMetricsInt, this.textSize);
            TextView brX = brX();
            if (brX == null || (brX.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void init() {
            TextView brX = brX();
            if (brX != null) {
                this.textSize = (int) brX.getTextSize();
            }
            this.eOZ = bsa();
            if (this.eOZ != null) {
                this.ePa = this.eOZ.topMargin;
                this.ePb = this.eOZ.bottomMargin;
            }
            this.ePc = 0;
            this.ePd = 0;
        }

        public void brY() {
            if (brZ()) {
                init();
                return;
            }
            ViewGroup.MarginLayoutParams bsa = bsa();
            if (bsa != null) {
                bsa.topMargin -= this.ePc;
                bsa.bottomMargin -= this.ePd;
                TextView brX = brX();
                if (brX != null) {
                    this.textSize = (int) brX.getTextSize();
                }
                this.ePc = 0;
                this.ePd = 0;
            }
        }

        private void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams bsa = bsa();
            if (bsa != null) {
                this.ePa = bsa.topMargin;
                this.ePb = bsa.bottomMargin;
                this.ePc = fontMetricsInt.top - fontMetricsInt.ascent;
                this.ePd = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                bsa.topMargin += this.ePc;
                bsa.bottomMargin += this.ePd;
            }
        }

        public boolean brZ() {
            ViewGroup.MarginLayoutParams bsa;
            if (this.eOZ == null || (bsa = bsa()) == null || this.eOZ != bsa) {
                return true;
            }
            return ((this.ePa + this.ePc == bsa.topMargin) && (this.ePb + this.ePd == bsa.bottomMargin)) ? false : true;
        }

        private ViewGroup.MarginLayoutParams bsa() {
            TextView brX = brX();
            if (brX == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = brX.getLayoutParams();
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        }
    }
}
