package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

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
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.event.MapEventHelper;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes4.dex */
public class CalloutViewCreateHelper {
    public static View creatCallout(final MapViewItem mapViewItem, final MarkerModel markerModel) {
        AiAppsLog.i("map", "creatCallout start");
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(markerModel.callout.color);
        paint.setTextSize(markerModel.callout.fontSize);
        float f = markerModel.callout.padding;
        float f2 = markerModel.callout.borderRadius;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setColor(markerModel.callout.bgColor);
        String str = markerModel.callout.content;
        int dp2px = AiAppsUIUtils.dp2px(6.0f);
        float measureText = paint.measureText(str) + (2.0f * f);
        float f3 = paint.getFontMetrics().bottom - paint.getFontMetrics().top;
        float f4 = dp2px + f3 + (2.0f * f);
        if (f4 <= 0.0f || measureText <= 0.0f) {
            AiAppsLog.w("map", "callout height or wodth is 0");
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
        path.moveTo((measureText / 2.0f) - (dp2px / 2), (2.0f * f) + f3);
        path.lineTo(measureText / 2.0f, f4);
        path.lineTo((dp2px / 2) + (measureText / 2.0f), (2.0f * f) + f3);
        path.close();
        canvas.drawPath(path, paint2);
        canvas.drawText(str, f, (-paint.getFontMetrics().top) + f, paint);
        ImageView imageView = new ImageView(AppRuntime.getAppContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(createBitmap.getWidth(), createBitmap.getHeight()));
        imageView.setImageBitmap(createBitmap);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.impl.map.action.helper.CalloutViewCreateHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MapEventHelper.calloutTap(MapViewItem.this, markerModel);
            }
        });
        AiAppsLog.i("map", "creatCallout end");
        return imageView;
    }
}
