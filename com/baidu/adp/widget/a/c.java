package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BitmapDrawable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, Bitmap bitmap) {
        super(bitmap);
        this.a = bVar;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        bitmap = this.a.b;
        if (bitmap != null && (bitmap2 = getBitmap()) != null && !bitmap2.isRecycled()) {
            bitmap3 = this.a.b;
            canvas.drawBitmap(bitmap3, 0.0f, 0.0f, getPaint());
        }
    }
}
