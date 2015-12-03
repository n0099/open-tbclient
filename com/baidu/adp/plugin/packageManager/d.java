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
    private static volatile d DA;
    private a DC;
    private ArrayList<String> Dp = new ArrayList<>();

    public static d lT() {
        if (DA == null) {
            synchronized (d.class) {
                if (DA == null) {
                    DA = new d();
                }
            }
        }
        return DA;
    }

    private d() {
    }

    public void a(PluginSetting pluginSetting) {
        boolean z;
        if (pluginSetting != null && !TextUtils.isEmpty(pluginSetting.packageName)) {
            Iterator<String> it = this.Dp.iterator();
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
                this.Dp.add(pluginSetting.packageName);
            }
            lP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP() {
        if (this.Dp.size() > 0 && this.DC == null) {
            this.DC = new a(this.Dp.get(0));
            this.DC.execute(new String[0]);
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
                bn(this.packageName);
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            d.this.DC = null;
            if (d.this.Dp.size() > 0) {
                Iterator it = d.this.Dp.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    if (str != null && str.equals(this.packageName)) {
                        d.this.Dp.remove(str);
                        break;
                    }
                }
            }
            d.this.lP();
        }

        private void bn(String str) {
            File[] listFiles;
            File mB = Util.mB();
            String bP = Util.bP(str);
            if (mB != null && mB.exists() && (listFiles = mB.listFiles()) != null) {
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i] != null && listFiles[i].isFile() && listFiles[i].getName().startsWith(bP)) {
                        try {
                            com.baidu.adp.lib.util.e.h(listFiles[i]);
                            com.baidu.adp.plugin.b.a.lI().d("plugin_del_temp", "deltmp_suc", str, listFiles[i].getName());
                        } catch (Throwable th) {
                            com.baidu.adp.plugin.b.a.lI().e("plugin_del_temp", "deltmp_fail", str, String.valueOf(listFiles[i].getName()) + "-" + th.getMessage());
                        }
                    }
                }
            }
        }
    }
}
