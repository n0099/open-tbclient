package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType Hh;
    private final ResolveStatus Hi;
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
        this.Hh = ResolveType.RESOLVE_NONE;
        this.Hi = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.Hh = ResolveType.RESOLVE_NONE;
        this.Hh = resolveType;
        this.Hi = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType lP() {
        return this.Hh;
    }

    public ResolveStatus lQ() {
        return this.Hi;
    }

    public ArrayList<String> lR() {
        return this.c;
    }

    public ArrayList<String> lS() {
        return this.d;
    }
}
