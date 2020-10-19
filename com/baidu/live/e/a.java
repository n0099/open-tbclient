package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aGp;
    private b aGq;

    private a() {
    }

    public static a Dm() {
        if (aGp == null) {
            synchronized (a.class) {
                if (aGp == null) {
                    aGp = new a();
                }
            }
        }
        return aGp;
    }

    public IGuideTab Dn() {
        if (this.aGq != null) {
            return this.aGq.Do();
        }
        return null;
    }
}
