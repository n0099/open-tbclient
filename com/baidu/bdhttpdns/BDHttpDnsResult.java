package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType Ey;
    private final ResolveStatus Ez;
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
        this.Ey = ResolveType.RESOLVE_NONE;
        this.Ez = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.Ey = ResolveType.RESOLVE_NONE;
        this.Ey = resolveType;
        this.Ez = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ArrayList<String> lA() {
        return this.c;
    }

    public ArrayList<String> lB() {
        return this.d;
    }

    public ResolveType ly() {
        return this.Ey;
    }

    public ResolveStatus lz() {
        return this.Ez;
    }
}
