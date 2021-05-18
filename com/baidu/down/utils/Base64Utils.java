package com.baidu.down.utils;

import android.util.Base64;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public class Base64Utils {
    public static String encode(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : new String(Base64.encode(bArr, 0), Charset.forName("UTF-8"));
    }
}
