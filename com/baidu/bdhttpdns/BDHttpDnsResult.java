package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class BDHttpDnsResult {
    private ResolveType aeE;
    private final ResolveStatus aeF;
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
        this.aeE = ResolveType.RESOLVE_NONE;
        this.aeF = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aeE = ResolveType.RESOLVE_NONE;
        this.aeE = resolveType;
        this.aeF = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sl() {
        return this.aeE;
    }

    public ResolveStatus sm() {
        return this.aeF;
    }

    public ArrayList<String> sn() {
        return this.c;
    }

    public ArrayList<String> so() {
        return this.d;
    }
}
