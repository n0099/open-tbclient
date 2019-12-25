package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType Hc;
    private final ResolveStatus Hd;
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
        this.Hc = ResolveType.RESOLVE_NONE;
        this.Hd = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.Hc = ResolveType.RESOLVE_NONE;
        this.Hc = resolveType;
        this.Hd = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType lP() {
        return this.Hc;
    }

    public ResolveStatus lQ() {
        return this.Hd;
    }

    public ArrayList<String> lR() {
        return this.c;
    }

    public ArrayList<String> lS() {
        return this.d;
    }
}
