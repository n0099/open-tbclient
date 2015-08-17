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
    private static b Ea;
    private a Eb;
    private boolean Ed;
    private f Ee;
    private static final BdUniqueId DZ = BdUniqueId.gen();
    public static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, DZ);
    private PluginSettings Ec = new PluginSettings();
    private final int BUFFER_SIZE = 1024;

    public static b ml() {
        if (Ea == null) {
            synchronized (b.class) {
                if (Ea == null) {
                    Ea = new b();
                }
            }
        }
        return Ea;
    }

    private b() {
    }

    public PluginSettings mm() {
        return this.Ec;
    }

    public void a(f fVar) {
        if (!this.Ed) {
            this.Ee = fVar;
            this.Ed = true;
            PluginSettings mn = mn();
            this.Ed = false;
            if (mn != null) {
                this.Ec = mn;
            }
            if (this.Ee != null) {
                this.Ee.a(mn);
                this.Ee = null;
            }
        }
    }

    private PluginSettings mn() {
        byte[] bz = bz(ml().mo());
        if (bz == null) {
            return null;
        }
        try {
            WriteSettingsReqIdl writeSettingsReqIdl = (WriteSettingsReqIdl) new Wire(new Class[0]).parseFrom(bz, WriteSettingsReqIdl.class);
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
            com.baidu.adp.plugin.b.a.lH().bi("settings_read_error");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=4, 198=4] */
    private byte[] bz(String str) {
        FileInputStream fileInputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    File file = new File(str);
                    if (file == null || !file.exists()) {
                        com.baidu.adp.lib.g.a.d(null);
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                    } else {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream(1024);
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
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                                return bArr;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                        } catch (Throwable th) {
                            outputStream = null;
                            th = th;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b(outputStream);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    outputStream = null;
                    fileInputStream = null;
                    th = th2;
                }
            }
            return bArr;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void save(PluginSettings pluginSettings, e eVar) {
        if (pluginSettings != null) {
            this.Ec = pluginSettings;
            if (this.Ed && this.Ee != null) {
                this.Ee.a(this.Ec);
                this.Ee = null;
                this.Ed = false;
            }
            if (this.Eb != null) {
                this.Eb.cancel();
                this.Eb = null;
            }
            if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
                pluginSettings.setContainerSetting("");
            }
            this.Eb = new a(pluginSettings, eVar);
            this.Eb.setParallel(sBdAsyncTaskParallel);
            this.Eb.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<String, Integer, Boolean> {
        private PluginSettings Ef;
        private e Eg;

        public a(PluginSettings pluginSettings, e eVar) {
            this.Ef = pluginSettings;
            this.Eg = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Boolean doInBackground(String... strArr) {
            if (this.Ef == null || this.Ef.getPlugins() == null) {
                return false;
            }
            ReqData.Builder builder = new ReqData.Builder();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, PluginSetting> entry : this.Ef.getPlugins().entrySet()) {
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
            builder.container_version = this.Ef.getContainerVersion();
            builder.forbidden_feature = this.Ef.getForbiddenFeatures();
            WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
            builder3.data = builder.build(false);
            return Boolean.valueOf(b.this.f(b.this.mo(), builder3.build(false).toByteArray()));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (this.Eg != null) {
                if (bool != null && bool.booleanValue()) {
                    this.Eg.ms();
                } else {
                    this.Eg.mt();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel();
            if (this.Eg != null) {
                this.Eg.mt();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=4] */
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
                if (bArr == null) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                if (bArr != null) {
                    try {
                        fileOutputStream2.write(bArr);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        return false;
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
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String mo() {
        if (Util.my() == null) {
            return null;
        }
        return Util.my().getAbsoluteFile() + File.separator + "plugin_settings";
    }
}
