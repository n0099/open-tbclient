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
import com.baidu.live.tbadk.data.Config;
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
    private static volatile b Sb;
    private HashMap<String, String> Sc = new HashMap<>();
    private a Se = null;
    private boolean Sf = false;

    public static b oj() {
        if (Sb == null) {
            synchronized (b.class) {
                if (Sb == null) {
                    Sb = new b();
                }
            }
        }
        return Sb;
    }

    private b() {
    }

    public void av(boolean z) {
        if (z && !this.Sf && this.Se == null && ok()) {
            this.Se = new a();
            this.Se.execute(new Void[0]);
            this.Sf = true;
        }
    }

    private boolean ok() {
        String[] split;
        this.Sc.clear();
        PluginSettings oN = com.baidu.adp.plugin.packageManager.pluginSettings.c.oQ().oN();
        if (oN == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = oN.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.Sc.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.Sc.put(new File(str).getName(), "");
                    }
                }
            }
            try {
                if (value.tempVersionCode > 0 && value.installStatus > 0) {
                    if (value.installStatus == a.b.SX) {
                        String f = Util.f(value);
                        if (!TextUtils.isEmpty(f) && new File(f).exists()) {
                            this.Sc.put(new File(f).getName(), "");
                        }
                    } else if (value.installStatus == a.b.Ta || value.installStatus == a.b.SZ) {
                        String str2 = Util.f(value) + ".tmp";
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            this.Sc.put(new File(str2).getName(), "");
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.plugin.b.a.nX().f("plugin_del_redundance", "use_plugin_temp_file", null, "plugin_name-" + value.packageName + "-install_status-" + String.valueOf(value.installStatus) + "-tempversioncode-" + String.valueOf(value.tempVersionCode));
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
            ArrayList<File> ol = ol();
            if (ol == null || ol.size() == 0) {
                return false;
            }
            e(ol);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            b.this.Se = null;
        }

        private ArrayList<File> ol() {
            File pa;
            File[] listFiles;
            PluginSettings oN = com.baidu.adp.plugin.packageManager.pluginSettings.c.oQ().oN();
            if (oN == null || oN.getPlugins() == null || oN.getPlugins().size() == 0 || (pa = Util.pa()) == null || (listFiles = pa.listFiles()) == null || listFiles.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            try {
                for (Map.Entry entry : b.this.Sc.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    sb.append((String) entry.getKey());
                }
            } catch (Throwable th) {
                sb.append(th.getMessage());
            }
            ArrayList<File> arrayList = new ArrayList<>();
            String oP = com.baidu.adp.plugin.packageManager.pluginSettings.b.oM().oP();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file = listFiles[i2];
                if (file != null) {
                    String absolutePath = file.getAbsolutePath();
                    BdLog.i("ClearRedunceFiles file: " + file.getAbsolutePath());
                    String name = file.getName();
                    if (!absolutePath.equals(oP) && !"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                        if (file.isDirectory()) {
                            if (name.equals("oat")) {
                                File[] listFiles2 = file.listFiles();
                                if (listFiles2.length > 0) {
                                    int length2 = listFiles2.length;
                                    int i3 = 0;
                                    while (true) {
                                        int i4 = i3;
                                        if (i4 < length2) {
                                            File file2 = listFiles2[i4];
                                            if (file2.isDirectory()) {
                                                String name2 = file2.getName();
                                                if (!"arm".equals(name2)) {
                                                    com.baidu.adp.plugin.b.a.nX().f("plugin_del_redundance", "delate_oat_debug", null, "oatfile_" + name2);
                                                }
                                                File[] listFiles3 = file2.listFiles();
                                                if (listFiles3.length > 0) {
                                                    int length3 = listFiles3.length;
                                                    int i5 = 0;
                                                    while (true) {
                                                        int i6 = i5;
                                                        if (i6 < length3) {
                                                            File file3 = listFiles3[i6];
                                                            String name3 = file3.getName();
                                                            if (name3.endsWith(".vdex") || name3.endsWith(".odex")) {
                                                                name3 = name3.substring(0, name3.length() - 5);
                                                            }
                                                            if (b.this.Sc.get(name3 + ".apk") == null) {
                                                                arrayList.add(file3);
                                                                if (sb3.length() < 10000) {
                                                                    if (sb3.length() > 0) {
                                                                        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                                    }
                                                                    sb3.append(file3.getAbsolutePath());
                                                                    sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                                    sb3.append("isarmfile_not_use");
                                                                }
                                                            }
                                                            i5 = i6 + 1;
                                                        }
                                                    }
                                                }
                                            } else {
                                                String name4 = file2.getName();
                                                if (name4.endsWith(".apk.cur.prof")) {
                                                    name4 = name4.substring(0, name4.length() - 13);
                                                }
                                                if (b.this.Sc.get(name4 + ".apk") == null) {
                                                    arrayList.add(file2);
                                                    if (sb3.length() < 10000) {
                                                        if (sb3.length() > 0) {
                                                            sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                        }
                                                        sb3.append(file2.getAbsolutePath());
                                                        sb3.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                                        sb3.append("isoatfile_not_use");
                                                    }
                                                }
                                            }
                                            i3 = i4 + 1;
                                        }
                                    }
                                }
                            } else if (name.endsWith(".apk") || b.this.Sc.get(name + ".apk") != null) {
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
                            if (b.this.Sc.get(name) != null) {
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
                        } else if (System.currentTimeMillis() - file.lastModified() <= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                            if (sb2.length() < 10000) {
                                if (sb2.length() > 0) {
                                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                }
                                sb2.append(absolutePath);
                            }
                        } else if (name.contains(".apk_") && b.this.Sc.get(name) != null) {
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
                i = i2 + 1;
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
                if (oN != null) {
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb4.append(oN.getContainerVersion());
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb4.append(oN.getForbiddenFeatures());
                    sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    for (Map.Entry<String, PluginSetting> entry2 : oN.getPlugins().entrySet()) {
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
                com.baidu.adp.plugin.b.a.nX().f("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb4.toString());
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
                            f.forceDelete(next);
                            com.baidu.adp.plugin.b.a.nX().f("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.nX().f("plugin_del_redundance", "delete_redundance_fail", null, next.getAbsolutePath() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
