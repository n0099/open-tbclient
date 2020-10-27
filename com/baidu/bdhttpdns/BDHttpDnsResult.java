package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes12.dex */
public class BDHttpDnsResult {
    private ResolveType adW;
    private final ResolveStatus adX;
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
        this.adW = ResolveType.RESOLVE_NONE;
        this.adX = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.adW = ResolveType.RESOLVE_NONE;
        this.adW = resolveType;
        this.adX = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sW() {
        return this.adW;
    }

    public ResolveStatus sX() {
        return this.adX;
    }

    public ArrayList<String> sY() {
        return this.c;
    }

    public ArrayList<String> sZ() {
        return this.d;
    }
}
