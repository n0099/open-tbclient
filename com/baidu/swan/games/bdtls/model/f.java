package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class f {
    private String dpr;
    private com.baidu.swan.games.bdtls.b.b dps;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.dpr, (Object) fVar.dpr) || !q.l(this.dps, fVar.dps)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dpr;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dps;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dpr + ", bdtlsRequest=" + this.dps + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dpr = str;
        this.dps = bVar;
    }

    public final String aMb() {
        return this.dpr;
    }

    public final com.baidu.swan.games.bdtls.b.b aMc() {
        return this.dps;
    }
}
