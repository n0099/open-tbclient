package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class i {
    private String dQu;
    private Integer dQv;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l(this.dQu, iVar.dQu) || !q.l(this.dQv, iVar.dQv)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dQu;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dQv;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dQu + ", responseStatusCode=" + this.dQv + ")";
    }

    public i(String str, Integer num) {
        this.dQu = str;
        this.dQv = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dQu;
    }

    public final void wp(String str) {
        this.dQu = str;
    }

    public final Integer aTr() {
        return this.dQv;
    }

    public final void f(Integer num) {
        this.dQv = num;
    }
}
