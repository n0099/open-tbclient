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
    public String f9463a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9464b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f9465c;

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f9466d;

    /* renamed from: e  reason: collision with root package name */
    public int f9467e;

    /* renamed from: f  reason: collision with root package name */
    public int f9468f;

    /* renamed from: g  reason: collision with root package name */
    public int f9469g;

    /* renamed from: h  reason: collision with root package name */
    public int f9470h;
    public int i;
    public int j;
    public String k;

    public b(Context context, boolean z, String str) {
        this.f9467e = h.a(12.0f, context);
        this.f9468f = h.a(5, context);
        this.f9469g = h.a(5, context);
        this.f9470h = h.a(8, context);
        this.i = h.a(8, context);
        this.f9464b = z;
        this.f9463a = str;
        if (z) {
            a();
        }
    }

    private void b() {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        paint.setTextSize(this.f9467e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int measureText = (int) paint.measureText(this.f9463a);
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int measureText2 = this.f9468f + measureText + this.f9469g + 30 + 2 + ((int) paint.measureText(this.k));
        int i = this.f9470h + ceil + this.i;
        int i2 = this.j;
        if (i2 > i) {
            i = i2;
        }
        Bitmap createBitmap = Bitmap.createBitmap(measureText2, i, Bitmap.Config.ARGB_8888);
        this.f9466d = createBitmap;
        canvas.setBitmap(createBitmap);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-11642518);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, measureText2, i), 10.0f, 10.0f, paint);
        if (this.f9464b) {
            canvas.drawRect(new Rect(0, 0, measureText2 - 20, i), paint);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        int i3 = this.f9468f;
        canvas.drawRect(new Rect(measureText + i3 + 15, this.f9470h, i3 + measureText + 15 + 2, i - this.i), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        float f2 = i / 2;
        float f3 = ceil / 2;
        canvas.drawText(this.f9463a, this.f9468f + 0, ((0.0f - fontMetrics.ascent) + f2) - f3, paint);
        paint.setColor(-13400577);
        canvas.drawText(this.k, measureText + this.f9468f + 30 + 2, ((0.0f - fontMetrics.ascent) + f2) - f3, paint);
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
        paint.setTextSize(this.f9467e);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int ceil = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
        int height = com.baidu.pano.platform.b.a.f9421a.getHeight();
        int width = com.baidu.pano.platform.b.a.f9421a.getWidth() + ((int) paint.measureText("进入")) + this.f9468f + this.f9469g + 15;
        if (height <= ceil) {
            height = ceil;
        }
        int i = height + this.f9470h + this.i;
        this.j = i;
        Bitmap createBitmap = Bitmap.createBitmap(width, i, Bitmap.Config.ARGB_8888);
        this.f9465c = createBitmap;
        canvas.setBitmap(createBitmap);
        canvas.drawColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-13400577);
        RectF rectF = new RectF(0.0f, 0.0f, width, this.j);
        Rect rect = new Rect(20, 0, width, this.j);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
        canvas.drawRect(rect, paint);
        Bitmap bitmap = com.baidu.pano.platform.b.a.f9421a;
        canvas.drawBitmap(bitmap, this.f9468f, (this.j / 2) - (bitmap.getHeight() / 2), paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(PullViewHelper.PULLVIEW_BGCOLOR_DAY_DEFAULT);
        canvas.drawText("进入", this.f9468f + com.baidu.pano.platform.b.a.f9421a.getWidth() + 15, ((0.0f - fontMetrics.ascent) + (this.j / 2)) - (ceil / 2), paint);
    }
}
