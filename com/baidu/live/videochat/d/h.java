package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes10.dex */
public class h {
    public static boolean fg(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bHk;
    }

    public static boolean fh(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bHg && i < c.bHk;
    }
}
