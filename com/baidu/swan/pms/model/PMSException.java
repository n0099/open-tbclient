package com.baidu.swan.pms.model;

import com.baidu.tieba.ak4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final ak4 mPmsError;

    public PMSException(String str, ak4 ak4Var) {
        super(str, null);
        this.mPmsError = ak4Var;
    }

    public ak4 getPmsError() {
        return this.mPmsError;
    }
}
