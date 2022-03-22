package c.a.n0.a.k.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.u.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b implements c.a.n0.a.k.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f5288b;

    /* renamed from: c  reason: collision with root package name */
    public String f5289c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f5290d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5291e;

    /* loaded from: classes.dex */
    public static class a extends b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final b f5292g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f5293h;
        public static final b i;
        public static final b j;
        public static final b k;
        public static final b l;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public volatile String f5294f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1547562460, "Lc/a/n0/a/k/h/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1547562460, "Lc/a/n0/a/k/h/b$a;");
                    return;
                }
            }
            f5292g = new a(0);
            f5293h = new a(202, "json str is empty");
            i = new a(202, "json str parse fail");
            j = new a(1001, "json put data fail");
            k = new a(1001, "swan app is null");
            l = new a(1001, "swan activity is null");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.n0.a.k.h.b, c.a.n0.a.k.h.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f5294f == null) {
                    synchronized (this) {
                        if (this.f5294f == null) {
                            this.f5294f = super.a();
                        }
                    }
                }
                return this.f5294f;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.n0.a.k.h.b
        public void g(@NonNull String str, @NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, @NonNull String str) {
            super(i2, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5291e = false;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1472);
                                        case 402:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f146f);
                                        case 403:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1470);
                                        default:
                                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1477);
                                    }
                                }
                                return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1471);
                            }
                            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1473);
                        }
                        return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1476);
                    }
                    return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1477);
                }
                return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1474);
            }
            return AppRuntime.getAppContext().getString(R.string.obfuscated_res_0x7f0f1475);
        }
        return (String) invokeI.objValue;
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.j : (b) invokeV.objValue;
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f5293h : (b) invokeV.objValue;
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.i : (b) invokeV.objValue;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.f5292g : (b) invokeV.objValue;
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.l : (b) invokeV.objValue;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.k : (b) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.h.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(this.f5288b));
                if (TextUtils.isEmpty(this.f5289c)) {
                    this.f5289c = b(this.f5288b);
                }
                jSONObject.put("message", this.f5289c);
                if (this.f5290d != null) {
                    jSONObject.put("data", this.f5291e ? Uri.encode(this.f5290d.toString(), StandardCharsets.UTF_8.name()) : this.f5290d);
                }
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#toJsonString json put data fail", e2, false);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public void g(@NonNull String str, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (this.f5290d == null) {
                this.f5290d = new JSONObject();
            }
            try {
                this.f5290d.put(str, obj);
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#putData json put data fail", e2, false);
            }
        }
    }

    public boolean h(@NonNull String str, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (this.f5290d == null) {
                this.f5290d = new JSONObject();
            }
            try {
                this.f5290d.put(str, obj);
                return true;
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#safePutData json put data fail", e2, false);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.n0.a.k.h.a
    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f5288b == 0 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a() : (String) invokeV.objValue;
    }

    public b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5291e = false;
        this.f5288b = i;
    }

    public b(int i, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f5291e = false;
        this.f5288b = i;
        this.f5289c = str;
    }

    public b(int i, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jSONObject};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f5291e = false;
        this.f5288b = i;
        this.f5290d = jSONObject;
    }

    public b(int i, @NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.f5291e = false;
        this.f5288b = i;
        this.f5290d = jSONObject;
        this.f5291e = z;
    }

    public b(int i, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str, jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f5291e = false;
        this.f5288b = i;
        this.f5289c = str;
        this.f5290d = jSONObject;
    }
}
