package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cKt;
    private Integer cKu;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.k(this.cKt, iVar.cKt) || !q.k(this.cKu, iVar.cKu)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cKt;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cKu;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cKt + ", responseStatusCode=" + this.cKu + ")";
    }

    public i(String str, Integer num) {
        this.cKt = str;
        this.cKu = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.cKt;
    }

    public final void pI(String str) {
        this.cKt = str;
    }

    public final Integer auY() {
        return this.cKu;
    }

    public final void b(Integer num) {
        this.cKu = num;
    }
}
