package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes9.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d bMb = new d();
    }

    public static b<ImageView> VT() {
        return a.bMb;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aQ(com.baidu.prologue.a.b.a.bKm.get().UK()).asBitmap().load(str).apply(new RequestOptions().placeholder(aR(imageView.getContext())).error(aS(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aR(Context context) {
        return null;
    }

    private Drawable aS(Context context) {
        return null;
    }
}
