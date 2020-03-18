package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class f {
    private String cld;
    private com.baidu.swan.games.bdtls.b.b cle;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!q.h(this.cld, fVar.cld) || !q.h(this.cle, fVar.cle)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cld;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        com.baidu.swan.games.bdtls.b.b bVar = this.cle;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.cld + ", bdtlsRequest=" + this.cle + ")";
    }

    public f(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        this.cld = str;
        this.cle = bVar;
    }

    public final String amA() {
        return this.cld;
    }

    public final com.baidu.swan.games.bdtls.b.b amB() {
        return this.cle;
    }
}
