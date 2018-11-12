package com.baidu.searchbox.ng.ai.apps.impl.map.model;

import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CircleModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.ControlModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.CoordinateModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.PolylineModel;
import com.baidu.searchbox.ng.ai.apps.model.IModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class MapModel extends AiAppsNaViewModel {
    private static final String CIRCLES = "circles";
    private static final String CONTROLS = "controls";
    private static final String COVERS = "covers";
    private static final boolean DEBUG = false;
    public static final String HIDDEN = "hide";
    private static final String INCLUDE_POINTS = "includePoints";
    private static final String MAP_ID = "mapId";
    private static final String MARKERS = "markers";
    private static final String PARENT_ID = "parentId";
    private static final String POLYLINE = "polyline";
    public static final String POSITION = "position";
    private static final String POSITION_HEIGHT = "height";
    private static final String POSITION_LEFT = "left";
    private static final String POSITION_TOP = "top";
    private static final String POSITION_WIDTH = "width";
    public static final String SCALE = "scale";
    private static final String SHOW_LOCATION = "showLocation";
    private static final String TAG = MapModel.class.getSimpleName();
    public static final String WEBVIEW_ID = "slaveId";
    public List<CircleModel> circles;
    public List<ControlModel> controls;
    public CoordinateModel coordinate;
    public List<CoordinateModel> includePoints;
    public boolean isShowLocation;
    public List<MarkerModel> markers;
    public List<PolylineModel> polyline;
    public double scale;

    public MapModel() {
        super(MAP_ID, "map");
        this.scale = 16.0d;
        this.isShowLocation = true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel, com.baidu.searchbox.ng.ai.apps.model.IModel
    public void parseFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.parseFromJson(jSONObject);
            if (jSONObject.has(CoordinateModel.LONGITUDE) && jSONObject.has(CoordinateModel.LATITUDE)) {
                this.coordinate = new CoordinateModel();
                this.coordinate.parseFromJson(jSONObject);
            }
            if (jSONObject.has("scale")) {
                this.scale = jSONObject.optDouble("scale", 16.0d);
            }
            this.isShowLocation = jSONObject.optBoolean(SHOW_LOCATION, true);
            try {
                this.markers = parseItems(jSONObject, jSONObject.has(MARKERS) ? MARKERS : COVERS, MarkerModel.class);
                this.circles = parseItems(jSONObject, CIRCLES, CircleModel.class);
                this.polyline = parseItems(jSONObject, POLYLINE, PolylineModel.class);
                this.controls = parseItems(jSONObject, CONTROLS, ControlModel.class);
                this.includePoints = parseItems(jSONObject, INCLUDE_POINTS, CoordinateModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private <T extends IModel> List<T> parseItems(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        int length = optJSONArray == null ? 0 : optJSONArray.length();
        if (length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                T newInstance = cls.newInstance();
                newInstance.parseFromJson(optJSONObject);
                if (newInstance.isValid()) {
                    arrayList.add(newInstance);
                }
            }
        }
        return arrayList;
    }
}
