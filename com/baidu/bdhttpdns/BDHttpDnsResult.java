package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class BDHttpDnsResult {
    private ResolveType abD;
    private final ResolveStatus abE;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes9.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes9.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.abD = ResolveType.RESOLVE_NONE;
        this.abE = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.abD = ResolveType.RESOLVE_NONE;
        this.abD = resolveType;
        this.abE = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType rf() {
        return this.abD;
    }

    public ResolveStatus rg() {
        return this.abE;
    }

    public ArrayList<String> rh() {
        return this.c;
    }

    public ArrayList<String> ri() {
        return this.d;
    }
}
