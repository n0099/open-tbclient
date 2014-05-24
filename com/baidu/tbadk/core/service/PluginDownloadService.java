package com.baidu.tbadk.core.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginReloadReceiver;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tbadk.tbplugin.i;
import com.baidu.tbadk.tbplugin.k;
import com.baidu.tbadk.tbplugin.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PluginDownloadService extends Service implements k {
    public static final int MSG_ADD = 3;
    public static final int MSG_CONNECT_CLIENT = 1;
    public static final int MSG_DISCONNECT_CLIENT = 2;
    public static final int MSG_FAILED = 7;
    public static final int MSG_FINISH = 6;
    public static final int MSG_GET = 4;
    public static final int MSG_SUCCEED = 8;
    public static final int MSG_UPDATE = 5;
    private static final String TAG = "PluginDownloadService";
    private Messenger mMessenger = new Messenger(new b(this, null));
    private List<Messenger> mClients = new ArrayList();
    private com.baidu.tbadk.download.a mFileDownloadCallBack = new c(this, null);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onFinish(int i, String str) {
        m.a().q();
        if (TbadkApplication.m252getInst().isMainProcess()) {
            sendBroadcast(new Intent(PluginReloadReceiver.ACTION_PLUGIN_RELOAD));
        }
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onProgress(int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String[] stringArrayExtra;
        boolean z;
        if (intent != null && intent.getBooleanExtra("background_download", false) && (stringArrayExtra = intent.getStringArrayExtra("plugins_download")) != null) {
            for (String str : stringArrayExtra) {
                PluginsConfig.PluginConfig d = m.a().d(str);
                if (d != null) {
                    DownloadData configToDownloadData = configToDownloadData(d);
                    Iterator<DownloadData> it = com.baidu.tbadk.download.b.a().b().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getId().equals(configToDownloadData.getId())) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        configToDownloadData.setCallback(new a(this, this, d));
                        com.baidu.tbadk.download.b.a().a(configToDownloadData);
                    }
                }
            }
        }
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.mClients.clear();
        super.onDestroy();
    }

    private DownloadData configToDownloadData(PluginsConfig.PluginConfig pluginConfig) {
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(i.f().getAbsolutePath()) + File.separator + str);
        return downloadData;
    }
}
