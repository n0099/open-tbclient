package com.baidu.swan.apps.setting.oauth;

import android.annotation.TargetApi;
/* loaded from: classes9.dex */
public class OAuthException extends RuntimeException {
    public final int mErrorCode;

    public OAuthException(int i) {
        this.mErrorCode = i;
    }

    public OAuthException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public OAuthException(String str, Throwable th, int i) {
        super(str, th);
        this.mErrorCode = i;
    }

    public OAuthException(Throwable th, int i) {
        super(th);
        this.mErrorCode = i;
    }

    @TargetApi(24)
    public OAuthException(String str, Throwable th, boolean z, boolean z2, int i) {
        super(str, th, z, z2);
        this.mErrorCode = i;
    }
}
