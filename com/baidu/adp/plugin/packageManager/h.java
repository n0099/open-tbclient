package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ g Dt;
    private String packageName;

    public h(g gVar, String str) {
        this.Dt = gVar;
        this.packageName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        if (this.packageName != null) {
            bq(this.packageName);
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        super.onPostExecute(bool);
        this.Dt.Ds = null;
        arrayList = this.Dt.Dj;
        if (arrayList.size() > 0) {
            arrayList2 = this.Dt.Dj;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (str != null && str.equals(this.packageName)) {
                    arrayList3 = this.Dt.Dj;
                    arrayList3.remove(str);
                    break;
                }
            }
        }
        this.Dt.lH();
    }

    private void bq(String str) {
        File[] listFiles;
        File mo = Util.mo();
        String bM = Util.bM(str);
        if (mo != null && mo.exists() && (listFiles = mo.listFiles()) != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bM)) {
                    com.baidu.adp.plugin.b.a.lB().g("plugin_del_temp", "todel" + listFiles[i].getName(), str);
                    com.baidu.adp.lib.util.commonsio.a.g(listFiles[i]);
                }
            }
        }
    }
}
