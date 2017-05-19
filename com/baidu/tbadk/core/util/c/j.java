package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class j extends a {
    private int procType;

    public j(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vR() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fL = com.baidu.tbadk.imageManager.c.DN().fL(str3);
        if (fL == null) {
            Bitmap cL = aq.cL(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cL == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cL, false, str2);
            com.baidu.tbadk.imageManager.c.DN().c(str3, aVar);
            return aVar;
        }
        return fL;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vS() {
        return this.procType;
    }
}
