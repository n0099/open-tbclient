package com.baidu.swan.pms.model;

import com.baidu.tieba.gi4;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final gi4 mPmsError;

    public PMSException(String str, gi4 gi4Var) {
        super(str, null);
        this.mPmsError = gi4Var;
    }

    public gi4 getPmsError() {
        return this.mPmsError;
    }
}
