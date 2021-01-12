package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.util.Util;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.ReqData;
import plugin.writeSettings.WriteSettingsReqIdl;
/* loaded from: classes.dex */
public class b {
    private static b Vi;
    private a Vj;
    private e Vl;
    private boolean isReading;
    private static final BdUniqueId Vh = BdUniqueId.gen();
    public static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, Vh);
    private PluginSettings Vk = new PluginSettings();
    private final int BUFFER_SIZE = 1024;

    public static b pV() {
        if (Vi == null) {
            synchronized (b.class) {
                if (Vi == null) {
                    Vi = new b();
                }
            }
        }
        return Vi;
    }

    private b() {
    }

    public PluginSettings pW() {
        return this.Vk;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(e eVar) {
        String str;
        boolean z;
        PluginSettings pX;
        PluginSettings pluginSettings;
        if (!this.isReading) {
            this.Vl = eVar;
            try {
                str = pY();
            } catch (Exception e) {
                e = e;
                str = null;
            }
            try {
                z = new File(str).exists();
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_readSettings", "path_" + str + "-exception_" + e.getMessage());
                z = true;
                this.isReading = true;
                pX = pX();
                this.isReading = false;
                if (pX == null) {
                }
                if (this.Vl == null) {
                }
            }
            this.isReading = true;
            pX = pX();
            this.isReading = false;
            if (pX == null) {
                this.Vk = pX;
                pluginSettings = pX;
            } else {
                this.isReading = true;
                PluginSettings pX2 = pX();
                this.isReading = false;
                if (pX2 != null) {
                    this.Vk = pX2;
                    pluginSettings = pX2;
                } else {
                    com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_readSettings", "isExist_" + z + "-PluginSettings_is_null");
                    if (z) {
                        com.baidu.adp.plugin.b.a.pg().log(PluginPackageManager.px().isMainProcess() ? "plugin_setting_read_null_main" : "plugin_setting_read_null");
                        com.baidu.adp.plugin.b.a.pg().f("plugin_setting", "setting_read_null", null, null);
                    }
                    pluginSettings = pX2;
                }
            }
            if (this.Vl == null) {
                this.Vl.c(pluginSettings);
                this.Vl = null;
            }
        }
    }

    private PluginSettings pX() {
        Wire wire = new Wire(new Class[0]);
        try {
            byte[] cH = cH(pV().pY());
            if (cH == null) {
                com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_read0", "data_is_null");
                return null;
            }
            WriteSettingsReqIdl writeSettingsReqIdl = (WriteSettingsReqIdl) wire.parseFrom(cH, WriteSettingsReqIdl.class);
            if (writeSettingsReqIdl == null || writeSettingsReqIdl.data == null) {
                com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_read0", writeSettingsReqIdl == null ? "res_is_null" : "res_data_is_null");
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
                        pluginSetting.isThird = plugin_setting.is_third.intValue() == 1;
                        pluginSetting.load_priority = plugin_setting.load_priority.intValue();
                        pluginSetting.isPatch = plugin_setting.is_Patch.intValue() == 1;
                        pluginSetting.replaceMethodClasses = plugin_setting.replaceMethodClasses;
                        pluginSetting.ext = plugin_setting.ext;
                        if (pluginSetting.isPatch) {
                            pluginSettings.setPatch(true);
                        }
                        concurrentHashMap.put(pluginSetting.packageName, pluginSetting);
                    }
                }
            }
            return pluginSettings;
        } catch (Throwable th) {
            com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_read0", "exception_" + th.getMessage());
            com.baidu.adp.plugin.b.a.pg().log("plugin_settings_read_error");
            com.baidu.adp.plugin.b.a.pg().f("plugin_setting", "settings_read_error", null, th.getMessage());
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [247=4, 248=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private byte[] cH(String str) {
        ?? r2;
        ?? r3;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = null;
        if (TextUtils.isEmpty(str)) {
            com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_read1", "path_is_null");
        } else {
            try {
                File file = new File(str);
                if (file.exists()) {
                    bArr2 = new FileInputStream(file);
                    try {
                        bArr = new ByteArrayOutputStream(1024);
                        try {
                            try {
                                byte[] bArr4 = new byte[1024];
                                while (true) {
                                    int read = bArr2.read(bArr4, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    bArr.write(bArr4, 0, read);
                                }
                                bArr3 = bArr.toByteArray();
                                com.baidu.adp.lib.f.a.close((InputStream) bArr2);
                                com.baidu.adp.lib.f.a.close((OutputStream) bArr);
                            } catch (Exception e) {
                                e = e;
                                bArr = bArr;
                                bArr2 = bArr2;
                                BdLog.e(e.getMessage());
                                throw new RuntimeException(e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            r2 = bArr;
                            r3 = bArr2;
                            com.baidu.adp.lib.f.a.close((InputStream) r3);
                            com.baidu.adp.lib.f.a.close((OutputStream) r2);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bArr = 0;
                        bArr2 = bArr2;
                    } catch (Throwable th2) {
                        th = th2;
                        r2 = 0;
                        r3 = bArr2;
                        com.baidu.adp.lib.f.a.close((InputStream) r3);
                        com.baidu.adp.lib.f.a.close((OutputStream) r2);
                        throw th;
                    }
                } else {
                    com.baidu.adp.plugin.b.b.E("PluginSettingIOManager_read1", "file_is_null");
                    com.baidu.adp.lib.f.a.close((InputStream) null);
                    com.baidu.adp.lib.f.a.close((OutputStream) null);
                }
            } catch (Exception e3) {
                e = e3;
                bArr = bArr3;
                bArr2 = bArr3;
            } catch (Throwable th3) {
                th = th3;
                r2 = bArr3;
                r3 = bArr3;
            }
        }
        return bArr3;
    }

    public void save(PluginSettings pluginSettings, d dVar) {
        if (pluginSettings != null) {
            this.Vk = pluginSettings;
            if (this.isReading && this.Vl != null) {
                this.Vl.c(this.Vk);
                this.Vl = null;
                this.isReading = false;
            }
            if (this.Vj != null) {
                this.Vj.cancel();
                this.Vj = null;
            }
            if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
                pluginSettings.setContainerSetting("");
            }
            this.Vj = new a(pluginSettings, dVar);
            this.Vj.setParallel(sBdAsyncTaskParallel);
            this.Vj.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private PluginSettings Vm;
        private d Vn;

        public a(PluginSettings pluginSettings, d dVar) {
            this.Vm = pluginSettings;
            this.Vn = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(String... strArr) {
            if (this.Vm == null || this.Vm.getPlugins() == null) {
                return false;
            }
            ReqData.Builder builder = new ReqData.Builder();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, PluginSetting> entry : this.Vm.getPlugins().entrySet()) {
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
                    builder2.is_third = Integer.valueOf(value.isThird ? 1 : 0);
                    builder2.is_Patch = Integer.valueOf(value.isPatch ? 1 : 0);
                    builder2.load_priority = Integer.valueOf(value.load_priority);
                    builder2.replaceMethodClasses = value.replaceMethodClasses;
                    builder2.ext = value.ext;
                    builder2.rollback = Integer.valueOf(value.rollback);
                    arrayList.add(builder2.build(false));
                }
            }
            builder.plugin_settings_list = arrayList;
            builder.container_version = this.Vm.getContainerVersion();
            builder.forbidden_feature = this.Vm.getForbiddenFeatures();
            WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
            try {
                builder3.data = builder.build(false);
                return Boolean.valueOf(b.this.f(b.this.pY(), builder3.build(false).toByteArray()));
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.pg().log("plugin_settings_write_error");
                com.baidu.adp.plugin.b.a.pg().f("plugin_setting", "settings_write_error", null, th.getMessage());
                return false;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            super.onPostExecute((a) bool);
            if (this.Vn != null) {
                if (bool != null && bool.booleanValue()) {
                    this.Vn.qc();
                } else {
                    this.Vn.qd();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Vn != null) {
                this.Vn.qd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (bArr != null) {
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                if (bArr != null) {
                    try {
                        fileOutputStream3.write(bArr);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream3;
                        try {
                            BdLog.e(e.getMessage());
                            throw new RuntimeException(e);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream3;
                        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                        throw th;
                    }
                }
                fileOutputStream3.flush();
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream3);
                return true;
            }
            com.baidu.adp.lib.f.a.close((OutputStream) null);
            return false;
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public String pY() {
        if (Util.qj() == null) {
            return null;
        }
        return Util.qj().getAbsoluteFile() + File.separator + "plugin_settings";
    }
}
