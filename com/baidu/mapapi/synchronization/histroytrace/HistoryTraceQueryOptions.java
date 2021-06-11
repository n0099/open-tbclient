package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7444a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7445b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7446c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7447d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7448e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7449f = 5;

    public int getCurrentOrderState() {
        return this.f7449f;
    }

    public String getDriverId() {
        return this.f7447d;
    }

    public String getOrderId() {
        return this.f7444a;
    }

    public int getQueryOrderState() {
        return this.f7448e;
    }

    public int getRoleType() {
        return this.f7445b;
    }

    public String getUserId() {
        return this.f7446c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i2) {
        this.f7449f = i2;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7447d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7444a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i2) {
        this.f7448e = i2;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i2) {
        this.f7445b = i2;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7446c = str;
        return this;
    }
}
