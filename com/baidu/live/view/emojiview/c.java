package com.baidu.live.view.emojiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class c extends DynamicDrawableSpan {
    private final Context mContext;
    private Drawable mDrawable;
    private WeakReference<Drawable> mDrawableRef;
    private int mHeight;
    private final int mResourceId;
    private final int mSize;
    private final int mTextSize;
    private int mTop;
    private int mWidth;

    public c(Context context, int i, int i2, int i3, int i4) {
        super(i3);
        this.mContext = context;
        this.mResourceId = i;
        this.mSize = i2;
        this.mHeight = i2;
        this.mWidth = i2;
        this.mTextSize = i4;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.mDrawable == null) {
            try {
                this.mDrawable = this.mContext.getResources().getDrawable(this.mResourceId);
                this.mHeight = this.mSize;
                this.mWidth = (this.mHeight * this.mDrawable.getIntrinsicWidth()) / this.mDrawable.getIntrinsicHeight();
                this.mTop = (this.mTextSize - this.mHeight) / 2;
                this.mDrawable.setBounds(0, this.mTop, this.mWidth, this.mTop + this.mHeight);
            } catch (Exception e) {
            }
        }
        return this.mDrawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        int i6 = i5 - cachedDrawable.getBounds().bottom;
        if (this.mVerticalAlignment == 1) {
            i6 = ((((i5 - i3) / 2) + i3) - ((cachedDrawable.getBounds().bottom - cachedDrawable.getBounds().top) / 2)) - this.mTop;
        }
        canvas.translate(f, i6);
        cachedDrawable.draw(canvas);
        canvas.restore();
    }

    private Drawable getCachedDrawable() {
        if (this.mDrawableRef == null || this.mDrawableRef.get() == null) {
            this.mDrawableRef = new WeakReference<>(getDrawable());
        }
        return this.mDrawableRef.get();
    }
}
