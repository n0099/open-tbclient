package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String ckR;
    private com.baidu.swan.games.bdtls.b.b ckS;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.h(this.ckR, fVar.ckR) || !q.h(this.ckS, fVar.ckS)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ckR;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.ckS;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.ckR + ", bdtlsRequest=" + this.ckS + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.ckR = str;
        this.ckS = bVar;
    }

    public final String amx() {
        return this.ckR;
    }

    public final com.baidu.swan.games.bdtls.b.b amy() {
        return this.ckS;
    }
}
