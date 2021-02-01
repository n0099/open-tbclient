package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class MapPoi {
    private static final String d = MapPoi.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    String f2728a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f2729b;
    String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        this.f2728a = jSONObject.optString("tx");
        if (this.f2728a != null && !this.f2728a.equals("")) {
            this.f2728a = this.f2728a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f2729b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.f2728a;
    }

    public LatLng getPosition() {
        return this.f2729b;
    }

    public String getUid() {
        return this.c;
    }
}
