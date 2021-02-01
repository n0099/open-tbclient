package com.baidu.pano.platform.comapi.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import com.baidu.pano.platform.c.h;
/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f3922a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3923b;
    public Bitmap c;
    public Bitmap d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private String k;

    public b(Context context, boolean z, String str) {
        this.e = h.a(12.0f, context);
        this.f = h.a(5, context);
        this.g = h.a(5, context);
        this.h = h.a(8, context);
        this.i = h.a(8, context);
        this.f3923b = z;
        this.f3922a = str;
        if (this.f3923b) {
            a();
        }
    }

    @Override // com.baidu.pano.platform.comapi.a.a
    public Bundle toBundle(String str, Bundle bundle) {
        bundle.putInt("markerType", 1004);
        return super.toBundle(str, bundle);
    }

    public void a(String str) {
        this.k = str;
        b();
    }

    private void a() {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(this.e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int measureText = (int) paint.measureText("进入");
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int height = com.baidu.pano.platform.b.a.f3903a.getHeight();
        int width = measureText + com.baidu.pano.platform.b.a.f3903a.getWidth() + this.f + this.g + 15;
        if (height <= ceil) {
            height = ceil;
        }
        this.j = height + this.h + this.i;
        this.c = Bitmap.createBitmap(width, this.j, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(this.c);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-13400577);
        RectF rectF = new RectF(0.0f, 0.0f, width, this.j);
        Rect rect = new Rect(20, 0, width, this.j);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
        canvas.drawRect(rect, paint);
        canvas.drawBitmap(com.baidu.pano.platform.b.a.f3903a, this.f, (this.j / 2) - (com.baidu.pano.platform.b.a.f3903a.getHeight() / 2), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1315344);
        canvas.drawText("进入", this.f + com.baidu.pano.platform.b.a.f3903a.getWidth() + 15, ((0.0f - fontMetrics.ascent) + (this.j / 2)) - (ceil / 2), paint);
    }

    private void b() {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(this.e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int measureText = (int) paint.measureText(this.f3922a);
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int measureText2 = this.f + measureText + this.g + 30 + 2 + ((int) paint.measureText(this.k));
        int i = this.h + ceil + this.i;
        if (this.j > i) {
            i = this.j;
        }
        this.d = Bitmap.createBitmap(measureText2, i, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(this.d);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-11642518);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, measureText2, i), 10.0f, 10.0f, paint);
        if (this.f3923b) {
            canvas.drawRect(new Rect(0, 0, measureText2 - 20, i), paint);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1315344);
        canvas.drawRect(new Rect(this.f + measureText + 15, this.h, this.f + measureText + 15 + 2, i - this.i), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-1315344);
        canvas.drawText(this.f3922a, this.f + 0, ((0.0f - fontMetrics.ascent) + (i / 2)) - (ceil / 2), paint);
        paint.setColor(-13400577);
        canvas.drawText(this.k, measureText + this.f + 30 + 2, ((i / 2) + (0.0f - fontMetrics.ascent)) - (ceil / 2), paint);
    }
}
