package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class BDHttpDnsResult {
    private ResolveType EZ;
    private final ResolveStatus Fa;
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
        this.EZ = ResolveType.RESOLVE_NONE;
        this.Fa = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.EZ = ResolveType.RESOLVE_NONE;
        this.EZ = resolveType;
        this.Fa = resolveStatus;
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
        return this.EZ;
    }

    public ResolveStatus lz() {
        return this.Fa;
    }
}
