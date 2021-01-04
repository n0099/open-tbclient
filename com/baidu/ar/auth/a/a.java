package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.ar.auth.ARAuth;
import com.baidu.ar.auth.AuthJni;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.h.d;
/* loaded from: classes6.dex */
public class a implements IAuthenticator {
    private static volatile a ki;
    private String js;
    private String jt;
    private d kh;
    private String mSecretKey;

    private a(String str, String str2, String str3) {
        this.js = str;
        this.jt = str2;
        this.mSecretKey = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback) {
        b.cE().init(context, bArr, iAuthenticateCallback);
    }

    public static a b(String str, String str2, String str3) {
        if (ki == null) {
            ki = new a(str, str2, str3);
        } else {
            ki.js = str;
            ki.jt = str2;
            ki.mSecretKey = str3;
        }
        return ki;
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr) {
        init(context, bArr, null);
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(final Context context, final byte[] bArr, final IAuthenticateCallback iAuthenticateCallback) {
        com.baidu.ar.libloader.a.load(context, null);
        ARAuth.setAuthLicense(bArr, this.js, this.jt, this.mSecretKey);
        if (this.kh == null) {
            this.kh = new d("AsyncAuthenticator");
            this.kh.start();
        }
        AuthJni.init();
        this.kh.execute(new Runnable() { // from class: com.baidu.ar.auth.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(context, bArr, iAuthenticateCallback);
            }
        });
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void release() {
        ARAuth.release();
    }
}
