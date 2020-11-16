package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class h {
    public static boolean gi(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bwS;
    }

    public static boolean gj(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bwO && i < c.bwS;
    }
}
