package com.alipay.sdk.cons;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f1865a = "https://mobilegw.alipay.com/mgw.htm";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1866b = "https://mobilegw.alipaydev.com/mgw.htm";

    /* renamed from: c  reason: collision with root package name */
    public static String f1867c = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDENksAVqDoz5SMCZq0bsZwE+I3NjrANyTTwUVSf1+ec1PfPB4tiocEpYJFCYju9MIbawR8ivECbUWjpffZq5QllJg+19CB7V5rYGcEnb/M7CS3lFF2sNcRFJUtXUUAqyR3/l7PmpxTwObZ4DLG258dhE2vFlVGXjnuLs+FI2hg4QIDAQAB";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1868d = "2014052600006128";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1869e = "1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1870f = "h.a.3.6.5";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1871g = "15.6.5";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1872h = "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1873i = "DF:EB:19:0B:BC:A8:7E:F9:EC:8D:6A:D8:FF:17:59:2F:66:17:B4:8B:6C:3B:A4:9A:14:F7:E7:9D:09:88:5A:B3";
    public static final String j = "alipays://platformapi/startApp?";
    public static final String k = "intent://platformapi/startapp?";
    public static final String l = "sdklite://h5quit?result=";
    public static final String m = "sdklite://h5quit";
    public static final String n = "http://m.alipay.com/?action=h5quit";
    public static final String o = "&end_code=";
    public static final String p = "&return_url=\"";
    public static final String q = "&return_url=";
    public static final String r = "service=alipay.acquire.mr.ord.createandpay";
    public static boolean s = false;
    public static final String t = "https://wappaygw.alipay.com/home/exterfaceAssign.htm?";
    public static final String u = "https://mclient.alipay.com/home/exterfaceAssign.htm?";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1973481192, "Lcom/alipay/sdk/cons/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1973481192, "Lcom/alipay/sdk/cons/a;");
        }
    }

    public a() {
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
}
