package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7412a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7413b;

    /* renamed from: c  reason: collision with root package name */
    public String f7414c;

    /* renamed from: d  reason: collision with root package name */
    public String f7415d;

    /* renamed from: e  reason: collision with root package name */
    public String f7416e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7417f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7417f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7416e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7415d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7413b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7417f;
    }

    public String getCityName() {
        return this.f7416e;
    }

    public String getEndName() {
        return this.f7415d;
    }

    public LatLng getEndPoint() {
        return this.f7413b;
    }

    public String getStartName() {
        return this.f7414c;
    }

    public LatLng getStartPoint() {
        return this.f7412a;
    }

    public RouteParaOption startName(String str) {
        this.f7414c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7412a = latLng;
        return this;
    }
}
