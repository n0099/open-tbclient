package com.baidu.pass.common;

import android.util.Base64;
import com.baidu.pass.common.a;
/* loaded from: classes8.dex */
public class SecurityUtil {
    public static String md5(byte[] bArr, boolean z) {
        return new a().a(bArr, z);
    }

    public static String base64Encode(byte[] bArr) {
        return new a().a(bArr);
    }

    public static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static byte[] aesEncrypt(String str, String str2, String str3) throws Exception {
        return new a.C0217a().a(str, str2, str3);
    }

    public byte[] aesDecrypt(byte[] bArr, String str, String str2) throws Exception {
        return new a.C0217a().a(bArr, str, str2);
    }
}
