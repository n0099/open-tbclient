package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class f {
    private String ebq;
    private com.baidu.swan.games.bdtls.b.b ebr;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.l(this.ebq, fVar.ebq) || !p.l(this.ebr, fVar.ebr)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ebq;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.ebr;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.ebq + ", bdtlsRequest=" + this.ebr + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.ebq = str;
        this.ebr = bVar;
    }

    public final String aUN() {
        return this.ebq;
    }

    public final com.baidu.swan.games.bdtls.b.b aUO() {
        return this.ebr;
    }
}
