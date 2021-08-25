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
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39379a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f39380b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f39381c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f39382d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f39383e;

    /* renamed from: com.baidu.fsg.base.statistics.e$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f39384a;

        /* renamed from: b  reason: collision with root package name */
        public String f39385b;

        /* renamed from: c  reason: collision with root package name */
        public f[] f39386c;

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
        public static e f39387a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004189609, "Lcom/baidu/fsg/base/statistics/e$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004189609, "Lcom/baidu/fsg/base/statistics/e$b;");
                    return;
                }
            }
            f39387a = new e(null);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1047894439, "Lcom/baidu/fsg/base/statistics/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1047894439, "Lcom/baidu/fsg/base/statistics/e;");
        }
    }

    public e() {
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
        this.f39380b = new JSONArray();
        this.f39381c = new byte[0];
        this.f39382d = new byte[0];
        this.f39383e = new byte[0];
    }

    public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f39387a : (e) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && com.baidu.fsg.base.statistics.b.o.equals(str)) {
            synchronized (this.f39382d) {
                this.f39380b = new JSONArray();
            }
            com.baidu.fsg.base.statistics.a.a(RimStatisticsUtil.getAppContext(), com.baidu.fsg.base.statistics.b.n, StringUtil.EMPTY_ARRAY, false);
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
            synchronized (this.f39382d) {
                try {
                    this.f39380b.put(this.f39380b.length(), jSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Context appContext = RimStatisticsUtil.getAppContext();
            if (com.baidu.fsg.base.statistics.a.c(appContext, com.baidu.fsg.base.statistics.b.n)) {
                String a2 = com.baidu.fsg.base.statistics.a.a(appContext, com.baidu.fsg.base.statistics.b.n);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                if ((a2 == null || a2.getBytes().length <= 102400) && d.a().a(appContext, a2)) {
                    try {
                        if (a2.getBytes().length > 51200) {
                            byte[] bArr = new byte[51200];
                            a2.getBytes(0, 51200, bArr, 0);
                            a2 = new String(bArr);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(a2);
                        long currentTimeMillis = System.currentTimeMillis();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                            if (currentTimeMillis - jSONObject.getLong("dim_excep_time") <= 604800000) {
                                a().a(jSONObject);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.f39382d) {
                z = this.f39380b.length() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public JSONArray d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39380b : (JSONArray) invokeV.objValue;
    }
}
