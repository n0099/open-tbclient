package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes14.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* loaded from: classes14.dex */
    private static class a {
        private static final d cnQ = new d();
    }

    public static b<ImageView> afq() {
        return a.cnQ;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.bz(com.baidu.prologue.a.b.a.clZ.get().aei()).asBitmap().load(str).apply(new RequestOptions().placeholder(bA(imageView.getContext())).error(bB(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable bA(Context context) {
        return null;
    }

    private Drawable bB(Context context) {
        return null;
    }
}
