package com.baidu.e.a.a;
/* loaded from: classes12.dex */
public final class n {
    public static void notNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(String.format("Argument '%s' cannot be null", str));
        }
    }
}
