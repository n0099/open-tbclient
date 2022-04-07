package com.baidu.searchbox.live.interfaces.net;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public interface INetWork {
    void cancel();

    void download(Object obj, String str, DownLoadCallback downLoadCallback);

    NetResponse getSync(Map<String, Object> map);

    NetResponse postSync(Map<String, Object> map);

    void setConnectTimeout(int i);

    void setExtra(Map<String, Object> map);

    void setHeaderData(HashMap<String, String> hashMap);

    void setReadTimeout(int i);

    void setRetryCount(int i);

    void setUrl(String str);
}
