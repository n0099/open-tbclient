package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes7.dex */
public class a {
    private static volatile a aCB;
    private b aCC;

    private a() {
    }

    public static a Ca() {
        if (aCB == null) {
            synchronized (a.class) {
                if (aCB == null) {
                    aCB = new a();
                }
            }
        }
        return aCB;
    }

    public IGuideTab Cb() {
        if (this.aCC != null) {
            return this.aCC.Cc();
        }
        return null;
    }
}
