package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aup;
    private b auq;

    private a() {
    }

    public static a vM() {
        if (aup == null) {
            synchronized (a.class) {
                if (aup == null) {
                    aup = new a();
                }
            }
        }
        return aup;
    }

    public IGuideTab vN() {
        if (this.auq != null) {
            return this.auq.vO();
        }
        return null;
    }
}
