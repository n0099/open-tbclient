package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Boolean, Integer, Boolean> {
    private ad AO = null;
    private h AP;
    final /* synthetic */ a AQ;
    private int pos;
    private String tid;

    public b(a aVar, String str, int i) {
        this.AQ = aVar;
        this.tid = null;
        this.pos = 0;
        this.AP = null;
        this.tid = str;
        this.pos = i;
        this.AP = new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
        this.AO.o("user_id", TbadkCoreApplication.getCurrentAccount());
        this.AO.o("tid", this.tid);
        this.AP.parserJson(this.AO.or());
        return this.AO.oS().qa().lT() && this.AP.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.AQ.AH = null;
        if (this.AQ.AN != null) {
            this.AQ.AN.callback(2, false, null);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        String str = null;
        this.AQ.AH = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.AQ.AI;
            if (i2 < arrayList.size()) {
                arrayList2 = this.AQ.AI;
                arrayList2.remove(this.pos);
                a aVar = this.AQ;
                i = aVar.AL;
                aVar.AL = i - 1;
            }
        } else if (this.AO.oS().qa().lT()) {
            str = this.AP.getErrorString();
        } else {
            str = this.AO.getErrorString();
        }
        if (this.AQ.AN != null) {
            this.AQ.AN.callback(2, bool, str);
        }
    }
}
