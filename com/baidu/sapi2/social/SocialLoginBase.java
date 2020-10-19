package com.baidu.sapi2.social;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.activity.BaseActivity;
/* loaded from: classes5.dex */
public class SocialLoginBase extends BaseActivity implements NoProguard {
    private static WXInvokeCallback p;

    public static WXInvokeCallback getWXinvokeCallback() {
        return p;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        p = wXInvokeCallback;
    }
}
