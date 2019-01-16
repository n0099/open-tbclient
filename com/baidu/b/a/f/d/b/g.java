package com.baidu.b.a.f.d.b;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class g extends f {
    public static int aaD = 11;

    @Override // com.baidu.b.a.f.d.b.f
    public boolean rY() {
        com.baidu.b.a.c.a.a rP = this.aap.rP();
        if (rP.ZF > 0 && !TextUtils.isEmpty(rP.filePath) && rP.ZG == rP.ZF && com.baidu.b.a.h.e.g(rP.filePath, rP.ZG) && com.baidu.b.a.h.e.ag(rP.filePath, rP.md5)) {
            this.aap.bH(11);
            return false;
        }
        return sd();
    }
}
