package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes7.dex */
public class a {
    private static volatile a aCz;
    private b aCA;

    private a() {
    }

    public static a Ca() {
        if (aCz == null) {
            synchronized (a.class) {
                if (aCz == null) {
                    aCz = new a();
                }
            }
        }
        return aCz;
    }

    public IGuideTab Cb() {
        if (this.aCA != null) {
            return this.aCA.Cc();
        }
        return null;
    }
}
