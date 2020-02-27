package com.baidu.searchbox.ugc.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.util.Log;
/* loaded from: classes13.dex */
class EmojiconSpan extends DynamicDrawableSpan {
    private final Context mContext;
    private Drawable mDrawable;
    private final int mResourceId;
    private final int mSize;

    public EmojiconSpan(Context context, int i, int i2) {
        this.mContext = context;
        this.mResourceId = i;
        this.mSize = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.mDrawable == null) {
            try {
                this.mDrawable = this.mContext.getResources().getDrawable(this.mResourceId);
                this.mDrawable.setBounds(0, 0, this.mSize, this.mSize);
            } catch (Exception e) {
                Log.i(EmojiconSpan.class.getSimpleName(), e.getMessage());
            }
        }
        return this.mDrawable;
    }
}
