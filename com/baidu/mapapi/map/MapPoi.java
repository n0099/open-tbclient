package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class MapPoi {
    private static final String d = MapPoi.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2028a;
    LatLng b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.f2028a = jSONObject.optString("tx");
        if (this.f2028a != null && !this.f2028a.equals("")) {
            this.f2028a = this.f2028a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f2028a;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public String getUid() {
        return this.c;
    }
}
