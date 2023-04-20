package com.baidu.nadcore.widget.txt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.w01;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class AlignTextView extends TextView {
    public float A;
    public float B;
    public float C;
    public float D;
    public float a;
    public float b;
    public int c;
    public List<String> d;
    public List<Integer> e;
    public Align f;
    public boolean g;
    public float h;
    public float i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public TextPaint n;
    public String o;
    public String[] p;
    public int q;
    public StringBuilder r;
    public int s;
    public float t;
    public int u;
    public TextView v;
    public Paint.FontMetrics w;
    public float x;
    public float y;
    public String z;

    /* loaded from: classes2.dex */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public AlignTextView(Context context) {
        super(context);
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
    }

    public void setAlign(Align align) {
        this.f = align;
        invalidate();
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = Align.ALIGN_LEFT;
        this.g = true;
        this.h = 1.0f;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = false;
        setTextIsSelectable(false);
        this.h = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res/android", "mLineSpacingMultiplier", 1.0f);
        this.i = context.obtainStyledAttributes(attributeSet, new int[]{16843287}).getDimensionPixelSize(0, 0);
        this.l = getPaddingBottom();
    }

    public final void a(Paint paint, String str) {
        if (str.length() == 0) {
            w01.b(this.d, "\n");
            return;
        }
        this.s = 0;
        float measureText = paint.measureText("中");
        this.t = measureText;
        int i = (int) (this.c / measureText);
        this.u = i;
        this.r = new StringBuilder(str.substring(0, Math.min(i + 1, str.length())));
        int i2 = this.u;
        while (true) {
            i2++;
            if (i2 >= str.length()) {
                break;
            } else if (paint.measureText(str.substring(this.s, i2 + 1)) > this.c) {
                this.s = i2;
                w01.b(this.d, this.r.toString());
                this.r = new StringBuilder();
                int length = str.length();
                int i3 = this.s;
                int i4 = length - i3;
                int i5 = this.u;
                if (i4 > i5) {
                    this.r.append(str.substring(i3, i5 + i3));
                    i2 = (i2 + this.u) - 1;
                } else {
                    w01.b(this.d, str.substring(i3));
                    break;
                }
            } else {
                this.r.append(str.charAt(i2));
            }
        }
        if (this.r.length() > 0) {
            w01.b(this.d, this.r.toString());
        }
        w01.b(this.e, Integer.valueOf(this.d.size() - 1));
    }

    public final void b(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        this.v = textView;
        textView.setText(str);
        this.v.setTextSize(0, f);
        this.v.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.k = this.v.getLineCount();
        this.j = this.v.getMeasuredHeight();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        this.n = paint;
        paint.setColor(getCurrentTextColor());
        this.n.drawableState = getDrawableState();
        this.c = getMeasuredWidth();
        this.w = this.n.getFontMetrics();
        float textSize = getTextSize();
        Paint.FontMetrics fontMetrics = this.w;
        this.x = textSize - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        if ((getGravity() & 16) == 16) {
            float f = this.x;
            this.x = f + ((this.a - f) / 2.0f);
        }
        this.c = (this.c - getPaddingLeft()) - getPaddingRight();
        for (int i = 0; i < this.d.size(); i++) {
            float f2 = i;
            this.y = (this.a * f2) + this.x;
            this.z = (String) w01.d(this.d, i);
            this.A = getPaddingLeft();
            float measureText = this.c - this.n.measureText(this.z);
            this.B = measureText;
            this.C = measureText / (this.z.length() - 1);
            if (this.e.contains(Integer.valueOf(i))) {
                this.C = 0.0f;
                Align align = this.f;
                if (align == Align.ALIGN_CENTER) {
                    this.A += this.B / 2.0f;
                } else if (align == Align.ALIGN_RIGHT) {
                    this.A += this.B;
                }
            }
            int i2 = 0;
            while (i2 < this.z.length()) {
                this.D = this.n.measureText(this.z.substring(0, i2)) + (this.C * i2);
                int i3 = i2 + 1;
                canvas.drawText(this.z.substring(i2, i3), this.D + this.A, this.y + getPaddingTop() + (this.b * f2), this.n);
                i2 = i3;
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g) {
            this.c = getMeasuredWidth();
            this.o = getText().toString();
            this.n = getPaint();
            this.d.clear();
            this.e.clear();
            String[] split = this.o.split("\\n");
            this.p = split;
            for (String str : split) {
                a(this.n, str);
            }
            b(this.o, this.n.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            float f = (this.j * 1.0f) / this.k;
            this.a = f;
            float f2 = ((this.h - 1.0f) * f) + this.i;
            this.b = f2;
            this.q = (int) ((f2 + f) * (this.d.size() - this.k));
            this.m = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.l + this.q);
            this.g = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.m) {
            this.l = i4;
        }
        this.m = false;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.g = true;
        super.setText(charSequence, bufferType);
    }
}
