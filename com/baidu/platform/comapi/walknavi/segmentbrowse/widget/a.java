package com.baidu.platform.comapi.walknavi.segmentbrowse.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.TextView;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public Context f10095a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f10096b;

    /* renamed from: c  reason: collision with root package name */
    public int f10097c;

    /* renamed from: d  reason: collision with root package name */
    public int f10098d;

    public a(Context context, String str, int i2) {
        super(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.f10095a = context;
        this.f10096b = arrayList;
        this.f10097c = -1;
        this.f10098d = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.d.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.f10097c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.f10095a, 22.0f));
        if (this.f10098d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), this.f10098d);
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new RectF(b.a(this.f10095a, 27.0f), b.a(this.f10095a, 21.0f), b.a(this.f10095a, 80.0f), b.a(this.f10095a, 74.0f)), (Paint) null);
            } catch (Exception unused) {
            }
        }
        ArrayList<String> arrayList = this.f10096b;
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                canvas.drawText(this.f10096b.get(0), b.a(this.f10095a, 100.0f), b.a(this.f10095a, 51.0f), paint);
            } else if (this.f10096b.size() == 2) {
                int a2 = b.a(this.f10095a, 40.0f);
                float a3 = b.a(this.f10095a, 100.0f);
                canvas.drawText(this.f10096b.get(0), a3, a2, paint);
                paint.setTextSize(b.a(this.f10095a, 18.0f));
                canvas.drawText(this.f10096b.get(1), a3, a2 + b.a(this.f10095a, 30.0f), paint);
            }
        }
    }
}
