package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes3.dex */
public class RouteParaOption {
    public LatLng a;
    public LatLng b;
    public String c;
    public String d;
    public String e;
    public EBusStrategyType f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes3.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f;
    }

    public String getCityName() {
        return this.e;
    }

    public String getEndName() {
        return this.d;
    }

    public LatLng getEndPoint() {
        return this.b;
    }

    public String getStartName() {
        return this.c;
    }

    public LatLng getStartPoint() {
        return this.a;
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public RouteParaOption startName(String str) {
        this.c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.a = latLng;
        return this;
    }
}
