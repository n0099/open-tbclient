package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cVa;
    private Integer cVb;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.cVa, (Object) iVar.cVa) || !q.l(this.cVb, iVar.cVb)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cVa;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cVb;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cVa + ", responseStatusCode=" + this.cVb + ")";
    }

    public i(String str, Integer num) {
        this.cVa = str;
        this.cVb = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.cVa;
    }

    public final void rj(String str) {
        this.cVa = str;
    }

    public final Integer ayL() {
        return this.cVb;
    }

    public final void c(Integer num) {
        this.cVb = num;
    }
}
