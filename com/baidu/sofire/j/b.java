package com.baidu.sofire.j;

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
    public Context f10344b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.h.c f10345c;

    /* renamed from: a  reason: collision with root package name */
    public a f10343a = null;

    /* renamed from: e  reason: collision with root package name */
    public String f10347e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f10348f = null;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f10346d = new d(this);

    public b(Context context, com.baidu.sofire.h.c cVar) {
        this.f10344b = context;
        this.f10345c = cVar;
    }

    public final String a(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f10347e)) {
                this.f10347e = this.f10344b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f10348f)) {
                try {
                    signatureArr = this.f10344b.getPackageManager().getPackageInfo(this.f10347e, 64).signatures;
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
                this.f10348f = str3;
            }
            str2 = this.f10343a.a(this.f10347e, this.f10348f, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
