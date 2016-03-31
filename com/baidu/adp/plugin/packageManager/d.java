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
    private static volatile d El;
    private ArrayList<String> Ea = new ArrayList<>();
    private a Em;

    public static d lq() {
        if (El == null) {
            synchronized (d.class) {
                if (El == null) {
                    El = new d();
                }
            }
        }
        return El;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Ea.iterator();
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
                this.Ea.add(pluginSetting.packageName);
            }
            lm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm() {
        if (this.Ea.size() > 0 && this.Em == null) {
            this.Em = new a(this.Ea.get(0));
            this.Em.execute(new String[0]);
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
        /* renamed from: m */
        public Boolean doInBackground(String... strArr) {
            if (this.packageName != null) {
                bo(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            d.this.Em = null;
            if (d.this.Ea.size() > 0) {
                Iterator it = d.this.Ea.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.Ea.remove(str);
                        break;
                    }
                }
            }
            d.this.lm();
        }

        private void bo(String str) {
            File[] listFiles;
            File me = Util.me();
            String bP = Util.bP(str);
            if (me != null && me.exists() && (listFiles = me.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bP)) {
                        try {
                            com.baidu.adp.lib.util.e.g(listFiles[i]);
                            com.baidu.adp.plugin.b.a.lf().e("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.lf().f("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + "-" + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
