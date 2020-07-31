package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes7.dex */
public final class i {
    private String dfv;
    private Integer dfw;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.l((Object) this.dfv, (Object) iVar.dfv) || !q.l(this.dfw, iVar.dfw)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.dfv;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.dfw;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.dfv + ", responseStatusCode=" + this.dfw + ")";
    }

    public i(String str, Integer num) {
        this.dfv = str;
        this.dfw = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String getResponseMessage() {
        return this.dfv;
    }

    public final void sp(String str) {
        this.dfv = str;
    }

    public final Integer aDw() {
        return this.dfw;
    }

    public final void c(Integer num) {
        this.dfw = num;
    }
}
