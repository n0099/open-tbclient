package com.baidu.searchbox.network.outback.manager;

import android.content.Context;
import com.baidu.searchbox.network.outback.base.AbstractHttpManager;
import com.baidu.searchbox.network.outback.core.CallFactoryParams;
/* loaded from: classes4.dex */
public class HttpManager extends AbstractHttpManager {
    public static volatile HttpManager httpManager;

    public HttpManager(Context context) {
        super(context);
    }

    public static HttpManager getDefault(Context context) {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager(context);
                }
            }
        }
        return httpManager;
    }

    public static HttpManager newHttpManager(Context context) {
        return new HttpManager(context);
    }

    public static HttpManager newHttpManager(Context context, String str) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.chooseEngine(str);
        return httpManager2;
    }

    public static HttpManager newHttpManager(Context context, String str, CallFactoryParams callFactoryParams) {
        HttpManager httpManager2 = new HttpManager(context);
        httpManager2.chooseEngine(str, callFactoryParams);
        return httpManager2;
    }
}
