package com.baidu.adp.lib.g;

import java.util.Random;
/* loaded from: classes.dex */
public class c {
    private static Random a = new Random();

    public static String a() {
        try {
            return Long.toHexString(Math.abs(a.nextLong()));
        } catch (Exception e) {
            return Long.toHexString(System.currentTimeMillis());
        }
    }
}
