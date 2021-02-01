package com.baidu.sofire.core;

import java.util.Random;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static String f5234a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        char[] charArray = f5234a.toCharArray();
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[i] = charArray[new Random().nextInt(62)];
        }
        return new String(cArr).getBytes();
    }
}
