package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class f extends a {
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int e() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean h() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
        if (c == null) {
            Bitmap b = com.baidu.tbadk.core.util.d.b(TbadkApplication.m252getInst().getApplicationContext(), com.baidu.adp.lib.e.b.a(str2, 0));
            if (b == null) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(b, false, str2);
            com.baidu.tbadk.imageManager.e.a().b(str, aVar);
            return aVar;
        }
        return c;
    }
}
