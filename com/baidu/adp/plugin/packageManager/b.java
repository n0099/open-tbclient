package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, Boolean> {
    private String apkPath;
    final /* synthetic */ a sF;

    public b(a aVar, String str) {
        this.sF = aVar;
        this.apkPath = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        if (this.apkPath != null) {
            aX(this.apkPath);
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
        this.sF.sE = null;
        arrayList = this.sF.sD;
        if (arrayList.size() > 0) {
            arrayList2 = this.sF.sD;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (str != null && str.equals(this.apkPath)) {
                    arrayList3 = this.sF.sD;
                    arrayList3.remove(str);
                    break;
                }
            }
        }
        this.sF.hT();
    }

    private void aX(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.b.a.hN().g("plugin_del_unuse", "delete unuse", str);
            com.baidu.adp.lib.util.commonsio.a.g(new File(str));
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        com.baidu.adp.lib.util.commonsio.a.f(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
