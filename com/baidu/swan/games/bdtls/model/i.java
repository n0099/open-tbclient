package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String clq;
    private Integer clr;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.h(this.clq, iVar.clq) || !q.h(this.clr, iVar.clr)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.clq;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.clr;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.clq + ", responseStatusCode=" + this.clr + ")";
    }

    public i(String str, Integer num) {
        this.clq = str;
        this.clr = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String amK() {
        return this.clq;
    }

    public final void ov(String str) {
        this.clq = str;
    }

    public final Integer amL() {
        return this.clr;
    }

    public final void b(Integer num) {
        this.clr = num;
    }
}
