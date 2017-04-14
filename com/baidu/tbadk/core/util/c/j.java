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
    public boolean wC() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wD() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        String str3 = String.valueOf(str) + (TbadkCoreApplication.m9getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a fO = com.baidu.tbadk.imageManager.c.EJ().fO(str3);
        if (fO == null) {
            Bitmap cO = aq.cO(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cO == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cO, false, str2);
            com.baidu.tbadk.imageManager.c.EJ().c(str3, aVar);
            return aVar;
        }
        return fO;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wE() {
        return this.procType;
    }
}
