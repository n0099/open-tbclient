package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.Serializable;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ PluginSettingIOService Ev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginSettingIOService pluginSettingIOService) {
        this.Ev = pluginSettingIOService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Bundle data;
        Bundle data2;
        Bundle data3;
        Bundle data4;
        Bundle data5;
        Bundle data6;
        Bundle data7;
        Serializable serializable;
        switch (message.what) {
            case 1:
                this.Ev.mClients.add(message.replyTo);
                return;
            case 2:
                this.Ev.mClients.remove(message.replyTo);
                return;
            case 3:
            case 5:
            default:
                return;
            case 4:
                Bundle data8 = message.getData();
                if (data8 != null && (serializable = data8.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                    PluginSettings pluginSettings = (PluginSettings) data8.getSerializable("plugin_settings");
                    this.Ev.save(pluginSettings, null);
                    this.Ev.sendUpdateMsg(pluginSettings);
                    return;
                }
                return;
            case 6:
                if (e.lL().lM() != null && (data5 = message.getData()) != null) {
                    boolean z = data5.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                    PluginSetting findPluginSetting = e.lL().lM().findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting != null) {
                        findPluginSetting.forbidden = z;
                        this.Ev.save(e.lL().lM(), null);
                        this.Ev.sendUpdateMsg(6, data5);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (e.lL().lM() != null && (data3 = message.getData()) != null) {
                    e.lL().lM().removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    this.Ev.save(e.lL().lM(), null);
                    this.Ev.sendUpdateMsg(7, data3);
                    return;
                }
                return;
            case 8:
                if (e.lL().lM() != null && (data7 = message.getData()) != null) {
                    e.lL().lM().setAllPluginEnable(data7.getBoolean(PluginSettingIOService.KEY_ENABLE));
                    this.Ev.save(e.lL().lM(), null);
                    this.Ev.sendUpdateMsg(8, data7);
                    return;
                }
                return;
            case 9:
                if (e.lL().lM() != null && (data6 = message.getData()) != null) {
                    boolean z2 = data6.getBoolean(PluginSettingIOService.KEY_ENABLE);
                    PluginSetting findPluginSetting2 = e.lL().lM().findPluginSetting(data6.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting2 != null) {
                        findPluginSetting2.enable = z2;
                        this.Ev.save(e.lL().lM(), null);
                        this.Ev.sendUpdateMsg(9, data6);
                        return;
                    }
                    return;
                }
                return;
            case 10:
                if (e.lL().lM() != null && (data2 = message.getData()) != null) {
                    e.lL().lM().setContainerSetting(data2.getString(PluginSettingIOService.KEY_VERSION));
                    this.Ev.save(e.lL().lM(), null);
                    this.Ev.sendUpdateMsg(10, data2);
                    return;
                }
                return;
            case 11:
                if (e.lL().lM() != null && (data4 = message.getData()) != null) {
                    int i = data4.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                    PluginSetting findPluginSetting3 = e.lL().lM().findPluginSetting(data4.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting3 != null) {
                        findPluginSetting3.installStatus = i;
                        this.Ev.save(e.lL().lM(), null);
                        this.Ev.sendUpdateMsg(11, data4);
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (e.lL().lM() != null && (data = message.getData()) != null) {
                    e.lL().lM().setForbiddenFeatures(data.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                    this.Ev.save(e.lL().lM(), null);
                    this.Ev.sendUpdateMsg(12, data);
                    return;
                }
                return;
        }
    }
}
