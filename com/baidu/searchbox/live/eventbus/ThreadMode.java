package com.baidu.searchbox.live.eventbus;
/* loaded from: classes3.dex */
public class ThreadMode {
    public static final int ASYNC = 4;
    public static final int BACKGROUND = 3;
    public static final int MAIN = 2;
    public static final int POSTING = 1;

    public static boolean isValid(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }
}
