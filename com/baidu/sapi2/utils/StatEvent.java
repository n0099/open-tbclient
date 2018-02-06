package com.baidu.sapi2.utils;
/* loaded from: classes.dex */
public enum StatEvent {
    PV_LOGIN("pv_login", SapiEnv.LOGIN_URI),
    OP_LOGIN("num_login_va", SapiEnv.LOGIN_URI),
    PV_SMS_LOGIN("pv_slogin", SapiEnv.GET_DYNAMIC_PWD_URI),
    OP_SMS_LOGIN("num_slogin_va", SapiEnv.GET_DYNAMIC_PWD_URI),
    PV_REG("pv_reg", SapiEnv.GET_REG_CODE_URI),
    OP_REG("num_reg_va", SapiEnv.GET_REG_CODE_URI);
    
    String a;
    String b;

    StatEvent(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
