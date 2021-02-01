package com.baidu.live.f;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes11.dex */
public class a {
    private static volatile a aFG;
    private b aFH;

    private a() {
    }

    public static a AR() {
        if (aFG == null) {
            synchronized (a.class) {
                if (aFG == null) {
                    aFG = new a();
                }
            }
        }
        return aFG;
    }

    public IGuideTab AS() {
        if (this.aFH != null) {
            return this.aFH.AT();
        }
        return null;
    }
}
