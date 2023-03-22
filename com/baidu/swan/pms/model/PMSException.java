package com.baidu.swan.pms.model;

import com.baidu.tieba.ng4;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final ng4 mPmsError;

    public PMSException(String str, ng4 ng4Var) {
        super(str, null);
        this.mPmsError = ng4Var;
    }

    public ng4 getPmsError() {
        return this.mPmsError;
    }
}
