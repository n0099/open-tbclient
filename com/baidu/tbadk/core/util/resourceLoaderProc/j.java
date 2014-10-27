package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class j extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nk() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean nl() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkApplication.m251getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.sg().dt(str3);
        if (dt == null) {
            Bitmap bA = aw.bA(com.baidu.adp.lib.g.c.f(str2, 0));
            if (bA == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(bA, false, str2);
            com.baidu.tbadk.imageManager.e.sg().c(str3, aVar);
            return aVar;
        }
        return dt;
    }
}
