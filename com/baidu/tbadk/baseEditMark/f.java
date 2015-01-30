package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Boolean, Integer, Boolean> {
    private ad AR = null;
    private h AS;
    private boolean Ba;
    final /* synthetic */ e Bb;

    public f(e eVar, boolean z) {
        this.Bb = eVar;
        this.Ba = true;
        this.AS = null;
        this.Ba = z;
        this.AS = new h();
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
        if (this.Ba) {
            this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            a aVar = new a();
            markData3 = this.Bb.AX;
            aVar.a(markData3);
            this.AR.o("data", aVar.m(0, 1));
        } else {
            this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
            ad adVar = this.AR;
            markData = this.Bb.AX;
            adVar.o("user_id", markData.getAccount());
            ad adVar2 = this.AR;
            markData2 = this.Bb.AX;
            adVar2.o("tid", markData2.getId());
        }
        this.AS.parserJson(this.AR.oy());
        boolean z = this.AS.getErrorCode() == 0;
        if (this.AR.oZ().qh().ma() && z) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.Bb.AY = null;
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
                gVar4 = this.Bb.AZ;
                if (gVar4 != null) {
                    gVar5 = this.Bb.AZ;
                    gVar5.a(true, this.Ba, null);
                }
            } else {
                gVar = this.Bb.AZ;
                if (gVar != null) {
                    if (this.AR == null || this.AR.oZ().qh().ma()) {
                        gVar2 = this.Bb.AZ;
                        gVar2.a(false, this.Ba, this.AS.getErrorString());
                    } else {
                        gVar3 = this.Bb.AZ;
                        gVar3.a(false, this.Ba, this.AR.getErrorString());
                    }
                }
            }
            this.Bb.AY = null;
        } catch (Throwable th) {
            BdLog.e(th.toString());
        }
    }
}
