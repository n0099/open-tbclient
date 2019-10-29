package com.baidu.live.tbadk.pay.channel.interfaces;
/* loaded from: classes6.dex */
public interface IPayCallback {
    public static final int STATE_CODE_CANCEL = 2;
    public static final int STATE_CODE_FAILD = 3;
    public static final int STATE_CODE_PAYING = 1;
    public static final int STATE_CODE_SUCCEED = 0;

    void onPayResult(int i, String str);
}
