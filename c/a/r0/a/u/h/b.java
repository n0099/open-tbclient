package c.a.r0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.core.R;
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
public class b implements c.a.r0.a.u.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f9529b;

    /* renamed from: c  reason: collision with root package name */
    public String f9530c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f9531d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9532e;

    /* loaded from: classes.dex */
    public static class a extends b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final b f9533g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f9534h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f9535i;

        /* renamed from: j  reason: collision with root package name */
        public static final b f9536j;

        /* renamed from: k  reason: collision with root package name */
        public static final b f9537k;
        public static final b l;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public volatile String f9538f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(622184598, "Lc/a/r0/a/u/h/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(622184598, "Lc/a/r0/a/u/h/b$a;");
                    return;
                }
            }
            f9533g = new a(0);
            f9534h = new a(202, "json str is empty");
            f9535i = new a(202, "json str parse fail");
            f9536j = new a(1001, "json put data fail");
            f9537k = new a(1001, "swan app is null");
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

        @Override // c.a.r0.a.u.h.b, c.a.r0.a.u.h.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f9538f == null) {
                    synchronized (this) {
                        if (this.f9538f == null) {
                            this.f9538f = super.a();
                        }
                    }
                }
                return this.f9538f;
            }
            return (String) invokeV.objValue;
        }

        @Override // c.a.r0.a.u.h.b
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9532e = false;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 101) {
                    if (i2 != 201) {
                        if (i2 != 202) {
                            if (i2 != 301) {
                                if (i2 != 302) {
                                    switch (i2) {
                                        case 401:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
                                        case 402:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
                                        case 403:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
                                        default:
                                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                                    }
                                }
                                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
                            }
                            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
                        }
                        return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
                    }
                    return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                }
                return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_not_support);
            }
            return AppRuntime.getAppContext().getString(R.string.united_scheme_err_message_ok);
        }
        return (String) invokeI.objValue;
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.f9536j : (b) invokeV.objValue;
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f9534h : (b) invokeV.objValue;
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.f9535i : (b) invokeV.objValue;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.f9533g : (b) invokeV.objValue;
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.l : (b) invokeV.objValue;
    }

    public static b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.f9537k : (b) invokeV.objValue;
    }

    @Override // c.a.r0.a.u.h.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(this.f9529b));
                if (TextUtils.isEmpty(this.f9530c)) {
                    this.f9530c = b(this.f9529b);
                }
                jSONObject.put("message", this.f9530c);
                if (this.f9531d != null) {
                    jSONObject.put("data", this.f9532e ? Uri.encode(this.f9531d.toString(), StandardCharsets.UTF_8.name()) : this.f9531d);
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
            if (this.f9531d == null) {
                this.f9531d = new JSONObject();
            }
            try {
                this.f9531d.put(str, obj);
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#putData json put data fail", e2, false);
            }
        }
    }

    public boolean h(@NonNull String str, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (this.f9531d == null) {
                this.f9531d = new JSONObject();
            }
            try {
                this.f9531d.put(str, obj);
                return true;
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#safePutData json put data fail", e2, false);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.a.u.h.a
    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f9529b == 0 : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a() : (String) invokeV.objValue;
    }

    public b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9532e = false;
        this.f9529b = i2;
    }

    public b(int i2, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f9532e = false;
        this.f9529b = i2;
        this.f9530c = str;
    }

    public b(int i2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f9532e = false;
        this.f9529b = i2;
        this.f9531d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65541, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.f9532e = false;
        this.f9529b = i2;
        this.f9531d = jSONObject;
        this.f9532e = z;
    }

    public b(int i2, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, jSONObject};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f9532e = false;
        this.f9529b = i2;
        this.f9530c = str;
        this.f9531d = jSONObject;
    }
}
