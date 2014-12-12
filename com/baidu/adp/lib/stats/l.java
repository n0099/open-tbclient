package com.baidu.adp.lib.stats;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends BdAsyncTask<Object, Integer, Void> {
    private BdStatBase ml;
    final /* synthetic */ f this$0;

    public l(f fVar, BdStatBase bdStatBase) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        BdUniqueId bdUniqueId;
        BdAsyncTaskParallel bdAsyncTaskParallel2;
        this.this$0 = fVar;
        this.ml = null;
        this.ml = bdStatBase;
        bdAsyncTaskParallel = fVar.mi;
        if (bdAsyncTaskParallel == null) {
            fVar.mi = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
        }
        bdUniqueId = f.lK;
        setTag(bdUniqueId);
        bdAsyncTaskParallel2 = fVar.mi;
        setParallel(bdAsyncTaskParallel2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Object... objArr) {
        this.this$0.c(this.ml);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r6) {
        BdStatSwitchData bdStatSwitchData;
        BdStatSwitchData bdStatSwitchData2;
        super.onPostExecute(r6);
        bdStatSwitchData = this.this$0.md;
        if (!bdStatSwitchData.inSpecStrategy()) {
            bdStatSwitchData2 = this.this$0.md;
            if (bdStatSwitchData2.getSpecifiedExpired() > 0) {
                new i(this.this$0, false).execute(new Object[0]);
            }
        }
    }
}
