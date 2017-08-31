package com.baidu.sofire.rp.f;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class i {
    private static final String[] a = {"0", "1", "2", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE, "4", "5", "6", NewWriteModel.THREAD_TYPE_LBS, "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String t(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(a[i / 16] + a[i % 16]);
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = new String(str);
            try {
                return t(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
            } catch (Throwable th) {
                b.a();
                return str2;
            }
        } catch (Throwable th2) {
            str2 = "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        try {
            return t(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable th) {
            b.a();
            return "";
        }
    }
}
