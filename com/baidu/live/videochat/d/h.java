package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class h {
    public static boolean gH(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bCa;
    }

    public static boolean gI(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bBW && i < c.bCa;
    }
}
