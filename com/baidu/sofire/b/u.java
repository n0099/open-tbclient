package com.baidu.sofire.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class u {
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
            String e = h.e(context);
            String d = h.d(context);
            if (TextUtils.isEmpty(e) && TextUtils.isEmpty(d)) {
                b = 1;
                str = e;
            } else if (TextUtils.isEmpty(e)) {
                b = 33;
                str = UUID.randomUUID().toString();
            } else if (TextUtils.isEmpty(d)) {
                b = 17;
                str = e;
            } else {
                b = 49;
                str = e;
            }
            if (Build.VERSION.SDK_INT < 23) {
                String uuid = UUID.randomUUID().toString();
                str2 = str + d + uuid;
                new StringBuilder("tdid androidId:").append(str).append(" imei:").append(d).append(" uuid:").append(uuid);
                com.baidu.sofire.b.a();
            } else {
                str2 = "baidu.sofire" + str;
                com.baidu.sofire.b.a();
            }
            byte[] a2 = a(h.a(str2.getBytes(), false));
            if (TextUtils.isEmpty(d)) {
                a = (int) f.a(UUID.randomUUID().toString());
            } else {
                a = (int) f.a(d);
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
            e.a();
        }
        return allocate.array();
    }
}
