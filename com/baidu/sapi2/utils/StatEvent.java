package com.baidu.sapi2.utils;
/* loaded from: classes.dex */
public enum StatEvent {
    PV_LOGIN("pv_login", f.a),
    OP_LOGIN("num_login_va", f.a),
    PV_SMS_LOGIN("pv_slogin", f.v),
    OP_SMS_LOGIN("num_slogin_va", f.v),
    PV_REG("pv_reg", f.h),
    OP_REG("num_reg_va", f.h),
    PV_QUICK_USER_REG("pv_qreg", f.j),
    OP_QUICK_USER_REG("num_qreg_va", f.j);
    
    String a;
    String b;

    StatEvent(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
