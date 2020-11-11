package com.baidu.live.alablmsdk.a;
/* loaded from: classes4.dex */
public class c {
    public static int s(float f) {
        int ceil = (int) Math.ceil(f);
        if (ceil % 2 == 1) {
            return ceil - 1;
        }
        return ceil;
    }
}
