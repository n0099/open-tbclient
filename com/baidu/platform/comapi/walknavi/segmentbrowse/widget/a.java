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
/* loaded from: classes4.dex */
public class a extends TextView {
    private Context a;
    private ArrayList<String> b;
    private int c;
    private int d;

    public a(Context context, String str, int i) {
        super(context);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        this.a = context;
        this.b = arrayList;
        this.c = -1;
        this.d = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        com.baidu.platform.comapi.wnplatform.c.a.a("AutoTextView.onDraw", " canvas" + canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.c == -1) {
            paint.setColor(-13400577);
        } else {
            paint.setColor(-13400577);
        }
        paint.setTextSize(b.a(this.a, 22.0f));
        if (this.d != -1) {
            Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.a(), this.d);
            try {
                canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new RectF(b.a(this.a, 27.0f), b.a(this.a, 21.0f), b.a(this.a, 80.0f), b.a(this.a, 74.0f)), (Paint) null);
            } catch (Exception e) {
            }
        }
        if (this.b != null) {
            if (this.b.size() == 1) {
                canvas.drawText(this.b.get(0), b.a(this.a, 100.0f), b.a(this.a, 51.0f), paint);
            } else if (this.b.size() == 2) {
                int a = b.a(this.a, 40.0f);
                float a2 = b.a(this.a, 100.0f);
                canvas.drawText(this.b.get(0), a2, a, paint);
                paint.setTextSize(b.a(this.a, 18.0f));
                canvas.drawText(this.b.get(1), a2, a + b.a(this.a, 30.0f), paint);
            }
        }
    }
}
