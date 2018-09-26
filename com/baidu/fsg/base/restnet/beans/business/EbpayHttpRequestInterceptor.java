package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.restnet.rest.d;
/* loaded from: classes3.dex */
public class EbpayHttpRequestInterceptor implements RestHttpRequestInterceptor {
    private static final String PARAM_CUID = "cuid_1";
    private static final String PARAM_IMSI = "wims";
    private static final String PARAM_LOCATION = "wloc";
    private static final String PARAM_MOBILE_IP = "wmip";
    private static final String PARAM_SIM_SERIAL_NUM = "wssn";
    private static final String TAG = "EbpayClientHttpRequestInterceptor";

    @Override // com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        dVar.b().a("Accept-Encoding", "gzip");
    }

    private void setToken(StringBuffer stringBuffer) {
    }
}
