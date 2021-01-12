package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
@kotlin.e
/* loaded from: classes8.dex */
public final class i {
    private String ebD;
    private Integer ebE;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.l(this.ebD, iVar.ebD) || !p.l(this.ebE, iVar.ebE)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ebD;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.ebE;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.ebD + ", responseStatusCode=" + this.ebE + ")";
    }

    public i(String str, Integer num) {
        this.ebD = str;
        this.ebE = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.ebD;
    }

    public final void vK(String str) {
        this.ebD = str;
    }

    public final Integer aUX() {
        return this.ebE;
    }

    public final void h(Integer num) {
        this.ebE = num;
    }
}
