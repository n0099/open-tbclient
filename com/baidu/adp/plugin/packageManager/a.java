package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a Dn;
    private c Do;
    private ArrayList<b> Dp = new ArrayList<>();
    private C0010a Dq;

    /* loaded from: classes.dex */
    public interface c {
        void G(String str, String str2);
    }

    private a() {
    }

    public static a lO() {
        if (Dn == null) {
            synchronized (a.class) {
                if (Dn == null) {
                    Dn = new a();
                }
            }
        }
        return Dn;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Do = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.Dp.iterator();
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
                        this.Dp.add(next);
                    }
                }
            }
            lP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP() {
        if (this.Dp.size() != 0 && this.Dq == null) {
            this.Dq = new C0010a(this.Dp.get(0));
            this.Dq.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0010a extends BdAsyncTask<String, Integer, Boolean> {
        private b Dr;

        public C0010a(b bVar) {
            this.Dr = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            if (this.Dr != null) {
                return Boolean.valueOf(bm(this.Dr.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.Dq = null;
            if (a.this.Dp.size() > 0) {
                Iterator it = a.this.Dp.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Dr, bVar)) {
                        a.this.Dp.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Do != null) {
                a.this.Do.G(this.Dr.packageName, this.Dr.apkPath);
            }
            a.this.lP();
        }

        private boolean bm(String str) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                com.baidu.adp.lib.util.e.h(new File(str));
                com.baidu.adp.plugin.b.a.lI().d("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.lI().d("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        com.baidu.adp.lib.util.e.h(file);
                        z = true;
                        com.baidu.adp.plugin.b.a.lI().d("plugin_del_unuse", "delete_unuse", str, null);
                        return true;
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.lI().d("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
                        return z;
                    }
                }
                return false;
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
