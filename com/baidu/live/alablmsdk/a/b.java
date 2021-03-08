package com.baidu.live.alablmsdk.a;
/* loaded from: classes10.dex */
public class b {
    public static int u(float f) {
        int ceil = (int) Math.ceil(f);
        if (ceil % 2 == 1) {
            return ceil - 1;
        }
        return ceil;
    }
}
