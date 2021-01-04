package com.baidu.prologue.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
/* loaded from: classes5.dex */
public class d implements b<ImageView> {
    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final d cuX = new d();
    }

    public static b<ImageView> ahm() {
        return a.cuX;
    }

    @Override // com.baidu.prologue.image.b
    public void b(String str, ImageView imageView) {
        c.with(com.baidu.prologue.a.b.a.ctd.get().age()).asBitmap().load(str).apply(new RequestOptions().placeholder(bN(imageView.getContext())).error(bO(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable bN(Context context) {
        return null;
    }

    private Drawable bO(Context context) {
        return null;
    }
}
