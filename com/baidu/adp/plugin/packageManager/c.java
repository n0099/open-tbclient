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
    private static volatile c Dp;
    private ArrayList<String> Dh = new ArrayList<>();
    private a Dq;

    public static c lQ() {
        if (Dp == null) {
            synchronized (c.class) {
                if (Dp == null) {
                    Dp = new c();
                }
            }
        }
        return Dp;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Dh.iterator();
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
                this.Dh.add(pluginSetting.packageName);
            }
            lM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM() {
        if (this.Dh.size() > 0 && this.Dq == null) {
            this.Dq = new a(this.Dh.get(0));
            this.Dq.execute(new String[0]);
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
            c.this.Dq = null;
            if (c.this.Dh.size() > 0) {
                Iterator it = c.this.Dh.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Dh.remove(str);
                        break;
                    }
                }
            }
            c.this.lM();
        }

        private void bl(String str) {
            File[] listFiles;
            File mw = Util.mw();
            String bL = Util.bL(str);
            if (mw != null && mw.exists() && (listFiles = mw.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bL)) {
                        try {
                            com.baidu.adp.lib.util.e.h(listFiles[i]);
                            com.baidu.adp.plugin.b.a.lF().d("plugin_del_temp", "deltmp_suc" + listFiles[i].getName(), str, null);
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.lF().e("plugin_del_temp", "deltmp_fail" + listFiles[i].getName(), str, th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
