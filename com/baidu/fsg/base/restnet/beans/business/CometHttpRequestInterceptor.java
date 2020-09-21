package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import com.baidu.fsg.base.restnet.rest.d;
/* loaded from: classes15.dex */
public class CometHttpRequestInterceptor extends EbpayHttpRequestInterceptor {
    public static final int COMET_HTTP_TIMEOUT = 60000;
    private static final String TAG = "CometHttpRequestInterceptor";

    @Override // com.baidu.fsg.base.restnet.beans.business.EbpayHttpRequestInterceptor, com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
    public void intercept(Context context, d dVar) {
        super.intercept(context, dVar);
        dVar.a(60000);
    }
}
