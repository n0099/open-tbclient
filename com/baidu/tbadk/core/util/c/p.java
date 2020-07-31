package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class p extends a {
    private int procType;

    public p(int i) {
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
    public boolean bbj() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public boolean bbk() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.c.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a zV = com.baidu.tbadk.imageManager.c.bkk().zV(str3);
        if (zV == null) {
            Bitmap bitmap = ao.getBitmap(com.baidu.adp.lib.f.b.toInt(str2, 0));
            if (bitmap == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(bitmap, false, str2);
            com.baidu.tbadk.imageManager.c.bkk().c(str3, aVar);
            return aVar;
        }
        return zV;
    }

    @Override // com.baidu.tbadk.core.util.c.a
    public int bbl() {
        return this.procType;
    }
}
