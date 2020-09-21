package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes10.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d bOb = new d();
    }

    public static b<ImageView> WC() {
        return a.bOb;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aP(com.baidu.prologue.a.b.a.bMm.get().Vt()).asBitmap().load(str).apply(new RequestOptions().placeholder(aQ(imageView.getContext())).error(aR(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aQ(Context context) {
        return null;
    }

    private Drawable aR(Context context) {
        return null;
    }
}
