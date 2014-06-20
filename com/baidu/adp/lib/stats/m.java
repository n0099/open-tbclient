package com.baidu.adp.lib.stats;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, Void> {
    final /* synthetic */ h a;
    private f b;

    public m(h hVar, f fVar) {
        BdAsyncTaskParallel bdAsyncTaskParallel;
        BdAsyncTaskParallel bdAsyncTaskParallel2;
        this.a = hVar;
        this.b = null;
        this.b = fVar;
        bdAsyncTaskParallel = hVar.x;
        if (bdAsyncTaskParallel == null) {
            hVar.x = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, com.baidu.adp.lib.asyncTask.l.a());
        }
        bdAsyncTaskParallel2 = hVar.x;
        setParallel(bdAsyncTaskParallel2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Object... objArr) {
        this.a.b(this.b);
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
        bdStatSwitchData = this.a.y;
        if (!bdStatSwitchData.inSpecStrategy()) {
            bdStatSwitchData2 = this.a.y;
            if (bdStatSwitchData2.getSpecifiedExpired() > 0) {
                new k(this.a, false).execute(new Object[0]);
            }
        }
    }
}
