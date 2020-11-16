package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private String dQh;
    private com.baidu.swan.games.bdtls.b.b dQi;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l(this.dQh, fVar.dQh) || !q.l(this.dQi, fVar.dQi)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dQh;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dQi;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dQh + ", bdtlsRequest=" + this.dQi + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dQh = str;
        this.dQi = bVar;
    }

    public final String aTh() {
        return this.dQh;
    }

    public final com.baidu.swan.games.bdtls.b.b aTi() {
        return this.dQi;
    }
}
