package com.baidu.swan.pms.model;

import com.baidu.tieba.rg4;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final rg4 mPmsError;

    public PMSException(String str, rg4 rg4Var) {
        super(str, null);
        this.mPmsError = rg4Var;
    }

    public rg4 getPmsError() {
        return this.mPmsError;
    }
}
