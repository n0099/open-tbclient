package com.baidu.searchbox.ng.ai.apps.impl.map.event;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.GetRegionAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.ControlViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MapViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.item.MarkerViewItem;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.ControlModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MapEventHelper {
    private static String MARKER_TAP = "markertap";
    private static String CALLOUT_TAP = "callouttap";
    private static String CONTROL_TAP = "controltap";
    private static String REGION_CHANGE = "regionchange";
    private static String MAP_TAP = AiAppsTouchHelper.TouchEventName.TOUCH_TAP;
    private static String MAP_UPDATED = "updated";
    private static String MAP_ID = "mapId";

    public static void markerTap(Marker marker, MapViewItem mapViewItem) {
        MarkerViewItem markerViewItem = mapViewItem.getMarkerViewItem(marker);
        String str = "";
        if (markerViewItem != null && markerViewItem.markerModel != null) {
            str = markerViewItem.markerModel.id;
        }
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", MARKER_TAP).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).put(MarkerModel.ID, str).makeParams().toString()).build().sendMessage();
    }

    public static void calloutTap(MapViewItem mapViewItem, MarkerModel markerModel) {
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", CALLOUT_TAP).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).put(MarkerModel.ID, markerModel.id).makeParams().toString()).build().sendMessage();
    }

    public static void ControlTap(View view, MapViewItem mapViewItem) {
        ControlViewItem controlViewItem = mapViewItem.getControlViewItem(view);
        String str = "";
        if (controlViewItem != null && controlViewItem.controlModel != null) {
            str = controlViewItem.controlModel.id;
        }
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", CONTROL_TAP).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).put(ControlModel.ID, str).makeParams().toString()).build().sendMessage();
    }

    public static void regionChanged(MapViewItem mapViewItem, MapStatus mapStatus) {
        JSONObject makeParams = ParamMaker.getMaker().put(CoordinateModel.LATITUDE, Double.valueOf(mapStatus.bound.northeast.latitude)).put(CoordinateModel.LONGITUDE, Double.valueOf(mapStatus.bound.northeast.longitude)).makeParams();
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", REGION_CHANGE).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).put(GetRegionAction.NORTH_EAST, makeParams).put(GetRegionAction.SOURCE_WEST, ParamMaker.getMaker().put(CoordinateModel.LATITUDE, Double.valueOf(mapStatus.bound.southwest.latitude)).put(CoordinateModel.LONGITUDE, Double.valueOf(mapStatus.bound.southwest.longitude)).makeParams()).makeParams().toString()).build().sendMessage();
    }

    public static void mapTap(MapViewItem mapViewItem, LatLng latLng) {
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", MAP_TAP).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).put("position", ParamMaker.getMaker().put(CoordinateModel.LATITUDE, Double.valueOf(latLng.latitude)).put(CoordinateModel.LONGITUDE, Double.valueOf(latLng.longitude)).makeParams()).makeParams().toString()).build().sendMessage();
    }

    public static void mapUpdate(MapViewItem mapViewItem) {
        MapMessage.getBuilder().put("wvID", mapViewItem.webViewId).put("vtype", MAP_UPDATED).put("data", ParamMaker.getMaker().put(MAP_ID, mapViewItem.id).makeParams().toString()).build().sendMessage();
    }

    /* loaded from: classes4.dex */
    private static class ParamMaker {
        private JSONObject params = new JSONObject();

        static ParamMaker getMaker() {
            return new ParamMaker();
        }

        ParamMaker put(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.params.put(str, obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this;
        }

        JSONObject makeParams() {
            return this.params;
        }

        ParamMaker() {
        }
    }
}
