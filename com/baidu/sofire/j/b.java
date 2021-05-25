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
    public Context f10282b;

    /* renamed from: c  reason: collision with root package name */
    public com.baidu.sofire.h.c f10283c;

    /* renamed from: a  reason: collision with root package name */
    public a f10281a = null;

    /* renamed from: e  reason: collision with root package name */
    public String f10285e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f10286f = null;

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f10284d = new d(this);

    public b(Context context, com.baidu.sofire.h.c cVar) {
        this.f10282b = context;
        this.f10283c = cVar;
    }

    public final String a(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f10285e)) {
                this.f10285e = this.f10282b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f10286f)) {
                try {
                    signatureArr = this.f10282b.getPackageManager().getPackageInfo(this.f10285e, 64).signatures;
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
                this.f10286f = str3;
            }
            str2 = this.f10281a.a(this.f10285e, this.f10286f, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
