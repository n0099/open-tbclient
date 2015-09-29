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
    private static volatile c Do;
    private ArrayList<String> Dg = new ArrayList<>();
    private a Dp;

    public static c lQ() {
        if (Do == null) {
            synchronized (c.class) {
                if (Do == null) {
                    Do = new c();
                }
            }
        }
        return Do;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Dg.iterator();
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
                this.Dg.add(pluginSetting.packageName);
            }
            lM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM() {
        if (this.Dg.size() > 0 && this.Dp == null) {
            this.Dp = new a(this.Dg.get(0));
            this.Dp.execute(new String[0]);
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
                bl(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            c.this.Dp = null;
            if (c.this.Dg.size() > 0) {
                Iterator it = c.this.Dg.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Dg.remove(str);
                        break;
                    }
                }
            }
            c.this.lM();
        }

        private void bl(String str) {
            File[] listFiles;
            File mw = Util.mw();
            String bK = Util.bK(str);
            if (mw != null && mw.exists() && (listFiles = mw.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bK)) {
                        com.baidu.adp.plugin.b.a.lF().g("plugin_del_temp", "todel" + listFiles[i].getName(), str);
                        com.baidu.adp.lib.util.e.f(listFiles[i]);
                    }
                }
            }
        }
    }
}
