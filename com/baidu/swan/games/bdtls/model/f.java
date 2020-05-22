package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String cUN;
    private com.baidu.swan.games.bdtls.b.b cUO;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.cUN, (Object) fVar.cUN) || !q.l(this.cUO, fVar.cUO)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cUN;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cUO;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cUN + ", bdtlsRequest=" + this.cUO + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cUN = str;
        this.cUO = bVar;
    }

    public final String ayB() {
        return this.cUN;
    }

    public final com.baidu.swan.games.bdtls.b.b ayC() {
        return this.cUO;
    }
}
