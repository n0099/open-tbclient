package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Void, Integer, Boolean> {
    final /* synthetic */ e Dq;

    public f(e eVar) {
        this.Dq = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public Boolean doInBackground(Void... voidArr) {
        ArrayList<File> lK = lK();
        if (lK == null || lK.size() == 0) {
            return false;
        }
        h(lK);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        this.Dq.Dp = null;
    }

    private ArrayList<File> lK() {
        HashMap hashMap;
        HashMap hashMap2;
        ArrayList<File> arrayList = null;
        File mo = Util.mo();
        if (mo != null) {
            String mh = com.baidu.adp.plugin.packageManager.pluginSettings.e.me().mh();
            File[] listFiles = mo.listFiles();
            if (listFiles != null) {
                arrayList = new ArrayList<>();
                for (File file : listFiles) {
                    if (file != null) {
                        String absolutePath = file.getAbsolutePath();
                        BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                        if (!absolutePath.equals(mh) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            if (file.isDirectory()) {
                                hashMap2 = this.Dq.Do;
                                if (hashMap2.get(String.valueOf(absolutePath) + ".apk") == null) {
                                    arrayList.add(file);
                                }
                            } else if (absolutePath.endsWith(".apk")) {
                                hashMap = this.Dq.Do;
                                if (hashMap.get(absolutePath) == null) {
                                    arrayList.add(file);
                                }
                            } else if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                                arrayList.add(file);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void h(ArrayList<File> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next != null) {
                    com.baidu.adp.lib.util.commonsio.a.g(next);
                }
            }
        }
    }
}
