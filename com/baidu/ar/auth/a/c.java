package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IOfflineAuthenticator;
/* loaded from: classes.dex */
public class c implements IOfflineAuthenticator {
    public static volatile c kp;

    public static c cF() {
        if (kp == null) {
            kp = new c();
        }
        return kp;
    }

    @Override // com.baidu.ar.auth.IOfflineAuthenticator
    public boolean checkLicense(Context context, byte[] bArr) {
        com.baidu.ar.libloader.a.load(context, null);
        return ARAuth.checkOfflineLicenseAuth(context, bArr);
    }
}
