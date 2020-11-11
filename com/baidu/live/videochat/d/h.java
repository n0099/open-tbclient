package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class h {
    public static boolean gm(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.byD;
    }

    public static boolean gn(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.byz && i < c.byD;
    }
}
