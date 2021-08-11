package com.baidu.livesdk.api.service;

import android.app.Activity;
import android.net.Uri;
/* loaded from: classes5.dex */
public interface Scheme {

    /* loaded from: classes5.dex */
    public interface CallbackHandler {
        void handleSchemeDispatchCallback(String str, String str2);
    }

    boolean invokeScheme(Uri uri, String str, CallbackHandler callbackHandler);

    int nickNameDialogStatus();

    void openScheme(String str);

    void openScheme(String str, boolean z);

    void showNickNameDialog(Activity activity, String str, int i2);
}
