package com.baidu.ar.auth.a;

import android.content.Context;
import com.baidu.ar.auth.AuthJni;
import com.baidu.ar.auth.IAuthenticateCallback;
import com.baidu.ar.auth.IAuthenticator;
import com.baidu.ar.g.d;
/* loaded from: classes12.dex */
public class a implements IAuthenticator {
    private static volatile a jT;
    private d jS;
    private String jd;
    private String je;
    private String mSecretKey;

    private a(String str, String str2, String str3) {
        this.jd = str;
        this.je = str2;
        this.mSecretKey = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, byte[] bArr, IAuthenticateCallback iAuthenticateCallback) {
        b.cF().init(context, bArr, iAuthenticateCallback);
    }

    public static a b(String str, String str2, String str3) {
        if (jT == null) {
            jT = new a(str, str2, str3);
        } else {
            jT.jd = str;
            jT.je = str2;
            jT.mSecretKey = str3;
        }
        return jT;
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(Context context, byte[] bArr) {
        init(context, bArr, null);
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void init(final Context context, final byte[] bArr, final IAuthenticateCallback iAuthenticateCallback) {
        com.baidu.ar.auth.a.setAuthLicense(bArr, this.jd, this.je, this.mSecretKey);
        if (this.jS == null) {
            this.jS = new d("AsyncAuthenticator");
            this.jS.start();
        }
        AuthJni.init();
        this.jS.execute(new Runnable() { // from class: com.baidu.ar.auth.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(context, bArr, iAuthenticateCallback);
            }
        });
    }

    @Override // com.baidu.ar.auth.IAuthenticator
    public void release() {
        com.baidu.ar.auth.a.release();
    }
}
