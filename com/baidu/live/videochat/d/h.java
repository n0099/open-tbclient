package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class h {
    public static boolean gb(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bCp;
    }

    public static boolean gc(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bCk && i < c.bCp;
    }
}
