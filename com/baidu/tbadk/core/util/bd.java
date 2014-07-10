package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
public class bd extends BdAsyncTask<String, String, String> {
    final /* synthetic */ bc a;
    private final String b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;

    public bd(bc bcVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        this.a = bcVar;
        this.b = str;
        this.c = str2;
        this.d = z;
        this.e = z2;
        this.f = z3;
        setParallel(bi.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            this.a.a(this.b, this.c, this.d, this.e, this.f);
        } catch (Throwable th) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
        }
        return null;
    }
}
