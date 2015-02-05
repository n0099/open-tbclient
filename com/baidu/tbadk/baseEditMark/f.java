package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Boolean, Integer, Boolean> {
    private ad AO = null;
    private h AP;
    private boolean AX;
    final /* synthetic */ e AY;

    public f(e eVar, boolean z) {
        this.AY = eVar;
        this.AX = true;
        this.AP = null;
        this.AX = z;
        this.AP = new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        MarkData markData;
        MarkData markData2;
        MarkData markData3;
        if (this.AX) {
            this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            a aVar = new a();
            markData3 = this.AY.AU;
            aVar.a(markData3);
            this.AO.o("data", aVar.m(0, 1));
        } else {
            this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            ad adVar = this.AO;
            markData = this.AY.AU;
            adVar.o("user_id", markData.getAccount());
            ad adVar2 = this.AO;
            markData2 = this.AY.AU;
            adVar2.o("tid", markData2.getId());
        }
        this.AP.parserJson(this.AO.or());
        boolean z = this.AP.getErrorCode() == 0;
        if (this.AO.oS().qa().lT() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.AY.AV = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        try {
            if (bool.booleanValue()) {
                gVar4 = this.AY.AW;
                if (gVar4 != null) {
                    gVar5 = this.AY.AW;
                    gVar5.a(true, this.AX, null);
                }
            } else {
                gVar = this.AY.AW;
                if (gVar != null) {
                    if (this.AO == null || this.AO.oS().qa().lT()) {
                        gVar2 = this.AY.AW;
                        gVar2.a(false, this.AX, this.AP.getErrorString());
                    } else {
                        gVar3 = this.AY.AW;
                        gVar3.a(false, this.AX, this.AO.getErrorString());
                    }
                }
            }
            this.AY.AV = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
