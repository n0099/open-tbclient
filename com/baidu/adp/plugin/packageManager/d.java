package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    private static volatile d Ec;
    private ArrayList<String> DR = new ArrayList<>();
    private a Ed;

    public static d ju() {
        if (Ec == null) {
            synchronized (d.class) {
                if (Ec == null) {
                    Ec = new d();
                }
            }
        }
        return Ec;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.DR.iterator();
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
                this.DR.add(pluginSetting.packageName);
            }
            jq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jq() {
        if (this.DR.size() > 0 && this.Ed == null) {
            this.Ed = new a(this.DR.get(0));
            this.Ed.execute(new String[0]);
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
                bc(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            d.this.Ed = null;
            if (d.this.DR.size() > 0) {
                Iterator it = d.this.DR.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.DR.remove(str);
                        break;
                    }
                }
            }
            d.this.jq();
        }

        private void bc(String str) {
            File[] listFiles;
            File kj = Util.kj();
            String bC = Util.bC(str);
            if (kj != null && kj.exists() && (listFiles = kj.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bC)) {
                        try {
                            com.baidu.adp.lib.util.e.i(listFiles[i]);
                            com.baidu.adp.plugin.b.a.jj().e("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.jj().f("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
