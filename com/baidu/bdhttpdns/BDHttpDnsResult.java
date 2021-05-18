package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {

    /* renamed from: a  reason: collision with root package name */
    public ResolveType f4231a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveStatus f4232b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f4233c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f4234d;

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
        this.f4231a = ResolveType.RESOLVE_NONE;
        this.f4232b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f4231a = ResolveType.RESOLVE_NONE;
        this.f4231a = resolveType;
        this.f4232b = resolveStatus;
        this.f4233c = arrayList;
        this.f4234d = arrayList2;
    }

    public ArrayList<String> a() {
        return this.f4233c;
    }

    public ArrayList<String> b() {
        return this.f4234d;
    }

    public ResolveStatus c() {
        return this.f4232b;
    }

    public ResolveType d() {
        return this.f4231a;
    }
}
