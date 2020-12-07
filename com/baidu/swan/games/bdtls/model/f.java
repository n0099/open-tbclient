package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class f {
    private String dXf;
    private com.baidu.swan.games.bdtls.b.b dXg;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.l(this.dXf, fVar.dXf) || !p.l(this.dXg, fVar.dXg)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dXf;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dXg;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dXf + ", bdtlsRequest=" + this.dXg + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dXf = str;
        this.dXg = bVar;
    }

    public final String aWm() {
        return this.dXf;
    }

    public final com.baidu.swan.games.bdtls.b.b aWn() {
        return this.dXg;
    }
}
