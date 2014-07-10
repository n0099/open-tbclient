package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class an {
    public static String a(String str) {
        String str2 = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer("");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < digest.length) {
                    int i3 = digest[i2];
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    if (i3 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i3));
                    i = i2 + 1;
                } else {
                    str2 = stringBuffer.toString();
                    return stringBuffer.toString();
                }
            }
        } catch (NoSuchAlgorithmException e) {
            String str3 = str2;
            BdLog.e(e.getMessage());
            return str3;
        }
    }
}
