package com.baidu.android.nebula.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f639a = k.class.getSimpleName();
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private k() {
    }

    public static long a(String str) {
        long j = 0;
        if (str == null || str.length() < 32) {
            return -1L;
        }
        String substring = str.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return (j + j2) & Util.MAX_32BIT_VALUE;
    }

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static s a(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(64);
        s sVar = new s();
        for (PackageInfo packageInfo : installedPackages) {
            a aVar = new a();
            aVar.a(packageInfo.versionCode);
            aVar.b(packageInfo.packageName);
            aVar.a(a(packageInfo.packageName, packageInfo.versionCode));
            aVar.a(a(a(packageInfo.signatures[0].toCharsString().getBytes())));
            sVar.a(packageInfo.packageName, aVar);
        }
        return sVar;
    }

    public static String a(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("@").append(i);
        return sb.toString();
    }

    public static String a(String str, String str2, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str).append(str2).append(j);
        return a(stringBuffer.toString().getBytes()).toLowerCase();
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return b(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static a b(Context context, String str) {
        a aVar = new a();
        aVar.b(str);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.a(packageInfo.versionCode);
            aVar.a(a(a(packageInfo.signatures[0].toCharsString().getBytes())));
            return aVar;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(b[(bArr[i] & 240) >>> 4]);
            sb.append(b[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
