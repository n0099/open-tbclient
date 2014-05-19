package com.baidu.bdcvf;

import android.content.Context;
/* loaded from: classes.dex */
public final class CertVerifier {
    private static volatile CertVerifier sInstance = null;

    /* loaded from: classes.dex */
    public interface ResultListener {
        void onVerifyFail(int i);

        void onVerifyOK();
    }

    public static CertVerifier getInstance() {
        if (sInstance == null) {
            synchronized (CertVerifier.class) {
                if (sInstance == null) {
                    sInstance = new CertVerifier();
                }
            }
        }
        return sInstance;
    }

    private CertVerifier() {
    }

    public void verify(Context context, ResultListener resultListener) {
        N.a(context, resultListener);
    }
}
