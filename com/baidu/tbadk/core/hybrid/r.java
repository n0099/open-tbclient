package com.baidu.tbadk.core.hybrid;

import com.baidu.adp.lib.util.BdLog;
import java.math.BigInteger;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class r {
    public static String toMd5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            int length = 32 - bigInteger.length();
            StringBuffer stringBuffer = new StringBuffer();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    stringBuffer.append("0");
                }
            }
            return stringBuffer.append(bigInteger).toString();
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }
}
