package com.baidu.adp.lib.stats;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ f a;
    private BdStatBase b;

    public l(f fVar, BdStatBase bdStatBase) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        BdUniqueId bdUniqueId;
        BdAsyncTaskParallel bdAsyncTaskParallel2;
        this.a = fVar;
        this.b = null;
        this.b = bdStatBase;
        bdAsyncTaskParallel = fVar.E;
        if (bdAsyncTaskParallel == null) {
            fVar.E = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        bdUniqueId = f.b;
        setTag(bdUniqueId);
        bdAsyncTaskParallel2 = fVar.E;
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
        bdStatSwitchData = this.a.A;
        if (!bdStatSwitchData.inSpecStrategy()) {
            bdStatSwitchData2 = this.a.A;
            if (bdStatSwitchData2.getSpecifiedExpired() > 0) {
                new i(this.a, false).execute(new Object[0]);
            }
        }
    }
}
