package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes10.dex */
public class h {
    public static boolean fb(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bCb;
    }

    public static boolean fc(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bBX && i < c.bCb;
    }
}
