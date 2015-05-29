package com.baidu.adp.lib.stats.switchs;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ a this$0;

    private e(a aVar) {
        this.this$0 = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ e(a aVar, e eVar) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public BdStatSwitchData doInBackground(Object... objArr) {
        f fVar;
        boolean z;
        f fVar2;
        boolean aE;
        f fVar3;
        String hE;
        f fVar4;
        f fVar5;
        f fVar6;
        f fVar7;
        f fVar8;
        BdStatSwitchData bdStatSwitchData = new BdStatSwitchData();
        fVar = this.this$0.xi;
        if (fVar.it()) {
            fVar8 = this.this$0.xi;
            bdStatSwitchData.parserJson(fVar8.xl);
        }
        this.this$0.xe = false;
        z = this.this$0.wu;
        if (z) {
            a aVar = this.this$0;
            fVar2 = this.this$0.xi;
            aE = aVar.aE(fVar2.xl);
            if (aE) {
                fVar3 = this.this$0.xi;
                hE = this.this$0.hE();
                fVar3.xl = hE;
                fVar4 = this.this$0.xi;
                if (!TextUtils.isEmpty(fVar4.xl)) {
                    this.this$0.xe = true;
                    fVar5 = this.this$0.xi;
                    bdStatSwitchData.parserJson(fVar5.xl);
                    fVar6 = this.this$0.xi;
                    fVar7 = this.this$0.xi;
                    fVar6.aF(fVar7.xl);
                }
            }
        }
        return bdStatSwitchData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        boolean z;
        boolean z2;
        super.onPostExecute(bdStatSwitchData);
        if (bdStatSwitchData != null) {
            this.this$0.xh = bdStatSwitchData;
            z = this.this$0.wu;
            if (z) {
                z2 = this.this$0.xe;
                if (z2) {
                    this.this$0.ir();
                }
            }
            if (this.this$0.xj != null) {
                this.this$0.xj.is();
            }
        }
    }
}
