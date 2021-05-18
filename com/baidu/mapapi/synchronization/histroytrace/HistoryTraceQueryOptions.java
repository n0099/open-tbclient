package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes2.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    public String f7501a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f7502b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f7503c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f7504d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7505e = 4;

    /* renamed from: f  reason: collision with root package name */
    public int f7506f = 5;

    public int getCurrentOrderState() {
        return this.f7506f;
    }

    public String getDriverId() {
        return this.f7504d;
    }

    public String getOrderId() {
        return this.f7501a;
    }

    public int getQueryOrderState() {
        return this.f7505e;
    }

    public int getRoleType() {
        return this.f7502b;
    }

    public String getUserId() {
        return this.f7503c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i2) {
        this.f7506f = i2;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.f7504d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f7501a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i2) {
        this.f7505e = i2;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i2) {
        this.f7502b = i2;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.f7503c = str;
        return this;
    }
}
