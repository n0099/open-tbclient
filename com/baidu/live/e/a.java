package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aDl;
    private b aDm;

    private a() {
    }

    public static a Cp() {
        if (aDl == null) {
            synchronized (a.class) {
                if (aDl == null) {
                    aDl = new a();
                }
            }
        }
        return aDl;
    }

    public IGuideTab Cq() {
        if (this.aDm != null) {
            return this.aDm.Cr();
        }
        return null;
    }
}
