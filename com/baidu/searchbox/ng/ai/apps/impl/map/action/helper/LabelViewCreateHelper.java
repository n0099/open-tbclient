package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

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
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
/* loaded from: classes4.dex */
public class LabelViewCreateHelper {
    public static View createLabel(MapViewItem mapViewItem, MarkerViewItem markerViewItem) {
        AiAppsLog.i("map", "createLabel start");
        if (markerViewItem == null) {
            return null;
        }
        MarkerModel markerModel = markerViewItem.markerModel;
        if (markerModel == null || markerModel.label == null || markerModel.coordinate == null) {
            AiAppsLog.e("map", "marker data error");
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(markerModel.label.color);
        paint.setTextSize(markerModel.label.fontSize);
        float f = markerModel.label.padding;
        float f2 = markerModel.label.borderRadius;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(markerModel.label.bgColor);
        String str = markerModel.label.content;
        float measureText = paint.measureText(str) + (2.0f * f);
        float f3 = (paint.getFontMetrics().bottom - paint.getFontMetrics().top) + (2.0f * f);
        if (f3 <= 0.0f || measureText <= 0.0f) {
            AiAppsLog.e("map", "label heigth or width is 0");
            return null;
        }
        float f4 = markerModel.label.borderWidth;
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
            paint2.setColor(markerModel.label.borderColor);
            paint2.setStrokeWidth(f4);
            canvas.drawRoundRect(rectF, f2, f2, paint2);
        }
        canvas.drawText(str, (f4 / 2.0f) + f, f + (-paint.getFontMetrics().top) + (f4 / 2.0f), paint);
        ImageView imageView = new ImageView(AppRuntime.getAppContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
        imageView.setPadding((int) markerModel.label.x, (int) markerModel.label.y, 0, 0);
        imageView.setImageBitmap(createBitmap);
        markerViewItem.label = (Marker) mapViewItem.mapView.getMap().addOverlay(new MarkerOptions().position(new LatLng(markerModel.coordinate.latitude, markerModel.coordinate.longitude)).icon(BitmapDescriptorFactory.fromView(imageView)).anchor(0.0f, 0.0f).zIndex(66));
        AiAppsLog.i("map", "createLabel end");
        return imageView;
    }
}
