package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a apw;
    private b apx;

    private a() {
    }

    public static a uF() {
        if (apw == null) {
            synchronized (a.class) {
                if (apw == null) {
                    apw = new a();
                }
            }
        }
        return apw;
    }

    public IGuideTab uG() {
        if (this.apx != null) {
            return this.apx.uH();
        }
        return null;
    }
}
