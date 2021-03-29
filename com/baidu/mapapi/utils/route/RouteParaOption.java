package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7413a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7414b;

    /* renamed from: c  reason: collision with root package name */
    public String f7415c;

    /* renamed from: d  reason: collision with root package name */
    public String f7416d;

    /* renamed from: e  reason: collision with root package name */
    public String f7417e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7418f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7418f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7417e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7416d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7414b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7418f;
    }

    public String getCityName() {
        return this.f7417e;
    }

    public String getEndName() {
        return this.f7416d;
    }

    public LatLng getEndPoint() {
        return this.f7414b;
    }

    public String getStartName() {
        return this.f7415c;
    }

    public LatLng getStartPoint() {
        return this.f7413a;
    }

    public RouteParaOption startName(String str) {
        this.f7415c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7413a = latLng;
        return this;
    }
}
