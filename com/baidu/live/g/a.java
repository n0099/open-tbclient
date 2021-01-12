package com.baidu.live.g;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes10.dex */
public class a {
    private static volatile a aDT;
    private b aDU;

    private a() {
    }

    public static a Ah() {
        if (aDT == null) {
            synchronized (a.class) {
                if (aDT == null) {
                    aDT = new a();
                }
            }
        }
        return aDT;
    }

    public IGuideTab Ai() {
        if (this.aDU != null) {
            return this.aDU.Aj();
        }
        return null;
    }
}
