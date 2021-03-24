package com.baidu.pass.ecommerce.result;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public class GetContactResult extends SapiResult {
    public static final int ERROR_CODE_NO_PERMISSION = -901;
    public static final String ERROR_MSG_NO_PERMISSION = "无权限";
    public String name;
    public String phone;

    public GetContactResult() {
        this.msgMap.put(-901, ERROR_MSG_NO_PERMISSION);
    }
}
