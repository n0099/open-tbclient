package c.a.r0.d.g;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.a.r0.w.d;
import c.a.r0.w.h;
import c.a.r0.w.i;
import c.a.r0.w.j;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f10283c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f10284b;

    /* loaded from: classes6.dex */
    public static class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("swan_host_info_config_sp_name");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public c() {
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
        this.f10284b = false;
        this.a = new a();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f10283c == null) {
                synchronized (c.class) {
                    if (f10283c == null) {
                        f10283c = new c();
                    }
                }
            }
            return f10283c;
        }
        return (c) invokeV.objValue;
    }

    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Set<String> stringSet = this.a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            if (stringSet != null) {
                return stringSet;
            }
            if (h()) {
                return this.a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = c("appKey");
            if (TextUtils.isEmpty(c2)) {
                if (c.a.r0.d.c.a) {
                    throw new IllegalStateException("获取 host app key 失败");
                }
                return "";
            }
            return c2;
        }
        return (String) invokeV.objValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String string = this.a.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                if (h()) {
                    String string2 = this.a.getString(str, "");
                    if (!TextUtils.isEmpty(string2)) {
                        return string2;
                    }
                }
                return null;
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String c2 = c("hostName");
            if (TextUtils.isEmpty(c2)) {
                if (c.a.r0.d.c.a) {
                    throw new IllegalStateException("获取 HostName-宿主名称 失败");
                }
                return "";
            }
            return c2;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String c2 = c("schemeHead");
            if (TextUtils.isEmpty(c2)) {
                if (c.a.r0.d.c.a) {
                    throw new IllegalStateException("获取 SchemeHead-协议头 失败");
                }
                return "";
            }
            return c2;
        }
        return (String) invokeV.objValue;
    }

    public String g(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, str, i2, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String c2 = c("shareCallBackUrl");
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            String a2 = i.a(i.a(c2, "type", String.valueOf(i2)), "appKey", str);
            return !TextUtils.isEmpty(str2) ? i.a(a2, "path", h.b(str2)) : a2;
        }
        return (String) invokeLIL.objValue;
    }

    public final synchronized boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                if (this.f10284b) {
                    return true;
                }
                String D = d.D(AppRuntime.getAppContext(), "config/union-cfg.json");
                HashSet hashSet = null;
                if (TextUtils.isEmpty(D)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    D = file.exists() ? d.E(file) : null;
                }
                if (TextUtils.isEmpty(D)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(D);
                    String optString = jSONObject.optString("hostName");
                    String optString2 = jSONObject.optString("schemeHead");
                    String optString3 = jSONObject.optString("appKey");
                    String optString4 = jSONObject.optString("shareCallBackUrl");
                    int optInt = jSONObject.optInt("version");
                    JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        hashSet = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            hashSet.add(optJSONArray.optString(i2));
                        }
                    }
                    i(optString, optString2, optString3, optString4, optInt, hashSet);
                    this.f10284b = true;
                    return true;
                } catch (JSONException e2) {
                    if (c.a.r0.d.c.a) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public final void i(String str, String str2, String str3, String str4, int i2, Set<String> set) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i2), set}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 < 0) {
            return;
        }
        SharedPreferences.Editor putInt = this.a.edit().putString("hostName", str).putString("schemeHead", str2).putString("appKey", str3).putString("shareCallBackUrl", str4).putInt("version", i2);
        if (set != null && !set.isEmpty()) {
            putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putInt.apply();
    }
}
