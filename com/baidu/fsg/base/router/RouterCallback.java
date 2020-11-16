package com.baidu.fsg.base.router;

import java.util.HashMap;
/* loaded from: classes15.dex */
public interface RouterCallback {
    public static final int CODE_ERROR = 268435457;
    public static final int CODE_INVALID = 268435459;
    public static final int CODE_NOT_FOUND = 268435458;
    public static final int CODE_NOT_IMPLEMENT = 268435461;
    public static final int CODE_ROUTER_NOT_REGISTER = 268435460;
    public static final int CODE_SUCCESS = 0;
    public static final String KEY_ERROR_MSG = "retMsg";
    public static final String KEY_VALUE = "result";

    void onResult(int i, HashMap hashMap);
}
