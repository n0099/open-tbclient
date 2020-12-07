package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes25.dex */
public final class i {
    private String dXs;
    private Integer dXt;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.l(this.dXs, iVar.dXs) || !p.l(this.dXt, iVar.dXt)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dXs;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dXt;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dXs + ", responseStatusCode=" + this.dXt + ")";
    }

    public i(String str, Integer num) {
        this.dXs = str;
        this.dXt = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dXs;
    }

    public final void wW(String str) {
        this.dXs = str;
    }

    public final Integer aWw() {
        return this.dXt;
    }

    public final void f(Integer num) {
        this.dXt = num;
    }
}
