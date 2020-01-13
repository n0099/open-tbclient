package com.baidu.searchbox.http;

import android.content.Context;
/* loaded from: classes12.dex */
public class HttpManager extends AbstractHttpManager {
    public static volatile HttpManager httpManager;
    private static ExtraInfoDispatcher sExtraInfoDispatcher = new ExtraInfoDispatcher();

    /* JADX INFO: Access modifiers changed from: protected */
    public HttpManager(Context context) {
        super(context);
    }

    public static HttpManager newHttpManager(Context context) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
        return httpManager2;
    }

    public static HttpManager getDefault(Context context) {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager(context);
                    httpManager.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                }
            }
        }
        return httpManager;
    }

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        return sExtraInfoDispatcher;
    }
}
