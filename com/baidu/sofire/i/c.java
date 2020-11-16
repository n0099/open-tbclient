package com.baidu.sofire.i;
/* loaded from: classes9.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static long[] f3630a = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            try {
                f3630a[i] = j;
            } catch (Throwable th) {
                e.a();
                return;
            }
        }
    }

    public static String a(String str) {
        byte[] bArr;
        char[] charArray;
        long j = 0;
        if (str != null && str.length() != 0) {
            if (str == null) {
                bArr = "".getBytes();
            } else {
                bArr = new byte[str.length() * 2];
                int i = 0;
                for (char c : str.toCharArray()) {
                    int i2 = i + 1;
                    bArr[i] = (byte) (c & 255);
                    i = i2 + 1;
                    bArr[i2] = (byte) (c >> '\b');
                }
            }
            if (bArr != null) {
                j = -1;
                for (byte b : bArr) {
                    j = (j >> 8) ^ f3630a[(((int) j) ^ b) & 255];
                }
            }
        }
        return Long.toHexString(j);
    }
}
