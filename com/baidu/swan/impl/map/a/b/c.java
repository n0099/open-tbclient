package com.baidu.swan.impl.map.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes5.dex */
public class c {
    public static View a(com.baidu.swan.impl.map.item.b bVar, com.baidu.swan.impl.map.item.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "createLabel start");
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.x.a.a.d dVar = cVar.bGz;
        if (dVar == null || dVar.aUm == null || dVar.aTL == null) {
            com.baidu.swan.apps.console.c.e("map", "marker data error");
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(dVar.aUm.color);
        paint.setTextSize(dVar.aUm.KP);
        float f = dVar.aUm.aUp;
        float f2 = dVar.aUm.KJ;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(dVar.aUm.bgColor);
        String str = dVar.aUm.content;
        float measureText = paint.measureText(str) + (2.0f * f);
        float f3 = (paint.getFontMetrics().bottom - paint.getFontMetrics().top) + (2.0f * f);
        if (f3 <= 0.0f || measureText <= 0.0f) {
            com.baidu.swan.apps.console.c.e("map", "label heigth or width is 0");
            return null;
        }
        float f4 = dVar.aUm.aUo;
        Bitmap createBitmap = Bitmap.createBitmap((int) (measureText + f4 + 0.5d), (int) (f3 + f4 + 0.5d), Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(Color.argb(0, 0, 0, 0));
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        RectF rectF = new RectF();
        rectF.left = f4 / 2.0f;
        rectF.top = f4 / 2.0f;
        rectF.bottom = f3 + (f4 / 2.0f);
        rectF.right = measureText + (f4 / 2.0f);
        canvas.drawRoundRect(rectF, f2, f2, paint2);
        if (f4 > 0.0f) {
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(dVar.aUm.borderColor);
            paint2.setStrokeWidth(f4);
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        canvas.drawText(str, (f4 / 2.0f) + f, f + (-paint.getFontMetrics().top) + (f4 / 2.0f), paint);
        ImageView imageView = new ImageView(AppRuntime.getAppContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
        imageView.setPadding((int) dVar.aUm.x, (int) dVar.aUm.y, 0, 0);
        imageView.setImageBitmap(createBitmap);
        cVar.bGB = (Marker) bVar.bGy.getMap().addOverlay(new MarkerOptions().position(new LatLng(dVar.aTL.latitude, dVar.aTL.longitude)).icon(BitmapDescriptorFactory.fromView(imageView)).anchor(0.0f, 0.0f).zIndex(66));
        com.baidu.swan.apps.console.c.i("map", "createLabel end");
        return imageView;
    }
}
