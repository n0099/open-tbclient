package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private String dRP;
    private com.baidu.swan.games.bdtls.b.b dRQ;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l(this.dRP, fVar.dRP) || !q.l(this.dRQ, fVar.dRQ)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dRP;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dRQ;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dRP + ", bdtlsRequest=" + this.dRQ + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dRP = str;
        this.dRQ = bVar;
    }

    public final String aTP() {
        return this.dRP;
    }

    public final com.baidu.swan.games.bdtls.b.b aTQ() {
        return this.dRQ;
    }
}
