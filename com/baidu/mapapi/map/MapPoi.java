package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MapPoi {

    /* renamed from: d  reason: collision with root package name */
    public static final String f6897d = "MapPoi";

    /* renamed from: a  reason: collision with root package name */
    public String f6898a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f6899b;

    /* renamed from: c  reason: collision with root package name */
    public String f6900c;

    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f6898a = optString;
        if (optString != null && !optString.equals("")) {
            this.f6898a = this.f6898a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f6899b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f6900c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f6898a;
    }

    public LatLng getPosition() {
        return this.f6899b;
    }

    public String getUid() {
        return this.f6900c;
    }
}
