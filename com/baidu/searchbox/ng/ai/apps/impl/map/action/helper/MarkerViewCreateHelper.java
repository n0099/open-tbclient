package com.baidu.searchbox.ng.ai.apps.impl.map.action.helper;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.utils.MapUtils;
/* loaded from: classes4.dex */
public class MarkerViewCreateHelper {
    public static void createMarker(MapViewItem mapViewItem, MarkerModel markerModel) {
        Bitmap bitmapFromPath;
        if (mapViewItem != null && markerModel.isValid() && (bitmapFromPath = MapUtils.getBitmapFromPath(markerModel.iconPath, true)) != null) {
            MarkerViewItem markerViewItem = new MarkerViewItem();
            int width = markerModel.width == -1 ? bitmapFromPath.getWidth() : markerModel.width;
            int height = markerModel.height == -1 ? bitmapFromPath.getHeight() : markerModel.height;
            if (width > 0 && height > 0) {
                ImageView imageView = new ImageView(AppRuntime.getAppContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                imageView.setImageBitmap(MapUtils.reSizeBitmap(bitmapFromPath, width, height));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                if (markerModel.anchor == null) {
                    markerModel.anchor = new MarkerModel.Anchor();
                }
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(imageView);
                if (fromView != null) {
                    Bitmap bitmap = fromView.getBitmap();
                    LatLng latLng = new LatLng(markerModel.coordinate.latitude, markerModel.coordinate.longitude);
                    markerViewItem.marker = (Marker) mapViewItem.mapView.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView).alpha((float) markerModel.alpha).title(markerModel.title).rotate((float) markerModel.rotate).zIndex(88).anchor((float) markerModel.anchor.x, (float) markerModel.anchor.y));
                    markerViewItem.markerModel = markerModel;
                    LinearLayout linearLayout = new LinearLayout(AppRuntime.getAppContext());
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    linearLayout.setGravity(17);
                    View view = new View(AppRuntime.getAppContext());
                    view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
                    view.setVisibility(4);
                    linearLayout.addView(view);
                    markerViewItem.container = linearLayout;
                    if (MarkerViewItem.SHOW_CALLOUT_LABEL.booleanValue()) {
                        if (markerModel.callout != null && markerModel.callout.isValid() && TextUtils.equals(markerModel.callout.display, MarkerModel.Callout.ALWAYS)) {
                            View creatCallout = CalloutViewCreateHelper.creatCallout(mapViewItem, markerModel);
                            linearLayout.addView(creatCallout, 0);
                            markerViewItem.callout = creatCallout;
                        }
                        if (markerModel.label != null && markerModel.label.isValid()) {
                            LabelViewCreateHelper.createLabel(mapViewItem, markerViewItem);
                        }
                    }
                    linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                    builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                    builder.position(latLng);
                    builder.yOffset((int) ((bitmap.getHeight() * (1.0d - markerModel.anchor.y)) + 0.0d));
                    mapViewItem.mapView.addView(linearLayout, builder.build());
                    linearLayout.setAlpha(0.0f);
                    BitmapDescriptor fromView2 = BitmapDescriptorFactory.fromView(linearLayout);
                    if (fromView2 != null) {
                        Bitmap bitmap2 = fromView2.getBitmap();
                        markerViewItem.entity = (Marker) mapViewItem.mapView.getMap().addOverlay(new MarkerOptions().position(latLng).icon(fromView2).anchor(((float) (((bitmap2.getWidth() - bitmap.getWidth()) / 2.0f) + (markerModel.anchor.x * bitmap.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - bitmap.getHeight())) + (markerModel.anchor.y * bitmap.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                        mapViewItem.markers.add(markerViewItem);
                    }
                }
            }
        }
    }
}
