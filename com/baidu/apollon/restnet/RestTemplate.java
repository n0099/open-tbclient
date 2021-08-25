package com.baidu.apollon.restnet;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.baidu.apollon.restnet.http.HttpDefines;
import com.baidu.apollon.restnet.http.HttpStatus;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.restnet.rest.f;
import com.baidu.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class RestTemplate {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37897a = "RestTemplate";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AbstractHttpMessageConverter<?> f37898b;

    /* renamed from: c  reason: collision with root package name */
    public List<RestHttpRequestInterceptor> f37899c;

    /* renamed from: d  reason: collision with root package name */
    public Context f37900d;

    /* renamed from: e  reason: collision with root package name */
    public String f37901e;

    /* renamed from: f  reason: collision with root package name */
    public String f37902f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37903g;

    /* renamed from: com.baidu.apollon.restnet.RestTemplate$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public final class a implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RestTemplate f37904a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f37905b;

        public /* synthetic */ a(RestTemplate restTemplate, Class cls, AnonymousClass1 anonymousClass1) {
            this(restTemplate, cls);
        }

        @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) || this.f37905b == null) {
                return;
            }
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

        public a(RestTemplate restTemplate, Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {restTemplate, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37904a = restTemplate;
            this.f37905b = cls;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestTemplate(Context context) {
        this(true, context, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Context) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<RestHttpRequestInterceptor> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37899c : (List) invokeV.objValue;
    }

    public AbstractHttpMessageConverter<?> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37898b : (AbstractHttpMessageConverter) invokeV.objValue;
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            a().add(new a(this, cls, null));
            f<T> fVar = new f<>(cls, b());
            d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
            e a3 = a(a2);
            a(HttpDefines.HttpMethod.POST, str, a3);
            return (T) a(a2, a3, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            LogUtil.d("#####. postForEntity. url = " + str);
            a().add(new a(this, cls, null));
            f<T> fVar = new f<>(cls, b());
            d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
            e a3 = a(a2);
            a(HttpDefines.HttpMethod.POST, str, a3);
            return b(a2, a3, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, restMultipartEntity, str2, cls)) == null) {
            a().add(new a(this, cls, null));
            f<T> fVar = new f<>(cls, b());
            d a2 = a(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
            e a3 = a(a2);
            a(HttpDefines.HttpMethod.POST, str, a3);
            return (T) a(a2, a3, fVar);
        }
        return (T) invokeLLLL.objValue;
    }

    public void setMessageConverter(AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, abstractHttpMessageConverter) == null) {
            this.f37898b = abstractHttpMessageConverter;
        }
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.f37899c = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RestTemplate(Context context, String str, String str2) {
        this(true, context, str, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), (Context) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f37903g = z;
        }
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            a().add(new a(this, cls, null));
            f<T> fVar = new f<>(cls, b());
            d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
            e a3 = a(a2);
            a(HttpDefines.HttpMethod.GET, str, a3);
            return b(a2, a3, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public RestTemplate(boolean z, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), context, str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37898b = null;
        this.f37899c = new ArrayList();
        this.f37900d = null;
        this.f37901e = null;
        this.f37902f = "";
        this.f37903g = true;
        this.f37902f = str2;
        this.f37900d = DxmApplicationContextImpl.getApplicationContext(context);
        this.f37901e = str;
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            a().add(new a(this, cls, null));
            f<T> fVar = new f<>(cls, b());
            d a2 = a(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
            e a3 = a(a2);
            a(HttpDefines.HttpMethod.GET, str, a3);
            return (T) a(a2, a3, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public <T> RestResponseEntity<T> b(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048580, this, str, list, str2, cls)) == null) ? b(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> T c(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, list, str2, cls)) == null) ? (T) c(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    public <T> RestResponseEntity<T> d(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, str, list, str2, cls)) == null) ? d(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        r5.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> RestResponseEntity<T> b(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        RestResponseEntity<T> restResponseEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, this, dVar, eVar, fVar)) == null) {
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
                            restResponseEntity.b(fVar.a());
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
        return (RestResponseEntity) invokeLLL.objValue;
    }

    public <T> T a(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, list, str2, cls)) == null) ? (T) a(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    private d a(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines.HttpMethod httpMethod, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, list, restMultipartEntity, str2, httpMethod, Boolean.valueOf(z)})) == null) {
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
            d a2 = com.baidu.apollon.restnet.rest.httpurlconnection.c.a().a(this.f37900d, this.f37902f, this.f37901e, str, httpMethod, list, restMultipartEntity, str2, z);
            for (RestHttpRequestInterceptor restHttpRequestInterceptor : a()) {
                restHttpRequestInterceptor.intercept(this.f37900d, a2);
            }
            return a2;
        }
        return (d) invokeCommon.objValue;
    }

    private e a(d dVar) throws RestRuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            try {
                URL url = new URL(dVar.c());
                String host = url.getHost();
                int port = url.getPort();
                if (port > 0) {
                    String str = host + ":" + port;
                }
                if (this.f37903g) {
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
        return (e) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        r5.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T a(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, dVar, eVar, fVar)) == null) {
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
        return (T) invokeLLL.objValue;
    }

    private void a(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, httpMethod, str, eVar) == null) || eVar == null) {
            return;
        }
        try {
            LogUtil.d("RestTemplate", httpMethod.name() + " request for \"" + str + "\" resulted in " + eVar.e() + " (" + eVar.b() + SmallTailInfo.EMOTION_SUFFIX);
        } catch (Exception e2) {
            LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
        }
    }
}
