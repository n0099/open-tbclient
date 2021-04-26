package com.baidu.fsg.base.utils;

import java.util.Random;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class RandomUtils {
    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static int b() {
        return new Random(System.currentTimeMillis() + Thread.currentThread().getId()).nextInt(100) % 3;
    }

    public static String getRandomString(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2 / 32; i3++) {
            stringBuffer.append(a());
        }
        return stringBuffer.toString();
    }
}
