package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class i extends a {
    private static BdAsyncTaskParallel c = null;
    private String a;
    private int b;
    private boolean d;

    public i(boolean z, boolean z2) {
        this.a = null;
        this.b = 0;
        this.d = false;
        float f = TbadkApplication.m252getInst().getApp().getResources().getDisplayMetrics().density;
        this.d = z;
        if (f < 2.0f) {
            this.a = TbConfig.getPhotoSmallAddress();
            this.b = 80;
        } else {
            this.a = TbConfig.getBigPhotoAdress();
            this.b = 110;
        }
        if (z2) {
            this.a = TbConfig.getBigPhotoAdress();
            this.b = 110;
            return;
        }
        this.a = TbConfig.getPhotoSmallAddress();
        this.b = 80;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.h
    public boolean a() {
        return com.baidu.tbadk.core.h.a().d();
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        if (this.d) {
            return null;
        }
        return com.baidu.tbadk.imageManager.e.a().b(str);
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public com.baidu.adp.widget.a.a b(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        if (this.d) {
            return null;
        }
        return super.a(str, str2, aVar, objArr);
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
    public int d() {
        return this.b;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a
    public int e() {
        return this.b;
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

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.a, com.baidu.adp.lib.resourceLoader.h
    public BdAsyncTaskParallel b() {
        if (c == null) {
            c = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL, BdUniqueId.gen());
        }
        return c;
    }
}
