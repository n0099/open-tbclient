package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aFC;
    private b aFD;

    private a() {
    }

    public static a Dd() {
        if (aFC == null) {
            synchronized (a.class) {
                if (aFC == null) {
                    aFC = new a();
                }
            }
        }
        return aFC;
    }

    public IGuideTab De() {
        if (this.aFD != null) {
            return this.aFD.Df();
        }
        return null;
    }
}
