package com.baidu.tbadk.core.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.download.a {
    final /* synthetic */ PluginDownloadService b;

    private d(PluginDownloadService pluginDownloadService) {
        this.b = pluginDownloadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(PluginDownloadService pluginDownloadService, d dVar) {
        this(pluginDownloadService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(PluginDownloadService pluginDownloadService, d dVar, d dVar2) {
        this(pluginDownloadService);
    }

    @Override // com.baidu.tbadk.download.a
    public void b(DownloadData downloadData) {
        Log.d("PluginDownloadService", "onFileUpdateProgress: " + downloadData);
        for (Messenger messenger : PluginDownloadService.a(this.b)) {
            Message obtain = Message.obtain(null, 5, null);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.download.a
    public boolean c(DownloadData downloadData) {
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public boolean d(DownloadData downloadData) {
        Log.d("PluginDownloadService", "onFileDownloaded: " + downloadData);
        for (Messenger messenger : PluginDownloadService.a(this.b)) {
            Message obtain = Message.obtain(null, 6, null);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        Log.d("PluginDownloadService", "onFileDownloadSucceed: " + downloadData);
        for (Messenger messenger : PluginDownloadService.a(this.b)) {
            Message obtain = Message.obtain((Handler) null, 8);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData, int i, String str) {
        Log.d("PluginDownloadService", "onFileDownloadFailed: " + downloadData);
        for (Messenger messenger : PluginDownloadService.a(this.b)) {
            Message obtain = Message.obtain((Handler) null, 7);
            if (obtain != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("download_data", downloadData);
                obtain.setData(bundle);
                try {
                    messenger.send(obtain);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
