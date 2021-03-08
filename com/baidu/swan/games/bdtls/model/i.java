package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class i {
    private String efl;
    private Integer efm;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.l(this.efl, iVar.efl) || !p.l(this.efm, iVar.efm)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.efl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.efm;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.efl + ", responseStatusCode=" + this.efm + ")";
    }

    public i(String str, Integer num) {
        this.efl = str;
        this.efm = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.efl;
    }

    public final void wk(String str) {
        this.efl = str;
    }

    public final Integer aVm() {
        return this.efm;
    }

    public final void h(Integer num) {
        this.efm = num;
    }
}
