package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {
    private static volatile c Rs;
    private ArrayList<String> Rj = new ArrayList<>();
    private a Rt;

    public static c nT() {
        if (Rs == null) {
            synchronized (c.class) {
                if (Rs == null) {
                    Rs = new c();
                }
            }
        }
        return Rs;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Rj.iterator();
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
                this.Rj.add(pluginSetting.packageName);
            }
            nP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP() {
        if (this.Rj.size() > 0 && this.Rt == null) {
            this.Rt = new a(this.Rj.get(0));
            this.Rt.execute(new String[0]);
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
        public Boolean doInBackground(String... strArr) {
            if (this.packageName != null) {
                co(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.Rt = null;
            if (c.this.Rj.size() > 0) {
                Iterator it = c.this.Rj.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Rj.remove(str);
                        break;
                    }
                }
            }
            c.this.nP();
        }

        private void co(String str) {
            File[] listFiles;
            File oJ = Util.oJ();
            String cM = Util.cM(str);
            if (oJ != null && oJ.exists() && (listFiles = oJ.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(cM)) {
                        try {
                            f.forceDelete(listFiles[i]);
                            com.baidu.adp.plugin.b.a.nF().f("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.nF().h("plugin_del_temp", "deltmp_fail", str, listFiles[i].getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
