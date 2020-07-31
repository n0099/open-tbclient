package com.baidu.mobads.a;
/* loaded from: classes20.dex */
public class b {
    public static final Boolean a = false;
    public static final Boolean b = false;

    public static double a() {
        try {
            return Double.parseDouble("8.8146");
        } catch (Exception e) {
            return 0.0d;
        }
    }

    public static int b() {
        try {
            return Integer.valueOf("8.8146".split("\\.")[0]).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
