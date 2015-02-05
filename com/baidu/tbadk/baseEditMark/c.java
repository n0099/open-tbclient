package com.baidu.tbadk.baseEditMark;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Boolean, String, a> {
    private h AP;
    final /* synthetic */ a AQ;
    private int offset;
    private ad AO = null;
    private String AR = null;
    Boolean AS = false;

    public c(a aVar, int i) {
        this.AQ = aVar;
        this.offset = 0;
        this.AP = null;
        this.offset = i;
        this.AP = new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public a doInBackground(Boolean... boolArr) {
        boolean z;
        ArrayList arrayList;
        ArrayList arrayList2;
        this.AS = boolArr[0];
        a aVar = new a();
        if (this.AS.booleanValue()) {
            t<String> bQ = com.baidu.tbadk.core.a.a.nO().bQ("tb.my_bookmarks");
            if (bQ != null) {
                publishProgress(bQ.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList = this.AQ.AI;
            if (arrayList == null) {
                this.AQ.AI = new ArrayList();
            } else {
                arrayList2 = this.AQ.AI;
                arrayList2.clear();
            }
            this.AQ.AJ = 0;
        }
        this.AO = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.AO.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.AQ.AM;
        if (z) {
            this.AO.o("offset", String.valueOf(0));
        } else {
            this.AO.o("offset", String.valueOf(this.offset));
        }
        this.AO.o("rn", String.valueOf(20));
        this.AR = this.AO.or();
        this.AP.parserJson(this.AR);
        if (this.AO.oS().qa().lT()) {
            aVar.bx(this.AR);
            if (this.offset == 0 && this.AS.booleanValue()) {
                bz(this.AR);
            }
        }
        return aVar;
    }

    private void bz(String str) {
        t<String> bQ;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && (bQ = com.baidu.tbadk.core.a.a.nO().bQ("tb.my_bookmarks")) != null) {
            bQ.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> by;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            by = this.AQ.by(str);
            if (this.AS.booleanValue()) {
                this.AQ.k(by);
            } else {
                this.AQ.l(by);
            }
        } else {
            this.AQ.k(arrayList);
        }
        this.AQ.AN.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.AQ.AF = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.AQ.AF = null;
        this.AQ.AJ = aVar.getCount();
        ArrayList<MarkData> kX = aVar.kX();
        if (this.AS.booleanValue()) {
            if (kX != null && kX.size() != 0) {
                this.AQ.k(kX);
            }
        } else {
            this.AQ.l(kX);
        }
        Iterator<MarkData> it = kX.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.AQ.aM(i2);
                i = i2;
            }
        }
        if (this.AQ.AN != null) {
            if (this.AO.oS().qa().lT()) {
                this.AQ.AN.callback(0, this.AP.getErrorString(), false);
            } else {
                this.AQ.AN.callback(3, this.AO.getErrorString());
            }
        }
        this.AQ.AM = false;
    }
}
