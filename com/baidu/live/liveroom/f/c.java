package com.baidu.live.liveroom.f;
/* loaded from: classes10.dex */
public class c {
    private static volatile c bor = null;
    private b bos = null;

    private c() {
    }

    public static c LC() {
        if (bor == null) {
            synchronized (c.class) {
                if (bor == null) {
                    bor = new c();
                }
            }
        }
        return bor;
    }

    public b LD() {
        return this.bos;
    }
}
