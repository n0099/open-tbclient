package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String cKa;
    private com.baidu.swan.games.bdtls.b.b cKb;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.k(this.cKa, fVar.cKa) || !q.k(this.cKb, fVar.cKb)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cKa;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cKb;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cKa + ", bdtlsRequest=" + this.cKb + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cKa = str;
        this.cKb = bVar;
    }

    public final String auO() {
        return this.cKa;
    }

    public final com.baidu.swan.games.bdtls.b.b auP() {
        return this.cKb;
    }
}
