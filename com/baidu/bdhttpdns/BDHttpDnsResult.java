package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {

    /* renamed from: a  reason: collision with root package name */
    public ResolveType f4253a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveStatus f4254b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f4255c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f4256d;

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
        this.f4253a = ResolveType.RESOLVE_NONE;
        this.f4254b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f4253a = ResolveType.RESOLVE_NONE;
        this.f4253a = resolveType;
        this.f4254b = resolveStatus;
        this.f4255c = arrayList;
        this.f4256d = arrayList2;
    }

    public ArrayList<String> a() {
        return this.f4255c;
    }

    public ArrayList<String> b() {
        return this.f4256d;
    }

    public ResolveStatus c() {
        return this.f4254b;
    }

    public ResolveType d() {
        return this.f4253a;
    }
}
