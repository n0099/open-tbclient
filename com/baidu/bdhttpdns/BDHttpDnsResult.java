package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class BDHttpDnsResult {
    private ResolveType aeX;
    private final ResolveStatus aeY;
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
        this.aeX = ResolveType.RESOLVE_NONE;
        this.aeY = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.aeX = ResolveType.RESOLVE_NONE;
        this.aeX = resolveType;
        this.aeY = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sZ() {
        return this.aeX;
    }

    public ResolveStatus ta() {
        return this.aeY;
    }

    public ArrayList<String> tb() {
        return this.c;
    }

    public ArrayList<String> tc() {
        return this.d;
    }
}
