package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.core.util.TbErrInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ d a;
    private BdStatBase b;

    public j(d dVar, BdStatBase bdStatBase) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        BdAsyncTaskParallel bdAsyncTaskParallel2;
        this.a = dVar;
        this.b = null;
        this.b = bdStatBase;
        bdAsyncTaskParallel = dVar.D;
        if (bdAsyncTaskParallel == null) {
            dVar.D = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
        }
        setTag(TbErrInfo.ERR_IMG_SEND);
        bdAsyncTaskParallel2 = dVar.D;
        setParallel(bdAsyncTaskParallel2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        this.a.c(this.b);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Void r6) {
        BdStatSwitchData bdStatSwitchData;
        BdStatSwitchData bdStatSwitchData2;
        super.onPostExecute(r6);
        bdStatSwitchData = this.a.z;
        if (!bdStatSwitchData.inSpecStrategy()) {
            bdStatSwitchData2 = this.a.z;
            if (bdStatSwitchData2.getSpecifiedExpired() > 0) {
                new g(this.a, false).execute(new Object[0]);
            }
        }
    }
}
