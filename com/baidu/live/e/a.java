package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aHn;
    private b aHo;

    private a() {
    }

    public static a DM() {
        if (aHn == null) {
            synchronized (a.class) {
                if (aHn == null) {
                    aHn = new a();
                }
            }
        }
        return aHn;
    }

    public IGuideTab DN() {
        if (this.aHo != null) {
            return this.aHo.DO();
        }
        return null;
    }
}
