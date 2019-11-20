package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.z;
/* loaded from: classes5.dex */
public class a {
    public static View a(final com.baidu.swan.impl.map.item.b bVar, final com.baidu.swan.apps.x.a.a.d dVar) {
        com.baidu.swan.apps.console.c.i("map", "creatCallout start");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(dVar.aUl.color);
        paint.setTextSize(dVar.aUl.KP);
        float f = dVar.aUl.aUp;
        float f2 = dVar.aUl.KJ;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(dVar.aUl.bgColor);
        String str = dVar.aUl.content;
        int S = z.S(6.0f);
        float measureText = paint.measureText(str) + (2.0f * f);
        float f3 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
        float f4 = S + f3 + (2.0f * f);
        if (f4 <= 0.0f || measureText <= 0.0f) {
            com.baidu.swan.apps.console.c.w("map", "callout height or wodth is 0");
            return new ImageView(AppRuntime.getAppContext());
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) measureText, (int) f4, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = (2.0f * f) + f3;
        rectF.right = measureText;
        canvas.drawRoundRect(rectF, f2, f2, paint2);
        Path path = new Path();
        path.moveTo((measureText / 2.0f) - (S / 2), (2.0f * f) + f3);
        path.lineTo(measureText / 2.0f, f4);
        path.lineTo((S / 2) + (measureText / 2.0f), (2.0f * f) + f3);
        path.close();
        canvas.drawPath(path, paint2);
        canvas.drawText(str, f, (-paint.getFontMetrics().top) + f, paint);
        ImageView imageView = new ImageView(AppRuntime.getAppContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
        imageView.setImageBitmap(createBitmap);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.impl.map.a.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.impl.map.b.a.c(com.baidu.swan.impl.map.item.b.this, dVar);
            }
        });
        com.baidu.swan.apps.console.c.i("map", "creatCallout end");
        return imageView;
    }
}
