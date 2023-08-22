package com.baidu.swan.pms.model;

import com.baidu.tieba.xj4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final xj4 mPmsError;

    public PMSException(String str, xj4 xj4Var) {
        super(str, null);
        this.mPmsError = xj4Var;
    }

    public xj4 getPmsError() {
        return this.mPmsError;
    }
}
