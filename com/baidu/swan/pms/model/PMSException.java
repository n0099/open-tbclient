package com.baidu.swan.pms.model;

import com.baidu.tieba.bk4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final bk4 mPmsError;

    public PMSException(String str, bk4 bk4Var) {
        super(str, null);
        this.mPmsError = bk4Var;
    }

    public bk4 getPmsError() {
        return this.mPmsError;
    }
}
