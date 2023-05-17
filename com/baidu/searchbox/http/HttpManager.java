package com.baidu.searchbox.http;

import android.content.Context;
import java.util.List;
/* loaded from: classes3.dex */
public class HttpManager extends AbstractHttpManager {
    public static volatile HttpManager httpManager;
    public static ExtraInfoDispatcher sExtraInfoDispatcher = new ExtraInfoDispatcher();

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        return sExtraInfoDispatcher;
    }

    public HttpManager(Context context) {
        super(context);
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

    public static HttpManager newHttpManager(Context context) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
        return httpManager2;
    }

    public static HttpManager newHttpManager(Context context, List<String> list) {
        return newHttpManager(context, list, null);
    }

    public static HttpManager newHttpManager(Context context, List<String> list, List<String> list2) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.openPreConnect(list, list2);
        httpManager2.setHttpDnsEnable(getDefault(context).getHttpDnsEnable());
        return httpManager2;
    }
}
