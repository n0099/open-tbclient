package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class MapPoi {
    private static final String d = MapPoi.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2837a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f2838b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f2837a = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
        if (this.f2837a != null && !this.f2837a.equals("")) {
            this.f2837a = this.f2837a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f2838b = CoordUtil.decodeNodeLocation(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f2837a;
    }

    public LatLng getPosition() {
        return this.f2838b;
    }

    public String getUid() {
        return this.c;
    }
}
