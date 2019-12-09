package com.baidu.sofire.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class t {
    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        char[] charArray = lowerCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (((byte) "0123456789abcdef".indexOf(charArray[i2 + 1])) | (((byte) "0123456789abcdef".indexOf(charArray[i2])) << 4));
        }
        return bArr;
    }

    public static byte[] a(Context context) {
        byte b;
        String str;
        String str2;
        int a;
        ByteBuffer allocate = ByteBuffer.allocate(32);
        try {
            String f = g.f(context);
            String e = g.e(context);
            if (TextUtils.isEmpty(f) && TextUtils.isEmpty(e)) {
                b = 1;
                str = f;
            } else if (TextUtils.isEmpty(f)) {
                b = 33;
                str = UUID.randomUUID().toString();
            } else if (TextUtils.isEmpty(e)) {
                b = 17;
                str = f;
            } else {
                b = 49;
                str = f;
            }
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                str2 = str + e + uuid;
                new StringBuilder("tdid androidId:").append(str).append(" imei:").append(e).append(" uuid:").append(uuid);
                com.baidu.sofire.b.a();
            } else {
                str2 = "baidu.sofire" + str;
                com.baidu.sofire.b.a();
            }
            byte[] a2 = a(g.a(str2.getBytes(), false));
            if (TextUtils.isEmpty(e)) {
                a = (int) e.a(UUID.randomUUID().toString());
            } else {
                a = (int) e.a(e);
            }
            byte[] a3 = a(a);
            byte[] bArr = new byte[9];
            System.arraycopy(a(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "")), 0, bArr, 0, 9);
            allocate.put(a2);
            allocate.put(a3);
            allocate.put(bArr);
            allocate.put(new byte[]{0, 2});
            allocate.put(new byte[]{b});
        } catch (Throwable th) {
            d.a();
        }
        return allocate.array();
    }
}
