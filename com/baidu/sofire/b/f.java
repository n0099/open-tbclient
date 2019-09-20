package com.baidu.sofire.b;

import java.util.zip.CRC32;
/* loaded from: classes2.dex */
public final class f {
    public static long a(String str) {
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
}
