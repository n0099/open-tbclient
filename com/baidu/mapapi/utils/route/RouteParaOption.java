package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7448a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7449b;

    /* renamed from: c  reason: collision with root package name */
    public String f7450c;

    /* renamed from: d  reason: collision with root package name */
    public String f7451d;

    /* renamed from: e  reason: collision with root package name */
    public String f7452e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7453f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7453f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7452e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7451d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7449b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7453f;
    }

    public String getCityName() {
        return this.f7452e;
    }

    public String getEndName() {
        return this.f7451d;
    }

    public LatLng getEndPoint() {
        return this.f7449b;
    }

    public String getStartName() {
        return this.f7450c;
    }

    public LatLng getStartPoint() {
        return this.f7448a;
    }

    public RouteParaOption startName(String str) {
        this.f7450c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7448a = latLng;
        return this;
    }
}
