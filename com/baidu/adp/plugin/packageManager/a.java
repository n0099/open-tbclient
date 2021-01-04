package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Ue;
    private c Uf;
    private ArrayList<b> Ug = new ArrayList<>();
    private C0021a Uh;

    /* loaded from: classes.dex */
    public interface c {
        void F(String str, String str2);
    }

    private a() {
    }

    public static a pq() {
        if (Ue == null) {
            synchronized (a.class) {
                if (Ue == null) {
                    Ue = new a();
                }
            }
        }
        return Ue;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Uf = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.Ug.iterator();
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
                        this.Ug.add(next);
                    }
                }
            }
            pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        if (this.Ug.size() != 0 && this.Uh == null) {
            this.Uh = new C0021a(this.Ug.get(0));
            this.Uh.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0021a extends BdAsyncTask<String, Integer, Boolean> {
        private b Ui;

        public C0021a(b bVar) {
            this.Ui = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.Ui != null) {
                return Boolean.valueOf(ct(this.Ui.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0021a) bool);
            a.this.Uh = null;
            if (a.this.Ug.size() > 0) {
                Iterator it = a.this.Ug.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Ui, bVar)) {
                        a.this.Ug.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Uf != null) {
                a.this.Uf.F(this.Ui.packageName, this.Ui.apkPath);
            }
            a.this.pr();
        }

        private boolean ct(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f.forceDelete(new File(str));
                com.baidu.adp.plugin.b.a.pg().f("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.pg().f("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        f.forceDelete(file);
                        com.baidu.adp.plugin.b.a.pg().f("plugin_del_unuse", "delete_unuse", str, null);
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.pg().f("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
