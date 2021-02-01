package com.baidu.mapapi.synchronization.histroytrace;
/* loaded from: classes4.dex */
public class HistoryTraceQueryOptions {

    /* renamed from: a  reason: collision with root package name */
    private String f2954a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f2955b = 0;
    private String c = null;
    private String d = null;
    private int e = 4;
    private int f = 5;

    public int getCurrentOrderState() {
        return this.f;
    }

    public String getDriverId() {
        return this.d;
    }

    public String getOrderId() {
        return this.f2954a;
    }

    public int getQueryOrderState() {
        return this.e;
    }

    public int getRoleType() {
        return this.f2955b;
    }

    public String getUserId() {
        return this.c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.f2954a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.f2955b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.c = str;
        return this;
    }
}
