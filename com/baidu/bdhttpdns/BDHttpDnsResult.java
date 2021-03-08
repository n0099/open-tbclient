package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BDHttpDnsResult {
    private ResolveType afW;
    private final ResolveStatus afX;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes5.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes5.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.afW = ResolveType.RESOLVE_NONE;
        this.afX = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.afW = ResolveType.RESOLVE_NONE;
        this.afW = resolveType;
        this.afX = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sl() {
        return this.afW;
    }

    public ResolveStatus sm() {
        return this.afX;
    }

    public ArrayList<String> sn() {
        return this.c;
    }

    public ArrayList<String> so() {
        return this.d;
    }
}
