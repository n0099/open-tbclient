package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MapPoi {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6932d = "MapPoi";

    /* renamed from: a  reason: collision with root package name */
    public String f6933a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6934b;

    /* renamed from: c  reason: collision with root package name */
    public String f6935c;

    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f6933a = optString;
        if (optString != null && !optString.equals("")) {
            this.f6933a = this.f6933a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f6934b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f6935c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f6933a;
    }

    public LatLng getPosition() {
        return this.f6934b;
    }

    public String getUid() {
        return this.f6935c;
    }
}
