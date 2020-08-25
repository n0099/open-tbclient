package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class i {
    private String dpE;
    private Integer dpF;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.dpE, (Object) iVar.dpE) || !q.l(this.dpF, iVar.dpF)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dpE;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dpF;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dpE + ", responseStatusCode=" + this.dpF + ")";
    }

    public i(String str, Integer num) {
        this.dpE = str;
        this.dpF = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dpE;
    }

    public final void uH(String str) {
        this.dpE = str;
    }

    public final Integer aMl() {
        return this.dpF;
    }

    public final void d(Integer num) {
        this.dpF = num;
    }
}
