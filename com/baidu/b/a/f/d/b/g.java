package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class g extends f {
    public static int aau = 11;

    @Override // com.baidu.b.a.f.d.b.f
    public boolean rU() {
        com.baidu.b.a.c.a.a rL = this.aag.rL();
        if (rL.Zw > 0 && !TextUtils.isEmpty(rL.filePath) && rL.Zx == rL.Zw && com.baidu.b.a.h.e.g(rL.filePath, rL.Zx) && com.baidu.b.a.h.e.af(rL.filePath, rL.md5)) {
            this.aag.bH(11);
            return false;
        }
        return rZ();
    }
}
