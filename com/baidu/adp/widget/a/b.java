package com.baidu.adp.widget.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BitmapDrawable {
    final /* synthetic */ a Hq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, Bitmap bitmap) {
        super(bitmap);
        this.Hq = aVar;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        bitmap = this.Hq.Hc;
        if (bitmap != null && (bitmap2 = getBitmap()) != null && !bitmap2.isRecycled()) {
            bitmap3 = this.Hq.Hc;
            canvas.drawBitmap(bitmap3, (Rect) null, getBounds(), getPaint());
        }
    }
}
