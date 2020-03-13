package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String clf;
    private Integer clg;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.h(this.clf, iVar.clf) || !q.h(this.clg, iVar.clg)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.clf;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.clg;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.clf + ", responseStatusCode=" + this.clg + ")";
    }

    public i(String str, Integer num) {
        this.clf = str;
        this.clg = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String amH() {
        return this.clf;
    }

    public final void ow(String str) {
        this.clf = str;
    }

    public final Integer amI() {
        return this.clg;
    }

    public final void b(Integer num) {
        this.clg = num;
    }
}
