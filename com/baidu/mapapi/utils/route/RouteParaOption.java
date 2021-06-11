package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7475a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7476b;

    /* renamed from: c  reason: collision with root package name */
    public String f7477c;

    /* renamed from: d  reason: collision with root package name */
    public String f7478d;

    /* renamed from: e  reason: collision with root package name */
    public String f7479e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7480f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7480f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7479e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7478d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7476b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7480f;
    }

    public String getCityName() {
        return this.f7479e;
    }

    public String getEndName() {
        return this.f7478d;
    }

    public LatLng getEndPoint() {
        return this.f7476b;
    }

    public String getStartName() {
        return this.f7477c;
    }

    public LatLng getStartPoint() {
        return this.f7475a;
    }

    public RouteParaOption startName(String str) {
        this.f7477c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7475a = latLng;
        return this;
    }
}
