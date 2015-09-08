package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private static volatile c Dn;
    private ArrayList<String> Df = new ArrayList<>();
    private a Do;

    public static c lP() {
        if (Dn == null) {
            synchronized (c.class) {
                if (Dn == null) {
                    Dn = new c();
                }
            }
        }
        return Dn;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Df.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                String next = it.next();
                if (next != null && next.equals(pluginSetting.packageName)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.Df.add(pluginSetting.packageName);
            }
            lL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lL() {
        if (this.Df.size() > 0 && this.Do == null) {
            this.Do = new a(this.Df.get(0));
            this.Do.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private String packageName;

        public a(String str) {
            this.packageName = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            if (this.packageName != null) {
                bk(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            c.this.Do = null;
            if (c.this.Df.size() > 0) {
                Iterator it = c.this.Df.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Df.remove(str);
                        break;
                    }
                }
            }
            c.this.lL();
        }

        private void bk(String str) {
            File[] listFiles;
            File mv = Util.mv();
            String bJ = Util.bJ(str);
            if (mv != null && mv.exists() && (listFiles = mv.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bJ)) {
                        com.baidu.adp.plugin.b.a.lE().g("plugin_del_temp", "todel" + listFiles[i].getName(), str);
                        com.baidu.adp.lib.util.e.f(listFiles[i]);
                    }
                }
            }
        }
    }
}
