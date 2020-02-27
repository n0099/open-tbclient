package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cld;
    private Integer cle;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.h(this.cld, iVar.cld) || !q.h(this.cle, iVar.cle)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cld;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cle;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cld + ", responseStatusCode=" + this.cle + ")";
    }

    public i(String str, Integer num) {
        this.cld = str;
        this.cle = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String amF() {
        return this.cld;
    }

    public final void ow(String str) {
        this.cld = str;
    }

    public final Integer amG() {
        return this.cle;
    }

    public final void b(Integer num) {
        this.cle = num;
    }
}
