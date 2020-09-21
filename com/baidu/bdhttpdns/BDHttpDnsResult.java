package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes18.dex */
public class BDHttpDnsResult {
    private ResolveType adF;
    private final ResolveStatus adG;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes18.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes18.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.adF = ResolveType.RESOLVE_NONE;
        this.adG = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.adF = ResolveType.RESOLVE_NONE;
        this.adF = resolveType;
        this.adG = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sW() {
        return this.adF;
    }

    public ResolveStatus sX() {
        return this.adG;
    }

    public ArrayList<String> sY() {
        return this.c;
    }

    public ArrayList<String> sZ() {
        return this.d;
    }
}
