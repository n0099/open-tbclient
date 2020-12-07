package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PluginSettingIOService extends Service {
    public static final String KEY_ENABLE = "key_enable";
    public static final String KEY_FORBIDDEN = "key_forbidden";
    public static final String KEY_FORBIDDEN_FEATURE = "key_forbidden_feature";
    public static final String KEY_INSTALL_STATUS = "key_install_status";
    public static final String KEY_SETTING_NAME = "key_setting_name";
    public static final String KEY_VERSION = "key_version";
    public static final int MSG_CONNECT_CLIENT = 1;
    public static final int MSG_DISCONNECT_CLIENT = 2;
    public static final int MSG_ENABLE_ALL = 8;
    public static final int MSG_ENABLE_SETTING = 9;
    public static final int MSG_FORBIDDEN_FEATURES = 12;
    public static final int MSG_FORBIDDEN_SETTING = 6;
    public static final int MSG_INSTALL_STATUS = 11;
    public static final int MSG_REMOVE_SETTING = 7;
    public static final int MSG_SET_VERSION = 10;
    public static final int MSG_UPDATE_SETTINGS = 5;
    public static final int MSG_WRITE_SETTINGS = 4;
    ArrayList<Messenger> mClients = new ArrayList<>();
    private Messenger mMessenger = new Messenger(new a());

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
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
                    PluginSettingIOService.this.mClients.add(message.replyTo);
                    return;
                case 2:
                    PluginSettingIOService.this.mClients.remove(message.replyTo);
                    return;
                case 3:
                case 5:
                default:
                    return;
                case 4:
                    Bundle data8 = message.getData();
                    if (data8 != null && (serializable = data8.getSerializable("plugin_settings")) != null && (serializable instanceof PluginSettings)) {
                        PluginSettings pluginSettings = (PluginSettings) data8.getSerializable("plugin_settings");
                        PluginSettingIOService.this.save(pluginSettings, null);
                        PluginSettingIOService.this.sendUpdateMsg(pluginSettings);
                        return;
                    }
                    return;
                case 6:
                    if (b.qt().qu() != null && (data5 = message.getData()) != null) {
                        boolean z = data5.getBoolean(PluginSettingIOService.KEY_FORBIDDEN);
                        PluginSetting findPluginSetting = b.qt().qu().findPluginSetting(data5.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting != null) {
                            findPluginSetting.forbidden = z;
                            PluginSettingIOService.this.save(b.qt().qu(), null);
                            PluginSettingIOService.this.sendUpdateMsg(6, data5);
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    if (b.qt().qu() != null && (data3 = message.getData()) != null) {
                        b.qt().qu().removePluginSetting(data3.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        PluginSettingIOService.this.save(b.qt().qu(), null);
                        PluginSettingIOService.this.sendUpdateMsg(7, data3);
                        return;
                    }
                    return;
                case 8:
                    if (b.qt().qu() != null && (data7 = message.getData()) != null) {
                        b.qt().qu().setAllPluginEnable(data7.getBoolean(PluginSettingIOService.KEY_ENABLE));
                        PluginSettingIOService.this.save(b.qt().qu(), null);
                        PluginSettingIOService.this.sendUpdateMsg(8, data7);
                        return;
                    }
                    return;
                case 9:
                    if (b.qt().qu() != null && (data6 = message.getData()) != null) {
                        boolean z2 = data6.getBoolean(PluginSettingIOService.KEY_ENABLE);
                        PluginSetting findPluginSetting2 = b.qt().qu().findPluginSetting(data6.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting2 != null) {
                            findPluginSetting2.enable = z2;
                            PluginSettingIOService.this.save(b.qt().qu(), null);
                            PluginSettingIOService.this.sendUpdateMsg(9, data6);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (b.qt().qu() != null && (data2 = message.getData()) != null) {
                        b.qt().qu().setContainerSetting(data2.getString(PluginSettingIOService.KEY_VERSION));
                        PluginSettingIOService.this.save(b.qt().qu(), null);
                        PluginSettingIOService.this.sendUpdateMsg(10, data2);
                        return;
                    }
                    return;
                case 11:
                    if (b.qt().qu() != null && (data4 = message.getData()) != null) {
                        int i = data4.getInt(PluginSettingIOService.KEY_INSTALL_STATUS);
                        PluginSetting findPluginSetting3 = b.qt().qu().findPluginSetting(data4.getString(PluginSettingIOService.KEY_SETTING_NAME));
                        if (findPluginSetting3 != null) {
                            findPluginSetting3.installStatus = i;
                            PluginSettingIOService.this.save(b.qt().qu(), null);
                            PluginSettingIOService.this.sendUpdateMsg(11, data4);
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    if (b.qt().qu() != null && (data = message.getData()) != null) {
                        b.qt().qu().setForbiddenFeatures(data.getString(PluginSettingIOService.KEY_FORBIDDEN_FEATURE));
                        PluginSettingIOService.this.save(b.qt().qu(), null);
                        PluginSettingIOService.this.sendUpdateMsg(12, data);
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(PluginSettings pluginSettings, d dVar) {
        b.qt().save(pluginSettings, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMsg(int i, Bundle bundle) {
        Iterator<Messenger> it = this.mClients.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            Message obtain = Message.obtain(null, i, null);
            if (obtain != null) {
                obtain.setData(bundle);
                try {
                    next.send(obtain);
                } catch (RemoteException e) {
                } catch (Exception e2) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMsg(PluginSettings pluginSettings) {
        Iterator<Messenger> it = this.mClients.iterator();
        while (it.hasNext()) {
            Messenger next = it.next();
            Message obtain = Message.obtain(null, 5, null);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("plugin_settings", pluginSettings);
                obtain.setData(bundle);
                try {
                    next.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mClients.clear();
        super.onDestroy();
    }
}
