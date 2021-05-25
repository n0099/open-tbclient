package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7401a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7402b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7403c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7404d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7405e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7406f = 5;

    public int getCurrentOrderState() {
        return this.f7406f;
    }

    public String getDriverId() {
        return this.f7404d;
    }

    public String getOrderId() {
        return this.f7401a;
    }

    public int getQueryOrderState() {
        return this.f7405e;
    }

    public int getRoleType() {
        return this.f7402b;
    }

    public String getUserId() {
        return this.f7403c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i2) {
        this.f7406f = i2;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7404d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7401a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i2) {
        this.f7405e = i2;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i2) {
        this.f7402b = i2;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7403c = str;
        return this;
    }
}
