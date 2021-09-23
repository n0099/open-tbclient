package com.baidu.fsg.base.restnet;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.a.a;
import com.baidu.fsg.base.restnet.http.HttpDefines;
import com.baidu.fsg.base.restnet.http.HttpStatus;
import com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.fsg.base.restnet.rest.d;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.restnet.rest.f;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class RestTemplate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RestTemplate";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public boolean mIsReuseLink;
    public String mRestType;
    public String mUserAgent;
    public a<?> messageConverter;
    public List<RestHttpRequestInterceptor> requestInterceptors;

    /* renamed from: com.baidu.fsg.base.restnet.RestTemplate$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public final class AcceptHeaderRequestInterceptor implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Class<?> responseType;
        public final /* synthetic */ RestTemplate this$0;

        public AcceptHeaderRequestInterceptor(RestTemplate restTemplate, Class<?> cls) {
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
            this.this$0 = restTemplate;
            this.responseType = cls;
        }

        public /* synthetic */ AcceptHeaderRequestInterceptor(RestTemplate restTemplate, Class cls, AnonymousClass1 anonymousClass1) {
            this(restTemplate, cls);
        }

        @Override // com.baidu.fsg.base.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) || this.responseType == null) {
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
            dVar.a().b(sb.toString());
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

    private d createHttpRequest(String str, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2, HttpDefines.HttpMethod httpMethod, boolean z) {
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
            d a2 = com.baidu.fsg.base.restnet.b.d.a().a(this.mContext, this.mRestType, this.mUserAgent, str, httpMethod, list, restMultipartEntity, str2, z);
            for (RestHttpRequestInterceptor restHttpRequestInterceptor : getRequestInterceptors()) {
                restHttpRequestInterceptor.intercept(this.mContext, a2);
            }
            return a2;
        }
        return (d) invokeCommon.objValue;
    }

    private e doExecuteForResponse(d dVar) throws RestRuntimeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dVar)) == null) {
            try {
                URL url = new URL(dVar.getUrl());
                String host = url.getHost();
                int port = url.getPort();
                if (port > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(host);
                    sb.append(":");
                    sb.append(port);
                    host = sb.toString();
                }
                dVar.a(url.toString());
                dVar.a().set("Host", host);
                e execute = dVar.execute();
                if (ApollonConstants.DEBUG) {
                    String t = execute.a().t();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("rtt:");
                    sb2.append(t);
                    LogUtil.v("apollon_rest", sb2.toString());
                }
                return execute;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (dVar != null) {
                    dVar.close();
                }
                throw new RestRuntimeException("RestRuntimeException: " + e2.getMessage(), e2);
            }
        }
        return (e) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> T handleAndCloseResponse(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, dVar, eVar, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            if (eVar != null) {
                try {
                    try {
                        if (eVar.getStatusCode().series() != HttpStatus.Series.CLIENT_ERROR && eVar.getStatusCode().series() != HttpStatus.Series.SERVER_ERROR) {
                            T a2 = fVar.a(eVar);
                            if (a2 != null) {
                                return a2;
                            }
                            if (dVar != null) {
                                dVar.close();
                            }
                            if (eVar != null) {
                                eVar.close();
                            }
                            return null;
                        }
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("error: ");
                        sb.append(e2.getMessage());
                        throw new RestRuntimeException(sb.toString(), e2);
                    }
                } finally {
                    if (dVar != null) {
                        dVar.close();
                    }
                    if (eVar != null) {
                        eVar.close();
                    }
                }
            }
            if (eVar != null) {
                eVar.close();
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> RestResponseEntity<T> handleAndCloseResponseForEntity(d dVar, e eVar, f<T> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, dVar, eVar, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            try {
                if (eVar != null) {
                    try {
                        if (eVar.getStatusCode().series() != HttpStatus.Series.CLIENT_ERROR && eVar.getStatusCode().series() != HttpStatus.Series.SERVER_ERROR) {
                            T a2 = fVar.a(eVar);
                            if (a2 != null) {
                                return new RestResponseEntity<>(a2, eVar.a(), eVar.getStatusCode());
                            }
                            RestResponseEntity<T> restResponseEntity = new RestResponseEntity<>(eVar.a(), eVar.getStatusCode());
                            if (dVar != null) {
                                dVar.close();
                            }
                            if (eVar != null) {
                                eVar.close();
                            }
                            return restResponseEntity;
                        }
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("error: ");
                        sb.append(e2.getMessage());
                        throw new RestRuntimeException(sb.toString(), e2);
                    }
                }
                if (eVar != null) {
                    eVar.close();
                }
                return null;
            } finally {
                if (dVar != null) {
                    dVar.close();
                }
                if (eVar != null) {
                    eVar.close();
                }
            }
        }
        return (RestResponseEntity) invokeLLL.objValue;
    }

    private void logResponseStatus(HttpDefines.HttpMethod httpMethod, String str, e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, this, httpMethod, str, eVar) == null) || eVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(httpMethod.name());
            sb.append(" request for \"");
            sb.append(str);
            sb.append("\" resulted in ");
            sb.append(eVar.getStatusCode());
            sb.append(" (");
            sb.append(eVar.c());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            LogUtil.d("RestTemplate", sb.toString());
        } catch (Exception e2) {
            LogUtil.d("RestTemplate", "IOException : " + e2.getMessage());
        }
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, list, str2, cls)) == null) ? getForEntity(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> RestResponseEntity<T> getForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
            return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, list, str2, cls)) == null) ? (T) getForObject(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    public <T> T getForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.GET, z);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.GET, str, doExecuteForResponse);
            return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public a<?> getMessageConverter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.messageConverter : (a) invokeV.objValue;
    }

    public List<RestHttpRequestInterceptor> getRequestInterceptors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.requestInterceptors : (List) invokeV.objValue;
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, str, list, str2, cls)) == null) ? postForEntity(str, list, str2, cls, false) : (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> RestResponseEntity<T> postForEntity(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            LogUtil.d("#####. postForEntity. url = " + str);
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
            return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (RestResponseEntity) invokeCommon.objValue;
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, list, str2, cls)) == null) ? (T) postForObject(str, list, str2, cls, false) : (T) invokeLLLL.objValue;
    }

    public <T> T postForObject(String str, List<RestNameValuePair> list, String str2, Class<T> cls, boolean z) throws RestRuntimeException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, list, str2, cls, Boolean.valueOf(z)})) == null) {
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, list, null, str2, HttpDefines.HttpMethod.POST, z);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
            return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (T) invokeCommon.objValue;
    }

    public <T> RestResponseEntity<T> postMultipartForEntity(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, str, restMultipartEntity, str2, cls)) == null) {
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
            return handleAndCloseResponseForEntity(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (RestResponseEntity) invokeLLLL.objValue;
    }

    public <T> T postMultipartForObject(String str, RestMultipartEntity restMultipartEntity, String str2, Class<T> cls) throws RestRuntimeException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048587, this, str, restMultipartEntity, str2, cls)) == null) {
            getRequestInterceptors().add(new AcceptHeaderRequestInterceptor(this, cls, null));
            f<T> fVar = new f<>(cls, getMessageConverter());
            d createHttpRequest = createHttpRequest(str, null, restMultipartEntity, str2, HttpDefines.HttpMethod.POST, false);
            e doExecuteForResponse = doExecuteForResponse(createHttpRequest);
            logResponseStatus(HttpDefines.HttpMethod.POST, str, doExecuteForResponse);
            return (T) handleAndCloseResponse(createHttpRequest, doExecuteForResponse, fVar);
        }
        return (T) invokeLLLL.objValue;
    }

    public void setMessageConverter(a<?> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.messageConverter = aVar;
        }
    }

    public void setRequestInterceptor(List<RestHttpRequestInterceptor> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.requestInterceptors = list;
        }
    }

    public void setReuseLink(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mIsReuseLink = z;
        }
    }
}
