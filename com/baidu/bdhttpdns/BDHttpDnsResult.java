package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {

    /* renamed from: a  reason: collision with root package name */
    public ResolveType f4234a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveStatus f4235b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f4236c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f4237d;

    /* loaded from: classes.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.f4234a = ResolveType.RESOLVE_NONE;
        this.f4235b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f4234a = ResolveType.RESOLVE_NONE;
        this.f4234a = resolveType;
        this.f4235b = resolveStatus;
        this.f4236c = arrayList;
        this.f4237d = arrayList2;
    }

    public ArrayList<String> a() {
        return this.f4236c;
    }

    public ArrayList<String> b() {
        return this.f4237d;
    }

    public ResolveStatus c() {
        return this.f4235b;
    }

    public ResolveType d() {
        return this.f4234a;
    }
}
