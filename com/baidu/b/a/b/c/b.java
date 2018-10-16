package com.baidu.b.a.b.c;

import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface b {
    String getChannelId();

    List<com.baidu.b.a.c.a.a> getDownloadItems();

    int getDownloadOptions();

    String getDownloadPath();

    Map<String, Integer> getOptions();

    String getPackageName();

    void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list, List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3);

    void onDownloadError(com.baidu.b.a.b.b.a aVar);

    void onDownloadStart(String str);

    void onDownloading(com.baidu.b.a.b.b.a aVar);

    void onFileCancel(com.baidu.b.a.b.b.a aVar);

    void onFileDownloaded(com.baidu.b.a.b.b.a aVar, com.baidu.b.a.c.a.a aVar2);

    void onFilePause(com.baidu.b.a.b.b.a aVar);

    void onFileProgress(String str, long j, long j2);
}
