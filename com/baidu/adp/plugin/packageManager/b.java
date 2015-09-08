package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private static volatile b Dj;
    private HashMap<String, String> Dk = new HashMap<>();
    private a Dl = null;

    public static b lM() {
        if (Dj == null) {
            synchronized (b.class) {
                if (Dj == null) {
                    Dj = new b();
                }
            }
        }
        return Dj;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && this.Dl == null && lN()) {
            this.Dl = new a();
            this.Dl.execute(new Void[0]);
        }
    }

    private boolean lN() {
        String[] split;
        this.Dk.clear();
        PluginSettings mj = com.baidu.adp.plugin.packageManager.pluginSettings.c.mm().mj();
        if (mj == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mj.getPlugins().entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Dk.put(value.apkPath, "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Dk.put(str, "");
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
            ArrayList<File> lO = lO();
            if (lO == null || lO.size() == 0) {
                return false;
            }
            f(lO);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            b.this.Dl = null;
        }

        private ArrayList<File> lO() {
            ArrayList<File> arrayList = null;
            File mv = Util.mv();
            if (mv != null) {
                String ml = com.baidu.adp.plugin.packageManager.pluginSettings.b.mi().ml();
                File[] listFiles = mv.listFiles();
                if (listFiles != null) {
                    arrayList = new ArrayList<>();
                    for (File file : listFiles) {
                        if (file != null) {
                            String absolutePath = file.getAbsolutePath();
                            BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                            if (!absolutePath.equals(ml) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                                if (file.isDirectory()) {
                                    if (b.this.Dk.get(String.valueOf(absolutePath) + ".apk") == null) {
                                        arrayList.add(file);
                                    }
                                } else if (absolutePath.endsWith(".apk")) {
                                    if (b.this.Dk.get(absolutePath) == null) {
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
                        com.baidu.adp.lib.util.e.f(next);
                    }
                }
            }
        }
    }
}
