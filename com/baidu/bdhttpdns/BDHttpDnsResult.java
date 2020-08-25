package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class BDHttpDnsResult {
    private ResolveType adl;
    private final ResolveStatus adm;
    private ArrayList<String> c;
    private ArrayList<String> d;

    /* loaded from: classes6.dex */
    public enum ResolveStatus {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* loaded from: classes6.dex */
    public enum ResolveType {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public BDHttpDnsResult(ResolveStatus resolveStatus) {
        this.adl = ResolveType.RESOLVE_NONE;
        this.adm = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.adl = ResolveType.RESOLVE_NONE;
        this.adl = resolveType;
        this.adm = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sR() {
        return this.adl;
    }

    public ResolveStatus sS() {
        return this.adm;
    }

    public ArrayList<String> sT() {
        return this.c;
    }

    public ArrayList<String> sU() {
        return this.d;
    }
}
