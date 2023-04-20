package com.baidu.swan.pms.model;

import com.baidu.tieba.pg4;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final pg4 mPmsError;

    public PMSException(String str, pg4 pg4Var) {
        super(str, null);
        this.mPmsError = pg4Var;
    }

    public pg4 getPmsError() {
        return this.mPmsError;
    }
}
