package com.baidu.searchbox.http.interceptor;

import android.text.TextUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ExtraInfoCallback;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class AllRequestsInterceptor implements Interceptor {
    private static final boolean DEBUG = false;
    private static final String TAG = "AllRequestsInterceptor";

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        String header = proceed.header(NetworkStatRecord.HEAD_X_BFE_SVBBRERS);
        if (!TextUtils.isEmpty(header)) {
            notifyClientIPChanged(header);
        }
        return proceed;
    }

    private void notifyClientIPChanged(String str) {
        for (ExtraInfoCallback extraInfoCallback : HttpManager.getExtraInfoDispatcher().getAllCallbacks()) {
            if (extraInfoCallback != null) {
                extraInfoCallback.onReceiveClientIP(str);
            }
        }
    }
}
