package b.d.a.a.a;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.StrategyProcess;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f30102a;

    /* renamed from: b  reason: collision with root package name */
    public int f30103b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f30104c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f30105d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f30106a;

        /* renamed from: b  reason: collision with root package name */
        public String f30107b;

        public b() {
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

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f30108a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-926948570, "Lb/d/a/a/a/d$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-926948570, "Lb/d/a/a/a/d$c;");
                    return;
                }
            }
            f30108a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f30108a : (d) invokeV.objValue;
    }

    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && "normal_log".equals(str)) {
            this.f30103b = i2;
        }
    }

    public void c(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        synchronized (this.f30104c) {
            try {
                this.f30102a.put(this.f30102a.length(), fVar.b());
            } catch (JSONException unused) {
            }
            e(StrategyProcess.getInstance().isForceToSend(fVar.f30112a));
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && "normal_log".equals(str)) {
            synchronized (this.f30104c) {
                i();
            }
            e(false);
        }
    }

    public final void e(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            synchronized (this.f30104c) {
                if (this.f30102a.length() == 0) {
                    b.d.a.a.a.a.g(false, StatApi.getAppContext(), "f509cd1137cc45e510496d1c174306a6.json", "", false);
                    return;
                }
                String jSONArray = this.f30102a.toString();
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
                    b.d.a.a.a.a.g(false, StatApi.getAppContext(), "f509cd1137cc45e510496d1c174306a6.json", jSONArray, false);
                }
                if (i2 >= 204800 || z) {
                    LogSender.getInstance().triggerSending("normal_log");
                }
            }
        }
    }

    public b f(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            b bVar = new b();
            synchronized (this.f30105d) {
                try {
                    IStatConfig settings = StatApi.getInstance().getSettings();
                    jSONObject = settings != null ? new JSONObject(settings.getHeader()) : null;
                } catch (JSONException unused) {
                    return bVar;
                }
            }
            if (jSONObject == null) {
                return bVar;
            }
            synchronized (this.f30104c) {
                try {
                    jSONObject.put("array", this.f30102a);
                    bVar.f30106a = this.f30102a.length();
                    bVar.f30107b = jSONObject.toString();
                } catch (JSONException unused2) {
                }
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f30104c) {
                z = this.f30102a.length() == 0;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && b.d.a.a.a.a.i(StatApi.getAppContext(), false, "f509cd1137cc45e510496d1c174306a6.json")) {
            String c2 = b.d.a.a.a.a.c(false, StatApi.getAppContext(), "f509cd1137cc45e510496d1c174306a6.json");
            if (TextUtils.isEmpty(c2) || c2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f30104c) {
                    this.f30102a = new JSONArray(c2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void i() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (i2 = this.f30103b) <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    this.f30102a.remove(0);
                    i2 = i3;
                } else {
                    this.f30103b = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f30102a);
                int i4 = this.f30103b;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i4 = i5;
                    } else {
                        this.f30103b = 0;
                        return;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30102a = new JSONArray();
        this.f30103b = 0;
        this.f30104c = new byte[0];
        this.f30105d = new byte[0];
    }
}
