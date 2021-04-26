package com.baidu.pano.platform.comapi.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import com.baidu.pano.platform.c.h;
import com.baidu.tbadk.core.util.PullViewHelper;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f9353a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9354b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f9355c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f9356d;

    /* renamed from: e  reason: collision with root package name */
    public int f9357e;

    /* renamed from: f  reason: collision with root package name */
    public int f9358f;

    /* renamed from: g  reason: collision with root package name */
    public int f9359g;

    /* renamed from: h  reason: collision with root package name */
    public int f9360h;

    /* renamed from: i  reason: collision with root package name */
    public int f9361i;
    public int j;
    public String k;

    public b(Context context, boolean z, String str) {
        this.f9357e = h.a(12.0f, context);
        this.f9358f = h.a(5, context);
        this.f9359g = h.a(5, context);
        this.f9360h = h.a(8, context);
        this.f9361i = h.a(8, context);
        this.f9354b = z;
        this.f9353a = str;
        if (z) {
            a();
        }
    }

    private void b() {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f9357e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int measureText = (int) paint.measureText(this.f9353a);
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int measureText2 = this.f9358f + measureText + this.f9359g + 30 + 2 + ((int) paint.measureText(this.k));
        int i2 = this.f9360h + ceil + this.f9361i;
        int i3 = this.j;
        if (i3 > i2) {
            i2 = i3;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measureText2, i2, Bitmap.Config.ARGB_8888);
        this.f9356d = createBitmap;
        canvas.setBitmap(createBitmap);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-11642518);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, measureText2, i2), 10.0f, 10.0f, paint);
        if (this.f9354b) {
            canvas.drawRect(new Rect(0, 0, measureText2 - 20, i2), paint);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        int i4 = this.f9358f;
        canvas.drawRect(new Rect(measureText + i4 + 15, this.f9360h, i4 + measureText + 15 + 2, i2 - this.f9361i), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        float f2 = i2 / 2;
        float f3 = ceil / 2;
        canvas.drawText(this.f9353a, this.f9358f + 0, ((0.0f - fontMetrics.ascent) + f2) - f3, paint);
        paint.setColor(-13400577);
        canvas.drawText(this.k, measureText + this.f9358f + 30 + 2, ((0.0f - fontMetrics.ascent) + f2) - f3, paint);
    }

    public void a(String str) {
        this.k = str;
        b();
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1004);
        return super.toBundle(str, bundle);
    }

    private void a() {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f9357e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int height = com.baidu.pano.platform.b.a.f9310a.getHeight();
        int width = com.baidu.pano.platform.b.a.f9310a.getWidth() + ((int) paint.measureText("进入")) + this.f9358f + this.f9359g + 15;
        if (height <= ceil) {
            height = ceil;
        }
        int i2 = height + this.f9360h + this.f9361i;
        this.j = i2;
        Bitmap createBitmap = Bitmap.createBitmap(width, i2, Bitmap.Config.ARGB_8888);
        this.f9355c = createBitmap;
        canvas.setBitmap(createBitmap);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-13400577);
        RectF rectF = new RectF(0.0f, 0.0f, width, this.j);
        Rect rect = new Rect(20, 0, width, this.j);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
        canvas.drawRect(rect, paint);
        Bitmap bitmap = com.baidu.pano.platform.b.a.f9310a;
        canvas.drawBitmap(bitmap, this.f9358f, (this.j / 2) - (bitmap.getHeight() / 2), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        canvas.drawText("进入", this.f9358f + com.baidu.pano.platform.b.a.f9310a.getWidth() + 15, ((0.0f - fontMetrics.ascent) + (this.j / 2)) - (ceil / 2), paint);
    }
}
