package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.asyncTask.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class h extends a {
    private static BdAsyncTaskParallel c = null;
    private String a;
    private int b;

    public h() {
        this.a = null;
        this.b = 0;
        if (TbadkApplication.m252getInst().getApp().getResources().getDisplayMetrics().density < 2.0f) {
            this.a = TbConfig.getPhotoSmallAddress();
            this.b = 80;
            return;
        }
        this.a = TbConfig.getBigPhotoAdress();
        this.b = 110;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.h
    public boolean a() {
        return com.baidu.tbadk.core.h.a().d();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.a().b(str);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    protected String a(String str, int i, int i2) {
        return String.valueOf(this.a) + str;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.h
    public void a(String str, Object obj, Object... objArr) {
        com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            a.a(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int c() {
        return this.b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int d() {
        return this.b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean e() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean f() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public boolean g() {
        return false;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.h
    public BdAsyncTaskParallel b() {
        if (c == null) {
            c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, l.a());
        }
        return c;
    }
}
