package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class f {
    private com.baidu.swan.games.bdtls.b.b cgA;
    private String cgz;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.h(this.cgz, fVar.cgz) || !p.h(this.cgA, fVar.cgA)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cgz;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cgA;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cgz + ", bdtlsRequest=" + this.cgA + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cgz = str;
        this.cgA = bVar;
    }

    public final String ajO() {
        return this.cgz;
    }

    public final com.baidu.swan.games.bdtls.b.b ajP() {
        return this.cgA;
    }
}
