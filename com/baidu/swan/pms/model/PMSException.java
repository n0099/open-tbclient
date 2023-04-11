package com.baidu.swan.pms.model;

import com.baidu.tieba.og4;
/* loaded from: classes3.dex */
public class PMSException extends Exception {
    public final og4 mPmsError;

    public PMSException(String str, og4 og4Var) {
        super(str, null);
        this.mPmsError = og4Var;
    }

    public og4 getPmsError() {
        return this.mPmsError;
    }
}
