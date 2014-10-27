package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<String, String, String> {
    private final String EM;
    private final boolean EN;
    private final boolean EO;
    private final boolean EP;
    final /* synthetic */ ap EQ;
    private final String imageUrl;

    public aq(ap apVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        BdUniqueId bdUniqueId;
        this.EQ = apVar;
        this.imageUrl = str;
        this.EM = str2;
        this.EN = z;
        this.EO = z2;
        this.EP = z3;
        BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType = BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL;
        bdUniqueId = ap.EL;
        setParallel(new BdAsyncTaskParallel(bdAsyncTaskParallelType, bdUniqueId));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        try {
            this.EQ.a(this.imageUrl, this.EM, this.EN, this.EO, this.EP);
        } catch (Throwable th) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
        }
        return null;
    }
}
