package c.a.o0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import c.a.o0.a.a2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f11497a;

    /* renamed from: b  reason: collision with root package name */
    public String f11498b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11499c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11500d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f11501e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11502f;

    /* renamed from: c.a.o0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0592a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f11503a;

        /* renamed from: b  reason: collision with root package name */
        public String f11504b;

        public C0592a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11503a = false;
            this.f11503a = z;
            this.f11504b = str;
        }

        public static C0592a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C0592a(false, "未启用真机调试") : (C0592a) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11504b : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11503a : invokeV.booleanValue;
        }
    }

    public a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11497a = null;
        this.f11498b = null;
        this.f11499c = false;
        this.f11500d = false;
        this.f11501e = false;
        this.f11502f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f11497a = optJSONObject.optString("hostname", null);
            this.f11498b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f11499c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f11502f = z;
        if (z) {
            this.f11497a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f11497a);
            this.f11498b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f11498b);
            this.f11499c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f11499c);
            this.f11500d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f11500d);
        }
        String str = this.f11497a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f11501e = true;
    }

    public static C0592a f(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? aVar == null ? C0592a.c() : aVar.e() : (C0592a) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11497a);
            if (this.f11498b != null) {
                str = ":" + this.f11498b;
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11500d : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.o0.a.v.a.f(e.V()) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f11499c : invokeV.booleanValue;
    }

    public C0592a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f11502f && c()) {
                return new C0592a(false, "线上包禁用真机调试");
            }
            boolean z = this.f11501e;
            return new C0592a(z, !z ? "未启用真机调试" : this.f11502f ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return (C0592a) invokeV.objValue;
    }
}
