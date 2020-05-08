package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType aaM;
    private final ResolveStatus aaN;
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
        this.aaM = ResolveType.RESOLVE_NONE;
        this.aaN = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aaM = ResolveType.RESOLVE_NONE;
        this.aaM = resolveType;
        this.aaN = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType qG() {
        return this.aaM;
    }

    public ResolveStatus qH() {
        return this.aaN;
    }

    public ArrayList<String> qI() {
        return this.c;
    }

    public ArrayList<String> qJ() {
        return this.d;
    }
}
