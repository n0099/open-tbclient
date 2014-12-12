package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.plugin.PluginCenter;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ h tz;

    private j(h hVar) {
        this.tz = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(h hVar, j jVar) {
        this(hVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
        if (android.text.TextUtils.isEmpty(r1.getContainerVersion()) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011b, code lost:
        if (android.text.TextUtils.isEmpty(r1.getContainerVersion()) == false) goto L73;
     */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        PluginSettings pluginSettings;
        PluginSettings pluginSettings2;
        PluginSettings pluginSettings3;
        PluginSettings pluginSettings4;
        PluginSettings pluginSettings5;
        PluginSettings pluginSettings6;
        PluginSettings pluginSettings7;
        PluginSettings pluginSettings8;
        PluginSettings pluginSettings9;
        PluginSettings pluginSettings10;
        PluginSettings pluginSettings11;
        PluginSettings pluginSettings12;
        Serializable serializable;
        switch (message.what) {
            case 5:
                Bundle data = message.getData();
                if (data != null && (serializable = data.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                    this.tz.tp = (PluginSettings) data.getSerializable("plugin_settings");
                }
                if (this.tz.tx != null) {
                    m mVar = this.tz.tx;
                    pluginSettings12 = this.tz.tp;
                    mVar.a(pluginSettings12);
                    this.tz.tx = null;
                    return;
                }
                return;
            case 6:
                Bundle data2 = message.getData();
                if (data2 != null) {
                    boolean z = data2.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                    String string = data2.getString(PluginSettingIOService.KEY_SETTING_NAME);
                    pluginSettings9 = this.tz.tp;
                    PluginSetting findPluginSetting = pluginSettings9.findPluginSetting(string);
                    if (findPluginSetting != null && findPluginSetting.forbidden != z) {
                        findPluginSetting.forbidden = z;
                    }
                    if (!z) {
                        PluginCenter.gX().aP(string);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                Bundle data3 = message.getData();
                if (data3 != null) {
                    String string2 = data3.getString(PluginSettingIOService.KEY_SETTING_NAME);
                    pluginSettings7 = this.tz.tp;
                    pluginSettings7.removePluginSetting(string2);
                    return;
                }
                return;
            case 8:
                Bundle data4 = message.getData();
                if (data4 != null) {
                    boolean z2 = data4.getBoolean(PluginSettingIOService.KEY_ENABLE);
                    pluginSettings10 = this.tz.tp;
                    pluginSettings10.setAllPluginEnable(z2);
                    return;
                }
                return;
            case 9:
                Bundle data5 = message.getData();
                if (data5 != null) {
                    boolean z3 = data5.getBoolean(PluginSettingIOService.KEY_ENABLE);
                    String string3 = data5.getString(PluginSettingIOService.KEY_SETTING_NAME);
                    pluginSettings11 = this.tz.tp;
                    PluginSetting findPluginSetting2 = pluginSettings11.findPluginSetting(string3);
                    if (findPluginSetting2 != null && findPluginSetting2.enable != z3) {
                        findPluginSetting2.enable = z3;
                        return;
                    }
                    return;
                }
                return;
            case 10:
                Bundle data6 = message.getData();
                if (data6 != null) {
                    String string4 = data6.getString(PluginSettingIOService.KEY_VERSION);
                    if (TextUtils.isEmpty(string4)) {
                        pluginSettings6 = this.tz.tp;
                        break;
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        pluginSettings4 = this.tz.tp;
                        break;
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        pluginSettings2 = this.tz.tp;
                        if (!TextUtils.isEmpty(pluginSettings2.getContainerVersion())) {
                            pluginSettings3 = this.tz.tp;
                            if (string4.equals(pluginSettings3.getContainerVersion())) {
                                return;
                            }
                            pluginSettings5 = this.tz.tp;
                            pluginSettings5.setContainerSetting(string4);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 11:
                Bundle data7 = message.getData();
                if (data7 != null) {
                    int i = data7.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                    String string5 = data7.getString(PluginSettingIOService.KEY_SETTING_NAME);
                    pluginSettings8 = this.tz.tp;
                    PluginSetting findPluginSetting3 = pluginSettings8.findPluginSetting(string5);
                    if (findPluginSetting3 != null && findPluginSetting3.installStatus != i) {
                        findPluginSetting3.installStatus = i;
                        return;
                    }
                    return;
                }
                return;
            case 12:
                Bundle data8 = message.getData();
                if (data8 != null) {
                    String string6 = data8.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE);
                    pluginSettings = this.tz.tp;
                    pluginSettings.setForbiddenFeatures(string6);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
