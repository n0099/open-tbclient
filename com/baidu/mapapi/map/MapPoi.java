package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class MapPoi {
    private static final String d = MapPoi.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2021a;
    LatLng b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f2021a = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
        if (this.f2021a != null && !this.f2021a.equals("")) {
            this.f2021a = this.f2021a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.b = CoordUtil.decodeNodeLocation(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f2021a;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public String getUid() {
        return this.c;
    }
}
