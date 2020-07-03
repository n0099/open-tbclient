package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cZK;
    private Integer cZL;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.cZK, (Object) iVar.cZK) || !q.l(this.cZL, iVar.cZL)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cZK;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cZL;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cZK + ", responseStatusCode=" + this.cZL + ")";
    }

    public i(String str, Integer num) {
        this.cZK = str;
        this.cZL = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.cZK;
    }

    public final void rr(String str) {
        this.cZK = str;
    }

    public final Integer azR() {
        return this.cZL;
    }

    public final void c(Integer num) {
        this.cZL = num;
    }
}
