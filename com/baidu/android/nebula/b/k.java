package com.baidu.android.nebula.b;
/* loaded from: classes.dex */
public enum k {
    GET,
    PUT,
    POST,
    DELETE,
    HEAD,
    OPTIONS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(String str) {
        k[] values;
        for (k kVar : values()) {
            if (kVar.toString().equalsIgnoreCase(str)) {
                return kVar;
            }
        }
        return null;
    }
}
