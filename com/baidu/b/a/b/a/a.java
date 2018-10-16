package com.baidu.b.a.b.a;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface a<T> {
    String getChannelId();

    String getChannelName();

    Map<String, String> getCommonParams();

    List<com.baidu.b.a.c.a.a> getDownloadItems();

    int getDownloadOptions();

    String getDownloadPath();

    Map<String, String> getExtParams();

    Map<String, String> getHeaderParams();

    Map<String, Integer> getOptions();

    String getPackageName();

    JSONArray getUploadParam();

    Map<String, String> getUrlParams();

    void onBulkDownloaded(List<com.baidu.b.a.c.a.a> list, List<com.baidu.b.a.c.a.a> list2, List<com.baidu.b.a.c.a.a> list3);

    void onConfigurationChanged(T t);

    void onDownloadError(com.baidu.b.a.b.b.a aVar);

    void onDownloadStart(String str);

    void onDownloading(com.baidu.b.a.b.b.a aVar);

    void onFetchError(com.baidu.b.a.b.b.a aVar);

    void onFileCancel(com.baidu.b.a.b.b.a aVar);

    void onFileDownloaded(com.baidu.b.a.b.b.a aVar, com.baidu.b.a.c.a.a aVar2);

    void onFilePause(com.baidu.b.a.b.b.a aVar);

    void onFileProgress(String str, long j, long j2);

    void onItemFiltered(T t);

    void onNewItemAdded(T t);

    void onReceiveItems(JSONArray jSONArray, @Nullable JSONArray jSONArray2);

    void onUpdate(T t);
}
