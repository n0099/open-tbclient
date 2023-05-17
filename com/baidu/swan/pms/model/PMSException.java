package com.baidu.swan.pms.model;

import com.baidu.tieba.ai4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final ai4 mPmsError;

    public PMSException(String str, ai4 ai4Var) {
        super(str, null);
        this.mPmsError = ai4Var;
    }

    public ai4 getPmsError() {
        return this.mPmsError;
    }
}
