package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cKn;
    private Integer cKo;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.k(this.cKn, iVar.cKn) || !q.k(this.cKo, iVar.cKo)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cKn;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cKo;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cKn + ", responseStatusCode=" + this.cKo + ")";
    }

    public i(String str, Integer num) {
        this.cKn = str;
        this.cKo = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.cKn;
    }

    public final void pI(String str) {
        this.cKn = str;
    }

    public final Integer auY() {
        return this.cKo;
    }

    public final void b(Integer num) {
        this.cKo = num;
    }
}
