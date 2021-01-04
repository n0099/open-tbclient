package com.baidu.pass.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.pass.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlignPartTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private float f4156a;

    /* renamed from: b  reason: collision with root package name */
    private float f4157b;
    private int c;
    private List<String> d;
    private List<Integer> e;
    private Align f;
    private boolean g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private List<String> n;
    private int o;
    private int[] p;
    private int[] q;

    /* loaded from: classes4.dex */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public AlignPartTextView(Context context) {
        super(context);
        this.f4157b = 0.0f;
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

    public void a(List<String> list, int i) {
        this.n = list;
        this.o = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z;
        TextPaint paint = getPaint();
        paint.drawableState = getDrawableState();
        this.c = getMeasuredWidth();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        float f = (getGravity() & 4096) == 0 ? textSize + ((this.f4156a - textSize) / 2.0f) : textSize;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        this.c = (this.c - paddingLeft) - getPaddingRight();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d.size()) {
                return;
            }
            float f2 = i3;
            float f3 = (this.f4156a * f2) + f;
            String str = this.d.get(i3);
            float f4 = paddingLeft;
            float measureText = this.c - paint.measureText(str);
            float length = measureText / (str.length() - 1);
            if (this.e.contains(Integer.valueOf(i3))) {
                length = 0.0f;
                Align align = this.f;
                if (align == Align.ALIGN_CENTER) {
                    f4 += measureText / 2.0f;
                } else if (align == Align.ALIGN_RIGHT) {
                    f4 += measureText;
                }
            }
            int i4 = 0;
            while (i4 < str.length()) {
                int[] iArr = this.p;
                if (iArr == null || iArr.length == 0) {
                    paint.setColor(getCurrentTextColor());
                } else {
                    int i5 = 0;
                    while (true) {
                        int[] iArr2 = this.p;
                        if (i5 >= iArr2.length) {
                            z = false;
                            break;
                        }
                        int i6 = iArr2[i5];
                        int i7 = this.q[i5];
                        if (i >= i6 && i < i7) {
                            z = true;
                            break;
                        }
                        i5++;
                    }
                    if (z) {
                        paint.setColor(this.o);
                    } else {
                        paint.setColor(getCurrentTextColor());
                    }
                }
                int i8 = i4 + 1;
                canvas.drawText(str.substring(i4, i8), (i4 * length) + paint.measureText(str.substring(0, i4)) + f4, paddingTop + f3 + (this.f4157b * f2), paint);
                i++;
                i4 = i8;
            }
            i2 = i3 + 1;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g) {
            this.c = getMeasuredWidth();
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            this.d.clear();
            this.e.clear();
            for (String str : charSequence.split("\\n")) {
                a(paint, str);
            }
            a(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            this.f4156a = (this.j * 1.0f) / this.k;
            float f = this.f4156a;
            this.f4157b = ((this.h - 1.0f) * f) + this.i;
            this.m = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), ((int) ((f + this.f4157b) * (this.d.size() - this.k))) + this.l);
            List<String> list = this.n;
            if (list != null && list.size() > 0) {
                this.p = new int[this.n.size()];
                this.q = new int[this.n.size()];
                for (int i5 = 0; i5 < this.n.size(); i5++) {
                    String str2 = this.n.get(i5);
                    this.p[i5] = charSequence.indexOf(str2);
                    this.q[i5] = str2.length() + this.p[i5];
                }
            }
            this.g = false;
        }
    }

    public void setAlign(Align align) {
        this.f = align;
        invalidate();
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

    private void a(Paint paint, String str) {
        int i;
        int i2 = 0;
        if (str.length() == 0) {
            this.d.add("\n");
            return;
        }
        int measureText = (int) (this.c / paint.measureText("中"));
        int i3 = measureText + 1;
        StringBuilder sb = new StringBuilder(str.substring(0, Math.min(i3, str.length())));
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            if (paint.measureText(str.substring(i2, i3 + 1)) > this.c) {
                this.d.add(sb.toString());
                sb = new StringBuilder();
                if (str.length() - i3 > measureText) {
                    int i4 = i3 + measureText;
                    sb.append(str.substring(i3, i4));
                    i = i4 - 1;
                    i2 = i3;
                } else {
                    this.d.add(str.substring(i3));
                    break;
                }
            } else {
                sb.append(str.charAt(i3));
                i = i3;
            }
            i3 = i + 1;
        }
        if (sb.length() > 0) {
            this.d.add(sb.toString());
        }
        this.e.add(Integer.valueOf(this.d.size() - 1));
    }

    public AlignPartTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4157b = 0.0f;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843287, 16843288});
        this.i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.h = obtainStyledAttributes.getFloat(1, 1.0f);
        this.l = getPaddingBottom();
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.sapi_sdk_align_textview);
        int i = obtainStyledAttributes2.getInt(R.styleable.sapi_sdk_align_textview_sapi_sdk_align, 0);
        if (i == 1) {
            this.f = Align.ALIGN_CENTER;
        } else if (i != 2) {
            this.f = Align.ALIGN_LEFT;
        } else {
            this.f = Align.ALIGN_RIGHT;
        }
        obtainStyledAttributes2.recycle();
    }

    private void a(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.k = textView.getLineCount();
        this.j = textView.getMeasuredHeight();
    }
}
