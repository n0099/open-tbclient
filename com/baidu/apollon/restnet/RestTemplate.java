package com.baidu.apollon.restnet;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.restnet.rest.f;
import com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.baidu.apollon.restnet.rest.httpurlconnection.c;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class RestTemplate {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3823a = "RestTemplate";

    /* renamed from: b  reason: collision with root package name */
    public AbstractHttpMessageConverter<?> f3824b;

    /* renamed from: c  reason: collision with root package name */
    public List<RestHttpRequestInterceptor> f3825c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3826d;

    /* renamed from: e  reason: collision with root package name */
    public String f3827e;

    /* renamed from: f  reason: collision with root package name */
    public String f3828f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f3829g;

    /* loaded from: classes.dex */
    public final class a implements RestHttpRequestInterceptor {

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f3831b;

        @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            if (this.f3831b != null) {
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
                dVar.a().a(sb.toString());
            }
        }

        public a(Class<?> cls) {
            this.f3831b = cls;
        }
    }

    public RestTemplate(Context context) {
        this(true, context, null, null);
    }

    public List<RestHttpRequestInterceptor> a() {
        return this.f3825c;
    }

    public AbstractHttpMessageConverter<?> b() {
        return this.f3824b;
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f<T> fVar = new f<>(cls, b());
        d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return (T) a(a2, a3, fVar);
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        LogUtil.d("#####. postForEntity. url = " + str);
        a().add(new a(cls));
        f<T> fVar = new f<>(cls, b());
        d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return b(a2, a3, fVar);
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        a().add(new a(cls));
        f<T> fVar = new f<>(cls, b());
        d a2 = a(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.POST, str, a3);
        return (T) a(a2, a3, fVar);
    }

    public void setMessageConverter(AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        this.f3824b = abstractHttpMessageConverter;
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        this.f3825c = list;
    }

    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
    }

    public void a(boolean z) {
        this.f3829g = z;
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f<T> fVar = new f<>(cls, b());
        d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.GET, str, a3);
        return b(a2, a3, fVar);
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        this.f3824b = null;
        this.f3825c = new ArrayList();
        this.f3826d = null;
        this.f3827e = null;
        this.f3828f = "";
        this.f3829g = true;
        this.f3828f = str2;
        this.f3826d = context.getApplicationContext();
        this.f3827e = str;
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        a().add(new a(cls));
        f<T> fVar = new f<>(cls, b());
        d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
        e a3 = a(a2);
        a(HttpDefines.HttpMethod.GET, str, a3);
        return (T) a(a2, a3, fVar);
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return b(str, list, str2, cls, false);
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) c(str, list, str2, cls, false);
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return d(str, list, str2, cls, false);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
        r5.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> RestResponseEntity<T> b(d dVar, e eVar, f<T> fVar) {
        RestResponseEntity<T> restResponseEntity;
        if (fVar == null) {
            return null;
        }
        try {
            if (eVar != null) {
                try {
                    if (eVar.e().series() != HttpStatus.Series.CLIENT_ERROR && eVar.e().series() != HttpStatus.Series.SERVER_ERROR) {
                        T a2 = fVar.a(eVar);
                        if (a2 != null) {
                            restResponseEntity = new RestResponseEntity<>(a2, eVar.d(), eVar.e());
                        } else {
                            restResponseEntity = new RestResponseEntity<>(eVar.d(), eVar.e());
                        }
                        restResponseEntity.c(fVar.a());
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
                dVar.f();
            }
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        return (T) a(str, list, str2, cls, false);
    }

    private d a(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines.HttpMethod httpMethod, boolean z) {
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
        d a2 = c.a().a(this.f3826d, this.f3828f, this.f3827e, str, httpMethod, list, restMultipartEntity, str2, z);
        for (RestHttpRequestInterceptor restHttpRequestInterceptor : a()) {
            restHttpRequestInterceptor.intercept(this.f3826d, a2);
        }
        return a2;
    }

    private e a(d dVar) throws RestRuntimeException {
        try {
            URL url = new URL(dVar.c());
            String host = url.getHost();
            int port = url.getPort();
            if (port > 0) {
                String str = host + ":" + port;
            }
            if (this.f3829g) {
                ((RestUrlConnectionRequest) dVar).b(RestHttpDNSEnabler.a(url));
            }
            dVar.a(url.toString());
            e d2 = dVar.d();
            if (ApollonConstants.DEBUG) {
                LogUtil.v("apollon_rest", "rtt:" + d2.d().u());
            }
            return d2;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                RestHttpDNSEnabler.b(new URL(dVar.c()).getHost());
            } catch (MalformedURLException e3) {
                e3.printStackTrace();
            }
            if (dVar != null) {
                dVar.f();
            }
            throw new RestRuntimeException("RestRuntimeException: " + e2.getMessage(), e2);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0066, code lost:
        r4.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(d dVar, e eVar, f<T> fVar) {
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
                            dVar.f();
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
                    dVar.f();
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

    private void a(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        if (eVar != null) {
            try {
                LogUtil.d("RestTemplate", httpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.e() + " (" + eVar.b() + SmallTailInfo.EMOTION_SUFFIX);
            } catch (Exception e2) {
                LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
            }
        }
    }
}
