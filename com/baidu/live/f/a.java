package com.baidu.live.f;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes10.dex */
public class a {
    private static volatile a aHg;
    private b aHh;

    private a() {
    }

    public static a AU() {
        if (aHg == null) {
            synchronized (a.class) {
                if (aHg == null) {
                    aHg = new a();
                }
            }
        }
        return aHg;
    }

    public IGuideTab AV() {
        if (this.aHh != null) {
            return this.aHh.AW();
        }
        return null;
    }
}
