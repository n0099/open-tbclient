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
    private static volatile b xd;
    private HashMap<String, String> xe = new HashMap<>();
    private a xf = null;
    private boolean xg = false;

    public static b iu() {
        if (xd == null) {
            synchronized (b.class) {
                if (xd == null) {
                    xd = new b();
                }
            }
        }
        return xd;
    }

    private b() {
    }

    public void clear(boolean z) {
        if (z && !this.xg && this.xf == null && iv()) {
            this.xf = new a();
            this.xf.execute(new Void[0]);
            this.xg = true;
        }
    }

    private boolean iv() {
        String[] split;
        this.xe.clear();
        PluginSettings iZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().iZ();
        if (iZ == null) {
            return false;
        }
        Map<String, PluginSetting> plugins = iZ.getPlugins();
        if (plugins.isEmpty()) {
            return false;
        }
        for (Map.Entry<String, PluginSetting> entry : plugins.entrySet()) {
            PluginSetting value = entry.getValue();
            if (!TextUtils.isEmpty(value.apkPath)) {
                this.xe.put(new File(value.apkPath).getName(), "");
            }
            if (!TextUtils.isEmpty(value.getAbandon_apk_path()) && (split = value.getAbandon_apk_path().split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.xe.put(new File(str).getName(), "");
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
            ArrayList<File> iw = iw();
            if (iw == null || iw.size() == 0) {
                return false;
            }
            d(iw);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            b.this.xf = null;
        }

        private ArrayList<File> iw() {
            File jn = Util.jn();
            if (jn == null) {
                return null;
            }
            String jb = com.baidu.adp.plugin.packageManager.pluginSettings.b.iY().jb();
            File[] listFiles = jn.listFiles();
            if (listFiles != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                try {
                    for (Map.Entry entry : b.this.xe.entrySet()) {
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
                        if (!absolutePath.equals(jb) && !"plugin_settings".equals(file.getName()) && System.currentTimeMillis() - file.lastModified() >= 86400000) {
                            if (file.isDirectory()) {
                                if (name.endsWith(".apk") || b.this.xe.get(String.valueOf(name) + ".apk") != null) {
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
                                if (b.this.xe.get(name) != null) {
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
                    PluginSettings iZ = com.baidu.adp.plugin.packageManager.pluginSettings.c.jc().iZ();
                    if (iZ == null) {
                        Message obtain = Message.obtain();
                        com.baidu.adp.plugin.packageManager.pluginSettings.b.iY().a(new c(this, obtain));
                        if (obtain != null && obtain.obj != null && (obtain.obj instanceof PluginSettings)) {
                            iZ = (PluginSettings) obtain.obj;
                            sb4.append("-");
                            sb4.append("settings_null_read_plugin_settings_again");
                        }
                    }
                    if (iZ != null) {
                        sb4.append("-");
                        sb4.append(iZ.getContainerVersion());
                        sb4.append("-");
                        sb4.append(iZ.getForbiddenFeatures());
                        sb4.append("-");
                        for (Map.Entry<String, PluginSetting> entry2 : iZ.getPlugins().entrySet()) {
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
                    com.baidu.adp.plugin.b.a.im().e("plugin_del_redundance", "del_redundance_detail", null, "uselist_" + sb.toString() + "_delandreason_" + sb3.toString() + "_jump_" + sb2.toString() + "_setting_" + sb4.toString());
                }
                return arrayList;
            }
            return null;
        }

        private void d(ArrayList<File> arrayList) {
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<File> it = arrayList.iterator();
                while (it.hasNext()) {
                    File next = it.next();
                    if (next != null) {
                        try {
                            com.baidu.adp.lib.util.e.h(next);
                            com.baidu.adp.plugin.b.a.im().e("plugin_del_redundance", "delete_redundance", null, next.getAbsolutePath());
                        } catch (IOException e) {
                            com.baidu.adp.plugin.b.a.im().e("plugin_del_redundance", "delete_redundance_fail", null, String.valueOf(next.getAbsolutePath()) + "-" + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
