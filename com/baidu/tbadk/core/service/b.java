package com.baidu.tbadk.core.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.tbadk.download.DownloadData;
import java.util.List;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ PluginDownloadService a;

    private b(PluginDownloadService pluginDownloadService) {
        this.a = pluginDownloadService;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(PluginDownloadService pluginDownloadService, b bVar) {
        this(pluginDownloadService);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        DownloadData downloadData;
        com.baidu.tbadk.download.a aVar;
        com.baidu.tbadk.download.a aVar2;
        List list;
        List list2;
        switch (message.what) {
            case 1:
                Log.d("PluginDownloadService", "on client bind");
                list2 = this.a.mClients;
                list2.add(message.replyTo);
                return;
            case 2:
                Log.d("PluginDownloadService", "on client unbind");
                list = this.a.mClients;
                list.remove(message.replyTo);
                return;
            case 3:
                Log.d("PluginDownloadService", "on client add download");
                Bundle data = message.getData();
                if (data != null && (downloadData = (DownloadData) data.getSerializable("download_data")) != null) {
                    for (DownloadData downloadData2 : com.baidu.tbadk.download.b.a().b()) {
                        if (downloadData2.getId().equals(downloadData.getId())) {
                            aVar2 = this.a.mFileDownloadCallBack;
                            downloadData.setCallback(aVar2);
                            return;
                        }
                    }
                    aVar = this.a.mFileDownloadCallBack;
                    downloadData.setCallback(aVar);
                    com.baidu.tbadk.download.b.a().a(downloadData);
                    Log.d("PluginDownloadService", "on client add download succ");
                    return;
                }
                return;
            default:
                return;
        }
    }
}
