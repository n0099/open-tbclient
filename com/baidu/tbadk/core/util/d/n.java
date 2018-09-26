package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
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
    public boolean Bd() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Be() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a hA = com.baidu.tbadk.imageManager.c.Kg().hA(str3);
        if (hA == null) {
            Bitmap dc = al.dc(com.baidu.adp.lib.g.b.l(str2, 0));
            if (dc == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(dc, false, str2);
            com.baidu.tbadk.imageManager.c.Kg().c(str3, aVar);
            return aVar;
        }
        return hA;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Bf() {
        return this.procType;
    }
}
