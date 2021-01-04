package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class f {
    private String egc;
    private com.baidu.swan.games.bdtls.b.b egd;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.l(this.egc, fVar.egc) || !p.l(this.egd, fVar.egd)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.egc;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.egd;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.egc + ", bdtlsRequest=" + this.egd + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.egc = str;
        this.egd = bVar;
    }

    public final String aYG() {
        return this.egc;
    }

    public final com.baidu.swan.games.bdtls.b.b aYH() {
        return this.egd;
    }
}
