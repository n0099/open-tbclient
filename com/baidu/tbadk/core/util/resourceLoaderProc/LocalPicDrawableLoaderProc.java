package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import d.a.c.e.m.b;
import d.a.c.j.d.a;
import d.a.j0.a0.c;
/* loaded from: classes3.dex */
public class LocalPicDrawableLoaderProc extends AbstractImageLoaderProc {
    public int procType;

    public LocalPicDrawableLoaderProc(int i2) {
        this.procType = i2;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? SkinManager.nightSufix : "");
        a m = c.k().m(str3);
        if (m == null) {
            Bitmap bitmap = SkinManager.getBitmap(b.d(str2, 0));
            if (bitmap == null) {
                return null;
            }
            a aVar = new a(bitmap, false, str2);
            c.k().d(str3, aVar);
            return aVar;
        }
        return m;
    }
}
