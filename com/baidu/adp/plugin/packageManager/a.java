package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a RV;
    private c RW;
    private ArrayList<b> RX = new ArrayList<>();
    private C0027a RY;

    /* loaded from: classes.dex */
    public interface c {
        void F(String str, String str2);
    }

    private a() {
    }

    public static a oh() {
        if (RV == null) {
            synchronized (a.class) {
                if (RV == null) {
                    RV = new a();
                }
            }
        }
        return RV;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.RW = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.RX.iterator();
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
                        this.RX.add(next);
                    }
                }
            }
            oi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi() {
        if (this.RX.size() != 0 && this.RY == null) {
            this.RY = new C0027a(this.RX.get(0));
            this.RY.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0027a extends BdAsyncTask<String, Integer, Boolean> {
        private b RZ;

        public C0027a(b bVar) {
            this.RZ = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.RZ != null) {
                return Boolean.valueOf(cp(this.RZ.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((C0027a) bool);
            a.this.RY = null;
            if (a.this.RX.size() > 0) {
                Iterator it = a.this.RX.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.RZ, bVar)) {
                        a.this.RX.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.RW != null) {
                a.this.RW.F(this.RZ.packageName, this.RZ.apkPath);
            }
            a.this.oi();
        }

        private boolean cp(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f.forceDelete(new File(str));
                com.baidu.adp.plugin.b.a.nX().f("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.nX().f("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        f.forceDelete(file);
                        com.baidu.adp.plugin.b.a.nX().f("plugin_del_unuse", "delete_unuse", str, null);
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.nX().f("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
