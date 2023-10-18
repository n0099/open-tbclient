package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class ci {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a;
    public static final String b = "404";
    public static volatile String d;
    public static volatile String e;
    public static ci f;
    public static AtomicBoolean h;
    public static String i;
    public static AtomicBoolean j;
    public static String k;
    public transient /* synthetic */ FieldHolder $fh;
    public final br c;
    public Context g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833694633, "Lcom/baidu/mobads/sdk/internal/ci;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833694633, "Lcom/baidu/mobads/sdk/internal/ci;");
                return;
            }
        }
        a = w.b;
        f = new ci();
        d = "";
        e = "";
        h = new AtomicBoolean(false);
        i = "";
        j = new AtomicBoolean(false);
        k = "";
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            String str = cj.e;
            if (cj.d.equals(str)) {
                try {
                    double b2 = bx.b(bx.a(this.g));
                    if (b2 > 0.0d) {
                        return String.valueOf(b2);
                    }
                    return str;
                } catch (Throwable th) {
                    this.c.a(th);
                    return str;
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public ci() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = br.a();
    }

    public static ci a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (ci) invokeV.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    private String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str3 = (String) cls.getDeclaredMethod(CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.class).invoke(cls, str);
                if (TextUtils.isEmpty(str3)) {
                    return str2;
                }
                return str3;
            } catch (Throwable th) {
                this.c.a(th);
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    private String a(String str, Object... objArr) {
        InterceptResult invokeLL;
        IXAdContainerFactory c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, objArr)) == null) {
            z a2 = z.a();
            if (a2 != null && (c = a2.c()) != null) {
                Object remoteParam = c.getRemoteParam(str, objArr);
                if (remoteParam instanceof String) {
                    return (String) remoteParam;
                }
                return "";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, this, str, str2, hashMap) == null) {
            Uri.Builder builder = new Uri.Builder();
            try {
                Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter("p_ver", "9.322").appendQueryParameter("appsid", a("appsid", new Object[0]));
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("v", "android_" + d() + "_" + cj.f);
                if (this.g == null) {
                    str3 = "";
                } else {
                    str3 = this.g.getPackageName();
                }
                Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("pack", str3).appendQueryParameter(ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, a("encodedSn", this.g)).appendQueryParameter("cuid", a("encodedCUID", this.g)).appendQueryParameter("os", "android").appendQueryParameter("osv", bj.a(this.g).c()).appendQueryParameter("romn", b()).appendQueryParameter("romv", c());
                Uri.Builder appendQueryParameter4 = appendQueryParameter3.appendQueryParameter("bdr", "" + bj.a(this.g).a());
                appendQueryParameter4.appendQueryParameter("brd", "" + a(bj.a(this.g).e()));
                if (str != null && str.length() > 128) {
                    int indexOf = str.indexOf(10);
                    if (indexOf <= 0) {
                        indexOf = 127;
                    }
                    str = str.substring(0, indexOf);
                }
                builder.appendQueryParameter("reason", str);
                if (hashMap != null) {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        builder.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable th) {
                this.c.a(th);
            }
            am amVar = new am(a, "POST");
            amVar.a(builder);
            amVar.b();
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, context) == null) && this.g == null) {
            this.g = context;
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("ad", str3);
                hashMap.put("stacktrace", str2);
                a(str, b, hashMap);
            } catch (Exception e2) {
                this.c.a(e2);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                if (h.compareAndSet(false, true)) {
                    Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                    String str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        i = str;
                    }
                }
                return i;
            } catch (Throwable th) {
                this.c.a(th);
                return i;
            }
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                if (j.get()) {
                    return k;
                }
                if (!h.get()) {
                    b();
                }
                if (i.equalsIgnoreCase("")) {
                    j.set(true);
                    return "";
                }
                if (j.compareAndSet(false, true)) {
                    String a2 = a("hw_sc.build.platform.version", "");
                    if (!TextUtils.isEmpty(a2)) {
                        k = a2;
                    }
                }
                return k;
            } catch (Throwable th) {
                this.c.a(th);
                return k;
            }
        }
        return (String) invokeV.objValue;
    }
}
