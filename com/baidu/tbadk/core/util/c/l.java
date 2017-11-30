package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class l extends a {
    private int procType;

    public l(int i) {
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
    public boolean wa() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean wb() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ez().gt(str3);
        if (gt == null) {
            Bitmap cR = aj.cR(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cR == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(cR, false, str2);
            com.baidu.tbadk.imageManager.c.Ez().c(str3, aVar);
            return aVar;
        }
        return gt;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int wc() {
        return this.procType;
    }
}
