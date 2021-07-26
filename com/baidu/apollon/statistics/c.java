package com.baidu.apollon.statistics;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3985a = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f3986b;

    /* renamed from: c  reason: collision with root package name */
    public int f3987c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3988d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3989e;

    /* renamed from: com.baidu.apollon.statistics.c$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f3990a;

        /* renamed from: b  reason: collision with root package name */
        public String f3991b;

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

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static c f3992a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2081874440, "Lcom/baidu/apollon/statistics/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2081874440, "Lcom/baidu/apollon/statistics/c$b;");
                    return;
                }
            }
            f3992a = new c(null);
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1906211386, "Lcom/baidu/apollon/statistics/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1906211386, "Lcom/baidu/apollon/statistics/c;");
        }
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f3992a : (c) invokeV.objValue;
    }

    @SuppressLint({"NewApi"})
    private void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || (i2 = this.f3987c) <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    this.f3986b.remove(0);
                    i2 = i3;
                } else {
                    this.f3987c = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f3986b);
                int i4 = this.f3987c;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i4 = i5;
                    } else {
                        this.f3987c = 0;
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && com.baidu.apollon.statistics.a.a(PayStatisticsUtil.c(), false, Config.v)) {
            String a2 = com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v);
            if (TextUtils.isEmpty(a2) || a2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f3988d) {
                    this.f3986b = new JSONArray(a2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f3988d) {
                z = this.f3986b.length() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public c() {
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
        this.f3986b = new JSONArray();
        this.f3987c = 0;
        this.f3988d = new byte[0];
        this.f3989e = new byte[0];
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        synchronized (this.f3988d) {
            try {
                this.f3986b.put(this.f3986b.length(), eVar.a());
            } catch (JSONException unused) {
            }
            a(g.a().a(eVar.f4007h));
            if (CustomerService.getInstance().isEnabled()) {
                CustomerService.getInstance().enqueEvent(eVar);
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && "normal_log".equals(str)) {
            synchronized (this.f3988d) {
                d();
            }
            a(false);
        }
    }

    private void a(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            synchronized (this.f3988d) {
                if (this.f3986b.length() == 0) {
                    com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, "", false);
                    return;
                }
                String jSONArray = this.f3986b.toString();
                try {
                    i2 = jSONArray.getBytes().length;
                } catch (Throwable th) {
                    if (th instanceof OutOfMemoryError) {
                        System.gc();
                        return;
                    }
                    i2 = 0;
                }
                if (i2 == 0) {
                    return;
                }
                if (204800 > i2) {
                    com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, jSONArray, false);
                }
                if (i2 >= 204800 || z) {
                    LogSender.getInstance().triggerSending("normal_log");
                }
            }
        }
    }

    public a a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            a aVar = new a();
            synchronized (this.f3989e) {
                try {
                    StatisticsSettings a2 = PayStatisticsUtil.getInstance().a();
                    jSONObject = a2 != null ? new JSONObject(a2.getCommonHeader()) : null;
                } catch (JSONException unused) {
                    return aVar;
                }
            }
            if (jSONObject == null) {
                return aVar;
            }
            synchronized (this.f3988d) {
                try {
                    jSONObject.put("array", this.f3986b);
                    aVar.f3990a = this.f3986b.length();
                    aVar.f3991b = jSONObject.toString();
                } catch (JSONException unused2) {
                }
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) && "normal_log".equals(str)) {
            this.f3987c = i2;
        }
    }
}
