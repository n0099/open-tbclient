package com.baidu.sapi2.dto;
/* loaded from: classes2.dex */
public class GetOneKeyLoginStateDTO {
    public static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    public static long beginTime;
    public int connectTimeout = 15000;

    public GetOneKeyLoginStateDTO() {
        beginTime = System.currentTimeMillis();
    }

    public static int getAfterConnTimeOut(int i2) {
        int i3;
        try {
            i3 = (int) (i2 - (System.currentTimeMillis() - beginTime));
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }
}
