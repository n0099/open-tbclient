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
/* loaded from: classes3.dex */
public class EMTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public a f13254e;

    /* loaded from: classes3.dex */
    public static class a implements LineHeightSpan {

        /* renamed from: e  reason: collision with root package name */
        public int f13255e;

        /* renamed from: f  reason: collision with root package name */
        public WeakReference<TextView> f13256f;

        /* renamed from: g  reason: collision with root package name */
        public ViewGroup.MarginLayoutParams f13257g;

        /* renamed from: h  reason: collision with root package name */
        public int f13258h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;

        public a(TextView textView) {
            this.f13256f = new WeakReference<>(textView);
            d();
        }

        public final void a(Paint.FontMetricsInt fontMetricsInt) {
            ViewGroup.MarginLayoutParams b2 = b();
            if (b2 != null) {
                this.f13258h = b2.topMargin;
                this.i = b2.bottomMargin;
                this.j = fontMetricsInt.top - fontMetricsInt.ascent;
                int dimenPixelSize = (fontMetricsInt.descent - fontMetricsInt.bottom) - UtilHelper.getDimenPixelSize(R.dimen.tbds3);
                this.k = dimenPixelSize;
                b2.topMargin += this.j;
                b2.bottomMargin += dimenPixelSize;
            }
        }

        public final ViewGroup.MarginLayoutParams b() {
            TextView c2 = c();
            if (c2 == null) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return (ViewGroup.MarginLayoutParams) layoutParams;
            }
            return null;
        }

        public TextView c() {
            WeakReference<TextView> weakReference = this.f13256f;
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return this.f13256f.get();
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
            f();
            d.b.h0.r.u.e.a.a(fontMetricsInt, this.f13255e);
            TextView c2 = c();
            if (c2 == null || (c2.getGravity() & 112) != 16) {
                a(fontMetricsInt);
            }
        }

        public void d() {
            TextView c2 = c();
            if (c2 != null) {
                this.f13255e = (int) c2.getTextSize();
            }
            ViewGroup.MarginLayoutParams b2 = b();
            this.f13257g = b2;
            if (b2 != null) {
                this.f13258h = b2.topMargin;
                this.i = b2.bottomMargin;
            }
            this.j = 0;
            this.k = 0;
        }

        public boolean e() {
            ViewGroup.MarginLayoutParams b2;
            if (this.f13257g != null && (b2 = b()) != null && this.f13257g == b2) {
                boolean z = this.f13258h + this.j == b2.topMargin;
                boolean z2 = this.i + this.k == b2.bottomMargin;
                if (z && z2) {
                    return false;
                }
            }
            return true;
        }

        public void f() {
            if (e()) {
                d();
                return;
            }
            ViewGroup.MarginLayoutParams b2 = b();
            if (b2 == null) {
                return;
            }
            b2.topMargin -= this.j;
            b2.bottomMargin -= this.k;
            TextView c2 = c();
            if (c2 != null) {
                this.f13255e = (int) c2.getTextSize();
            }
            this.j = 0;
            this.k = 0;
        }
    }

    public EMTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView
    @Deprecated
    public void setLineSpacing(float f2, float f3) {
        super.setLineSpacing(f2, f3);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        SpannableStringBuilder spannableStringBuilder;
        super.setText(charSequence, bufferType);
        if (charSequence == null) {
            return;
        }
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
        }
        if (this.f13254e == null) {
            this.f13254e = new a(this);
        }
        spannableStringBuilder.setSpan(this.f13254e, 0, charSequence.length(), 33);
        super.setText(spannableStringBuilder, bufferType);
    }

    public EMTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
