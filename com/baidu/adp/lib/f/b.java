package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public abstract class b {
    public static int a(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                return i;
            }
        }
        return i;
    }
}
