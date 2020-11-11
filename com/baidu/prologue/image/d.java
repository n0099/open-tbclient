package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes19.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* loaded from: classes19.dex */
    private static class a {
        private static final d ciU = new d();
    }

    public static b<ImageView> acR() {
        return a.ciU;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aT(com.baidu.prologue.a.b.a.che.get().abJ()).asBitmap().load(str).apply(new RequestOptions().placeholder(aU(imageView.getContext())).error(aV(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aU(Context context) {
        return null;
    }

    private Drawable aV(Context context) {
        return null;
    }
}
