package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes2.dex */
public class a {
    private static a Vx;
    private b Vy;

    private a() {
    }

    public static a pz() {
        if (Vx == null) {
            synchronized (a.class) {
                if (Vx == null) {
                    Vx = new a();
                }
            }
        }
        return Vx;
    }

    public IGuideTab pA() {
        if (this.Vy != null) {
            return this.Vy.pB();
        }
        return null;
    }
}
