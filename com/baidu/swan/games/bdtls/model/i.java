package com.baidu.swan.games.bdtls.model;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@kotlin.h
/* loaded from: classes11.dex */
public final class i {
    private String cle;
    private Integer clf;

    public i() {
        this(null, null, 3, null);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!q.h(this.cle, iVar.cle) || !q.h(this.clf, iVar.clf)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.cle;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.clf;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.cle + ", responseStatusCode=" + this.clf + ")";
    }

    public i(String str, Integer num) {
        this.cle = str;
        this.clf = num;
    }

    public /* synthetic */ i(String str, Integer num, int i, o oVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }

    public final String amH() {
        return this.cle;
    }

    public final void ow(String str) {
        this.cle = str;
    }

    public final Integer amI() {
        return this.clf;
    }

    public final void b(Integer num) {
        this.clf = num;
    }
}
