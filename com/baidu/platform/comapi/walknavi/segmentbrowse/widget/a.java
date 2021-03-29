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
    public Context f10177a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f10178b;

    /* renamed from: c  reason: collision with root package name */
    public int f10179c;

    /* renamed from: d  reason: collision with root package name */
    public int f10180d;

    public a(Context context, String str, int i) {
        super(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.f10177a = context;
        this.f10178b = arrayList;
        this.f10179c = -1;
        this.f10180d = i;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.d.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.f10179c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.f10177a, 22.0f));
        if (this.f10180d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), this.f10180d);
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new RectF(b.a(this.f10177a, 27.0f), b.a(this.f10177a, 21.0f), b.a(this.f10177a, 80.0f), b.a(this.f10177a, 74.0f)), (Paint) null);
            } catch (Exception unused) {
            }
        }
        ArrayList<String> arrayList = this.f10178b;
        if (arrayList != null) {
            if (arrayList.size() == 1) {
                canvas.drawText(this.f10178b.get(0), b.a(this.f10177a, 100.0f), b.a(this.f10177a, 51.0f), paint);
            } else if (this.f10178b.size() == 2) {
                int a2 = b.a(this.f10177a, 40.0f);
                float a3 = b.a(this.f10177a, 100.0f);
                canvas.drawText(this.f10178b.get(0), a3, a2, paint);
                paint.setTextSize(b.a(this.f10177a, 18.0f));
                canvas.drawText(this.f10178b.get(1), a3, a2 + b.a(this.f10177a, 30.0f), paint);
            }
        }
    }
}
