package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.restnet.rest.d;
/* loaded from: classes2.dex */
public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    public static final String PARAM_CUID = "cuid_1";
    public static final String PARAM_IMSI = "wims";
    public static final String PARAM_LOCATION = "wloc";
    public static final String PARAM_MOBILE_IP = "wmip";
    public static final String PARAM_SIM_SERIAL_NUM = "wssn";
    public static final String TAG = "EbpayClientHttpRequestInterceptor";

    private void setToken(StringBuffer stringBuffer) {
    }

    @Override // com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        dVar.b().a("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
    }
}
