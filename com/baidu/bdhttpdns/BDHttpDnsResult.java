package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BDHttpDnsResult {

    /* renamed from: a  reason: collision with root package name */
    public ResolveType f4275a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveStatus f4276b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f4277c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f4278d;

    /* loaded from: classes2.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes2.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.f4275a = ResolveType.RESOLVE_NONE;
        this.f4276b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f4275a = ResolveType.RESOLVE_NONE;
        this.f4275a = resolveType;
        this.f4276b = resolveStatus;
        this.f4277c = arrayList;
        this.f4278d = arrayList2;
    }

    public ArrayList<String> a() {
        return this.f4277c;
    }

    public ArrayList<String> b() {
        return this.f4278d;
    }

    public ResolveStatus c() {
        return this.f4276b;
    }

    public ResolveType d() {
        return this.f4275a;
    }
}
