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
    private static volatile c KS;
    private ArrayList<String> KI = new ArrayList<>();
    private a KT;

    public static c mZ() {
        if (KS == null) {
            synchronized (c.class) {
                if (KS == null) {
                    KS = new c();
                }
            }
        }
        return KS;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.KI.iterator();
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
                this.KI.add(pluginSetting.packageName);
            }
            mV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mV() {
        if (this.KI.size() > 0 && this.KT == null) {
            this.KT = new a(this.KI.get(0));
            this.KT.execute(new String[0]);
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
                bR(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            c.this.KT = null;
            if (c.this.KI.size() > 0) {
                Iterator it = c.this.KI.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.KI.remove(str);
                        break;
                    }
                }
            }
            c.this.mV();
        }

        private void bR(String str) {
            File[] listFiles;
            File nO = Util.nO();
            String cr = Util.cr(str);
            if (nO != null && nO.exists() && (listFiles = nO.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(cr)) {
                        try {
                            f.q(listFiles[i]);
                            com.baidu.adp.plugin.b.a.mO().f("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.mO().g("plugin_del_temp", "deltmp_fail", str, listFiles[i].getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
