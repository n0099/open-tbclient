package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Fo;
    private c Fp;
    private ArrayList<b> Fq = new ArrayList<>();
    private C0010a Fr;

    /* loaded from: classes.dex */
    public interface c {
        void C(String str, String str2);
    }

    private a() {
    }

    public static a jx() {
        if (Fo == null) {
            synchronized (a.class) {
                if (Fo == null) {
                    Fo = new a();
                }
            }
        }
        return Fo;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Fp = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.Fq.iterator();
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
                        this.Fq.add(next);
                    }
                }
            }
            jy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jy() {
        if (this.Fq.size() != 0 && this.Fr == null) {
            this.Fr = new C0010a(this.Fq.get(0));
            this.Fr.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0010a extends BdAsyncTask<String, Integer, Boolean> {
        private b Fs;

        public C0010a(b bVar) {
            this.Fs = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.Fs != null) {
                return Boolean.valueOf(bj(this.Fs.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0010a) bool);
            a.this.Fr = null;
            if (a.this.Fq.size() > 0) {
                Iterator it = a.this.Fq.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Fs, bVar)) {
                        a.this.Fq.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Fp != null) {
                a.this.Fp.C(this.Fs.packageName, this.Fs.apkPath);
            }
            a.this.jy();
        }

        private boolean bj(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                e.i(new File(str));
                com.baidu.adp.plugin.b.a.jr().e("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.jr().e("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        e.i(file);
                        com.baidu.adp.plugin.b.a.jr().e("plugin_del_unuse", "delete_unuse", str, null);
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.jr().e("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
