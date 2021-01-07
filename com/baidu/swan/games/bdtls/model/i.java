package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class i {
    private String egq;
    private Integer egr;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.l(this.egq, iVar.egq) || !p.l(this.egr, iVar.egr)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.egq;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.egr;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.egq + ", responseStatusCode=" + this.egr + ")";
    }

    public i(String str, Integer num) {
        this.egq = str;
        this.egr = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.egq;
    }

    public final void wV(String str) {
        this.egq = str;
    }

    public final Integer aYR() {
        return this.egr;
    }

    public final void h(Integer num) {
        this.egr = num;
    }
}
