package com.baidu.swan.apps.setting.oauth;

import android.annotation.TargetApi;
/* loaded from: classes3.dex */
public class OAuthException extends RuntimeException {
    public final int mErrorCode;

    public OAuthException(int i2) {
        this.mErrorCode = i2;
    }

    public OAuthException(String str, int i2) {
        super(str);
        this.mErrorCode = i2;
    }

    public OAuthException(String str, Throwable th, int i2) {
        super(str, th);
        this.mErrorCode = i2;
    }

    public OAuthException(Throwable th, int i2) {
        super(th);
        this.mErrorCode = i2;
    }

    @TargetApi(24)
    public OAuthException(String str, Throwable th, boolean z, boolean z2, int i2) {
        super(str, th, z, z2);
        this.mErrorCode = i2;
    }
}
