package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MapPoi {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6933d = "MapPoi";

    /* renamed from: a  reason: collision with root package name */
    public String f6934a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6935b;

    /* renamed from: c  reason: collision with root package name */
    public String f6936c;

    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f6934a = optString;
        if (optString != null && !optString.equals("")) {
            this.f6934a = this.f6934a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f6935b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f6936c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f6934a;
    }

    public LatLng getPosition() {
        return this.f6935b;
    }

    public String getUid() {
        return this.f6936c;
    }
}
