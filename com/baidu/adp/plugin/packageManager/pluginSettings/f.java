package com.baidu.adp.plugin.packageManager.pluginSettings;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
import java.util.Map;
import plugin.writeSettings.Plugin_setting;
import plugin.writeSettings.ReqData;
import plugin.writeSettings.WriteSettingsReqIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, Boolean> {
    private PluginSettings tB;
    private l tC;
    final /* synthetic */ e tD;

    public f(e eVar, PluginSettings pluginSettings, l lVar) {
        this.tD = eVar;
        this.tB = pluginSettings;
        this.tC = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        boolean e;
        if (this.tB == null || this.tB.getPlugins() == null) {
            return false;
        }
        ReqData.Builder builder = new ReqData.Builder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, PluginSetting> entry : this.tB.getPlugins().entrySet()) {
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
                arrayList.add(builder2.build(false));
            }
        }
        builder.plugin_settings_list = arrayList;
        builder.container_version = this.tB.getContainerVersion();
        builder.forbidden_feature = this.tB.getForbiddenFeatures();
        WriteSettingsReqIdl.Builder builder3 = new WriteSettingsReqIdl.Builder();
        builder3.data = builder.build(false);
        e = this.tD.e(this.tD.ix(), builder3.build(false).toByteArray());
        return Boolean.valueOf(e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (this.tC != null) {
            if (bool != null && bool.booleanValue()) {
                this.tC.iB();
            } else {
                this.tC.iC();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.tC != null) {
            this.tC.iC();
        }
    }
}
