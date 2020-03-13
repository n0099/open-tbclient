package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String ckS;
    private com.baidu.swan.games.bdtls.b.b ckT;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.h(this.ckS, fVar.ckS) || !q.h(this.ckT, fVar.ckT)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ckS;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.ckT;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.ckS + ", bdtlsRequest=" + this.ckT + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.ckS = str;
        this.ckT = bVar;
    }

    public final String amx() {
        return this.ckS;
    }

    public final com.baidu.swan.games.bdtls.b.b amy() {
        return this.ckT;
    }
}
