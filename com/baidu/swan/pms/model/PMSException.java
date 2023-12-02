package com.baidu.swan.pms.model;

import com.baidu.tieba.ef4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final ef4 mPmsError;

    public PMSException(String str, ef4 ef4Var) {
        super(str, null);
        this.mPmsError = ef4Var;
    }

    public ef4 getPmsError() {
        return this.mPmsError;
    }
}
