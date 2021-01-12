package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class BDHttpDnsResult {
    private ResolveType aeL;
    private final ResolveStatus aeM;
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
        this.aeL = ResolveType.RESOLVE_NONE;
        this.aeM = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aeL = ResolveType.RESOLVE_NONE;
        this.aeL = resolveType;
        this.aeM = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType so() {
        return this.aeL;
    }

    public ResolveStatus sp() {
        return this.aeM;
    }

    public ArrayList<String> sq() {
        return this.c;
    }

    public ArrayList<String> sr() {
        return this.d;
    }
}
