package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a Xn;
    private b Xo;

    private a() {
    }

    public static a qp() {
        if (Xn == null) {
            synchronized (a.class) {
                if (Xn == null) {
                    Xn = new a();
                }
            }
        }
        return Xn;
    }

    public IGuideTab qq() {
        if (this.Xo != null) {
            return this.Xo.qr();
        }
        return null;
    }
}
