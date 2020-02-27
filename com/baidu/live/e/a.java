package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a Xd;
    private b Xe;

    private a() {
    }

    public static a qk() {
        if (Xd == null) {
            synchronized (a.class) {
                if (Xd == null) {
                    Xd = new a();
                }
            }
        }
        return Xd;
    }

    public IGuideTab ql() {
        if (this.Xe != null) {
            return this.Xe.qm();
        }
        return null;
    }
}
