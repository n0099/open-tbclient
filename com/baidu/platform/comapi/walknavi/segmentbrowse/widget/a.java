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
    public Context f9735a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f9736b;

    /* renamed from: c  reason: collision with root package name */
    public int f9737c;

    /* renamed from: d  reason: collision with root package name */
    public int f9738d;

    public a(Context context, String str, int i) {
        super(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.f9735a = context;
        this.f9736b = arrayList;
        this.f9737c = -1;
        this.f9738d = i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.d.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.f9737c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.f9735a, 22.0f));
        if (this.f9738d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), this.f9738d);
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new RectF(b.a(this.f9735a, 27.0f), b.a(this.f9735a, 21.0f), b.a(this.f9735a, 80.0f), b.a(this.f9735a, 74.0f)), (Paint) null);
            } catch (Exception unused) {
            }
        }
        ArrayList<String> arrayList = this.f9736b;
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                canvas.drawText(this.f9736b.get(0), b.a(this.f9735a, 100.0f), b.a(this.f9735a, 51.0f), paint);
            } else if (this.f9736b.size() == 2) {
                int a2 = b.a(this.f9735a, 40.0f);
                float a3 = b.a(this.f9735a, 100.0f);
                canvas.drawText(this.f9736b.get(0), a3, a2, paint);
                paint.setTextSize(b.a(this.f9735a, 18.0f));
                canvas.drawText(this.f9736b.get(1), a3, a2 + b.a(this.f9735a, 30.0f), paint);
            }
        }
    }
}
