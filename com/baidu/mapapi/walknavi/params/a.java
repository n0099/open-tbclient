package com.baidu.mapapi.walknavi.params;

import android.text.TextUtils;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    protected String f3110b;
    protected LatLng c;

    /* renamed from: a  reason: collision with root package name */
    protected RouteNodeType f3109a = RouteNodeType.LOCATION;
    protected int d = -1;
    protected String e = "";
    protected String f = "";

    public abstract void setBuildingID(String str);

    public abstract void setFloorID(String str);

    public abstract void setKeyword(String str);

    public abstract void setLocation(LatLng latLng);

    public abstract void setType(RouteNodeType routeNodeType);

    public String getBuildingID() {
        return this.f;
    }

    public RouteNodeType getType() {
        return this.f3109a;
    }

    public String getKeyword() {
        return this.f3110b;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public String getFloorID() {
        return this.e;
    }

    public int getCitycode() {
        return this.d;
    }

    public void setCitycode(int i) {
        this.d = i;
    }

    public String toQuery() {
        com.baidu.platform.comapi.wnplatform.e.a.a aVar = new com.baidu.platform.comapi.wnplatform.e.a.a();
        aVar.a();
        aVar.a("type").a(this.f3109a.getNativeType());
        aVar.a("uid").b("");
        if (this.f3110b != null) {
            aVar.a("keyword").b(this.f3110b);
        } else {
            aVar.a("keyword").b("");
        }
        aVar.a("keyword2").b("");
        if (this.c != null) {
            if (this.c.longitude != 0.0d && this.c.latitude != 0.0d) {
                GeoPoint ll2mc = CoordUtil.ll2mc(this.c);
                aVar.a("xy").b(String.format("%d,%d", Integer.valueOf((int) ll2mc.getLongitudeE6()), Integer.valueOf((int) ll2mc.getLatitudeE6())));
            } else {
                aVar.a("xy").b("");
            }
        } else {
            aVar.a("xy").b("");
        }
        if (!TextUtils.isEmpty(this.e)) {
            aVar.a("floor").b(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            aVar.a("building").b(this.f);
        }
        aVar.b();
        return aVar.toString();
    }
}
