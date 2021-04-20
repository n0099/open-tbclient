package com.baidu.sapi2.utils.enums;

import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
/* loaded from: classes2.dex */
public enum QrLoginAction {
    NOTICE(ErrorContentResponse.Operations.NOTICE),
    LOGIN("login"),
    CANCEL(QueryResponse.Options.CANCEL);
    

    /* renamed from: a  reason: collision with root package name */
    public String f11077a;

    QrLoginAction(String str) {
        this.f11077a = str;
    }

    public String getName() {
        return this.f11077a;
    }
}
