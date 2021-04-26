package com.baidu.sapi2.utils.enums;

import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
/* loaded from: classes2.dex */
public enum QrLoginAction {
    NOTICE(ErrorContentResponse.Operations.NOTICE),
    LOGIN("login"),
    CANCEL(QueryResponse.Options.CANCEL);
    
    public String name;

    QrLoginAction(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
