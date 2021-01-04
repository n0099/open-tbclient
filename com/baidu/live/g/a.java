package com.baidu.live.g;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes11.dex */
public class a {
    private static volatile a aIG;
    private b aIH;

    private a() {
    }

    public static a Ec() {
        if (aIG == null) {
            synchronized (a.class) {
                if (aIG == null) {
                    aIG = new a();
                }
            }
        }
        return aIG;
    }

    public IGuideTab Ed() {
        if (this.aIH != null) {
            return this.aIH.Ee();
        }
        return null;
    }
}
