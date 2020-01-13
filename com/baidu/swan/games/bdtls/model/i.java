package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes10.dex */
public final class i {
    private String cgZ;
    private Integer cha;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.h(this.cgZ, iVar.cgZ) || !q.h(this.cha, iVar.cha)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cgZ;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.cha;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cgZ + ", responseStatusCode=" + this.cha + ")";
    }

    public i(String str, Integer num) {
        this.cgZ = str;
        this.cha = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String akr() {
        return this.cgZ;
    }

    public final void og(String str) {
        this.cgZ = str;
    }

    public final Integer aks() {
        return this.cha;
    }

    public final void b(Integer num) {
        this.cha = num;
    }
}
