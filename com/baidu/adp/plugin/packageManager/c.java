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
    private static volatile c Dq;
    private ArrayList<String> Di = new ArrayList<>();
    private a Dr;

    public static c lR() {
        if (Dq == null) {
            synchronized (c.class) {
                if (Dq == null) {
                    Dq = new c();
                }
            }
        }
        return Dq;
    }

    private c() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Di.iterator();
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
                this.Di.add(pluginSetting.packageName);
            }
            lN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN() {
        if (this.Di.size() > 0 && this.Dr == null) {
            this.Dr = new a(this.Di.get(0));
            this.Dr.execute(new String[0]);
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
                bj(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            c.this.Dr = null;
            if (c.this.Di.size() > 0) {
                Iterator it = c.this.Di.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        c.this.Di.remove(str);
                        break;
                    }
                }
            }
            c.this.lN();
        }

        private void bj(String str) {
            File[] listFiles;
            File mx = Util.mx();
            String bJ = Util.bJ(str);
            if (mx != null && mx.exists() && (listFiles = mx.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bJ)) {
                        try {
                            com.baidu.adp.lib.util.e.h(listFiles[i]);
                            com.baidu.adp.plugin.b.a.lG().d("plugin_del_temp", "deltmp_suc" + listFiles[i].getName(), str, null);
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.lG().e("plugin_del_temp", "deltmp_fail" + listFiles[i].getName(), str, th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
