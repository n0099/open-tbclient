package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.ReqData;
import plugin.writeSettings.WriteSettingsReqIdl;
/* loaded from: classes.dex */
public class b {
    private static b Ec;
    private a Ed;
    private boolean Ef;
    private f Eg;
    private static final BdUniqueId Eb = BdUniqueId.gen();
    public static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, Eb);
    private PluginSettings Ee = new PluginSettings();
    private final int BUFFER_SIZE = 1024;

    public static b mj() {
        if (Ec == null) {
            synchronized (b.class) {
                if (Ec == null) {
                    Ec = new b();
                }
            }
        }
        return Ec;
    }

    private b() {
    }

    public PluginSettings mk() {
        return this.Ee;
    }

    public void a(f fVar) {
        boolean z;
        PluginSettings pluginSettings;
        if (!this.Ef) {
            this.Eg = fVar;
            try {
                z = new File(mm()).exists();
            } catch (Exception e) {
                z = true;
            }
            this.Ef = true;
            PluginSettings ml = ml();
            this.Ef = false;
            if (ml != null) {
                this.Ee = ml;
                pluginSettings = ml;
            } else {
                this.Ef = true;
                PluginSettings ml2 = ml();
                this.Ef = false;
                if (ml2 != null) {
                    this.Ee = ml2;
                    pluginSettings = ml2;
                } else {
                    if (z) {
                        com.baidu.adp.plugin.b.a.lF().bj("setting_read_null");
                        com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "setting_read_null", null, null);
                    }
                    pluginSettings = ml2;
                }
            }
            if (this.Eg != null) {
                this.Eg.a(pluginSettings);
                this.Eg = null;
            }
        }
    }

    private PluginSettings ml() {
        Wire wire = new Wire(new Class[0]);
        try {
            byte[] bA = bA(mj().mm());
            if (bA == null) {
                return null;
            }
            WriteSettingsReqIdl writeSettingsReqIdl = (WriteSettingsReqIdl) wire.parseFrom(bA, WriteSettingsReqIdl.class);
            if (writeSettingsReqIdl == null || writeSettingsReqIdl.data == null) {
                return null;
            }
            PluginSettings pluginSettings = new PluginSettings();
            if (writeSettingsReqIdl.data.container_version != null) {
                pluginSettings.setContainerSetting(writeSettingsReqIdl.data.container_version);
            }
            if (writeSettingsReqIdl.data.forbidden_feature != null) {
                pluginSettings.setForbiddenFeatures(writeSettingsReqIdl.data.forbidden_feature);
            }
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            pluginSettings.setPlugins(concurrentHashMap);
            if (writeSettingsReqIdl.data.plugin_settings_list != null) {
                for (Plugin_setting plugin_setting : writeSettingsReqIdl.data.plugin_settings_list) {
                    if (plugin_setting != null) {
                        PluginSetting pluginSetting = new PluginSetting();
                        pluginSetting.apkPath = plugin_setting.apk_path;
                        pluginSetting.setCmdRange(plugin_setting.cmd_range);
                        pluginSetting.displayName = plugin_setting.display_name;
                        if (plugin_setting.enable.intValue() == 0) {
                            pluginSetting.enable = true;
                        } else {
                            pluginSetting.enable = false;
                        }
                        if (plugin_setting.forbidden.intValue() == 1) {
                            pluginSetting.forbidden = true;
                        } else {
                            pluginSetting.forbidden = false;
                        }
                        pluginSetting.installStatus = plugin_setting.install_status.intValue();
                        pluginSetting.md5 = plugin_setting.md5;
                        pluginSetting.packageName = plugin_setting.package_name;
                        pluginSetting.requireLoad = plugin_setting.requireLoad;
                        pluginSetting.size = plugin_setting.size.intValue();
                        pluginSetting.tempMd5 = plugin_setting.temp_md5;
                        pluginSetting.tempVersionCode = plugin_setting.temp_version_code.intValue();
                        pluginSetting.url = plugin_setting.url;
                        pluginSetting.version = plugin_setting.version;
                        pluginSetting.versionCode = plugin_setting.version_code.intValue();
                        pluginSetting.setInjectClassloader(plugin_setting.is_inject_classloader.intValue() != 0);
                        pluginSetting.setAbandon_apk_path(plugin_setting.abandon_apk_path);
                        pluginSetting.install_fail_count = plugin_setting.install_fail_count.intValue();
                        pluginSetting.priority = plugin_setting.priority.intValue();
                        pluginSetting.hasRes = plugin_setting.has_res.intValue() == 1;
                        concurrentHashMap.put(pluginSetting.packageName, pluginSetting);
                    }
                }
            }
            return pluginSettings;
        } catch (Throwable th) {
            com.baidu.adp.plugin.b.a.lF().bj("plugin_settings_read_error");
            com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "settings_read_error", null, th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0054 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    private byte[] bA(String str) {
        FileInputStream fileInputStream;
        Exception e;
        byte[] bArr = null;
        ?? isEmpty = TextUtils.isEmpty(str);
        try {
            if (isEmpty == 0) {
                try {
                    File file = new File(str);
                    if (file != null && file.exists()) {
                        fileInputStream = new FileInputStream(file);
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr2, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            } catch (Exception e2) {
                                e = e2;
                                BdLog.e(e.getMessage());
                                throw new RuntimeException(e);
                            }
                        } catch (Exception e3) {
                            e = e3;
                        } catch (Throwable th) {
                            isEmpty = 0;
                            th = th;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b((OutputStream) isEmpty);
                            throw th;
                        }
                    } else {
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                    }
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th2) {
                    fileInputStream = null;
                    th = th2;
                    isEmpty = 0;
                }
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void save(PluginSettings pluginSettings, e eVar) {
        if (pluginSettings != null) {
            this.Ee = pluginSettings;
            if (this.Ef && this.Eg != null) {
                this.Eg.a(this.Ee);
                this.Eg = null;
                this.Ef = false;
            }
            if (this.Ed != null) {
                this.Ed.cancel();
                this.Ed = null;
            }
            if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
                pluginSettings.setContainerSetting("");
            }
            this.Ed = new a(pluginSettings, eVar);
            this.Ed.setParallel(sBdAsyncTaskParallel);
            this.Ed.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private PluginSettings Eh;
        private e Ei;

        public a(PluginSettings pluginSettings, e eVar) {
            this.Eh = pluginSettings;
            this.Ei = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public Boolean doInBackground(String... strArr) {
            if (this.Eh == null || this.Eh.getPlugins() == null) {
                return false;
            }
            ReqData.Builder builder = new ReqData.Builder();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, PluginSetting> entry : this.Eh.getPlugins().entrySet()) {
                PluginSetting value = entry.getValue();
                if (value != null) {
                    Plugin_setting.Builder builder2 = new Plugin_setting.Builder();
                    builder2.apk_path = value.apkPath;
                    builder2.cmd_range = value.getCmdRange();
                    builder2.display_name = value.displayName;
                    if (value.enable) {
                        builder2.enable = 0;
                    } else {
                        builder2.enable = 1;
                    }
                    if (value.forbidden) {
                        builder2.forbidden = 1;
                    } else {
                        builder2.forbidden = 0;
                    }
                    builder2.install_status = Integer.valueOf(value.installStatus);
                    builder2.md5 = value.md5;
                    builder2.package_name = value.packageName;
                    builder2.requireLoad = value.requireLoad;
                    builder2.size = Integer.valueOf(value.size);
                    builder2.temp_md5 = value.tempMd5;
                    builder2.temp_version_code = Integer.valueOf(value.tempVersionCode);
                    builder2.url = value.url;
                    builder2.version = value.version;
                    builder2.version_code = Integer.valueOf(value.versionCode);
                    builder2.is_inject_classloader = Integer.valueOf(value.isInjectClassloader() ? 1 : 0);
                    builder2.abandon_apk_path = value.getAbandon_apk_path();
                    builder2.install_fail_count = Integer.valueOf(value.install_fail_count);
                    builder2.priority = Integer.valueOf(value.priority);
                    builder2.has_res = Integer.valueOf(value.hasRes ? 1 : 0);
                    arrayList.add(builder2.build(false));
                }
            }
            builder.plugin_settings_list = arrayList;
            builder.container_version = this.Eh.getContainerVersion();
            builder.forbidden_feature = this.Eh.getForbiddenFeatures();
            WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
            try {
                builder3.data = builder.build(false);
                return Boolean.valueOf(b.this.f(b.this.mm(), builder3.build(false).toByteArray()));
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.lF().bj("plugin_settings_write_error");
                com.baidu.adp.plugin.b.a.lF().d("plugin_setting", "settings_write_error", null, th.getMessage());
                return false;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.Ei != null) {
                if (bool != null && bool.booleanValue()) {
                    this.Ei.mq();
                } else {
                    this.Ei.mr();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Ei != null) {
                this.Ei.mr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (bArr != null) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    if (bArr != null) {
                        try {
                            fileOutputStream2.write(bArr);
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.getMessage());
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                            throw th;
                        }
                    }
                    fileOutputStream2.flush();
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                    return true;
                }
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                return false;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String mm() {
        if (Util.mw() == null) {
            return null;
        }
        return Util.mw().getAbsoluteFile() + File.separator + "plugin_settings";
    }
}
