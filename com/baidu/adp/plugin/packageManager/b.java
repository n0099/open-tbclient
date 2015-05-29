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
    private c Dl;
    final /* synthetic */ a Dm;

    public b(a aVar, c cVar) {
        this.Dm = aVar;
        this.Dl = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        if (this.Dl != null) {
            return Boolean.valueOf(bp(this.Dl.apkPath));
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        ArrayList arrayList;
        d dVar;
        d dVar2;
        ArrayList arrayList2;
        boolean a;
        ArrayList arrayList3;
        super.onPostExecute(bool);
        this.Dm.Dk = null;
        arrayList = this.Dm.Dj;
        if (arrayList.size() > 0) {
            arrayList2 = this.Dm.Dj;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c cVar = (c) it.next();
                a = this.Dm.a(this.Dl, cVar);
                if (a) {
                    arrayList3 = this.Dm.Dj;
                    arrayList3.remove(cVar);
                    break;
                }
            }
        }
        if (bool != null && bool.booleanValue()) {
            dVar = this.Dm.Di;
            if (dVar != null) {
                dVar2 = this.Dm.Di;
                dVar2.L(this.Dl.packageName, this.Dl.apkPath);
            }
        }
        this.Dm.lH();
    }

    private boolean bp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.adp.plugin.b.a.lB().g("plugin_del_unuse", "delete unuse", str);
        com.baidu.adp.lib.util.commonsio.a.g(new File(str));
        int length = str.length();
        if (length >= 4) {
            File file = new File(str.substring(0, length - 4));
            if (file.exists() && file.isDirectory()) {
                try {
                    com.baidu.adp.lib.util.commonsio.a.f(file);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
