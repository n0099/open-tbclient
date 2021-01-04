package com.baidu.live.liveroom.f;
/* loaded from: classes11.dex */
public class c {
    private static volatile c btd = null;
    private b bte = null;

    private c() {
    }

    public static c Px() {
        if (btd == null) {
            synchronized (c.class) {
                if (btd == null) {
                    btd = new c();
                }
            }
        }
        return btd;
    }

    public b Py() {
        return this.bte;
    }
}
