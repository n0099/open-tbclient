package com.baidu.sofire.l;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes15.dex */
public final class b {
    Context b;
    public com.baidu.sofire.j.c c;

    /* renamed from: a  reason: collision with root package name */
    public a f3658a = null;
    private String e = null;
    private String f = null;
    ServiceConnection d = new d(this);

    public b(Context context, com.baidu.sofire.j.c cVar) {
        this.b = context;
        this.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        String str2;
        Throwable th;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.e)) {
                this.e = this.b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f)) {
                try {
                    signatureArr = this.b.getPackageManager().getPackageInfo(this.e, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    try {
                        byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str3 = sb.toString();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    this.f = str3;
                } catch (Throwable th2) {
                    str2 = str3;
                    th = th2;
                    th.printStackTrace();
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
            }
            str2 = this.f3658a.a(this.e, this.f, str);
        } catch (Throwable th3) {
            str2 = null;
            th = th3;
        }
        return !TextUtils.isEmpty(str2) ? "" : str2;
    }
}
