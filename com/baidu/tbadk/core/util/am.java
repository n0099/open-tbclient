package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class am extends BdAsyncTask<String, String, String> {
    private final String Vs;
    private final boolean Vt;
    private final boolean Vu;
    private final boolean Vv;
    final /* synthetic */ al Vw;
    private final String imageUrl;

    public am(al alVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        BdUniqueId bdUniqueId;
        this.Vw = alVar;
        this.imageUrl = str;
        this.Vs = str2;
        this.Vt = z;
        this.Vu = z2;
        this.Vv = z3;
        BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType = BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL;
        bdUniqueId = al.Vr;
        setParallel(new BdAsyncTaskParallel(bdAsyncTaskParallelType, bdUniqueId));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        try {
            this.Vw.a(this.imageUrl, this.Vs, this.Vt, this.Vu, this.Vv);
        } catch (Throwable th) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
        }
        return null;
    }
}
