package com.baidu.swan.pms.model;

import com.baidu.tieba.pk4;
/* loaded from: classes4.dex */
public class PMSException extends Exception {
    public final pk4 mPmsError;

    public PMSException(String str, pk4 pk4Var) {
        super(str, null);
        this.mPmsError = pk4Var;
    }

    public pk4 getPmsError() {
        return this.mPmsError;
    }
}
