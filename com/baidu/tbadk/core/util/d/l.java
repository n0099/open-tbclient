package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class l extends a {
    private int procType;

    public l(int i) {
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btn() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int bto() {
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
        com.baidu.adp.widget.ImageView.a Di = com.baidu.tbadk.imageManager.c.bCP().Di(str3);
        if (Di == null) {
            Bitmap bitmap = ap.getBitmap(com.baidu.adp.lib.f.b.toInt(str2, 0));
            if (bitmap == null) {
                return null;
            }
            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(bitmap, false, str2);
            com.baidu.tbadk.imageManager.c.bCP().b(str3, aVar);
            return aVar;
        }
        return Di;
    }

    @Override // com.baidu.tbadk.core.util.d.a
    public int btp() {
        return this.procType;
    }
}
