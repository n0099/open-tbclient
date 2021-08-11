package com.baidu.ar.auth;

import android.content.Context;
/* loaded from: classes5.dex */
public interface IAuthenticator {
    void init(Context context, byte[] bArr);

    void init(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback);

    void release();
}
