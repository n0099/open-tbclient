package com.baidu.searchbox.live.interfaces.net;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public interface INetWork {
    void cancel();

    void download(Object obj, String str, DownLoadCallback downLoadCallback);

    NetResponse getSync(Map map);

    NetResponse postSync(Map map);

    void setConnectTimeout(int i);

    void setExtra(Map map);

    void setHeaderData(HashMap hashMap);

    void setReadTimeout(int i);

    void setRetryCount(int i);

    void setUrl(String str);
}
