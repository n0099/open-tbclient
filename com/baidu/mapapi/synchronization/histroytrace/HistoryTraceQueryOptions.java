package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7383a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7384b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7385c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7386d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7387e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7388f = 5;

    public int getCurrentOrderState() {
        return this.f7388f;
    }

    public String getDriverId() {
        return this.f7386d;
    }

    public String getOrderId() {
        return this.f7383a;
    }

    public int getQueryOrderState() {
        return this.f7387e;
    }

    public int getRoleType() {
        return this.f7384b;
    }

    public String getUserId() {
        return this.f7385c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f7388f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7386d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7383a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.f7387e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.f7384b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7385c = str;
        return this;
    }
}
