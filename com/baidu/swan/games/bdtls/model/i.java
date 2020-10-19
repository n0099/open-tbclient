package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class i {
    private String dDN;
    private Integer dDO;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l(this.dDN, iVar.dDN) || !q.l(this.dDO, iVar.dDO)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dDN;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dDO;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dDN + ", responseStatusCode=" + this.dDO + ")";
    }

    public i(String str, Integer num) {
        this.dDN = str;
        this.dDO = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dDN;
    }

    public final void vN(String str) {
        this.dDN = str;
    }

    public final Integer aPF() {
        return this.dDO;
    }

    public final void f(Integer num) {
        this.dDO = num;
    }
}
