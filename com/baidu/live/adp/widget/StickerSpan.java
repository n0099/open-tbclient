package com.baidu.live.adp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class StickerSpan extends DynamicDrawableSpan {
    private Uri mContentUri;
    private Context mContext;
    private Drawable mDrawable;
    private DrawableLoader mDrawableLoader;
    private Rect mRect;
    private int mResourceId;
    private String mSource;

    /* loaded from: classes11.dex */
    public interface DrawableLoader {
        Drawable getDrawableFromUI(StickerSpan stickerSpan);
    }

    public void setDrawable(Drawable drawable) {
        this.mDrawable = drawable;
    }

    public StickerSpan(Context context, Bitmap bitmap) {
        this(context, bitmap, 0);
    }

    public StickerSpan(Context context, Bitmap bitmap, int i) {
        super(i);
        this.mRect = new Rect();
        this.mContext = context;
        this.mDrawable = context != null ? new BitmapDrawable(context.getResources(), bitmap) : new BitmapDrawable(bitmap);
        int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        this.mDrawable.setBounds(0, 0, intrinsicWidth <= 0 ? 0 : intrinsicWidth, intrinsicHeight <= 0 ? 0 : intrinsicHeight);
    }

    public StickerSpan(Drawable drawable) {
        this(drawable, 0);
    }

    public StickerSpan(Drawable drawable, int i) {
        super(i);
        this.mRect = new Rect();
        this.mDrawable = drawable;
    }

    public StickerSpan(DrawableLoader drawableLoader, int i, int i2) {
        super(i2);
        this.mRect = new Rect();
        this.mResourceId = i;
        this.mDrawableLoader = drawableLoader;
    }

    public StickerSpan(Drawable drawable, String str) {
        this(drawable, str, 0);
    }

    public StickerSpan(Drawable drawable, String str, int i) {
        super(i);
        this.mRect = new Rect();
        this.mDrawable = drawable;
        this.mSource = str;
    }

    public StickerSpan(Context context, Uri uri) {
        this(context, uri, 0);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mDrawable != null || this.mDrawableLoader == null) {
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

    public StickerSpan(Context context, Uri uri, int i) {
        super(i);
        this.mRect = new Rect();
        this.mContext = context;
        this.mContentUri = uri;
        this.mSource = uri.toString();
    }

    public StickerSpan(Context context, int i) {
        this(context, i, 0);
    }

    public StickerSpan(Context context, int i, int i2) {
        super(i2);
        this.mRect = new Rect();
        this.mContext = context;
        this.mResourceId = i;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = null;
        if (this.mDrawable != null) {
            drawable = this.mDrawable;
        } else if (this.mDrawableLoader != null) {
            drawable = this.mDrawableLoader.getDrawableFromUI(this);
        }
        if (drawable != null) {
            return drawable;
        }
        if (this.mContentUri != null) {
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.mContentUri);
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
            Drawable drawable2 = this.mContext.getResources().getDrawable(this.mResourceId);
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

    public String getSource() {
        return this.mSource;
    }

    public void setEmptyBounds(int i, int i2, int i3, int i4) {
        this.mRect.set(i, i2, i3, i4);
    }
}
