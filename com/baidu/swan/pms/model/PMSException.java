package com.baidu.swan.pms.model;

import d.a.l0.n.h.a;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final a mPmsError;

    public PMSException(String str, a aVar) {
        super(str, null);
        this.mPmsError = aVar;
    }

    public a getPmsError() {
        return this.mPmsError;
    }
}
