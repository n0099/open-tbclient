package com.baidu.swan.apps.statistic.interfacestability;
/* loaded from: classes3.dex */
public enum SwanInterfaceType {
    LOGIN("cs_auth", "ma_login"),
    CHECK_SESSION("cs_auth", "ma_user_checksessionkey"),
    OPEN_DATA("cs_auth", "ma_open_data"),
    SWAN_ID("cs_auth", "ma_user_swanid"),
    OPEN_ID("cs_auth", "ma_user_openid"),
    AUTHORIZE("cs_auth", "ma_accredit_v1"),
    ACCREDIT_DATA("cs_auth", "ma_accredit_data"),
    FACE_CHECK("cs_auth", "ma_authentication_facecheck"),
    REAL_NAME_CHECK("cs_auth", "ma_authentication_realnamecheck"),
    UPDATE("cs_auth", "ma_update"),
    NAVIGATE("cs_common", "ma_navigate");
    
    public final String classify;
    public final String interfaceName;

    SwanInterfaceType(String str, String str2) {
        this.classify = str;
        this.interfaceName = str2;
    }

    public String getClassify() {
        return this.classify;
    }

    public String getInterfaceName() {
        return this.interfaceName;
    }
}
