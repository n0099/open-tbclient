package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallelType;
/* loaded from: classes.dex */
public final class aw extends BdAsyncTask<String, String, String> {
    final /* synthetic */ av a;
    private final String b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    public aw(av avVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        this.a = avVar;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
        this.f = z3;
        setParallelTag(1);
        setType(BdAsyncTaskParallelType.SERIAL);
    }

    private String a() {
        try {
            this.a.a(this.b, this.c, this.d, this.e, this.f);
        } catch (Throwable th) {
            TiebaStatic.a("", -1004, "pic cache img err: " + th.toString(), (String) null);
        }
        return null;
    }
}
