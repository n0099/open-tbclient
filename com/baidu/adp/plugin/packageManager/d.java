package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Boolean> {
    private String packageName;
    final /* synthetic */ c sL;

    public d(c cVar, String str) {
        this.sL = cVar;
        this.packageName = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        if (this.packageName != null) {
            bb(this.packageName);
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
        this.sL.sK = null;
        arrayList = this.sL.sG;
        if (arrayList.size() > 0) {
            arrayList2 = this.sL.sG;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (str != null && str.equals(this.packageName)) {
                    arrayList3 = this.sL.sG;
                    arrayList3.remove(str);
                    break;
                }
            }
        }
        this.sL.ia();
    }

    private void bb(String str) {
        File[] listFiles;
        File iE = Util.iE();
        String bx = Util.bx(str);
        if (iE != null && iE.exists() && (listFiles = iE.listFiles()) != null) {
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bx)) {
                    com.baidu.adp.plugin.b.a.hU().g("plugin_del_temp", "todel" + listFiles[i].getName(), str);
                    com.baidu.adp.lib.util.commonsio.a.g(listFiles[i]);
                }
            }
        }
    }
}
