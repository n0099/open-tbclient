package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<String, String, String> {
    private final String IY;
    private final boolean IZ;
    private final boolean Ja;
    private final boolean Jb;
    final /* synthetic */ aq Jc;
    private final String imageUrl;

    public ar(aq aqVar, String str, String str2, boolean z, boolean z2, boolean z3) {
        BdUniqueId bdUniqueId;
        this.Jc = aqVar;
        this.imageUrl = str;
        this.IY = str2;
        this.IZ = z;
        this.Ja = z2;
        this.Jb = z3;
        BdAsyncTaskParallel.BdAsyncTaskParallelType bdAsyncTaskParallelType = BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL;
        bdUniqueId = aq.IX;
        setParallel(new BdAsyncTaskParallel(bdAsyncTaskParallelType, bdUniqueId));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: l */
    public String doInBackground(String... strArr) {
        try {
            this.Jc.a(this.imageUrl, this.IY, this.IZ, this.Ja, this.Jb);
        } catch (Throwable th) {
            TiebaStatic.imgError("", TbErrInfo.ERR_IMG_CACHE, "pic cache img err: " + th.toString(), null);
        }
        return null;
    }
}
