package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class MapPoi {
    private static final String d = MapPoi.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2730a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f2731b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.f2730a = jSONObject.optString("tx");
        if (this.f2730a != null && !this.f2730a.equals("")) {
            this.f2730a = this.f2730a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f2731b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f2730a;
    }

    public LatLng getPosition() {
        return this.f2731b;
    }

    public String getUid() {
        return this.c;
    }
}
