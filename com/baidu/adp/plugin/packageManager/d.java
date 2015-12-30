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
    private static volatile d DS;
    private ArrayList<String> DH = new ArrayList<>();
    private a DU;

    public static d lq() {
        if (DS == null) {
            synchronized (d.class) {
                if (DS == null) {
                    DS = new d();
                }
            }
        }
        return DS;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.DH.iterator();
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
                this.DH.add(pluginSetting.packageName);
            }
            lm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.DH.size() > 0 && this.DU == null) {
            this.DU = new a(this.DH.get(0));
            this.DU.execute(new String[0]);
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
                bq(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            d.this.DU = null;
            if (d.this.DH.size() > 0) {
                Iterator it = d.this.DH.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.DH.remove(str);
                        break;
                    }
                }
            }
            d.this.lm();
        }

        private void bq(String str) {
            File[] listFiles;
            File lY = Util.lY();
            String bR = Util.bR(str);
            if (lY != null && lY.exists() && (listFiles = lY.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bR)) {
                        try {
                            com.baidu.adp.lib.util.e.h(listFiles[i]);
                            com.baidu.adp.plugin.b.a.lf().d("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.lf().e("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + "-" + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
