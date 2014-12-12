package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
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
    public boolean qf() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean qg() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m255getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.vL().en(str3);
        if (en == null) {
            Bitmap bX = ax.bX(com.baidu.adp.lib.g.c.toInt(str2, 0));
            if (bX == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(bX, false, str2);
            com.baidu.tbadk.imageManager.e.vL().c(str3, aVar);
            return aVar;
        }
        return en;
    }
}
