package com.baidu.sapi2.social;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.c;
/* loaded from: classes4.dex */
public class SocialLoginBase extends BaseActivity implements c {
    private static WXInvokeCallback r;

    public static WXInvokeCallback getWXinvokeCallback() {
        return r;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        r = wXInvokeCallback;
    }
}
