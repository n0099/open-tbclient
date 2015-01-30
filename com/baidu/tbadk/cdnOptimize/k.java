package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.core.util.httpNet.ImgHttpClient;
import com.baidu.tbadk.core.util.w;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, ArrayList<String>> {
    final /* synthetic */ h BQ;
    p BR;
    ArrayList<l> ipList;

    public k(h hVar, p pVar) {
        this.BQ = hVar;
        this.BR = null;
        this.BR = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public ArrayList<String> doInBackground(Object... objArr) {
        String str;
        String str2;
        if (this.BR == null || (str = this.BR.BX) == null || str.length() <= 0 || (str2 = this.BR.BY) == null || str2.length() <= 0) {
            return null;
        }
        try {
            String host = new URL(str).getHost();
            if (host != null) {
                if (host.length() > 0) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        Iterator<String> it = this.BR.mobileIpList.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            long currentTimeMillis2 = System.currentTimeMillis();
                            com.baidu.adp.lib.network.http.e eVar = new com.baidu.adp.lib.network.http.e();
                            ImgHttpClient imgHttpClient = new ImgHttpClient(eVar);
                            eVar.dN().setUrl(str);
                            imgHttpClient.e(next, host, 1);
                            byte[] bArr = eVar.dO().kK;
                            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                            boolean z = false;
                            if (bArr != null && str2.equalsIgnoreCase(z.n(bArr))) {
                                z = true;
                            }
                            if (z) {
                                c(next, currentTimeMillis3);
                            }
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < this.ipList.size() && i2 < 4) {
                                arrayList.add(this.ipList.get(i2).ip);
                                i = i2 + 1;
                            }
                        }
                        w.b(arrayList, System.currentTimeMillis() - currentTimeMillis);
                        return arrayList;
                    } catch (Exception e) {
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(ArrayList<String> arrayList) {
        super.onPostExecute(arrayList);
        if (arrayList == null) {
            return;
        }
        this.BQ.m(arrayList);
    }

    private void c(String str, long j) {
        int i;
        if (this.ipList == null) {
            this.ipList = new ArrayList<>();
        }
        l lVar = new l(this, null);
        lVar.ip = str;
        lVar.vD = j;
        if (this.ipList.size() == 0) {
            this.ipList.add(lVar);
        } else if (this.ipList.size() <= 5) {
            int size = this.ipList.size();
            int i2 = 0;
            while (true) {
                i = i2;
                if (i < this.ipList.size()) {
                    if (this.ipList.get(i).vD > j) {
                        break;
                    }
                    i2 = i + 1;
                } else {
                    i = size;
                    break;
                }
            }
            this.ipList.add(i, lVar);
        }
    }
}
