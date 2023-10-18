package com.baidu.swan.pms.model;

import com.baidu.tieba.je4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final je4 mPmsError;

    public PMSException(String str, je4 je4Var) {
        super(str, null);
        this.mPmsError = je4Var;
    }

    public je4 getPmsError() {
        return this.mPmsError;
    }
}
