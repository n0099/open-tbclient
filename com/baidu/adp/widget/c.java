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
import java.io.InputStream;
/* loaded from: classes.dex */
public class c extends DynamicDrawableSpan {
    private Uri avN;
    private int avO;
    private a avP;
    private Rect lQ;
    private Context mContext;
    private Drawable wz;

    /* loaded from: classes.dex */
    public interface a {
        Drawable a(c cVar);
    }

    public void setDrawable(Drawable drawable) {
        this.wz = drawable;
    }

    public c(a aVar, int i, int i2) {
        super(i2);
        this.lQ = new Rect();
        this.avO = i;
        this.avP = aVar;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.wz != null || this.avP == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.lQ.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.lQ.right;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = null;
        if (this.wz != null) {
            drawable = this.wz;
        } else if (this.avP != null) {
            drawable = this.avP.a(this);
        }
        if (drawable != null) {
            return drawable;
        }
        if (this.avN != null) {
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.avN);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception e) {
                    return bitmapDrawable;
                }
            } catch (Exception e2) {
                return drawable;
            }
        }
        try {
            Drawable drawable2 = this.mContext.getResources().getDrawable(this.avO);
            try {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                return drawable2;
            } catch (Exception e3) {
                return drawable2;
            }
        } catch (Exception e4) {
            return drawable;
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

    public void k(int i, int i2, int i3, int i4) {
        this.lQ.set(i, i2, i3, i4);
    }
}
