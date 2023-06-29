package com.baidu.swan.pms.model;

import com.baidu.tieba.wk4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final wk4 mPmsError;

    public PMSException(String str, wk4 wk4Var) {
        super(str, null);
        this.mPmsError = wk4Var;
    }

    public wk4 getPmsError() {
        return this.mPmsError;
    }
}
