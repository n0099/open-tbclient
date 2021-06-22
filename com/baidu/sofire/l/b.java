package com.baidu.sofire.l;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public Context f10358b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.j.c f10359c;

    /* renamed from: a  reason: collision with root package name */
    public a f10357a = null;

    /* renamed from: e  reason: collision with root package name */
    public String f10361e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f10362f = null;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f10360d = new d(this);

    public b(Context context, com.baidu.sofire.j.c cVar) {
        this.f10358b = context;
        this.f10359c = cVar;
    }

    public final String a(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f10361e)) {
                this.f10361e = this.f10358b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f10362f)) {
                try {
                    signatureArr = this.f10358b.getPackageManager().getPackageInfo(this.f10361e, 64).signatures;
                } catch (PackageManager.NameNotFoundException unused) {
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    try {
                        byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str3 = sb.toString();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.f10362f = str3;
            }
            str2 = this.f10357a.a(this.f10361e, this.f10362f, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
