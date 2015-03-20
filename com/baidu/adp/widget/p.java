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
public class p extends DynamicDrawableSpan {
    private Drawable GC;
    private Uri Je;
    private int Jf;
    private q Jg;
    private Context mContext;
    private Rect mRect;

    public void setDrawable(Drawable drawable) {
        this.GC = drawable;
    }

    public p(q qVar, int i, int i2) {
        super(i2);
        this.mRect = new Rect();
        this.Jf = i;
        this.Jg = qVar;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.GC != null || this.Jg == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.mRect.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.mRect.right;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable;
        Drawable drawable2;
        Exception e;
        Drawable drawable3 = null;
        if (this.GC != null) {
            drawable3 = this.GC;
        } else if (this.Jg != null) {
            drawable3 = this.Jg.a(this);
        }
        if (drawable3 != null) {
            return drawable3;
        }
        if (this.Je != null) {
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.Je);
                drawable2 = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                    openInputStream.close();
                    return drawable2;
                } catch (Exception e2) {
                    e = e2;
                    Log.e("sms", "Failed to loaded content " + this.Je, e);
                    return drawable2;
                }
            } catch (Exception e3) {
                drawable2 = drawable3;
                e = e3;
            }
        } else {
            try {
                drawable = this.mContext.getResources().getDrawable(this.Jf);
                try {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    return drawable;
                } catch (Exception e4) {
                    Log.e("sms", "Unable to find resource: " + this.Jf);
                    return drawable;
                }
            } catch (Exception e5) {
                drawable = drawable3;
            }
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

    public void c(int i, int i2, int i3, int i4) {
        this.mRect.set(i, i2, i3, i4);
    }
}
