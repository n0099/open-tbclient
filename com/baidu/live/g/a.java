package com.baidu.live.g;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes4.dex */
public class a {
    private static volatile a aIk;
    private b aIl;

    private a() {
    }

    public static a EN() {
        if (aIk == null) {
            synchronized (a.class) {
                if (aIk == null) {
                    aIk = new a();
                }
            }
        }
        return aIk;
    }

    public IGuideTab EO() {
        if (this.aIl != null) {
            return this.aIl.EP();
        }
        return null;
    }
}
