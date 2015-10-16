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
    private static volatile b Dl;
    private HashMap<String, String> Dm = new HashMap<>();
    private a Dn = null;

    public static b lN() {
        if (Dl == null) {
            synchronized (b.class) {
                if (Dl == null) {
                    Dl = new b();
                }
            }
        }
        return Dl;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && this.Dn == null && lO()) {
            this.Dn = new a();
            this.Dn.execute(new Void[0]);
        }
    }

    private boolean lO() {
        String[] split;
        this.Dm.clear();
        PluginSettings mk = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().mk();
        if (mk == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mk.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Dm.put(value.apkPath, "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Dm.put(str, "");
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
            ArrayList<File> lP = lP();
            if (lP == null || lP.size() == 0) {
                return false;
            }
            f(lP);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            b.this.Dn = null;
        }

        private ArrayList<File> lP() {
            ArrayList<File> arrayList = null;
            File mw = Util.mw();
            if (mw != null) {
                String mm = com.baidu.adp.plugin.packageManager.pluginSettings.b.mj().mm();
                File[] listFiles = mw.listFiles();
                if (listFiles != null) {
                    arrayList = new ArrayList<>();
                    for (File file : listFiles) {
                        if (file != null) {
                            String absolutePath = file.getAbsolutePath();
                            BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                            if (!absolutePath.equals(mm) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                                if (file.isDirectory()) {
                                    if (b.this.Dm.get(String.valueOf(absolutePath) + ".apk") == null) {
                                        arrayList.add(file);
                                    }
                                } else if (absolutePath.endsWith(".apk")) {
                                    if (b.this.Dm.get(absolutePath) == null) {
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
                            com.baidu.adp.plugin.b.a.lF().d("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.lF().d("plugin_del_redundance", "delete_redundance_fail", null, String.valueOf(next.getAbsolutePath()) + "-" + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
