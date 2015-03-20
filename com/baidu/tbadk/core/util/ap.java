package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<String, String, String> {
    private final String UO;
    private final boolean UQ;
    private final boolean UR;
    private final boolean US;
    final /* synthetic */ ao UT;
    private final String imageUrl;

    public ap(ao aoVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        BdUniqueId bdUniqueId;
        this.UT = aoVar;
        this.imageUrl = str;
        this.UO = str2;
        this.UQ = z;
        this.UR = z2;
        this.US = z3;
        BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType = BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL;
        bdUniqueId = ao.UN;
        setParallel(new BdAsyncTaskParallel(bdAsyncTaskParallelType, bdUniqueId));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String doInBackground(String... strArr) {
        try {
            this.UT.a(this.imageUrl, this.UO, this.UQ, this.UR, this.US);
        } catch (Throwable th) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
        }
        return null;
    }
}
