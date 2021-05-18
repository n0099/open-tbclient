package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MapPoi {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6990d = "MapPoi";

    /* renamed from: a  reason: collision with root package name */
    public String f6991a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6992b;

    /* renamed from: c  reason: collision with root package name */
    public String f6993c;

    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f6991a = optString;
        if (optString != null && !optString.equals("")) {
            this.f6991a = this.f6991a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f6992b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f6993c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f6991a;
    }

    public LatLng getPosition() {
        return this.f6992b;
    }

    public String getUid() {
        return this.f6993c;
    }
}
