package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class l extends a {
    private int procType;

    public l(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bsT() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bsU() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean isFromCDN() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a CT = com.baidu.tbadk.imageManager.c.bCx().CT(str3);
        if (CT == null) {
            Bitmap bitmap = ao.getBitmap(com.baidu.adp.lib.f.b.toInt(str2, 0));
            if (bitmap == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(bitmap, false, str2);
            com.baidu.tbadk.imageManager.c.bCx().b(str3, aVar);
            return aVar;
        }
        return CT;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bsV() {
        return this.procType;
    }
}
