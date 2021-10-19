package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39551a = "g";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f39552b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f39553c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f39554d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f39555e;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f39556a;

        /* renamed from: b  reason: collision with root package name */
        public String f39557b;

        /* renamed from: c  reason: collision with root package name */
        public h[] f39558c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static g f39559a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004249191, "Lcom/baidu/fsg/base/statistics/g$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004249191, "Lcom/baidu/fsg/base/statistics/g$b;");
                    return;
                }
            }
            f39559a = new g(null);
        }

        public b() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1047894501, "Lcom/baidu/fsg/base/statistics/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1047894501, "Lcom/baidu/fsg/base/statistics/g;");
        }
    }

    public g() {
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
        this.f39552b = new JSONArray();
        this.f39553c = new byte[0];
        this.f39554d = new byte[0];
        this.f39555e = new byte[0];
    }

    public /* synthetic */ g(f fVar) {
        this();
    }

    public static g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f39559a : (g) invokeV.objValue;
    }

    public JSONArray a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f39552b : (JSONArray) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && com.baidu.fsg.base.statistics.b.o.equals(str)) {
            synchronized (this.f39554d) {
                this.f39552b = new JSONArray();
            }
            com.baidu.fsg.base.statistics.a.a(RimStatisticsUtil.getAppContext(), com.baidu.fsg.base.statistics.b.n, StringUtil.EMPTY_ARRAY, false);
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            synchronized (this.f39554d) {
                try {
                    this.f39552b.put(this.f39552b.length(), jSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f39554d) {
                z = this.f39552b.length() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context appContext = RimStatisticsUtil.getAppContext();
            if (com.baidu.fsg.base.statistics.a.a(appContext, com.baidu.fsg.base.statistics.b.n)) {
                String b2 = com.baidu.fsg.base.statistics.a.b(appContext, com.baidu.fsg.base.statistics.b.n);
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                if ((b2 == null || b2.getBytes().length <= 102400) && e.a().a(appContext, b2)) {
                    try {
                        if (b2.getBytes().length > 51200) {
                            byte[] bArr = new byte[51200];
                            b2.getBytes(0, 51200, bArr, 0);
                            b2 = new String(bArr);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(b2);
                        long currentTimeMillis = System.currentTimeMillis();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                            if (currentTimeMillis - jSONObject.getLong("dim_excep_time") <= 604800000) {
                                b().a(jSONObject);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
