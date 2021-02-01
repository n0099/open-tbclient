package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes11.dex */
public class h {
    public static boolean ff(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bFK;
    }

    public static boolean fg(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bFG && i < c.bFK;
    }
}
