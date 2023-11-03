package com.baidu.swan.pms.model;

import com.baidu.tieba.af4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final af4 mPmsError;

    public PMSException(String str, af4 af4Var) {
        super(str, null);
        this.mPmsError = af4Var;
    }

    public af4 getPmsError() {
        return this.mPmsError;
    }
}
