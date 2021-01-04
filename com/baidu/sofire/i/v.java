package com.baidu.sofire.i;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.UUID;
/* loaded from: classes15.dex */
public final class v {
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
        byte b2;
        String str;
        String str2;
        int a2;
        ByteBuffer allocate = ByteBuffer.allocate(32);
        try {
            String f = h.f(context);
            String e = h.e(context);
            String cuid = DeviceId.getCUID(context);
            String b3 = com.baidu.sofire.j.a.a().b();
            if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(e) && !TextUtils.isEmpty(cuid) && !TextUtils.isEmpty(b3)) {
                b2 = 61;
                str = f;
            } else {
                b2 = TextUtils.isEmpty(e) ? (byte) 17 : (byte) 1;
                if (TextUtils.isEmpty(f)) {
                    str = UUID.randomUUID().toString();
                    b2 = (byte) (b2 + 32);
                } else {
                    str = f;
                }
                if (TextUtils.isEmpty(cuid)) {
                    b2 = (byte) (b2 + 4);
                }
                if (TextUtils.isEmpty(b3)) {
                    b2 = (byte) (b2 + 8);
                }
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(e) && TextUtils.isEmpty(cuid) && TextUtils.isEmpty(b3)) {
                    b2 = 1;
                }
            }
            if (Build.VERSION.SDK_INT < 23) {
                str2 = str + e + UUID.randomUUID().toString();
            } else {
                str2 = "baidu.sofire" + str;
            }
            byte[] a3 = a(h.a(str2.getBytes(), false));
            if (!TextUtils.isEmpty(e) || !TextUtils.isEmpty(cuid)) {
                if (!TextUtils.isEmpty(e)) {
                    a2 = (int) f.a(e);
                } else {
                    a2 = !TextUtils.isEmpty(cuid) ? (int) f.a(cuid) : 0;
                }
            } else {
                a2 = (int) f.a(UUID.randomUUID().toString());
            }
            byte[] a4 = a(a2);
            byte[] bArr = new byte[9];
            if (TextUtils.isEmpty(b3)) {
                System.arraycopy(a(UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "")), 0, bArr, 0, 9);
            } else {
                System.arraycopy(a(c.a(b3.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""))), 0, bArr, 0, 8);
                bArr[8] = (byte) new Random().nextInt(127);
            }
            allocate.put(a3);
            allocate.put(a4);
            allocate.put(bArr);
            allocate.put(new byte[]{0, 3});
            allocate.put(new byte[]{b2});
        } catch (Throwable th) {
            e.a();
        }
        return allocate.array();
    }
}
