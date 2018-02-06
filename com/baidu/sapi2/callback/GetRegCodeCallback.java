package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.GetRegCodeResult;
/* loaded from: classes2.dex */
public abstract class GetRegCodeCallback implements SapiCallback<GetRegCodeResult> {
    public abstract void onPhoneNumberExist(GetRegCodeResult getRegCodeResult);
}
