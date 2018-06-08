package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
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
    public boolean zV() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zW() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.ID().he(str3);
        if (he == null) {
            Bitmap cQ = al.cQ(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cQ == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(cQ, false, str2);
            com.baidu.tbadk.imageManager.c.ID().c(str3, aVar);
            return aVar;
        }
        return he;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int zX() {
        return this.procType;
    }
}
