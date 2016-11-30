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
public class e extends DynamicDrawableSpan {
    private Drawable AF;
    private Uri Dj;
    private int Dk;
    private a Dl;
    private Rect kG;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        Drawable a(e eVar);
    }

    public void setDrawable(Drawable drawable) {
        this.AF = drawable;
    }

    public e(a aVar, int i, int i2) {
        super(i2);
        this.kG = new Rect();
        this.Dk = i;
        this.Dl = aVar;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.AF != null || this.Dl == null) {
            return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -this.kG.bottom;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.kG.right;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = null;
        if (this.AF != null) {
            drawable = this.AF;
        } else if (this.Dl != null) {
            drawable = this.Dl.a(this);
        }
        if (drawable != null) {
            return drawable;
        }
        if (this.Dj != null) {
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.Dj);
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
            Drawable drawable2 = this.mContext.getResources().getDrawable(this.Dk);
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

    public void d(int i, int i2, int i3, int i4) {
        this.kG.set(i, i2, i3, i4);
    }
}
