package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aGx;
    private b aGy;

    private a() {
    }

    public static a Dt() {
        if (aGx == null) {
            synchronized (a.class) {
                if (aGx == null) {
                    aGx = new a();
                }
            }
        }
        return aGx;
    }

    public IGuideTab Du() {
        if (this.aGy != null) {
            return this.aGy.Dv();
        }
        return null;
    }
}
