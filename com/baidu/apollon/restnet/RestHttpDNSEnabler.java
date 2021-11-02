package com.baidu.apollon.restnet;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class RestHttpDNSEnabler {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36059a = "RestHttpDNSEnabler";

    /* renamed from: b  reason: collision with root package name */
    public static final String f36060b = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    /* renamed from: c  reason: collision with root package name */
    public static Pattern f36061c;

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap<String, a> f36062d;

    /* renamed from: e  reason: collision with root package name */
    public static long f36063e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36066a;

        /* renamed from: b  reason: collision with root package name */
        public long f36067b;

        /* renamed from: c  reason: collision with root package name */
        public long f36068c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f36069d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            this(str, System.currentTimeMillis(), RestHttpDNSEnabler.f36063e);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r8;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], ((Long) objArr2[1]).longValue(), ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f36066a = str;
            this.f36067b = j;
            this.f36068c = j2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(774487733, "Lcom/baidu/apollon/restnet/RestHttpDNSEnabler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(774487733, "Lcom/baidu/apollon/restnet/RestHttpDNSEnabler;");
                return;
            }
        }
        f36061c = Pattern.compile(f36060b);
        f36062d = new ConcurrentHashMap<>();
        f36063e = 86400L;
    }

    public RestHttpDNSEnabler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            for (Map.Entry<String, a> entry : f36062d.entrySet()) {
                if (entry.getValue().f36066a.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void enableHttpDns(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                if (f36062d.containsKey(str)) {
                    return;
                }
                new Thread(new Runnable(context, str) { // from class: com.baidu.apollon.restnet.RestHttpDNSEnabler.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Context f36064a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f36065b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36064a = context;
                        this.f36065b = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RestTemplate restTemplate = new RestTemplate(DxmApplicationContextImpl.getApplicationContext(this.f36064a));
                            restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new RestNameValuePair("dn", this.f36065b));
                            try {
                                String str2 = (String) restTemplate.a("http://180.76.76.112/", arrayList, "utf-8", String.class);
                                if (str2 instanceof String) {
                                    String trim = str2.trim();
                                    if (trim.contains(" ")) {
                                        String[] split = trim.split(" ");
                                        trim = split[new Random().nextInt(split.length)];
                                    }
                                    LogUtil.v("apollon_rest", "result: " + trim);
                                    if (TextUtils.isEmpty(trim) || !RestHttpDNSEnabler.a(trim)) {
                                        return;
                                    }
                                    synchronized (RestHttpDNSEnabler.f36062d) {
                                        RestHttpDNSEnabler.f36062d.put(this.f36065b, new a(trim));
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }).start();
                return;
            }
            String str2 = f36059a;
            LogUtil.w(str2, f36059a + " enableHttpDns params context is null or hostName is null.");
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? f36061c.matcher(str).matches() : invokeL.booleanValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && a(str)) {
            Iterator<Map.Entry<String, a>> it = f36062d.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().f36066a.equals(str)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public static String a(URL url) {
        InterceptResult invokeL;
        String replaceFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, url)) == null) {
            String host = url.getHost();
            String url2 = url.toString();
            for (Map.Entry<String, a> entry : f36062d.entrySet()) {
                String key = entry.getKey();
                if (key.equals(host) || (ApollonConstants.WALLET_SPECIFIC && key.endsWith("baifubao.com") && host.endsWith("baifubao.com"))) {
                    synchronized (f36062d) {
                        replaceFirst = url2.replaceFirst(host, f36062d.get(key).f36066a);
                    }
                    return replaceFirst;
                }
            }
            return url2;
        }
        return (String) invokeL.objValue;
    }
}
