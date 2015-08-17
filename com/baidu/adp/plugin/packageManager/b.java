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

    public static b lP() {
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
        if (z && this.Dl == null && lQ()) {
            this.Dl = new a();
            this.Dl.execute(new Void[0]);
        }
    }

    private boolean lQ() {
        String[] split;
        this.Dk.clear();
        PluginSettings mm = com.baidu.adp.plugin.packageManager.pluginSettings.c.mp().mm();
        if (mm == null) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : mm.getPlugins().entrySet()) {
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
            ArrayList<File> lR = lR();
            if (lR == null || lR.size() == 0) {
                return false;
            }
            f(lR);
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

        private ArrayList<File> lR() {
            ArrayList<File> arrayList = null;
            File my = Util.my();
            if (my != null) {
                String mo = com.baidu.adp.plugin.packageManager.pluginSettings.b.ml().mo();
                File[] listFiles = my.listFiles();
                if (listFiles != null) {
                    arrayList = new ArrayList<>();
                    for (File file : listFiles) {
                        if (file != null) {
                            String absolutePath = file.getAbsolutePath();
                            BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                            if (!absolutePath.equals(mo) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
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
