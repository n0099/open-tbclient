package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Dk;
    private c Dl;
    private ArrayList<b> Dm = new ArrayList<>();
    private C0009a Dn;

    /* loaded from: classes.dex */
    public interface c {
        void C(String str, String str2);
    }

    private a() {
    }

    public static a jp() {
        if (Dk == null) {
            synchronized (a.class) {
                if (Dk == null) {
                    Dk = new a();
                }
            }
        }
        return Dk;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Dl = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.Dm.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        } else if (a(it2.next(), next)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        this.Dm.add(next);
                    }
                }
            }
            jq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        if (this.Dm.size() != 0 && this.Dn == null) {
            this.Dn = new C0009a(this.Dm.get(0));
            this.Dn.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0009a extends BdAsyncTask<String, Integer, Boolean> {
        private b Do;

        public C0009a(b bVar) {
            this.Do = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.Do != null) {
                return Boolean.valueOf(bg(this.Do.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0009a) bool);
            a.this.Dn = null;
            if (a.this.Dm.size() > 0) {
                Iterator it = a.this.Dm.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Do, bVar)) {
                        a.this.Dm.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Dl != null) {
                a.this.Dl.C(this.Do.packageName, this.Do.apkPath);
            }
            a.this.jq();
        }

        private boolean bg(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                e.j(new File(str));
                com.baidu.adp.plugin.b.a.jj().c("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.jj().c("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        e.j(file);
                        com.baidu.adp.plugin.b.a.jj().c("plugin_del_unuse", "delete_unuse", str, null);
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.jj().c("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                    }
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public String apkPath;
        public String packageName;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str, String str2) {
            this.packageName = str;
            this.apkPath = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b bVar, b bVar2) {
        return (bVar == null || bVar2 == null || TextUtils.isEmpty(bVar2.apkPath) || TextUtils.isEmpty(bVar2.packageName) || TextUtils.isEmpty(bVar.apkPath) || TextUtils.isEmpty(bVar.packageName) || !bVar2.packageName.equals(bVar.packageName) || !bVar2.apkPath.equals(bVar.apkPath)) ? false : true;
    }
}
