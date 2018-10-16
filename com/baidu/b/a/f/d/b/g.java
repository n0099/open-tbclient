package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class g extends f {
    public static int aau = 11;

    @Override // com.baidu.b.a.f.d.b.f
    public boolean rY() {
        com.baidu.b.a.c.a.a rP = this.aag.rP();
        if (rP.Zw > 0 && !TextUtils.isEmpty(rP.filePath) && rP.Zx == rP.Zw && com.baidu.b.a.h.e.g(rP.filePath, rP.Zx) && com.baidu.b.a.h.e.af(rP.filePath, rP.md5)) {
            this.aag.bs(11);
            return false;
        }
        return sd();
    }
}
