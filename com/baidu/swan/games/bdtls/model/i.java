package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
/* loaded from: classes9.dex */
public final class i {
    private String cgM;
    private Integer cgN;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!p.h(this.cgM, iVar.cgM) || !p.h(this.cgN, iVar.cgN)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cgM;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cgN;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cgM + ", responseStatusCode=" + this.cgN + ")";
    }

    public i(String str, Integer num) {
        this.cgM = str;
        this.cgN = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String ajY() {
        return this.cgM;
    }

    public final void oc(String str) {
        this.cgM = str;
    }

    public final Integer ajZ() {
        return this.cgN;
    }

    public final void b(Integer num) {
        this.cgN = num;
    }
}
