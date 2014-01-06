package com.baidu.adp.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
import java.io.InputStream;
/* loaded from: classes.dex */
public class y extends DynamicDrawableSpan {
    private Drawable a;
    private Uri b;
    private int c;
    private Context d;

    public y(Drawable drawable, int i) {
        super(i);
        this.a = drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        Exception e;
        InputStream openInputStream;
        if (this.a != null) {
            return this.a;
        }
        if (this.b != null) {
            try {
                openInputStream = this.d.getContentResolver().openInputStream(this.b);
                bitmapDrawable = new BitmapDrawable(this.d.getResources(), BitmapFactory.decodeStream(openInputStream));
            } catch (Exception e2) {
                bitmapDrawable = null;
                e = e2;
            }
            try {
                bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                openInputStream.close();
                return bitmapDrawable;
            } catch (Exception e3) {
                e = e3;
                Log.e("sms", "Failed to loaded content " + this.b, e);
                return bitmapDrawable;
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
            drawable = null;
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
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
