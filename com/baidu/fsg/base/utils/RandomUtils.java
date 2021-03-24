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

    public static String getRandomString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i / 32; i2++) {
            stringBuffer.append(a());
        }
        return stringBuffer.toString();
    }
}
