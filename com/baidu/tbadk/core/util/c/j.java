package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
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
    public boolean vP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean vQ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DT().gh(str3);
        if (gh == null) {
            Bitmap cQ = aj.cQ(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cQ == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(cQ, false, str2);
            com.baidu.tbadk.imageManager.c.DT().c(str3, aVar);
            return aVar;
        }
        return gh;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int vR() {
        return this.procType;
    }
}
