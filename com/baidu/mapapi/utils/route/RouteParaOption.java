package com.baidu.mapapi.utils.route;

import com.baidu.mapapi.model.LatLng;
/* loaded from: classes2.dex */
public class RouteParaOption {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f7432a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f7433b;

    /* renamed from: c  reason: collision with root package name */
    public String f7434c;

    /* renamed from: d  reason: collision with root package name */
    public String f7435d;

    /* renamed from: e  reason: collision with root package name */
    public String f7436e;

    /* renamed from: f  reason: collision with root package name */
    public EBusStrategyType f7437f = EBusStrategyType.bus_recommend_way;

    /* loaded from: classes2.dex */
    public enum EBusStrategyType {
        bus_time_first,
        bus_transfer_little,
        bus_walk_little,
        bus_no_subway,
        bus_recommend_way
    }

    public RouteParaOption busStrategyType(EBusStrategyType eBusStrategyType) {
        this.f7437f = eBusStrategyType;
        return this;
    }

    public RouteParaOption cityName(String str) {
        this.f7436e = str;
        return this;
    }

    public RouteParaOption endName(String str) {
        this.f7435d = str;
        return this;
    }

    public RouteParaOption endPoint(LatLng latLng) {
        this.f7433b = latLng;
        return this;
    }

    public EBusStrategyType getBusStrategyType() {
        return this.f7437f;
    }

    public String getCityName() {
        return this.f7436e;
    }

    public String getEndName() {
        return this.f7435d;
    }

    public LatLng getEndPoint() {
        return this.f7433b;
    }

    public String getStartName() {
        return this.f7434c;
    }

    public LatLng getStartPoint() {
        return this.f7432a;
    }

    public RouteParaOption startName(String str) {
        this.f7434c = str;
        return this;
    }

    public RouteParaOption startPoint(LatLng latLng) {
        this.f7432a = latLng;
        return this;
    }
}
