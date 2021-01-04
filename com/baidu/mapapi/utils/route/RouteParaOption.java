package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes15.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    LatLng f3077a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f3078b;
    String c;
    String d;
    String e;
    EBusStrategyType f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes15.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
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
        this.f3078b = latLng;
        return this;
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
        return this.f3078b;
    }

    public String getStartName() {
        return this.c;
    }

    public LatLng getStartPoint() {
        return this.f3077a;
    }

    public RouteParaOption startName(String str) {
        this.c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f3077a = latLng;
        return this;
    }
}
