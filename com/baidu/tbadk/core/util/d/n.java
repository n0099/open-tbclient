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
    public boolean Dr() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean Ds() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a hP = com.baidu.tbadk.imageManager.c.Mq().hP(str3);
        if (hP == null) {
            Bitmap dA = al.dA(com.baidu.adp.lib.g.b.l(str2, 0));
            if (dA == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(dA, false, str2);
            com.baidu.tbadk.imageManager.c.Mq().c(str3, aVar);
            return aVar;
        }
        return hP;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Dt() {
        return this.procType;
    }
}
