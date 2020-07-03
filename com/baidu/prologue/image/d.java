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
        private static final d bFZ = new d();
    }

    public static b<ImageView> PJ() {
        return a.bFZ;
    }

    @Override // com.baidu.prologue.image.b
    public void a(String str, ImageView imageView) {
        c.aK(com.baidu.prologue.a.b.a.bEl.get().Oz()).asBitmap().load(str).apply(new RequestOptions().placeholder(aL(imageView.getContext())).error(aM(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable aL(Context context) {
        return null;
    }

    private Drawable aM(Context context) {
        return null;
    }
}
