package com.baidu.adp.plugin.packageManager;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.a;
import com.baidu.adp.plugin.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    private static volatile b KZ;
    private HashMap<String, String> La = new HashMap<>();
    private a Lb = null;
    private boolean Lc = false;

    public static b nd() {
        if (KZ == null) {
            synchronized (b.class) {
                if (KZ == null) {
                    KZ = new b();
                }
            }
        }
        return KZ;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && !this.Lc && this.Lb == null && ne()) {
            this.Lb = new a();
            this.Lb.execute(new Void[0]);
            this.Lc = true;
        }
    }

    private boolean ne() {
        String[] split;
        this.La.clear();
        PluginSettings nI = com.baidu.adp.plugin.packageManager.pluginSettings.c.nL().nI();
        if (nI == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = nI.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.La.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.La.put(new File(str).getName(), "");
                    }
                }
            }
            try {
                if (value.tempVersionCode > 0 && value.installStatus > 0) {
                    if (value.installStatus == a.b.LS) {
                        String f = Util.f(value);
                        if (!TextUtils.isEmpty(f) && new File(f).exists()) {
                            this.La.put(new File(f).getName(), "");
                        }
                    } else if (value.installStatus == a.b.LW || value.installStatus == a.b.LV) {
                        String str2 = Util.f(value) + ".tmp";
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            this.La.put(new File(str2).getName(), "");
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.mS().f("plugin_del_redundance", "use_plugin_temp_file", null, "plugin_name-" + value.packageName + "-install_status-" + String.valueOf(value.installStatus) + "-tempversioncode-" + String.valueOf(value.tempVersionCode));
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
        public Boolean doInBackground(Void... voidArr) {
            ArrayList<File> nf = nf();
            if (nf == null || nf.size() == 0) {
                return false;
            }
            e(nf);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            b.this.Lb = null;
        }

        private ArrayList<File> nf() {
            File nW;
            File[] listFiles;
            PluginSettings nI = com.baidu.adp.plugin.packageManager.pluginSettings.c.nL().nI();
            if (nI == null || nI.getPlugins() == null || nI.getPlugins().size() == 0 || (nW = Util.nW()) == null || (listFiles = nW.listFiles()) == null || listFiles.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            try {
                for (Map.Entry entry : b.this.La.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    sb.append((String) entry.getKey());
                }
            } catch (Throwable th) {
                sb.append(th.getMessage());
            }
            ArrayList<File> arrayList = new ArrayList<>();
            String nK = com.baidu.adp.plugin.packageManager.pluginSettings.b.nH().nK();
            for (File file : listFiles) {
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                    String name = file.getName();
                    if (!absolutePath.equals(nK) && !"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                        if (file.isDirectory()) {
                            if (name.endsWith(".apk") || b.this.La.get(name + ".apk") != null) {
                                if (sb2.length() < 10000) {
                                    if (sb2.length() > 0) {
                                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    }
                                    sb2.append(absolutePath);
                                }
                            } else {
                                arrayList.add(file);
                                if (sb3.length() < 10000) {
                                    if (sb3.length() > 0) {
                                        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    }
                                    sb3.append(absolutePath);
                                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb3.append("isdirectory_not_use");
                                }
                            }
                        } else if (name.endsWith(".apk")) {
                            if (b.this.La.get(name) != null) {
                                if (sb2.length() < 10000) {
                                    if (sb2.length() > 0) {
                                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    }
                                    sb2.append(absolutePath);
                                }
                            } else {
                                arrayList.add(file);
                                if (sb3.length() < 10000) {
                                    if (sb3.length() > 0) {
                                        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    }
                                    sb3.append(absolutePath);
                                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    sb3.append("isapk_not_use");
                                }
                            }
                        } else if (System.currentTimeMillis() - file.lastModified() <= 259200000) {
                            if (sb2.length() < 10000) {
                                if (sb2.length() > 0) {
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                                sb2.append(absolutePath);
                            }
                        } else if (name.contains(".apk_") && b.this.La.get(name) != null) {
                            if (sb2.length() < 10000) {
                                if (sb2.length() > 0) {
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                                sb2.append(absolutePath);
                            }
                        } else {
                            arrayList.add(file);
                            if (sb3.length() < 10000) {
                                if (sb3.length() > 0) {
                                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                                sb3.append(absolutePath);
                                sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                sb3.append("not_use_timemax");
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("loadcount");
                sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                ArrayList<Plugin> allPlugins = PluginCenter.getInstance().getAllPlugins();
                sb4.append(allPlugins == null ? 0 : allPlugins.size());
                if (allPlugins != null && allPlugins.size() > 0) {
                    Iterator<Plugin> it = allPlugins.iterator();
                    while (it.hasNext()) {
                        Plugin next = it.next();
                        if (next != null) {
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(next.getPackageName());
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(next.getPluginApkFilePath());
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(next.isLoaded());
                        }
                    }
                }
                if (nI != null) {
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb4.append(nI.getContainerVersion());
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb4.append(nI.getForbiddenFeatures());
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    for (Map.Entry<String, PluginSetting> entry2 : nI.getPlugins().entrySet()) {
                        PluginSetting value = entry2.getValue();
                        if (value != null) {
                            sb4.append(value.packageName);
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(value.apkPath);
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(value.getAbandon_apk_path());
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(value.versionCode);
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append(value.tempVersionCode);
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        }
                    }
                }
                com.baidu.adp.plugin.b.a.mS().f("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb4.toString());
            }
            return arrayList;
        }

        private void e(ArrayList<File> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        try {
                            f.r(next);
                            com.baidu.adp.plugin.b.a.mS().f("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.mS().f("plugin_del_redundance", "delete_redundance_fail", null, next.getAbsolutePath() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
