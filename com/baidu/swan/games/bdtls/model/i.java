package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes8.dex */
public final class i {
    private String dpI;
    private Integer dpJ;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.dpI, (Object) iVar.dpI) || !q.l(this.dpJ, iVar.dpJ)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dpI;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dpJ;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dpI + ", responseStatusCode=" + this.dpJ + ")";
    }

    public i(String str, Integer num) {
        this.dpI = str;
        this.dpJ = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dpI;
    }

    public final void uI(String str) {
        this.dpI = str;
    }

    public final Integer aMl() {
        return this.dpJ;
    }

    public final void d(Integer num) {
        this.dpJ = num;
    }
}
