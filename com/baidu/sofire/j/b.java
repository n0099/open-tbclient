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
    public Context f10381b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.h.c f10382c;

    /* renamed from: a  reason: collision with root package name */
    public a f10380a = null;

    /* renamed from: e  reason: collision with root package name */
    public String f10384e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f10385f = null;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f10383d = new d(this);

    public b(Context context, com.baidu.sofire.h.c cVar) {
        this.f10381b = context;
        this.f10382c = cVar;
    }

    public final String a(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f10384e)) {
                this.f10384e = this.f10381b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f10385f)) {
                try {
                    signatureArr = this.f10381b.getPackageManager().getPackageInfo(this.f10384e, 64).signatures;
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
                this.f10385f = str3;
            }
            str2 = this.f10380a.a(this.f10384e, this.f10385f, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
