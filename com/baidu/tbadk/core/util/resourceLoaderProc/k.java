package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class k extends a {
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
    public boolean ue() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean uf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m411getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a eL = com.baidu.tbadk.imageManager.e.Am().eL(str3);
        if (eL == null) {
            Bitmap ck = ay.ck(com.baidu.adp.lib.g.c.toInt(str2, 0));
            if (ck == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(ck, false, str2);
            com.baidu.tbadk.imageManager.e.Am().c(str3, aVar);
            return aVar;
        }
        return eL;
    }
}
