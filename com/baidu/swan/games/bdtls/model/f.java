package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class f {
    private String dpv;
    private com.baidu.swan.games.bdtls.b.b dpw;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.dpv, (Object) fVar.dpv) || !q.l(this.dpw, fVar.dpw)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dpv;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dpw;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.dpv + ", bdtlsRequest=" + this.dpw + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.dpv = str;
        this.dpw = bVar;
    }

    public final String aMb() {
        return this.dpv;
    }

    public final com.baidu.swan.games.bdtls.b.b aMc() {
        return this.dpw;
    }
}
