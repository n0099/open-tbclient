package com.baidu.live.e;

import com.baidu.live.adp.widget.IGuideTab;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aws;
    private b awt;

    private a() {
    }

    public static a wg() {
        if (aws == null) {
            synchronized (a.class) {
                if (aws == null) {
                    aws = new a();
                }
            }
        }
        return aws;
    }

    public IGuideTab wh() {
        if (this.awt != null) {
            return this.awt.wi();
        }
        return null;
    }
}
