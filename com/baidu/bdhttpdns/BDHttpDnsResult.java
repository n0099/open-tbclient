package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType abI;
    private final ResolveStatus abJ;
    private ArrayList<String> c;
    private ArrayList<String> d;

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
        this.abI = ResolveType.RESOLVE_NONE;
        this.abJ = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.abI = ResolveType.RESOLVE_NONE;
        this.abI = resolveType;
        this.abJ = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType rd() {
        return this.abI;
    }

    public ResolveStatus re() {
        return this.abJ;
    }

    public ArrayList<String> rf() {
        return this.c;
    }

    public ArrayList<String> rg() {
        return this.d;
    }
}
