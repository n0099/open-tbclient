package com.baidu.searchbox.live.interfaces.pay;
/* loaded from: classes3.dex */
public interface IPayCallback {
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_CODE_FAIL = 6;
    public static final int STATE_CODE_CODE_UNKNOW = -1000;
    public static final int STATE_CODE_LOGIN_FAIL = 5;
    public static final int STATE_CODE_NOT_SUPPORT = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;
    public static final int STATE_CODE_TOKEN_FAIL = 4;

    void onPayResult(int i2, String str);
}
