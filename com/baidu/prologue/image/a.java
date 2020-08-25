package com.baidu.prologue.image;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
/* loaded from: classes9.dex */
public class a extends BitmapTransformation {
    private BitmapPool bLU;
    private int bLV;
    private int bLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(@NonNull Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    a(@NonNull BitmapPool bitmapPool) {
        this.bLV = 0;
        this.bLW = 0;
        this.bLU = bitmapPool;
    }
}
