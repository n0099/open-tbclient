package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.auth.IDuMixAuthCallback;
import java.util.List;
/* loaded from: classes6.dex */
public class b implements IAuthenticator {
    private static volatile b km;

    private b() {
    }

    public static b cE() {
        if (km == null) {
            km = new b();
        }
        return km;
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr) {
        init(context, bArr, null);
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(final Context context, byte[] bArr, final IAuthenticateCallback iAuthenticateCallback) {
        com.baidu.ar.libloader.a.load(context, null);
        final List[] listArr = {ARAuth.checkAuth(context, bArr, new IDuMixAuthCallback() { // from class: com.baidu.ar.auth.a.b.1
            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onAvailFeaturesUpdate(List<Integer> list) {
                listArr[0] = list;
                if (iAuthenticateCallback != null) {
                    iAuthenticateCallback.onAvailFeaturesChanged(list);
                }
            }

            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onFeatureRejected(int i) {
                if (iAuthenticateCallback != null) {
                    iAuthenticateCallback.onFeatureRejected(i);
                }
            }

            @Override // com.baidu.ar.auth.IDuMixAuthCallback
            public void onResult(boolean z) {
                if (z) {
                    ARAuth.doAuth(context, null);
                } else {
                    listArr[0].clear();
                }
                if (iAuthenticateCallback != null) {
                    iAuthenticateCallback.onResult(z, listArr[0]);
                }
            }
        })};
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void release() {
        ARAuth.release();
    }
}
