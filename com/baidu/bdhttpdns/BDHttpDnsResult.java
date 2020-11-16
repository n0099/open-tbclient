package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes19.dex */
public class BDHttpDnsResult {
    private ResolveType aeb;
    private final ResolveStatus aed;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes19.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes19.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.aeb = ResolveType.RESOLVE_NONE;
        this.aed = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aeb = ResolveType.RESOLVE_NONE;
        this.aeb = resolveType;
        this.aed = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sW() {
        return this.aeb;
    }

    public ResolveStatus sX() {
        return this.aed;
    }

    public ArrayList<String> sY() {
        return this.c;
    }

    public ArrayList<String> sZ() {
        return this.d;
    }
}
