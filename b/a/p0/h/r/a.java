package b.a.p0.h.r;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import b.a.p0.a.a2.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10725a;

    /* renamed from: b  reason: collision with root package name */
    public String f10726b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10727c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10728d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10729e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10730f;

    /* renamed from: b.a.p0.h.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0589a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f10731a;

        /* renamed from: b  reason: collision with root package name */
        public String f10732b;

        public C0589a(boolean z, String str) {
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
            this.f10731a = false;
            this.f10731a = z;
            this.f10732b = str;
        }

        public static C0589a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new C0589a(false, "未启用真机调试") : (C0589a) invokeV.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10732b : (String) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10731a : invokeV.booleanValue;
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
        this.f10725a = null;
        this.f10726b = null;
        this.f10727c = false;
        this.f10728d = false;
        this.f10729e = false;
        this.f10730f = false;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("inspector")) != null) {
            this.f10725a = optJSONObject.optString("hostname", null);
            this.f10726b = optJSONObject.optString(ClientCookie.PORT_ATTR, null);
            this.f10727c = optJSONObject.optBoolean("breakOnStart", false);
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext());
        boolean z = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_ENABLED", false);
        this.f10730f = z;
        if (z) {
            this.f10725a = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_HOSTNAME", this.f10725a);
            this.f10726b = defaultSharedPreferences.getString("KEY_DEBUG_SWAN_INSPECTOR_FRONTEND_PORT", this.f10726b);
            this.f10727c = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_BREAK_FIRST_ENABLED", this.f10727c);
            this.f10728d = defaultSharedPreferences.getBoolean("KEY_DEBUG_SWAN_INSPECTOR_DEBUGGER_DISABLED", this.f10728d);
        }
        String str = this.f10725a;
        if (str == null || str.trim().equals("")) {
            return;
        }
        this.f10729e = true;
    }

    public static C0589a f(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? aVar == null ? C0589a.c() : aVar.e() : (C0589a) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10725a);
            if (this.f10726b != null) {
                str = ":" + this.f10726b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10728d : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.v.a.f(e.U()) : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f10727c : invokeV.booleanValue;
    }

    public C0589a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!this.f10730f && c()) {
                return new C0589a(false, "线上包禁用真机调试");
            }
            boolean z = this.f10729e;
            return new C0589a(z, !z ? "未启用真机调试" : this.f10730f ? "使用了 debug 面板配置" : "启用了真机调试");
        }
        return (C0589a) invokeV.objValue;
    }
}
