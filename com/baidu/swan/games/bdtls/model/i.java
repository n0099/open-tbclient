package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes10.dex */
public final class i {
    private String dMk;
    private Integer dMl;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l(this.dMk, iVar.dMk) || !q.l(this.dMl, iVar.dMl)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dMk;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dMl;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dMk + ", responseStatusCode=" + this.dMl + ")";
    }

    public i(String str, Integer num) {
        this.dMk = str;
        this.dMl = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dMk;
    }

    public final void wg(String str) {
        this.dMk = str;
    }

    public final Integer aRz() {
        return this.dMl;
    }

    public final void f(Integer num) {
        this.dMl = num;
    }
}
