package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType abd;
    private final ResolveStatus abe;
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
        this.abd = ResolveType.RESOLVE_NONE;
        this.abe = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.abd = ResolveType.RESOLVE_NONE;
        this.abd = resolveType;
        this.abe = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType qM() {
        return this.abd;
    }

    public ResolveStatus qN() {
        return this.abe;
    }

    public ArrayList<String> qO() {
        return this.c;
    }

    public ArrayList<String> qP() {
        return this.d;
    }
}
