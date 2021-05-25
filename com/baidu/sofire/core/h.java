package com.baidu.sofire.core;

import java.util.Random;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f10171a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        char[] charArray = f10171a.toCharArray();
        char[] cArr = new char[16];
        for (int i2 = 0; i2 < 16; i2++) {
            cArr[i2] = charArray[new Random().nextInt(62)];
        }
        return new String(cArr).getBytes();
    }
}
