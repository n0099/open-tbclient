package com.baidu.swan.pms.model;

import com.baidu.tieba.bf4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final bf4 mPmsError;

    public PMSException(String str, bf4 bf4Var) {
        super(str, null);
        this.mPmsError = bf4Var;
    }

    public bf4 getPmsError() {
        return this.mPmsError;
    }
}
