package com.baidu.searchbox.http;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Arrays;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
/* loaded from: classes4.dex */
public class DownloadHttpManager extends HttpManager {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile DownloadHttpManager sDownloadHttpManager;

    public DownloadHttpManager(Context context) {
        super(context);
    }

    public static DownloadHttpManager getDefault(Context context) {
        if (sDownloadHttpManager == null) {
            synchronized (HttpManager.class) {
                if (sDownloadHttpManager == null) {
                    sDownloadHttpManager = new DownloadHttpManager(context);
                    sDownloadHttpManager.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                }
            }
        }
        return sDownloadHttpManager;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        return super.initClient().newBuilder().protocols(Arrays.asList(Protocol.HTTP_1_1)).build();
    }
}
