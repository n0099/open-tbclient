package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import java.io.InputStream;
/* loaded from: classes.dex */
public class r extends DynamicDrawableSpan {
    private Drawable a;
    private Uri b;
    private int c;
    private Context d;
    private s e;
    private Rect f;

    public void a(Drawable drawable) {
        this.a = drawable;
    }

    public r(s sVar, int i, int i2) {
        super(i2);
        this.f = new Rect();
        this.c = i;
        this.e = sVar;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.a != null || this.e == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.f.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.f.right;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable;
        Drawable drawable2;
        Exception e;
        InputStream openInputStream;
        Drawable drawable3 = null;
        if (this.a != null) {
            drawable3 = this.a;
        } else if (this.e != null) {
            drawable3 = this.e.a(this);
        }
        if (drawable3 != null) {
            return drawable3;
        }
        if (this.b != null) {
            try {
                openInputStream = this.d.getContentResolver().openInputStream(this.b);
                drawable2 = new BitmapDrawable(this.d.getResources(), BitmapFactory.decodeStream(openInputStream));
            } catch (Exception e2) {
                drawable2 = drawable3;
                e = e2;
            }
            try {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                openInputStream.close();
                return drawable2;
            } catch (Exception e3) {
                e = e3;
                Log.e("sms", "Failed to loaded content " + this.b, e);
                return drawable2;
            }
        }
        try {
            drawable = this.d.getResources().getDrawable(this.c);
            try {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            } catch (Exception e4) {
                Log.e("sms", "Unable to find resource: " + this.c);
                return drawable;
            }
        } catch (Exception e5) {
            drawable = drawable3;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            int i6 = i5 - drawable.getBounds().bottom;
            if (this.mVerticalAlignment != 0) {
                i5 = i4;
            }
            canvas.translate(f, i5 - (drawable.getBounds().bottom - 4));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f.set(i, i2, i3, i4);
    }
}
