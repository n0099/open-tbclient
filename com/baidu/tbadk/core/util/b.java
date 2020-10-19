package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b {
    public static boolean dZ(Context context) {
        byte[] ea = ea(context);
        return ea == null || ea.length == 0 || Arrays.equals(ea, wo("30819f300d06092a864886f70d010101050003818d0030818902818100b17c8a1a350a202f33e461293638cbf1b6bd481877a87379cd6b99d2ec33aa123d9e16028e94c89a3ea268bd5b055869cd99bf10780e7fafa6254a4471d4d57d36589331e28f66b0044bd8e6cc0cd82dc4fa21f28887776b2094118f859739e8271811894260d9a8f36482fc4e2e9df40dc953e2c2da429ea1101524bce33fd10203010001"));
    }

    private static byte[] ea(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && packageInfo.signatures[0] != null) {
                return aa(packageInfo.signatures[0].toByteArray());
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    private static byte[] aa(byte[] bArr) {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().getEncoded();
        } catch (CertificateException e) {
            BdLog.e(e);
            return null;
        }
    }

    private static byte[] wo(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = (i * 2) + 1;
            bArr[i] = (byte) (Integer.decode("0x" + str.substring(i * 2, i2) + str.substring(i2, i2 + 1)).intValue() & 255);
        }
        return bArr;
    }
}
