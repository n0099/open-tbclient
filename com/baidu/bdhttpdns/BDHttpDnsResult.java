package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes12.dex */
public class BDHttpDnsResult {
    private ResolveType adV;
    private final ResolveStatus adW;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes12.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes12.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.adV = ResolveType.RESOLVE_NONE;
        this.adW = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.adV = ResolveType.RESOLVE_NONE;
        this.adV = resolveType;
        this.adW = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sW() {
        return this.adV;
    }

    public ResolveStatus sX() {
        return this.adW;
    }

    public ArrayList<String> sY() {
        return this.c;
    }

    public ArrayList<String> sZ() {
        return this.d;
    }
}
