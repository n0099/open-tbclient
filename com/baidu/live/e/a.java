package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a axx;
    private b axy;

    private a() {
    }

    public static a wC() {
        if (axx == null) {
            synchronized (a.class) {
                if (axx == null) {
                    axx = new a();
                }
            }
        }
        return axx;
    }

    public IGuideTab wD() {
        if (this.axy != null) {
            return this.axy.wE();
        }
        return null;
    }
}
