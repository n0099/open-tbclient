package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.Serializable;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ PluginSettingIOService Em;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginSettingIOService pluginSettingIOService) {
        this.Em = pluginSettingIOService;
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
                this.Em.mClients.add(message.replyTo);
                return;
            case 2:
                this.Em.mClients.remove(message.replyTo);
                return;
            case 3:
            case 5:
            default:
                return;
            case 4:
                Bundle data8 = message.getData();
                if (data8 != null && (serializable = data8.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                    PluginSettings pluginSettings = (PluginSettings) data8.getSerializable("plugin_settings");
                    this.Em.save(pluginSettings, null);
                    this.Em.sendUpdateMsg(pluginSettings);
                    return;
                }
                return;
            case 6:
                if (e.me().mf() != null && (data5 = message.getData()) != null) {
                    boolean z = data5.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                    PluginSetting findPluginSetting = e.me().mf().findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting != null) {
                        findPluginSetting.forbidden = z;
                        this.Em.save(e.me().mf(), null);
                        this.Em.sendUpdateMsg(6, data5);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (e.me().mf() != null && (data3 = message.getData()) != null) {
                    e.me().mf().removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    this.Em.save(e.me().mf(), null);
                    this.Em.sendUpdateMsg(7, data3);
                    return;
                }
                return;
            case 8:
                if (e.me().mf() != null && (data7 = message.getData()) != null) {
                    e.me().mf().setAllPluginEnable(data7.getBoolean(PluginSettingIOService.KEY_ENABLE));
                    this.Em.save(e.me().mf(), null);
                    this.Em.sendUpdateMsg(8, data7);
                    return;
                }
                return;
            case 9:
                if (e.me().mf() != null && (data6 = message.getData()) != null) {
                    boolean z2 = data6.getBoolean(PluginSettingIOService.KEY_ENABLE);
                    PluginSetting findPluginSetting2 = e.me().mf().findPluginSetting(data6.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting2 != null) {
                        findPluginSetting2.enable = z2;
                        this.Em.save(e.me().mf(), null);
                        this.Em.sendUpdateMsg(9, data6);
                        return;
                    }
                    return;
                }
                return;
            case 10:
                if (e.me().mf() != null && (data2 = message.getData()) != null) {
                    e.me().mf().setContainerSetting(data2.getString(PluginSettingIOService.KEY_VERSION));
                    this.Em.save(e.me().mf(), null);
                    this.Em.sendUpdateMsg(10, data2);
                    return;
                }
                return;
            case 11:
                if (e.me().mf() != null && (data4 = message.getData()) != null) {
                    int i = data4.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                    PluginSetting findPluginSetting3 = e.me().mf().findPluginSetting(data4.getString(PluginSettingIOService.KEY_SETTING_NAME));
                    if (findPluginSetting3 != null) {
                        findPluginSetting3.installStatus = i;
                        this.Em.save(e.me().mf(), null);
                        this.Em.sendUpdateMsg(11, data4);
                        return;
                    }
                    return;
                }
                return;
            case 12:
                if (e.me().mf() != null && (data = message.getData()) != null) {
                    e.me().mf().setForbiddenFeatures(data.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                    this.Em.save(e.me().mf(), null);
                    this.Em.sendUpdateMsg(12, data);
                    return;
                }
                return;
        }
    }
}
