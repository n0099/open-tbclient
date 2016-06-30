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
    private static volatile d uF;
    private a uG;
    private ArrayList<String> uu = new ArrayList<>();

    public static d hF() {
        if (uF == null) {
            synchronized (d.class) {
                if (uF == null) {
                    uF = new d();
                }
            }
        }
        return uF;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.uu.iterator();
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
                this.uu.add(pluginSetting.packageName);
            }
            hB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hB() {
        if (this.uu.size() > 0 && this.uG == null) {
            this.uG = new a(this.uu.get(0));
            this.uG.execute(new String[0]);
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
                bh(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            d.this.uG = null;
            if (d.this.uu.size() > 0) {
                Iterator it = d.this.uu.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.uu.remove(str);
                        break;
                    }
                }
            }
            d.this.hB();
        }

        private void bh(String str) {
            File[] listFiles;
            File iv = Util.iv();
            String bI = Util.bI(str);
            if (iv != null && iv.exists() && (listFiles = iv.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bI)) {
                        try {
                            com.baidu.adp.lib.util.e.g(listFiles[i]);
                            com.baidu.adp.plugin.b.a.hu().e("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.hu().f("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + "-" + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
