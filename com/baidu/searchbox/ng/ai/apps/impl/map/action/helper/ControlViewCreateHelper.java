package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.widget.ImageView;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.event.MapEventListener;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.ControlViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.ControlModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils;
/* loaded from: classes4.dex */
public class ControlViewCreateHelper {
    public static void createControl(MapViewItem mapViewItem, ControlModel controlModel, MapEventListener mapEventListener) {
        AiAppsLog.i("map", "createControl start");
        if (controlModel != null && controlModel.isValid()) {
            Bitmap bitmapFromPath = MapUtils.getBitmapFromPath(controlModel.iconPath, false);
            if (bitmapFromPath == null) {
                AiAppsLog.w("map", " icon is null ");
            }
            if (bitmapFromPath != null) {
                int width = controlModel.position.width == -1 ? bitmapFromPath.getWidth() : controlModel.position.width;
                int height = controlModel.position.height == -1 ? bitmapFromPath.getHeight() : controlModel.position.height;
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.absoluteMode);
                builder.width(width);
                builder.height(height);
                builder.align(1, 8);
                builder.point(new Point(controlModel.position.left, controlModel.position.top));
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setImageBitmap(bitmapFromPath);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setClickable(controlModel.isClickable);
                mapViewItem.mapView.addView(imageView, builder.build());
                imageView.setOnClickListener(mapEventListener);
                ControlViewItem controlViewItem = new ControlViewItem();
                controlViewItem.controlModel = controlModel;
                controlViewItem.control = imageView;
                mapViewItem.controls.add(controlViewItem);
            }
        }
        AiAppsLog.i("map", "createControl end");
    }
}
