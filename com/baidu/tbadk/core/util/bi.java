package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class bi extends BdAsyncTask<String, String, String> {
    public static final BdAsyncTaskParallel a = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
    private e b;

    public bi(e eVar) {
        this.b = null;
        this.b = eVar;
        setParallel(a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r5v0, types: [byte[], java.lang.String] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            if (!this.b.p) {
                if (this.b.d == 4) {
                    if (this.b.k != null) {
                        bl.a().a(this.b.k, this.b.j);
                    }
                } else if (this.b.d == 5) {
                    com.baidu.tbadk.core.a.a.b(this.b.l, this.b.e);
                } else if (this.b.d == 7) {
                    bl.a().b(this.b.k, this.b.j);
                } else if (this.b.k != null) {
                    com.baidu.adp.lib.cache.s<String> A = com.baidu.tbadk.core.a.b.a().A();
                    if (A != null && this.b.h) {
                        A.a(this.b.l, "gif", 315532800000L);
                    }
                    bl.a().a(this.b.k, this.b.j);
                }
            }
        } catch (Throwable th) {
            try {
                TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "cache img err: " + th.toString(), this.b.m);
            } finally {
                this.b.j = null;
                this.b.m = null;
            }
        }
        return null;
    }
}
