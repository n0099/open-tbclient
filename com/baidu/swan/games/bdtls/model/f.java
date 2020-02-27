package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String ckQ;
    private com.baidu.swan.games.bdtls.b.b ckR;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.h(this.ckQ, fVar.ckQ) || !q.h(this.ckR, fVar.ckR)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ckQ;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.ckR;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.ckQ + ", bdtlsRequest=" + this.ckR + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.ckQ = str;
        this.ckR = bVar;
    }

    public final String amv() {
        return this.ckQ;
    }

    public final com.baidu.swan.games.bdtls.b.b amw() {
        return this.ckR;
    }
}
