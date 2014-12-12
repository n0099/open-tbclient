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
    private h AS;
    final /* synthetic */ a AT;
    private int offset;
    private ad AR = null;
    private String AU = null;
    Boolean AV = false;

    public c(a aVar, int i) {
        this.AT = aVar;
        this.offset = 0;
        this.AS = null;
        this.offset = i;
        this.AS = new h();
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
        this.AV = boolArr[0];
        a aVar = new a();
        if (this.AV.booleanValue()) {
            t<String> bV = com.baidu.tbadk.core.a.a.nS().bV("tb.my_bookmarks");
            if (bV != null) {
                publishProgress(bV.get(TbadkCoreApplication.getCurrentAccount()));
            }
            arrayList = this.AT.AM;
            if (arrayList == null) {
                this.AT.AM = new ArrayList();
            } else {
                arrayList2 = this.AT.AM;
                arrayList2.clear();
            }
            this.AT.AN = 0;
        }
        this.AR = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.MARK_GETSTORE);
        this.AR.o("user_id", TbadkCoreApplication.getCurrentAccount());
        z = this.AT.AP;
        if (z) {
            this.AR.o("offset", String.valueOf(0));
        } else {
            this.AR.o("offset", String.valueOf(this.offset));
        }
        this.AR.o("rn", String.valueOf(20));
        this.AU = this.AR.ov();
        this.AS.parserJson(this.AU);
        if (this.AR.oW().pW().ma()) {
            aVar.bC(this.AU);
            if (this.offset == 0 && this.AV.booleanValue()) {
                bE(this.AU);
            }
        }
        return aVar;
    }

    private void bE(String str) {
        t<String> bV;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && (bV = com.baidu.tbadk.core.a.a.nS().bV("tb.my_bookmarks")) != null) {
            bV.a(currentAccount, str, TbConfig.APP_OVERDUR_DRAFT_BOX);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public void onProgressUpdate(String... strArr) {
        ArrayList<MarkData> bD;
        super.onProgressUpdate(strArr);
        String str = strArr[0];
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (str != null) {
            bD = this.AT.bD(str);
            if (this.AV.booleanValue()) {
                this.AT.k(bD);
            } else {
                this.AT.l(bD);
            }
        } else {
            this.AT.k(arrayList);
        }
        this.AT.AQ.callback(0, null, true);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.AR != null) {
            this.AR.dL();
        }
        this.AT.AI = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(a aVar) {
        if (aVar == null) {
            aVar = new a();
        }
        this.AT.AI = null;
        this.AT.AN = aVar.getCount();
        ArrayList<MarkData> le = aVar.le();
        if (this.AV.booleanValue()) {
            if (le != null && le.size() != 0) {
                this.AT.k(le);
            }
        } else {
            this.AT.l(le);
        }
        Iterator<MarkData> it = le.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getNewCounts() > 0) {
                int i2 = i + 1;
                this.AT.aH(i2);
                i = i2;
            }
        }
        if (this.AT.AQ != null) {
            if (this.AR.oW().pW().ma()) {
                this.AT.AQ.callback(0, this.AS.getErrorString(), false);
            } else {
                this.AT.AQ.callback(3, this.AR.getErrorString());
            }
        }
        this.AT.AP = false;
    }
}
