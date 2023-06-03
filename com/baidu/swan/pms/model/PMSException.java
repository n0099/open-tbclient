package com.baidu.swan.pms.model;

import com.baidu.tieba.sk4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final sk4 mPmsError;

    public PMSException(String str, sk4 sk4Var) {
        super(str, null);
        this.mPmsError = sk4Var;
    }

    public sk4 getPmsError() {
        return this.mPmsError;
    }
}
