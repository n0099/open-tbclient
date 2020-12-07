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
    private static volatile c Un;
    private ArrayList<String> Ue = new ArrayList<>();
    private a Uo;

    public static c pT() {
        if (Un == null) {
            synchronized (c.class) {
                if (Un == null) {
                    Un = new c();
                }
            }
        }
        return Un;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Ue.iterator();
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
                this.Ue.add(pluginSetting.packageName);
            }
            pP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP() {
        if (this.Ue.size() > 0 && this.Uo == null) {
            this.Uo = new a(this.Ue.get(0));
            this.Uo.execute(new String[0]);
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
                cB(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.Uo = null;
            if (c.this.Ue.size() > 0) {
                Iterator it = c.this.Ue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Ue.remove(str);
                        break;
                    }
                }
            }
            c.this.pP();
        }

        private void cB(String str) {
            File[] listFiles;
            File qH = Util.qH();
            String cZ = Util.cZ(str);
            if (qH != null && qH.exists() && (listFiles = qH.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(cZ)) {
                        try {
                            f.forceDelete(listFiles[i]);
                            com.baidu.adp.plugin.b.a.pF().f("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.pF().h("plugin_del_temp", "deltmp_fail", str, listFiles[i].getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
