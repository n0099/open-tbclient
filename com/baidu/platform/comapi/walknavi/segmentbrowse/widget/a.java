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
/* loaded from: classes6.dex */
public class a extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private Context f4365a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f4366b;
    private int c;
    private int d;

    public a(Context context, String str, int i) {
        super(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.f4365a = context;
        this.f4366b = arrayList;
        this.c = -1;
        this.d = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.d.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.f4365a, 22.0f));
        if (this.d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), this.d);
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new RectF(b.a(this.f4365a, 27.0f), b.a(this.f4365a, 21.0f), b.a(this.f4365a, 80.0f), b.a(this.f4365a, 74.0f)), (Paint) null);
            } catch (Exception e) {
            }
        }
        if (this.f4366b != null) {
            if (this.f4366b.size() == 1) {
                canvas.drawText(this.f4366b.get(0), b.a(this.f4365a, 100.0f), b.a(this.f4365a, 51.0f), paint);
            } else if (this.f4366b.size() == 2) {
                int a2 = b.a(this.f4365a, 40.0f);
                float a3 = b.a(this.f4365a, 100.0f);
                canvas.drawText(this.f4366b.get(0), a3, a2, paint);
                paint.setTextSize(b.a(this.f4365a, 18.0f));
                canvas.drawText(this.f4366b.get(1), a3, a2 + b.a(this.f4365a, 30.0f), paint);
            }
        }
    }
}
