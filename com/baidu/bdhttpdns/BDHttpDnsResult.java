package com.baidu.bdhttpdns;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class BDHttpDnsResult {
    private ResolveType adn;
    private final ResolveStatus ado;
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
        this.adn = ResolveType.RESOLVE_NONE;
        this.ado = resolveStatus;
    }

    public BDHttpDnsResult(ResolveType resolveType, ResolveStatus resolveStatus, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.adn = ResolveType.RESOLVE_NONE;
        this.adn = resolveType;
        this.ado = resolveStatus;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public ResolveType sR() {
        return this.adn;
    }

    public ResolveStatus sS() {
        return this.ado;
    }

    public ArrayList<String> sT() {
        return this.c;
    }

    public ArrayList<String> sU() {
        return this.d;
    }
}
