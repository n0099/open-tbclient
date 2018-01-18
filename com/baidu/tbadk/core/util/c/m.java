package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class m extends a {
    private int procType;

    public m(int i) {
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
    public boolean Dn() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean Do() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.a.a gy = com.baidu.tbadk.imageManager.c.LP().gy(str3);
        if (gy == null) {
            Bitmap fO = aj.fO(com.baidu.adp.lib.g.b.h(str2, 0));
            if (fO == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(fO, false, str2);
            com.baidu.tbadk.imageManager.c.LP().c(str3, aVar);
            return aVar;
        }
        return gy;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int Dp() {
        return this.procType;
    }
}
