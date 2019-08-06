package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class n extends a {
    private int procType;

    public n(int i) {
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
    public boolean ajU() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean ajV() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a qH = com.baidu.tbadk.imageManager.c.aty().qH(str3);
        if (qH == null) {
            Bitmap ij = am.ij(com.baidu.adp.lib.g.b.f(str2, 0));
            if (ij == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(ij, false, str2);
            com.baidu.tbadk.imageManager.c.aty().c(str3, aVar);
            return aVar;
        }
        return qH;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int ajW() {
        return this.procType;
    }
}
