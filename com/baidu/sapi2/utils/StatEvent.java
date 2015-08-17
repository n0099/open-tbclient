package com.baidu.sapi2.utils;
/* loaded from: classes.dex */
public enum StatEvent {
    PV_LOGIN("pv_login", d.a),
    OP_LOGIN("num_login_va", d.a),
    PV_SMS_LOGIN("pv_slogin", d.t),
    OP_SMS_LOGIN("num_slogin_va", d.t),
    PV_REG("pv_reg", d.g),
    OP_REG("num_reg_va", d.g),
    PV_QUICK_USER_REG("pv_qreg", d.i),
    OP_QUICK_USER_REG("num_qreg_va", d.i);
    
    String a;
    String b;

    StatEvent(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
