package com.baidu.adp.plugin.packageManager;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
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
    private static volatile b uw;
    private HashMap<String, String> ux = new HashMap<>();
    private a uy = null;
    private boolean uz = false;

    public static b hA() {
        if (uw == null) {
            synchronized (b.class) {
                if (uw == null) {
                    uw = new b();
                }
            }
        }
        return uw;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && !this.uz && this.uy == null && hB()) {
            this.uy = new a();
            this.uy.execute(new Void[0]);
            this.uz = true;
        }
    }

    private boolean hB() {
        String[] split;
        this.ux.clear();
        PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
        if (m9if == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = m9if.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.ux.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.ux.put(new File(str).getName(), "");
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
            ArrayList<File> hC = hC();
            if (hC == null || hC.size() == 0) {
                return false;
            }
            c(hC);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            b.this.uy = null;
        }

        private ArrayList<File> hC() {
            File is = Util.is();
            if (is == null) {
                return null;
            }
            String ih = com.baidu.adp.plugin.packageManager.pluginSettings.b.ie().ih();
            File[] listFiles = is.listFiles();
            if (listFiles != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                try {
                    for (Map.Entry entry : b.this.ux.entrySet()) {
                        if (sb.length() > 0) {
                            sb.append("-");
                        }
                        sb.append((String) entry.getKey());
                    }
                } catch (Throwable th) {
                    sb.append(th.getMessage());
                }
                ArrayList<File> arrayList = new ArrayList<>();
                for (File file : listFiles) {
                    if (file != null) {
                        String absolutePath = file.getAbsolutePath();
                        BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                        String name = file.getName();
                        if (!absolutePath.equals(ih) && !"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            if (file.isDirectory()) {
                                if (name.endsWith(".apk") || b.this.ux.get(String.valueOf(name) + ".apk") != null) {
                                    if (sb2.length() < 10000) {
                                        if (sb2.length() > 0) {
                                            sb2.append("-");
                                        }
                                        sb2.append(absolutePath);
                                    }
                                } else {
                                    arrayList.add(file);
                                    if (sb3.length() < 10000) {
                                        if (sb3.length() > 0) {
                                            sb3.append("-");
                                        }
                                        sb3.append(absolutePath);
                                        sb3.append("-");
                                        sb3.append("isdirectory_not_use");
                                    }
                                }
                            } else if (name.endsWith(".apk")) {
                                if (b.this.ux.get(name) != null) {
                                    if (sb2.length() < 10000) {
                                        if (sb2.length() > 0) {
                                            sb2.append("-");
                                        }
                                        sb2.append(absolutePath);
                                    }
                                } else {
                                    arrayList.add(file);
                                    if (sb3.length() < 10000) {
                                        if (sb3.length() > 0) {
                                            sb3.append("-");
                                        }
                                        sb3.append(absolutePath);
                                        sb3.append("-");
                                        sb3.append("isapk_not_use");
                                    }
                                }
                            } else if (System.currentTimeMillis() - file.lastModified() <= 259200000) {
                                if (sb2.length() < 10000) {
                                    if (sb2.length() > 0) {
                                        sb2.append("-");
                                    }
                                    sb2.append(absolutePath);
                                }
                            } else {
                                arrayList.add(file);
                                if (sb3.length() < 10000) {
                                    if (sb3.length() > 0) {
                                        sb3.append("-");
                                    }
                                    sb3.append(absolutePath);
                                    sb3.append("-");
                                    sb3.append("not_use_timemax");
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("loadcount");
                    sb4.append("-");
                    ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
                    sb4.append(allPlugins == null ? 0 : allPlugins.size());
                    if (allPlugins != null && allPlugins.size() > 0) {
                        Iterator<Plugin> it = allPlugins.iterator();
                        while (it.hasNext()) {
                            Plugin next = it.next();
                            if (next != null) {
                                sb4.append("-");
                                sb4.append(next.getPackageName());
                                sb4.append("-");
                                sb4.append(next.getPluginApkFilePath());
                                sb4.append("-");
                                sb4.append(next.isLoaded());
                            }
                        }
                    }
                    PluginSettings m9if = com.baidu.adp.plugin.packageManager.pluginSettings.c.ii().m9if();
                    if (m9if == null) {
                        Message obtain = Message.obtain();
                        com.baidu.adp.plugin.packageManager.pluginSettings.b.ie().a(new c(this, obtain));
                        if (obtain != null && obtain.obj != null && (obtain.obj instanceof PluginSettings)) {
                            m9if = (PluginSettings) obtain.obj;
                            sb4.append("-");
                            sb4.append("settings_null_read_plugin_settings_again");
                        }
                    }
                    if (m9if != null) {
                        sb4.append("-");
                        sb4.append(m9if.getContainerVersion());
                        sb4.append("-");
                        sb4.append(m9if.getForbiddenFeatures());
                        sb4.append("-");
                        for (Map.Entry<String, PluginSetting> entry2 : m9if.getPlugins().entrySet()) {
                            PluginSetting value = entry2.getValue();
                            if (value != null) {
                                sb4.append(value.packageName);
                                sb4.append("-");
                                sb4.append(value.apkPath);
                                sb4.append("-");
                                sb4.append(value.getAbandon_apk_path());
                                sb4.append("-");
                                sb4.append(value.versionCode);
                                sb4.append("-");
                                sb4.append(value.tempVersionCode);
                                sb4.append("-");
                            }
                        }
                    }
                    com.baidu.adp.plugin.b.a.hs().e("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb4.toString());
                }
                return arrayList;
            }
            return null;
        }

        private void c(ArrayList<File> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        try {
                            com.baidu.adp.lib.util.e.g(next);
                            com.baidu.adp.plugin.b.a.hs().e("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.hs().e("plugin_del_redundance", "delete_redundance_fail", null, String.valueOf(next.getAbsolutePath()) + "-" + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
