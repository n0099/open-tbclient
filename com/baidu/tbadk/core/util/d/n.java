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
    public boolean zY() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public boolean zZ() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.util.d.a, com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? "_1" : "");
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(str3);
        if (he == null) {
            Bitmap cT = am.cT(com.baidu.adp.lib.g.b.g(str2, 0));
            if (cT == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(cT, false, str2);
            com.baidu.tbadk.imageManager.c.IQ().c(str3, aVar);
            return aVar;
        }
        return he;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int Aa() {
        return this.procType;
    }
}
