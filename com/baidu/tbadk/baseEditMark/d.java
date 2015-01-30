package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<a, Integer, Boolean> {
    private ad AR;
    private h AS;
    final /* synthetic */ a AT;

    private d(a aVar) {
        this.AT = aVar;
        this.AR = null;
        this.AS = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(a aVar, d dVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.AS = new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(a... aVarArr) {
        a aVar = new a();
        try {
            aVar.lg();
            this.AR = new ad();
            this.AR.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_ADDSTORE);
            int lh = this.AT.lh();
            if (aVar.getCount() - 1 <= lh) {
                lh = aVar.getCount() - 1;
            }
            while (lh >= 0) {
                String m = aVar.m(lh, 20);
                this.AR.r(new ArrayList<>());
                this.AR.o("data", m);
                this.AS.parserJson(this.AR.oy());
                if (!this.AR.oZ().qh().ma() || this.AS.getErrorCode() != 0) {
                    break;
                }
                lh -= 20;
            }
            this.AT.aO(lh);
            if (lh >= 0) {
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
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.AT.AJ = null;
        if (this.AT.AQ != null) {
            this.AT.AQ.callback(1, false, null, false);
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
        this.AT.AJ = null;
        if (bool.booleanValue()) {
            arrayList = this.AT.AM;
            arrayList.clear();
            str = null;
            z = false;
        } else if (this.AR.oZ().qh().ma()) {
            str = this.AS.getErrorString();
            z = false;
        } else {
            str = null;
            z = true;
        }
        if (this.AT.AQ != null) {
            this.AT.AQ.callback(1, bool, str, Boolean.valueOf(z));
        }
    }
}
