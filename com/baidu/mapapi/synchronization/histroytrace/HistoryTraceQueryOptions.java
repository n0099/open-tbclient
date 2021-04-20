package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7418a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7419b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7420c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7421d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7422e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7423f = 5;

    public int getCurrentOrderState() {
        return this.f7423f;
    }

    public String getDriverId() {
        return this.f7421d;
    }

    public String getOrderId() {
        return this.f7418a;
    }

    public int getQueryOrderState() {
        return this.f7422e;
    }

    public int getRoleType() {
        return this.f7419b;
    }

    public String getUserId() {
        return this.f7420c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f7423f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7421d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7418a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.f7422e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.f7419b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7420c = str;
        return this;
    }
}
