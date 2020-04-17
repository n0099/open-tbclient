package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a apq;
    private b apr;

    private a() {
    }

    public static a uG() {
        if (apq == null) {
            synchronized (a.class) {
                if (apq == null) {
                    apq = new a();
                }
            }
        }
        return apq;
    }

    public IGuideTab uH() {
        if (this.apr != null) {
            return this.apr.uI();
        }
        return null;
    }
}
