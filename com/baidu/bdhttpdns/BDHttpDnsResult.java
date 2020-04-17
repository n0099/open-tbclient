package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType aaJ;
    private final ResolveStatus aaK;
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
        this.aaJ = ResolveType.RESOLVE_NONE;
        this.aaK = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aaJ = ResolveType.RESOLVE_NONE;
        this.aaJ = resolveType;
        this.aaK = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType qG() {
        return this.aaJ;
    }

    public ResolveStatus qH() {
        return this.aaK;
    }

    public ArrayList<String> qI() {
        return this.c;
    }

    public ArrayList<String> qJ() {
        return this.d;
    }
}
