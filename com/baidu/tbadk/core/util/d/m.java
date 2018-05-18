package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends a {
    private int procType;

    public m(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wu() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean wv() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.EY().gG(str3);
        if (gG == null) {
            Bitmap cO = ak.cO(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cO == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(cO, false, str2);
            com.baidu.tbadk.imageManager.c.EY().c(str3, aVar);
            return aVar;
        }
        return gG;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ww() {
        return this.procType;
    }
}
