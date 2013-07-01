package com.baidu.mapapi;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
final class r implements p {

    /* renamed from: a  reason: collision with root package name */
    private o f565a = new o(Bitmap.Config.ARGB_4444);
    private Drawable b = null;

    public static void a(Drawable drawable, Drawable drawable2) {
        Rect bounds = drawable2.getBounds();
        int height = (int) (bounds.height() * 0.5f);
        int width = (int) (bounds.width() * 0.9f * 0.5d);
        drawable.setBounds(bounds.left + width, bounds.top + height, width + bounds.right, bounds.bottom + height);
    }

    public final Drawable a(Drawable drawable) {
        this.b = drawable;
        this.f565a.a(this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
        this.f565a.a(this);
        this.b = null;
        return new BitmapDrawable(this.f565a.b());
    }

    @Override // com.baidu.mapapi.p
    public final void a(Canvas canvas) {
        this.b.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
        canvas.skew(-0.9f, 0.0f);
        canvas.scale(1.0f, 0.5f);
        this.b.draw(canvas);
        this.b.clearColorFilter();
    }
}
