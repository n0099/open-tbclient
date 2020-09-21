package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class f {
    private String drx;
    private com.baidu.swan.games.bdtls.b.b dry;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.l((Object) this.drx, (Object) fVar.drx) || !q.l(this.dry, fVar.dry)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.drx;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.dry;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.drx + ", bdtlsRequest=" + this.dry + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.drx = str;
        this.dry = bVar;
    }

    public final String aMM() {
        return this.drx;
    }

    public final com.baidu.swan.games.bdtls.b.b aMN() {
        return this.dry;
    }
}
