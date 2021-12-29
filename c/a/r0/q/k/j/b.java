package c.a.r0.q.k.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11899c;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f11900b;

    /* loaded from: classes6.dex */
    public static class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_host");
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
        this.f11900b = false;
        this.a = new a();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11899c == null) {
                synchronized (b.class) {
                    if (f11899c == null) {
                        f11899c = new b();
                    }
                }
            }
            return f11899c;
        }
        return (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a.contains("version")) {
                return this.a.getString("version", "0");
            }
            return f() ? this.a.getString("version", "0") : "0";
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = c("failureUrl");
            return !TextUtils.isEmpty(c2) ? c2 : "";
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
                if (f()) {
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

    public Long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Long.valueOf(this.a.getLong("identity", 0L)) : (Long) invokeV.objValue;
    }

    public synchronized boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.f11900b) {
                    return true;
                }
                String D = c.a.r0.w.d.D(AppRuntime.getAppContext(), "config/union-cfg.json");
                HashSet hashSet = null;
                if (TextUtils.isEmpty(D)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    D = file.exists() ? c.a.r0.w.d.E(file) : null;
                }
                if (TextUtils.isEmpty(D)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(D);
                    String optString = jSONObject.optString("hostName");
                    String optString2 = jSONObject.optString("schemeHead");
                    String optString3 = jSONObject.optString("shareCallbackUrl");
                    String optString4 = jSONObject.optString("failureUrl");
                    int optInt = jSONObject.optInt("version");
                    JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        hashSet = new HashSet();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            hashSet.add(optJSONArray.optString(i2));
                        }
                    }
                    HashSet hashSet2 = hashSet;
                    int optInt2 = jSONObject.optInt("officialNo");
                    int optInt3 = jSONObject.optInt("containerNo");
                    JSONObject optJSONObject = jSONObject.optJSONObject("confsk");
                    long j2 = 0;
                    if (optJSONObject != null) {
                        String optString5 = optJSONObject.optString("value");
                        long optLong = optJSONObject.optLong("identity");
                        if (c.a.r0.q.c.b() != null) {
                            c.a.r0.q.c.b().d(optString5.getBytes());
                        }
                        j2 = optLong;
                    }
                    h(new c.a.r0.q.k.j.a(null, optInt2, optInt3, optString, optString3, optString4, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j2)));
                    this.f11900b = true;
                    return true;
                } catch (JSONException unused) {
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public boolean g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            int i2 = this.a.getInt("use_openbundleid", -1);
            return i2 == -1 ? z : i2 == 1;
        }
        return invokeZ.booleanValue;
    }

    public final void h(c.a.r0.q.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.f11891d) || TextUtils.isEmpty(aVar.f11896i) || TextUtils.isEmpty(aVar.f11894g)) {
            return;
        }
        SharedPreferences.Editor putString = this.a.edit().putString("hostName", aVar.f11891d).putString("schemeHead", aVar.f11896i).putString("shareCallbackUrl", aVar.f11892e).putString("failureUrl", aVar.f11893f).putString("version", aVar.f11894g);
        Set<String> set = aVar.f11895h;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f11895h);
        }
        Long l = aVar.f11897j;
        if (l != null) {
            putString.putLong("identity", l.longValue());
        }
        putString.apply();
    }

    public void i(c.a.r0.q.k.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null) {
            return;
        }
        SharedPreferences.Editor putString = this.a.edit().putString("hostName", aVar.f11891d).putString("schemeHead", aVar.f11896i).putString("shareCallbackUrl", aVar.f11892e).putString("failureUrl", aVar.f11893f).putString("contentType", aVar.a).putInt("containerNo", aVar.f11890c).putInt("officialNo", aVar.f11889b).putString("version", aVar.f11894g);
        Set<String> set = aVar.f11895h;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f11895h);
        }
        putString.apply();
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.a.edit().putInt("use_openbundleid", i2).apply();
        }
    }
}
