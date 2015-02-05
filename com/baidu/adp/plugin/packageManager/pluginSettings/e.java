package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.util.Util;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.WriteSettingsReqIdl;
/* loaded from: classes.dex */
public class e {
    private static e tt;
    private f tu;
    private boolean tw;
    private m tx;
    private static final BdUniqueId ts = BdUniqueId.gen();
    public static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, ts);
    private PluginSettings tv = new PluginSettings();
    private final int BUFFER_SIZE = 1024;

    public static e in() {
        if (tt == null) {
            synchronized (e.class) {
                if (tt == null) {
                    tt = new e();
                }
            }
        }
        return tt;
    }

    private e() {
    }

    public PluginSettings io() {
        return this.tv;
    }

    public void a(m mVar) {
        if (!this.tw) {
            this.tx = mVar;
            this.tw = true;
            PluginSettings ip = ip();
            this.tw = false;
            if (ip != null) {
                this.tv = ip;
            }
            if (this.tx != null) {
                this.tx.a(ip);
                this.tx = null;
            }
        }
    }

    private PluginSettings ip() {
        byte[] bn = bn(in().iq());
        if (bn == null) {
            return null;
        }
        try {
            WriteSettingsReqIdl writeSettingsReqIdl = (WriteSettingsReqIdl) new Wire(new Class[0]).parseFrom(bn, WriteSettingsReqIdl.class);
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
                        concurrentHashMap.put(pluginSetting.packageName, pluginSetting);
                    }
                }
            }
            return pluginSettings;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [190=4, 191=4] */
    private byte[] bn(String str) {
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
                                com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                            } catch (Exception e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                com.baidu.adp.lib.g.a.d(fileInputStream);
                                com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
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

    public void save(PluginSettings pluginSettings, l lVar) {
        if (pluginSettings != null) {
            this.tv = pluginSettings;
            if (this.tw && this.tx != null) {
                this.tx.a(this.tv);
                this.tx = null;
                this.tw = false;
            }
            if (this.tu != null) {
                this.tu.cancel();
                this.tu = null;
            }
            if (TextUtils.isEmpty(pluginSettings.getContainerVersion())) {
                pluginSettings.setContainerSetting("");
            }
            this.tu = new f(this, pluginSettings, lVar);
            this.tu.setParallel(sBdAsyncTaskParallel);
            this.tu.execute(new String[0]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [336=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str, byte[] bArr) {
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
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        throw th;
                    }
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                return true;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String iq() {
        if (Util.ix() == null) {
            return null;
        }
        return Util.ix().getAbsoluteFile() + File.separator + "plugin_settings";
    }
}
