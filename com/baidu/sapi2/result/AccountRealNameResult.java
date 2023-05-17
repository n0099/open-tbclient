package com.baidu.sapi2.result;
/* loaded from: classes3.dex */
public class AccountRealNameResult extends SapiResult {
    public String callbackkey;
    public int errorStep;
    public boolean juniorRealNameSuc;
    public boolean seniorRealNameSuc;
    public int subResultCode = -100000;
    public String subResultMsg = "未触发任何实名操作返回或实名时放弃返回";
}
