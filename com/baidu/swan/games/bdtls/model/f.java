package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class f {
    private String edx;
    private com.baidu.swan.games.bdtls.b.b edy;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.l(this.edx, fVar.edx) || !p.l(this.edy, fVar.edy)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.edx;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.edy;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.edx + ", bdtlsRequest=" + this.edy + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.edx = str;
        this.edy = bVar;
    }

    public final String aUZ() {
        return this.edx;
    }

    public final com.baidu.swan.games.bdtls.b.b aVa() {
        return this.edy;
    }
}
