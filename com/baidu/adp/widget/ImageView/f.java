package com.baidu.adp.widget.ImageView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BitmapDrawable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, Bitmap bitmap) {
        super(bitmap);
        this.a = eVar;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        bitmap = this.a.d;
        if (bitmap != null && (bitmap2 = getBitmap()) != null && !bitmap2.isRecycled()) {
            bitmap3 = this.a.d;
            canvas.drawBitmap(bitmap3, (Rect) null, getBounds(), getPaint());
        }
    }
}
