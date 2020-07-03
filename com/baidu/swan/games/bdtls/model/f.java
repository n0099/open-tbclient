package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String cZx;
    private com.baidu.swan.games.bdtls.b.b cZy;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.cZx, (Object) fVar.cZx) || !q.l(this.cZy, fVar.cZy)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cZx;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cZy;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cZx + ", bdtlsRequest=" + this.cZy + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cZx = str;
        this.cZy = bVar;
    }

    public final String azH() {
        return this.cZx;
    }

    public final com.baidu.swan.games.bdtls.b.b azI() {
        return this.cZy;
    }
}
