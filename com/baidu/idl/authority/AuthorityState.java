package com.baidu.idl.authority;

import java.util.HashMap;
/* loaded from: classes9.dex */
public class AuthorityState {
    public static final int STATE_ERROR_AUTHORIZED = 51;
    public static final int STATE_ERROR_BEGIN = 48;
    public static final int STATE_ERROR_EXPIRED = 50;
    public static final int STATE_ERROR_NETWORK = 240;
    public static final int STATE_ERROR_NOT_FIND_LICENSE = 49;
    public static final int STATE_INIT_ING = 272;
    public static final int STATE_NOT_INIT = 256;
    public static final int STATE_SUCCESS = 0;
    public static final int STATE_WARNING_VALIDITY_COMING = 16;
    private static HashMap<Integer, String> sStateName = new HashMap<>();

    static {
        sStateName.put(0, "STATE_SUCCESS");
        sStateName.put(16, "STATE_WARNING_VALIDITY_COMING");
        sStateName.put(49, "STATE_ERROR_NOT_FIND_LICENSE");
        sStateName.put(50, "STATE_ERROR_EXPIRED");
        sStateName.put(51, "STATE_ERROR_AUTHORIZED");
        sStateName.put(240, "STATE_ERROR_NETWORK");
        sStateName.put(256, "STATE_NOT_INIT");
        sStateName.put(Integer.valueOf((int) STATE_INIT_ING), "STATE_INIT_ING");
    }

    public static String getStateName(int i) {
        if (sStateName == null) {
            return null;
        }
        return sStateName.get(Integer.valueOf(i));
    }
}
