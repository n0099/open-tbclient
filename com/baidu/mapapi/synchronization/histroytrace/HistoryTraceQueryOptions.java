package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7382a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7383b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7384c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7385d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7386e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7387f = 5;

    public int getCurrentOrderState() {
        return this.f7387f;
    }

    public String getDriverId() {
        return this.f7385d;
    }

    public String getOrderId() {
        return this.f7382a;
    }

    public int getQueryOrderState() {
        return this.f7386e;
    }

    public int getRoleType() {
        return this.f7383b;
    }

    public String getUserId() {
        return this.f7384c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f7387f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7385d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7382a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.f7386e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.f7383b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7384c = str;
        return this;
    }
}
