package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes9.dex */
public final class i {
    private String edK;
    private Integer edL;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.l(this.edK, iVar.edK) || !p.l(this.edL, iVar.edL)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.edK;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.edL;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.edK + ", responseStatusCode=" + this.edL + ")";
    }

    public i(String str, Integer num) {
        this.edK = str;
        this.edL = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.edK;
    }

    public final void wd(String str) {
        this.edK = str;
    }

    public final Integer aVj() {
        return this.edL;
    }

    public final void h(Integer num) {
        this.edL = num;
    }
}
