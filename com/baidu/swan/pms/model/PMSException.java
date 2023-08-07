package com.baidu.swan.pms.model;

import com.baidu.tieba.sj4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final sj4 mPmsError;

    public PMSException(String str, sj4 sj4Var) {
        super(str, null);
        this.mPmsError = sj4Var;
    }

    public sj4 getPmsError() {
        return this.mPmsError;
    }
}
