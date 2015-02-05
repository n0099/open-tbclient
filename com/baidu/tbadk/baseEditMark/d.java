package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<a, Integer, Boolean> {
    private ad AO;
    private h AP;
    final /* synthetic */ a AQ;

    private d(a aVar) {
        this.AQ = aVar;
        this.AO = null;
        this.AP = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.AP = new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.kZ();
            this.AO = new ad();
            this.AO.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int la = this.AQ.la();
            if (aVar.getCount() - 1 <= la) {
                la = aVar.getCount() - 1;
            }
            while (la >= 0) {
                String m = aVar.m(la, 20);
                this.AO.r(new ArrayList<>());
                this.AO.o("data", m);
                this.AP.parserJson(this.AO.or());
                if (!this.AO.oS().qa().lT() || this.AP.getErrorCode() != 0) {
                    break;
                }
                la -= 20;
            }
            this.AQ.aO(la);
            if (la >= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.AQ.AG = null;
        if (this.AQ.AN != null) {
            this.AQ.AN.callback(1, false, null, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        String str;
        boolean z;
        ArrayList arrayList;
        this.AQ.AG = null;
        if (bool.booleanValue()) {
            arrayList = this.AQ.AI;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.AO.oS().qa().lT()) {
            str = this.AP.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.AQ.AN != null) {
            this.AQ.AN.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
