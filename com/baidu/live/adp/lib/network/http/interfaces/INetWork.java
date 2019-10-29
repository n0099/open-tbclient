package com.baidu.live.adp.lib.network.http.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface INetWork {
    void cancel();

    NetResponse download(Object obj, String str, DownLoadCallback downLoadCallback);

    NetResponse get(List<Map.Entry<String, Object>> list);

    NetResponse post(List<Map.Entry<String, Object>> list);

    void setConnectTimeout(int i);

    void setHeaderData(HashMap<String, String> hashMap);

    void setReadTimeout(int i);

    void setRetryCount(int i);

    void setUrl(String str);
}
