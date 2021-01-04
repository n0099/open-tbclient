package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes11.dex */
public class h {
    public static boolean gI(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bGN;
    }

    public static boolean gJ(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bGJ && i < c.bGN;
    }
}
