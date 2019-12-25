package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes2.dex */
public class a {
    private static a Vh;
    private b Vi;

    private a() {
    }

    public static a pv() {
        if (Vh == null) {
            synchronized (a.class) {
                if (Vh == null) {
                    Vh = new a();
                }
            }
        }
        return Vh;
    }

    public IGuideTab pw() {
        if (this.Vi != null) {
            return this.Vi.px();
        }
        return null;
    }
}
