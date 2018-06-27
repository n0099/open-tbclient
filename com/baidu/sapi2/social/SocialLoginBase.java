package com.baidu.sapi2.social;

import android.content.Intent;
import com.baidu.sapi2.activity.TitleActivity;
/* loaded from: classes2.dex */
public class SocialLoginBase extends TitleActivity {
    protected static WXInvokeCallback wxInvokeCallback;

    /* loaded from: classes2.dex */
    public interface WXInvokeCallback {
        void onResult(int i, Intent intent);
    }

    public static WXInvokeCallback getWXinvokeCallback() {
        return wxInvokeCallback;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        wxInvokeCallback = wXInvokeCallback;
    }
}
