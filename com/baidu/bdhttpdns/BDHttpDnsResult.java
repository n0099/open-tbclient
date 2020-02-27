package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType HB;
    private final ResolveStatus HC;
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
        this.HB = ResolveType.RESOLVE_NONE;
        this.HC = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.HB = ResolveType.RESOLVE_NONE;
        this.HB = resolveType;
        this.HC = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType me() {
        return this.HB;
    }

    public ResolveStatus mf() {
        return this.HC;
    }

    public ArrayList<String> mg() {
        return this.c;
    }

    public ArrayList<String> mh() {
        return this.d;
    }
}
