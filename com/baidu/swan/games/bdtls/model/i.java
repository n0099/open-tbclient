package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes3.dex */
public final class i {
    private String drK;
    private Integer drL;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.drK, (Object) iVar.drK) || !q.l(this.drL, iVar.drL)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.drK;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.drL;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.drK + ", responseStatusCode=" + this.drL + ")";
    }

    public i(String str, Integer num) {
        this.drK = str;
        this.drL = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.drK;
    }

    public final void vb(String str) {
        this.drK = str;
    }

    public final Integer aMW() {
        return this.drL;
    }

    public final void d(Integer num) {
        this.drL = num;
    }
}
