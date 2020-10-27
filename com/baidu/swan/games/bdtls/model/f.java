package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private String dLX;
    private com.baidu.swan.games.bdtls.b.b dLY;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l(this.dLX, fVar.dLX) || !q.l(this.dLY, fVar.dLY)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dLX;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dLY;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dLX + ", bdtlsRequest=" + this.dLY + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dLX = str;
        this.dLY = bVar;
    }

    public final String aRp() {
        return this.dLX;
    }

    public final com.baidu.swan.games.bdtls.b.b aRq() {
        return this.dLY;
    }
}
