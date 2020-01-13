package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class f {
    private String cgM;
    private com.baidu.swan.games.bdtls.b.b cgN;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.h(this.cgM, fVar.cgM) || !q.h(this.cgN, fVar.cgN)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cgM;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cgN;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cgM + ", bdtlsRequest=" + this.cgN + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cgM = str;
        this.cgN = bVar;
    }

    public final String akh() {
        return this.cgM;
    }

    public final com.baidu.swan.games.bdtls.b.b aki() {
        return this.cgN;
    }
}
