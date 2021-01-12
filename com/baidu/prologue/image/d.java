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
        private static final d cqf = new d();
    }

    public static b<ImageView> adt() {
        return a.cqf;
    }

    @Override // com.baidu.prologue.image.b
    public void b(String str, ImageView imageView) {
        c.with(com.baidu.prologue.a.b.a.cop.get().acl()).asBitmap().load(str).apply(new RequestOptions().placeholder(bM(imageView.getContext())).error(bN(imageView.getContext())).centerCrop()).transition(new BitmapTransitionOptions().crossFade(300)).into(imageView);
    }

    private Drawable bM(Context context) {
        return null;
    }

    private Drawable bN(Context context) {
        return null;
    }
}
