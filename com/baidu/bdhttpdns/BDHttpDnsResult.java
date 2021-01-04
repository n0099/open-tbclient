package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class BDHttpDnsResult {
    private ResolveType afC;
    private final ResolveStatus afD;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes6.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes6.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.afC = ResolveType.RESOLVE_NONE;
        this.afD = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.afC = ResolveType.RESOLVE_NONE;
        this.afC = resolveType;
        this.afD = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveStatus sA() {
        return this.afD;
    }

    public ArrayList<String> sB() {
        return this.c;
    }

    public ArrayList<String> sC() {
        return this.d;
    }

    public ResolveType sz() {
        return this.afC;
    }
}
