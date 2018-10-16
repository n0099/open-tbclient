package com.baidu.fsg.base.restnet;

import android.content.Context;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.a.a;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.restnet.rest.d;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.restnet.rest.f;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.webkit.internal.ETAG;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class RestTemplate {
    public static final String TAG = "RestTemplate";
    private Context mContext;
    private boolean mIsReuseLink;
    private String mRestType;
    private String mUserAgent;
    private a<?> messageConverter;
    private List<RestHttpRequestInterceptor> requestInterceptors;

    public RestTemplate(Context context) {
        this(true, context, null, null);
    }

    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        this.messageConverter = null;
        this.requestInterceptors = new ArrayList();
        this.mContext = null;
        this.mUserAgent = null;
        this.mRestType = "";
        this.mIsReuseLink = true;
        this.mRestType = str2;
        this.mContext = context.getApplicationContext();
        this.mUserAgent = str;
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        this.requestInterceptors = list;
    }

    public List<RestHttpRequestInterceptor> getRequestInterceptors() {
        return this.requestInterceptors;
    }

    public void setReuseLink(boolean z) {
        this.mIsReuseLink = z;
    }

    public a<?> getMessageConverter() {
        return this.messageConverter;
    }

    public void setMessageConverter(a<?> aVar) {
        this.messageConverter = aVar;
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
        return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) getForObject(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
        return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return getForEntity(str, list, str2, cls, false);
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
        return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) postForObject(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        LogUtil.d("#####. postForEntity. url = " + str);
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
        return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return postForEntity(str, list, str2, cls, false);
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
        return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> RestResponseEntity<T> postMultipartForEntity(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
        return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
    }

    private d createHttpRequest(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines.HttpMethod httpMethod, boolean z) {
        if (str == null || httpMethod == null) {
            return null;
        }
        if (ApollonConstants.DEBUG) {
            StringBuilder sb = new StringBuilder(str);
            if (list != null && !list.isEmpty()) {
                sb.append("? params : ");
                for (RestNameValuePair restNameValuePair : list) {
                    sb.append(restNameValuePair.getName() + ETAG.EQUAL + restNameValuePair.getValue() + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
            LogUtil.d(TAG, sb.toString());
        }
        d a = com.baidu.fsg.base.restnet.b.d.a().a(this.mContext, this.mRestType, this.mUserAgent, str, httpMethod, list, restMultipartEntity, str2, z);
        for (RestHttpRequestInterceptor restHttpRequestInterceptor : getRequestInterceptors()) {
            restHttpRequestInterceptor.intercept(this.mContext, a);
        }
        return a;
    }

    private e doExecuteForResponse(d dVar) throws RestRuntimeException {
        try {
            URL url = new URL(dVar.d());
            String host = url.getHost();
            int port = url.getPort();
            if (port > 0) {
                host = host + ":" + port;
            }
            dVar.b(url.toString());
            dVar.b().a("Host", host);
            e e = dVar.e();
            if (ApollonConstants.DEBUG) {
                LogUtil.v(ApollonConstants.APOLLON_REST_TAG, "rtt:" + e.d().u());
            }
            return e;
        } catch (Exception e2) {
            e2.printStackTrace();
            if (dVar != null) {
                dVar.g();
            }
            throw new RestRuntimeException("RestRuntimeException: " + e2.getMessage(), e2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [393=4, 394=4, 397=4, 398=4] */
    private <T> T handleAndCloseResponse(d dVar, e eVar, f<T> fVar) {
        if (fVar == null) {
            return null;
        }
        try {
            if (eVar != null) {
                try {
                    if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR && eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a = fVar.a(eVar);
                        if (a != null) {
                            if (dVar != null) {
                                dVar.g();
                            }
                            if (eVar != null) {
                                eVar.f();
                            }
                            return a;
                        }
                        if (dVar != null) {
                            dVar.g();
                        }
                        if (eVar != null) {
                            eVar.f();
                            return null;
                        }
                        return null;
                    }
                } catch (Exception e) {
                    throw new RestRuntimeException("error: " + e.getMessage(), e);
                }
            }
        } finally {
            if (dVar != null) {
                dVar.g();
            }
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [430=4, 431=4, 434=4, 435=4] */
    private <T> RestResponseEntity<T> handleAndCloseResponseForEntity(d dVar, e eVar, f<T> fVar) {
        RestResponseEntity<T> restResponseEntity = null;
        if (fVar != null) {
            if (eVar != null) {
                try {
                    try {
                        if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR && eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                            T a = fVar.a(eVar);
                            if (a != null) {
                                restResponseEntity = new RestResponseEntity<>(a, eVar.d(), eVar.e());
                                if (dVar != null) {
                                    dVar.g();
                                }
                                if (eVar != null) {
                                    eVar.f();
                                }
                            } else {
                                restResponseEntity = new RestResponseEntity<>(eVar.d(), eVar.e());
                                if (dVar != null) {
                                    dVar.g();
                                }
                                if (eVar != null) {
                                    eVar.f();
                                }
                            }
                        }
                    } catch (Exception e) {
                        throw new RestRuntimeException("error: " + e.getMessage(), e);
                    }
                } finally {
                    if (dVar != null) {
                        dVar.g();
                    }
                    if (eVar != null) {
                        eVar.f();
                    }
                }
            }
        }
        return restResponseEntity;
    }

    private void logResponseStatus(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        if (eVar != null) {
            try {
                LogUtil.d(TAG, httpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.e() + " (" + eVar.b() + ")");
            } catch (Exception e) {
                LogUtil.d(TAG, "IOException : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class AcceptHeaderRequestInterceptor implements RestHttpRequestInterceptor {
        private final Class<?> responseType;

        private AcceptHeaderRequestInterceptor(Class<?> cls) {
            this.responseType = cls;
        }

        @Override // com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            if (this.responseType != null) {
                ArrayList arrayList = new ArrayList();
                if (!arrayList.isEmpty()) {
                    LogUtil.d(RestTemplate.TAG, "Setting request Accept header to " + arrayList);
                    StringBuilder sb = new StringBuilder();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        if (it.hasNext()) {
                            sb.append(", ");
                        }
                    }
                    dVar.b().a(sb.toString());
                }
            }
        }
    }
}
