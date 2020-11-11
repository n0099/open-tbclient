package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class i {
    private String dSc;
    private Integer dSd;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l(this.dSc, iVar.dSc) || !q.l(this.dSd, iVar.dSd)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dSc;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dSd;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dSc + ", responseStatusCode=" + this.dSd + ")";
    }

    public i(String str, Integer num) {
        this.dSc = str;
        this.dSd = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dSc;
    }

    public final void wu(String str) {
        this.dSc = str;
    }

    public final Integer aTZ() {
        return this.dSd;
    }

    public final void f(Integer num) {
        this.dSd = num;
    }
}
