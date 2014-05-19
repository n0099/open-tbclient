package com.baidu.tbadk.core.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.download.DownloadData;
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
    private Messenger a = new Messenger(new c(this, null));
    private List<Messenger> b = new ArrayList();
    private com.baidu.tbadk.download.a c = new d(this, null);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.getBinder();
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i, String str) {
        m.a().q();
        if (TbadkApplication.m252getInst().isMainProcess()) {
            sendBroadcast(new Intent("com.baidu.tbadk.tbplugin.action.PLUGIN_RELOAD"));
        }
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String[] stringArrayExtra;
        boolean z;
        if (intent != null && intent.getBooleanExtra("background_download", false) && (stringArrayExtra = intent.getStringArrayExtra("plugins_download")) != null) {
            for (String str : stringArrayExtra) {
                PluginsConfig.PluginConfig d = m.a().d(str);
                if (d != null) {
                    DownloadData a = a(d);
                    Iterator<DownloadData> it = com.baidu.tbadk.download.b.a().b().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getId().equals(a.getId())) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        a.setCallback(new b(this, this, d));
                        com.baidu.tbadk.download.b.a().a(a);
                    }
                }
            }
        }
        super.onStartCommand(intent, i, i2);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.b.clear();
        super.onDestroy();
    }

    private DownloadData a(PluginsConfig.PluginConfig pluginConfig) {
        DownloadData downloadData = new DownloadData(pluginConfig.name, pluginConfig.newest.url);
        String str = String.valueOf(pluginConfig.name) + ".tbplugin";
        downloadData.setName(str);
        downloadData.setPath(String.valueOf(i.f().getAbsolutePath()) + File.separator + str);
        return downloadData;
    }
}
