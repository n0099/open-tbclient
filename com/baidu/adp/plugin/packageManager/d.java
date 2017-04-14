package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private static volatile d DZ;
    private ArrayList<String> DO = new ArrayList<>();
    private a Ea;

    public static d jv() {
        if (DZ == null) {
            synchronized (d.class) {
                if (DZ == null) {
                    DZ = new d();
                }
            }
        }
        return DZ;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.DO.iterator();
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
                this.DO.add(pluginSetting.packageName);
            }
            jr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jr() {
        if (this.DO.size() > 0 && this.Ea == null) {
            this.Ea = new a(this.DO.get(0));
            this.Ea.execute(new String[0]);
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
        /* renamed from: n */
        public Boolean doInBackground(String... strArr) {
            if (this.packageName != null) {
                aX(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            d.this.Ea = null;
            if (d.this.DO.size() > 0) {
                Iterator it = d.this.DO.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.DO.remove(str);
                        break;
                    }
                }
            }
            d.this.jr();
        }

        private void aX(String str) {
            File[] listFiles;
            File kl = Util.kl();
            String bx = Util.bx(str);
            if (kl != null && kl.exists() && (listFiles = kl.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bx)) {
                        try {
                            com.baidu.adp.lib.util.e.h(listFiles[i]);
                            com.baidu.adp.plugin.b.a.jk().e("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.jk().f("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + "-" + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
