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

    /* renamed from: b  reason: collision with root package name */
    Context f5581b;
    public com.baidu.sofire.j.c c;

    /* renamed from: a  reason: collision with root package name */
    public a f5580a = null;
    private String e = null;
    private String f = null;
    ServiceConnection d = new d(this);

    public b(Context context, com.baidu.sofire.j.c cVar) {
        this.f5581b = context;
        this.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        String str2;
        Signature[] signatureArr;
        try {
            if (TextUtils.isEmpty(this.e)) {
                this.e = this.f5581b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f)) {
                try {
                    signatureArr = this.f5581b.getPackageManager().getPackageInfo(this.e, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    signatureArr = null;
                }
                try {
                    if (signatureArr != null && signatureArr.length > 0) {
                        try {
                            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        } catch (NoSuchAlgorithmException e2) {
                            e2.printStackTrace();
                        }
                        this.f = str2;
                    }
                    this.f = str2;
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (!TextUtils.isEmpty(str2)) {
                    }
                }
                str2 = null;
            }
            str2 = this.f5580a.a(this.e, this.f, str);
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        return !TextUtils.isEmpty(str2) ? "" : str2;
    }
}
