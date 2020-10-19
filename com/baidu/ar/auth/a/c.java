package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.ar.auth.IOfflineAuthenticator;
/* loaded from: classes14.dex */
public class c implements IOfflineAuthenticator {
    private static volatile c ka;

    private c() {
    }

    public static c cG() {
        if (ka == null) {
            ka = new c();
        }
        return ka;
    }

    @Override // com.baidu.ar.auth.IOfflineAuthenticator
    public boolean checkLicense(Context context, byte[] bArr) {
        return com.baidu.ar.auth.a.checkOfflineLicenseAuth(context, bArr);
    }
}
