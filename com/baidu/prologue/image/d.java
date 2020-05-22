package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes6.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* loaded from: classes6.dex */
    private static class a {
        private static final d bBl = new d();
    }

    public static b<ImageView> OD() {
        return a.bBl;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aJ(com.baidu.prologue.a.b.a.bzx.get().Nt()).asBitmap().load(str).apply(new RequestOptions().placeholder(aK(imageView.getContext())).error(aL(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aK(Context context) {
        return null;
    }

    private Drawable aL(Context context) {
        return null;
    }
}
