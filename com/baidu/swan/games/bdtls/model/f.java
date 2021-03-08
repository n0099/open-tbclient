package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class f {
    private String eeY;
    private com.baidu.swan.games.bdtls.b.b eeZ;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!p.l(this.eeY, fVar.eeY) || !p.l(this.eeZ, fVar.eeZ)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.eeY;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.eeZ;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.eeY + ", bdtlsRequest=" + this.eeZ + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.eeY = str;
        this.eeZ = bVar;
    }

    public final String aVc() {
        return this.eeY;
    }

    public final com.baidu.swan.games.bdtls.b.b aVd() {
        return this.eeZ;
    }
}
