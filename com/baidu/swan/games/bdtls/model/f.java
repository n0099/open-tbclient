package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String cKg;
    private com.baidu.swan.games.bdtls.b.b cKh;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.k(this.cKg, fVar.cKg) || !q.k(this.cKh, fVar.cKh)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cKg;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cKh;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cKg + ", bdtlsRequest=" + this.cKh + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cKg = str;
        this.cKh = bVar;
    }

    public final String auO() {
        return this.cKg;
    }

    public final com.baidu.swan.games.bdtls.b.b auP() {
        return this.cKh;
    }
}
