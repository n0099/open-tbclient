package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public final class ay extends BdAsyncTask<String, String, String> {
    private e a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    public ay(e eVar) {
        this.a = null;
        this.a = eVar;
        setParallelTag(1);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [byte[], java.lang.String] */
    private String a() {
        try {
            if (!this.a.p) {
                if (this.a.d == 4) {
                    if (this.a.k != null) {
                        bb.a().a(this.a.k, this.a.j);
                    }
                } else if (this.a.d == 5) {
                    com.baidu.tbadk.core.c.a.b(this.a.l, this.a.e);
                } else if (this.a.d == 7) {
                    bb.a();
                    String str = this.a.k;
                    byte[] bArr = this.a.j;
                    if (!TextUtils.isEmpty(str)) {
                        w.a(w.a(3), str, bArr);
                    }
                } else if (this.a.k != null) {
                    com.baidu.adp.lib.cache.s<String> x = com.baidu.tbadk.core.c.b.a().x();
                    if (x != null && this.a.h) {
                        x.a(this.a.l, "gif", 315532800000L);
                    }
                    bb.a().a(this.a.k, this.a.j);
                }
            }
        } catch (Throwable th) {
            try {
                TiebaStatic.a("", -1004, "cache img err: " + th.toString(), this.a.m);
            } finally {
                this.a.j = null;
                this.a.m = null;
            }
        }
        return null;
    }
}
