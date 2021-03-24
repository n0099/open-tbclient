package com.baidu.fsg.base.restnet;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.a.a;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.restnet.rest.d;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.restnet.rest.f;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class RestTemplate {
    public static final String TAG = "RestTemplate";
    public Context mContext;
    public boolean mIsReuseLink;
    public String mRestType;
    public String mUserAgent;
    public a<?> messageConverter;
    public List<RestHttpRequestInterceptor> requestInterceptors;

    /* loaded from: classes2.dex */
    public final class AcceptHeaderRequestInterceptor implements RestHttpRequestInterceptor {
        public final Class<?> responseType;

        @Override // com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            if (this.responseType != null) {
                ArrayList arrayList = new ArrayList();
                if (arrayList.isEmpty()) {
                    return;
                }
                LogUtil.d("RestTemplate", "Setting request Accept header to " + arrayList);
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next());
                    if (it.hasNext()) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                }
                dVar.b().a(sb.toString());
            }
        }

        public AcceptHeaderRequestInterceptor(Class<?> cls) {
            this.responseType = cls;
        }
    }

    public RestTemplate(Context context) {
        this(true, context, null, null);
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
                    sb.append(restNameValuePair.getName() + "=" + restNameValuePair.getValue() + ",");
                }
                sb.delete(sb.length() - 1, sb.length());
            }
            LogUtil.d("RestTemplate", sb.toString());
        }
        d a2 = com.baidu.fsg.base.restnet.b.d.a().a(this.mContext, this.mRestType, this.mUserAgent, str, httpMethod, list, restMultipartEntity, str2, z);
        for (RestHttpRequestInterceptor restHttpRequestInterceptor : getRequestInterceptors()) {
            restHttpRequestInterceptor.intercept(this.mContext, a2);
        }
        return a2;
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
            e e2 = dVar.e();
            if (ApollonConstants.DEBUG) {
                LogUtil.v("apollon_rest", "rtt:" + e2.d().u());
            }
            return e2;
        } catch (Exception e3) {
            e3.printStackTrace();
            if (dVar != null) {
                dVar.g();
            }
            throw new RestRuntimeException("RestRuntimeException: " + e3.getMessage(), e3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        r4.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T handleAndCloseResponse(d dVar, e eVar, f<T> fVar) {
        if (fVar == null) {
            return null;
        }
        if (eVar != null) {
            try {
                try {
                    if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR && eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a2 = fVar.a(eVar);
                        if (a2 != null) {
                            return a2;
                        }
                        if (dVar != null) {
                            dVar.g();
                        }
                        if (eVar != null) {
                            eVar.f();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    throw new RestRuntimeException("error: " + e2.getMessage(), e2);
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
        if (eVar != null) {
            eVar.f();
        }
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
        r4.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> RestResponseEntity<T> handleAndCloseResponseForEntity(d dVar, e eVar, f<T> fVar) {
        if (fVar == null) {
            return null;
        }
        try {
            if (eVar != null) {
                try {
                    if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR && eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a2 = fVar.a(eVar);
                        if (a2 != null) {
                            return new RestResponseEntity<>(a2, eVar.d(), eVar.e());
                        }
                        RestResponseEntity<T> restResponseEntity = new RestResponseEntity<>(eVar.d(), eVar.e());
                        if (dVar != null) {
                            dVar.g();
                        }
                        if (eVar != null) {
                            eVar.f();
                        }
                        return restResponseEntity;
                    }
                } catch (Exception e2) {
                    throw new RestRuntimeException("error: " + e2.getMessage(), e2);
                }
            }
            if (eVar != null) {
                eVar.f();
            }
            return null;
        } finally {
            if (dVar != null) {
                dVar.g();
            }
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    private void logResponseStatus(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        if (eVar != null) {
            try {
                LogUtil.d("RestTemplate", httpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.e() + " (" + eVar.b() + SmallTailInfo.EMOTION_SUFFIX);
            } catch (Exception e2) {
                LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
            }
        }
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
        return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
        return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
    }

    public a<?> getMessageConverter() {
        return this.messageConverter;
    }

    public List<RestHttpRequestInterceptor> getRequestInterceptors() {
        return this.requestInterceptors;
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

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
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

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(cls));
        f<T> fVar = new f<>(cls, getMessageConverter());
        d createHttpRequest = createHttpRequest(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
        e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
        logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
        return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
    }

    public void setMessageConverter(a<?> aVar) {
        this.messageConverter = aVar;
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        this.requestInterceptors = list;
    }

    public void setReuseLink(boolean z) {
        this.mIsReuseLink = z;
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

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return getForEntity(str, list, str2, cls, false);
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) getForObject(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return postForEntity(str, list, str2, cls, false);
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) postForObject(str, list, str2, cls, false);
    }
}
