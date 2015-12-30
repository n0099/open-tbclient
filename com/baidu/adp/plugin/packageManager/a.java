package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a DF;
    private c DG;
    private ArrayList<b> DH = new ArrayList<>();
    private C0011a DI;

    /* loaded from: classes.dex */
    public interface c {
        void F(String str, String str2);
    }

    private a() {
    }

    public static a ll() {
        if (DF == null) {
            synchronized (a.class) {
                if (DF == null) {
                    DF = new a();
                }
            }
        }
        return DF;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.DG = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.DH.iterator();
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
                        this.DH.add(next);
                    }
                }
            }
            lm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.DH.size() != 0 && this.DI == null) {
            this.DI = new C0011a(this.DH.get(0));
            this.DI.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0011a extends BdAsyncTask<String, Integer, Boolean> {
        private b DJ;

        public C0011a(b bVar) {
            this.DJ = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            if (this.DJ != null) {
                return Boolean.valueOf(bp(this.DJ.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.DI = null;
            if (a.this.DH.size() > 0) {
                Iterator it = a.this.DH.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.DJ, bVar)) {
                        a.this.DH.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.DG != null) {
                a.this.DG.F(this.DJ.packageName, this.DJ.apkPath);
            }
            a.this.lm();
        }

        private boolean bp(String str) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                com.baidu.adp.lib.util.e.h(new File(str));
                com.baidu.adp.plugin.b.a.lf().d("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.lf().d("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        com.baidu.adp.lib.util.e.h(file);
                        z = true;
                        com.baidu.adp.plugin.b.a.lf().d("plugin_del_unuse", "delete_unuse", str, null);
                        return true;
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.lf().d("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
