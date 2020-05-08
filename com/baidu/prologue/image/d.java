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
        private static final d btI = new d();
    }

    public static b<ImageView> Mq() {
        return a.btI;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.az(com.baidu.prologue.a.b.a.brU.get().Lg()).asBitmap().load(str).apply(new RequestOptions().placeholder(aA(imageView.getContext())).error(aB(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aA(Context context) {
        return null;
    }

    private Drawable aB(Context context) {
        return null;
    }
}
