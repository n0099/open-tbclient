package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Boolean, Integer, Boolean> {
    private ad AR = null;
    private h AS;
    final /* synthetic */ a AT;
    private int pos;
    private String tid;

    public b(a aVar, String str, int i) {
        this.AT = aVar;
        this.tid = null;
        this.pos = 0;
        this.AS = null;
        this.tid = str;
        this.pos = i;
        this.AS = new h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Boolean... boolArr) {
        this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_DELSTORE);
        this.AR.o("user_id", TbadkCoreApplication.getCurrentAccount());
        this.AR.o("tid", this.tid);
        this.AS.parserJson(this.AR.oy());
        return this.AR.oZ().qh().ma() && this.AS.getErrorCode() == 0;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.AT.AL = null;
        if (this.AT.AQ != null) {
            this.AT.AQ.callback(2, false, null);
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
        this.AT.AL = null;
        if (bool.booleanValue()) {
            int i2 = this.pos;
            arrayList = this.AT.AM;
            if (i2 < arrayList.size()) {
                arrayList2 = this.AT.AM;
                arrayList2.remove(this.pos);
                a aVar = this.AT;
                i = aVar.AO;
                aVar.AO = i - 1;
            }
        } else if (this.AR.oZ().qh().ma()) {
            str = this.AS.getErrorString();
        } else {
            str = this.AR.getErrorString();
        }
        if (this.AT.AQ != null) {
            this.AT.AQ.callback(2, bool, str);
        }
    }
}
