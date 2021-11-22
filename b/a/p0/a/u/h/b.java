package b.a.p0.a.u.h;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class b implements b.a.p0.a.u.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f8958b;

    /* renamed from: c  reason: collision with root package name */
    public String f8959c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f8960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8961e;

    /* loaded from: classes.dex */
    public static class a extends b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: g  reason: collision with root package name */
        public static final b f8962g;

        /* renamed from: h  reason: collision with root package name */
        public static final b f8963h;

        /* renamed from: i  reason: collision with root package name */
        public static final b f8964i;
        public static final b j;
        public static final b k;
        public static final b l;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public volatile String f8965f;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-144319085, "Lb/a/p0/a/u/h/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-144319085, "Lb/a/p0/a/u/h/b$a;");
                    return;
                }
            }
            f8962g = new a(0);
            f8963h = new a(202, "json str is empty");
            f8964i = new a(202, "json str parse fail");
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

        @Override // b.a.p0.a.u.h.b, b.a.p0.a.u.h.a
        @NonNull
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f8965f == null) {
                    synchronized (this) {
                        if (this.f8965f == null) {
                            this.f8965f = super.a();
                        }
                    }
                }
                return this.f8965f;
            }
            return (String) invokeV.objValue;
        }

        @Override // b.a.p0.a.u.h.b
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
        this.f8961e = false;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.j : (b) invokeV.objValue;
    }

    public static b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.f8963h : (b) invokeV.objValue;
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.f8964i : (b) invokeV.objValue;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.f8962g : (b) invokeV.objValue;
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

    @Override // b.a.p0.a.u.h.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(this.f8958b));
                if (TextUtils.isEmpty(this.f8959c)) {
                    this.f8959c = b(this.f8958b);
                }
                jSONObject.put("message", this.f8959c);
                if (this.f8960d != null) {
                    jSONObject.put("data", this.f8961e ? Uri.encode(this.f8960d.toString(), StandardCharsets.UTF_8.name()) : this.f8960d);
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
            if (this.f8960d == null) {
                this.f8960d = new JSONObject();
            }
            try {
                this.f8960d.put(str, obj);
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#putData json put data fail", e2, false);
            }
        }
    }

    public boolean h(@NonNull String str, @Nullable Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, obj)) == null) {
            if (this.f8960d == null) {
                this.f8960d = new JSONObject();
            }
            try {
                this.f8960d.put(str, obj);
                return true;
            } catch (JSONException e2) {
                d.p("SwanApiResult", "API", "#safePutData json put data fail", e2, false);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.a.u.h.a
    public boolean isSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8958b == 0 : invokeV.booleanValue;
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
        this.f8961e = false;
        this.f8958b = i2;
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
        this.f8961e = false;
        this.f8958b = i2;
        this.f8959c = str;
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
        this.f8961e = false;
        this.f8958b = i2;
        this.f8960d = jSONObject;
    }

    public b(int i2, @NonNull JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        this.f8961e = false;
        this.f8958b = i2;
        this.f8960d = jSONObject;
        this.f8961e = z;
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
        this.f8961e = false;
        this.f8958b = i2;
        this.f8959c = str;
        this.f8960d = jSONObject;
    }
}
