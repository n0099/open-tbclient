package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Uc;
    private c Ud;
    private ArrayList<b> Ue = new ArrayList<>();
    private C0021a Uf;

    /* loaded from: classes.dex */
    public interface c {
        void F(String str, String str2);
    }

    private a() {
    }

    public static a pq() {
        if (Uc == null) {
            synchronized (a.class) {
                if (Uc == null) {
                    Uc = new a();
                }
            }
        }
        return Uc;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Ud = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.Ue.iterator();
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
                        this.Ue.add(next);
                    }
                }
            }
            pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        if (this.Ue.size() != 0 && this.Uf == null) {
            this.Uf = new C0021a(this.Ue.get(0));
            this.Uf.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0021a extends BdAsyncTask<String, Integer, Boolean> {
        private b Ug;

        public C0021a(b bVar) {
            this.Ug = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.Ug != null) {
                return Boolean.valueOf(ct(this.Ug.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0021a) bool);
            a.this.Uf = null;
            if (a.this.Ue.size() > 0) {
                Iterator it = a.this.Ue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Ug, bVar)) {
                        a.this.Ue.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Ud != null) {
                a.this.Ud.F(this.Ug.packageName, this.Ug.apkPath);
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
