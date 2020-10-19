package com.baidu.live.videochat.d;

import com.baidu.live.adp.lib.util.BdLog;
/* loaded from: classes4.dex */
public class h {
    public static boolean fW(int i) {
        BdLog.e("chatStatus=" + i);
        return i == c.bzt;
    }

    public static boolean fX(int i) {
        BdLog.e("chatStatus=" + i);
        return i > c.bzo && i < c.bzt;
    }
}
