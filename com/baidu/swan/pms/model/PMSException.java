package com.baidu.swan.pms.model;

import com.baidu.tieba.tk4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final tk4 mPmsError;

    public PMSException(String str, tk4 tk4Var) {
        super(str, null);
        this.mPmsError = tk4Var;
    }

    public tk4 getPmsError() {
        return this.mPmsError;
    }
}
