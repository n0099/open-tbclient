package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a {
    private static a El;
    private c Em;
    private ArrayList<b> En = new ArrayList<>();
    private C0009a Eo;

    /* loaded from: classes.dex */
    public interface c {
        void C(String str, String str2);
    }

    private a() {
    }

    public static a jm() {
        if (El == null) {
            synchronized (a.class) {
                if (El == null) {
                    El = new a();
                }
            }
        }
        return El;
    }

    public void a(ArrayList<b> arrayList, c cVar) {
        boolean z;
        if (arrayList != null && arrayList.size() != 0) {
            this.Em = cVar;
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null && !TextUtils.isEmpty(next.apkPath) && !TextUtils.isEmpty(next.packageName)) {
                    Iterator<b> it2 = this.En.iterator();
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
                        this.En.add(next);
                    }
                }
            }
            jn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jn() {
        if (this.En.size() != 0 && this.Eo == null) {
            this.Eo = new C0009a(this.En.get(0));
            this.Eo.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.plugin.packageManager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0009a extends BdAsyncTask<String, Integer, Boolean> {
        private b Ep;

        public C0009a(b bVar) {
            this.Ep = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            if (this.Ep != null) {
                return Boolean.valueOf(bb(this.Ep.apkPath));
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            a.this.Eo = null;
            if (a.this.En.size() > 0) {
                Iterator it = a.this.En.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b bVar = (b) it.next();
                    if (a.this.a(this.Ep, bVar)) {
                        a.this.En.remove(bVar);
                        break;
                    }
                }
            }
            if (bool != null && bool.booleanValue() && a.this.Em != null) {
                a.this.Em.C(this.Ep.packageName, this.Ep.apkPath);
            }
            a.this.jn();
        }

        private boolean bb(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                com.baidu.adp.lib.util.e.h(new File(str));
                com.baidu.adp.plugin.b.a.jg().e("plugin_del_unuse", "delete_unuse", str, null);
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.jg().e("plugin_del_unuse", "delete_unuse_fail", str, th.getMessage());
            }
            int length = str.length();
            if (length >= 4) {
                File file = new File(str.substring(0, length - 4));
                if (file.exists() && file.isDirectory()) {
                    try {
                        com.baidu.adp.lib.util.e.h(file);
                        com.baidu.adp.plugin.b.a.jg().e("plugin_del_unuse", "delete_unuse", str, null);
                    } catch (Throwable th2) {
                        com.baidu.adp.plugin.b.a.jg().e("plugin_del_unuse", "delete_unuse_fail", str, th2.getMessage());
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
