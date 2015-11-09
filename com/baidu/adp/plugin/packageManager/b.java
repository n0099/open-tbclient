package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private static volatile b Dm;
    private HashMap<String, String> Dn = new HashMap<>();
    private a Do = null;

    public static b lO() {
        if (Dm == null) {
            synchronized (b.class) {
                if (Dm == null) {
                    Dm = new b();
                }
            }
        }
        return Dm;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && this.Do == null && lP()) {
            this.Do = new a();
            this.Do.execute(new Void[0]);
        }
    }

    private boolean lP() {
        String[] split;
        this.Dn.clear();
        PluginSettings ml = com.baidu.adp.plugin.packageManager.pluginSettings.c.mo().ml();
        if (ml == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : ml.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Dn.put(value.apkPath, "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Dn.put(str, "");
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Void, Integer, Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            ArrayList<File> lQ = lQ();
            if (lQ == null || lQ.size() == 0) {
                return false;
            }
            f(lQ);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            b.this.Do = null;
        }

        private ArrayList<File> lQ() {
            ArrayList<File> arrayList = null;
            File mx = Util.mx();
            if (mx != null) {
                String mn = com.baidu.adp.plugin.packageManager.pluginSettings.b.mk().mn();
                File[] listFiles = mx.listFiles();
                if (listFiles != null) {
                    arrayList = new ArrayList<>();
                    for (File file : listFiles) {
                        if (file != null) {
                            String absolutePath = file.getAbsolutePath();
                            BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                            if (!absolutePath.equals(mn) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                                if (file.isDirectory()) {
                                    if (b.this.Dn.get(String.valueOf(absolutePath) + ".apk") == null) {
                                        arrayList.add(file);
                                    }
                                } else if (absolutePath.endsWith(".apk")) {
                                    if (b.this.Dn.get(absolutePath) == null) {
                                        arrayList.add(file);
                                    }
                                } else if (System.currentTimeMillis() - file.lastModified() > 259200000) {
                                    arrayList.add(file);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        private void f(ArrayList<File> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        try {
                            com.baidu.adp.lib.util.e.h(next);
                            com.baidu.adp.plugin.b.a.lG().d("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.lG().d("plugin_del_redundance", "delete_redundance_fail", null, String.valueOf(next.getAbsolutePath()) + "-" + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
