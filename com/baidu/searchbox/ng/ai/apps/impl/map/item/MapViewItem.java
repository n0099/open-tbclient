package com.baidu.searchbox.ng.ai.apps.impl.map.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.MapModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class MapViewItem {
    public Context context;
    public String id;
    public boolean isShowLocation;
    public TextureMapView mapView;
    public String parentId;
    public String webViewId;
    public List<MarkerViewItem> markers = new ArrayList();
    public List<ControlViewItem> controls = new ArrayList();

    private MapViewItem() {
    }

    public static MapViewItem makeOne(Context context, MapModel mapModel) {
        if (context == null || mapModel == null || !mapModel.isValid()) {
            return null;
        }
        MapViewItem mapViewItem = new MapViewItem();
        mapViewItem.webViewId = mapModel.slaveId;
        mapViewItem.id = mapModel.id;
        mapViewItem.parentId = mapModel.parentId;
        mapViewItem.context = context;
        mapViewItem.mapView = new TextureMapView(context);
        return mapViewItem;
    }

    public MarkerViewItem getMarkerViewItem(Marker marker) {
        for (MarkerViewItem markerViewItem : this.markers) {
            if (marker == markerViewItem.marker) {
                return markerViewItem;
            }
        }
        return null;
    }

    public List<MarkerViewItem> getMarkerViewItem(String str) {
        ArrayList arrayList = new ArrayList(1);
        for (MarkerViewItem markerViewItem : this.markers) {
            if (markerViewItem.markerModel != null && TextUtils.equals(str, markerViewItem.markerModel.id)) {
                arrayList.add(markerViewItem);
            }
        }
        return arrayList;
    }

    public ControlViewItem getControlViewItem(View view) {
        for (ControlViewItem controlViewItem : this.controls) {
            if (controlViewItem.control == view) {
                return controlViewItem;
            }
        }
        return null;
    }

    public void clear() {
        for (MarkerViewItem markerViewItem : this.markers) {
            this.mapView.removeView(markerViewItem.container);
        }
        this.markers.clear();
        for (ControlViewItem controlViewItem : this.controls) {
            this.mapView.removeView(controlViewItem.control);
        }
        this.controls.clear();
        this.mapView.getMap().clear();
    }
}
