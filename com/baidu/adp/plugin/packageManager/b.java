package com.baidu.adp.plugin.packageManager;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
import com.baidu.adp.plugin.packageManager.pluginSettings.e;
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
    private static volatile b arc;
    private HashMap<String, String> ard = new HashMap<>();
    private a are = null;
    private boolean arf = false;

    public static b qN() {
        if (arc == null) {
            synchronized (b.class) {
                if (arc == null) {
                    arc = new b();
                }
            }
        }
        return arc;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && !this.arf && this.are == null && qO()) {
            this.are = new a();
            this.are.execute(new Void[0]);
            this.arf = true;
        }
    }

    private boolean qO() {
        String[] split;
        this.ard.clear();
        PluginSettings rr = com.baidu.adp.plugin.packageManager.pluginSettings.c.ru().rr();
        if (rr == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = rr.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.ard.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.ard.put(new File(str).getName(), "");
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
        public Boolean doInBackground(Void... voidArr) {
            ArrayList<File> qP = qP();
            if (qP == null || qP.size() == 0) {
                return false;
            }
            e(qP);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            b.this.are = null;
        }

        private ArrayList<File> qP() {
            File rF = Util.rF();
            if (rF == null) {
                return null;
            }
            String rt = com.baidu.adp.plugin.packageManager.pluginSettings.b.rq().rt();
            File[] listFiles = rF.listFiles();
            if (listFiles != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                try {
                    for (Map.Entry entry : b.this.ard.entrySet()) {
                        if (sb.length() > 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
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
                        if (!absolutePath.equals(rt) && !"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            if (file.isDirectory()) {
                                if (name.endsWith(".apk") || b.this.ard.get(name + ".apk") != null) {
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
                                if (b.this.ard.get(name) != null) {
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
                    PluginSettings rr = com.baidu.adp.plugin.packageManager.pluginSettings.c.ru().rr();
                    if (rr == null) {
                        final Message obtain = Message.obtain();
                        com.baidu.adp.plugin.packageManager.pluginSettings.b.rq().a(new e() { // from class: com.baidu.adp.plugin.packageManager.b.a.1
                            @Override // com.baidu.adp.plugin.packageManager.pluginSettings.e
                            public void a(PluginSettings pluginSettings) {
                                obtain.obj = pluginSettings;
                            }
                        });
                        if (obtain != null && obtain.obj != null && (obtain.obj instanceof PluginSettings)) {
                            rr = (PluginSettings) obtain.obj;
                            sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            sb4.append("settings_null_read_plugin_settings_again");
                        }
                    }
                    if (rr != null) {
                        sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb4.append(rr.getContainerVersion());
                        sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb4.append(rr.getForbiddenFeatures());
                        sb4.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        for (Map.Entry<String, PluginSetting> entry2 : rr.getPlugins().entrySet()) {
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
                    com.baidu.adp.plugin.b.a.qF().f("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb4.toString());
                }
                return arrayList;
            }
            return null;
        }

        private void e(ArrayList<File> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        try {
                            f.l(next);
                            com.baidu.adp.plugin.b.a.qF().f("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.qF().f("plugin_del_redundance", "delete_redundance_fail", null, next.getAbsolutePath() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
