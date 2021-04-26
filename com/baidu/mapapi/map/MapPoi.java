package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class MapPoi {

    /* renamed from: d  reason: collision with root package name */
    public static final String f7174d = "MapPoi";

    /* renamed from: a  reason: collision with root package name */
    public String f7175a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7176b;

    /* renamed from: c  reason: collision with root package name */
    public String f7177c;

    public void a(JSONObject jSONObject) {
        String optString = jSONObject.optString("tx");
        this.f7175a = optString;
        if (optString != null && !optString.equals("")) {
            this.f7175a = this.f7175a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f7176b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.f7177c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f7175a;
    }

    public LatLng getPosition() {
        return this.f7176b;
    }

    public String getUid() {
        return this.f7177c;
    }
}
