package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7532a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7533b;

    /* renamed from: c  reason: collision with root package name */
    public String f7534c;

    /* renamed from: d  reason: collision with root package name */
    public String f7535d;

    /* renamed from: e  reason: collision with root package name */
    public String f7536e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7537f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7537f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7536e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7535d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7533b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7537f;
    }

    public String getCityName() {
        return this.f7536e;
    }

    public String getEndName() {
        return this.f7535d;
    }

    public LatLng getEndPoint() {
        return this.f7533b;
    }

    public String getStartName() {
        return this.f7534c;
    }

    public LatLng getStartPoint() {
        return this.f7532a;
    }

    public RouteParaOption startName(String str) {
        this.f7534c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7532a = latLng;
        return this;
    }
}
