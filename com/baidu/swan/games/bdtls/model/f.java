package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private String dfi;
    private com.baidu.swan.games.bdtls.b.b dfj;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.dfi, (Object) fVar.dfi) || !q.l(this.dfj, fVar.dfj)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dfi;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dfj;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dfi + ", bdtlsRequest=" + this.dfj + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dfi = str;
        this.dfj = bVar;
    }

    public final String aDm() {
        return this.dfi;
    }

    public final com.baidu.swan.games.bdtls.b.b aDn() {
        return this.dfj;
    }
}
