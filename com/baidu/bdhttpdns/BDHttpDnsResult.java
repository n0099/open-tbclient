package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {

    /* renamed from: a  reason: collision with root package name */
    public ResolveType f4276a;

    /* renamed from: b  reason: collision with root package name */
    public final ResolveStatus f4277b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f4278c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f4279d;

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
        this.f4276a = ResolveType.RESOLVE_NONE;
        this.f4277b = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f4276a = ResolveType.RESOLVE_NONE;
        this.f4276a = resolveType;
        this.f4277b = resolveStatus;
        this.f4278c = arrayList;
        this.f4279d = arrayList2;
    }

    public ArrayList<String> a() {
        return this.f4278c;
    }

    public ArrayList<String> b() {
        return this.f4279d;
    }

    public ResolveStatus c() {
        return this.f4277b;
    }

    public ResolveType d() {
        return this.f4276a;
    }
}
