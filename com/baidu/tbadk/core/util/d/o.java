package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class o extends a {
    private int procType;

    public o(int i) {
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
    public boolean aGQ() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean aGR() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a vx = com.baidu.tbadk.imageManager.c.aPO().vx(str3);
        if (vx == null) {
            Bitmap bitmap = am.getBitmap(com.baidu.adp.lib.f.b.toInt(str2, 0));
            if (bitmap == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(bitmap, false, str2);
            com.baidu.tbadk.imageManager.c.aPO().c(str3, aVar);
            return aVar;
        }
        return vx;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int aGS() {
        return this.procType;
    }
}
