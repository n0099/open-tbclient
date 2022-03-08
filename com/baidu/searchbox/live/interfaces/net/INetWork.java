package com.baidu.searchbox.live.interfaces.net;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public interface INetWork {
    void cancel();

    void download(Object obj, String str, DownLoadCallback downLoadCallback);

    NetResponse getSync(Map<String, Object> map);

    NetResponse postSync(Map<String, Object> map);

    void setConnectTimeout(int i2);

    void setExtra(Map<String, Object> map);

    void setHeaderData(HashMap<String, String> hashMap);

    void setReadTimeout(int i2);

    void setRetryCount(int i2);

    void setUrl(String str);
}
