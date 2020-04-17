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
        private static final d btE = new d();
    }

    public static b<ImageView> Mr() {
        return a.btE;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aL(com.baidu.prologue.a.b.a.brQ.get().Lh()).asBitmap().load(str).apply(new RequestOptions().placeholder(aM(imageView.getContext())).error(aN(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aM(Context context) {
        return null;
    }

    private Drawable aN(Context context) {
        return null;
    }
}
