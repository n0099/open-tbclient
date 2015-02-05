package com.baidu.adp.plugin.packageManager.pluginSettings;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
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
    private Messenger mMessenger = new Messenger(new g(this));

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(PluginSettings pluginSettings, l lVar) {
        e.in().save(pluginSettings, lVar);
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
