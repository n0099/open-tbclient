package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7715a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7716b;

    /* renamed from: c  reason: collision with root package name */
    public String f7717c;

    /* renamed from: d  reason: collision with root package name */
    public String f7718d;

    /* renamed from: e  reason: collision with root package name */
    public String f7719e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7720f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7720f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7719e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7718d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7716b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7720f;
    }

    public String getCityName() {
        return this.f7719e;
    }

    public String getEndName() {
        return this.f7718d;
    }

    public LatLng getEndPoint() {
        return this.f7716b;
    }

    public String getStartName() {
        return this.f7717c;
    }

    public LatLng getStartPoint() {
        return this.f7715a;
    }

    public RouteParaOption startName(String str) {
        this.f7717c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7715a = latLng;
        return this;
    }
}
