package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class g extends f {
    public static int aau = 11;

    @Override // com.baidu.b.a.f.d.b.f
    public boolean rV() {
        com.baidu.b.a.c.a.a rM = this.aag.rM();
        if (rM.Zw > 0 && !TextUtils.isEmpty(rM.filePath) && rM.Zx == rM.Zw && com.baidu.b.a.h.e.g(rM.filePath, rM.Zx) && com.baidu.b.a.h.e.af(rM.filePath, rM.md5)) {
            this.aag.bH(11);
            return false;
        }
        return sa();
    }
}
