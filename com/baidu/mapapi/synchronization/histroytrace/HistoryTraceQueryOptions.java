package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7684a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7685b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7686c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7687d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7688e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7689f = 5;

    public int getCurrentOrderState() {
        return this.f7689f;
    }

    public String getDriverId() {
        return this.f7687d;
    }

    public String getOrderId() {
        return this.f7684a;
    }

    public int getQueryOrderState() {
        return this.f7688e;
    }

    public int getRoleType() {
        return this.f7685b;
    }

    public String getUserId() {
        return this.f7686c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i2) {
        this.f7689f = i2;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7687d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7684a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i2) {
        this.f7688e = i2;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i2) {
        this.f7685b = i2;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7686c = str;
        return this;
    }
}
