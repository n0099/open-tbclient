package b.a.p0.n.j.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import b.a.p0.t.j;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11233c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f11234a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f11235b;

    /* loaded from: classes4.dex */
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
        this.f11235b = false;
        this.f11234a = new a();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f11233c == null) {
                synchronized (b.class) {
                    if (f11233c == null) {
                        f11233c = new b();
                    }
                }
            }
            return f11233c;
        }
        return (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f11234a.contains("version")) {
                return this.f11234a.getString("version", "0");
            }
            return d() ? this.f11234a.getString("version", "0") : "0";
        }
        return (String) invokeV.objValue;
    }

    public Long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Long.valueOf(this.f11234a.getLong("identity", 0L)) : (Long) invokeV.objValue;
    }

    public synchronized boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.f11235b) {
                    return true;
                }
                String C = b.a.p0.t.d.C(AppRuntime.getAppContext(), "config/union-cfg.json");
                HashSet hashSet = null;
                if (TextUtils.isEmpty(C)) {
                    File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
                    C = file.exists() ? b.a.p0.t.d.D(file) : null;
                }
                if (TextUtils.isEmpty(C)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(C);
                    String optString = jSONObject.optString("hostName");
                    String optString2 = jSONObject.optString("schemeHead");
                    String optString3 = jSONObject.optString("shareCallbackUrl");
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
                    long j = 0;
                    if (optJSONObject != null) {
                        String optString4 = optJSONObject.optString("value");
                        long optLong = optJSONObject.optLong("identity");
                        if (b.a.p0.n.c.b() != null) {
                            b.a.p0.n.c.b().d(optString4.getBytes());
                        }
                        j = optLong;
                    }
                    e(new b.a.p0.n.j.j.a(null, optInt2, optInt3, optString, optString3, String.valueOf(optInt), hashSet2, optString2, Long.valueOf(j)));
                    this.f11235b = true;
                    return true;
                } catch (JSONException e2) {
                    if (b.a.p0.n.c.f11048a) {
                        e2.printStackTrace();
                    }
                    return false;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public final void e(b.a.p0.n.j.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.f11227d) || TextUtils.isEmpty(aVar.f11231h) || TextUtils.isEmpty(aVar.f11229f)) {
            return;
        }
        SharedPreferences.Editor putString = this.f11234a.edit().putString("hostName", aVar.f11227d).putString("schemeHead", aVar.f11231h).putString("shareCallbackUrl", aVar.f11228e).putString("version", aVar.f11229f);
        Set<String> set = aVar.f11230g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f11230g);
        }
        Long l = aVar.f11232i;
        if (l != null) {
            putString.putLong("identity", l.longValue());
        }
        putString.apply();
    }

    public void f(b.a.p0.n.j.j.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        if (b.a.p0.n.c.f11048a) {
            String str = "update host data version " + aVar.f11229f;
        }
        SharedPreferences.Editor putString = this.f11234a.edit().putString("hostName", aVar.f11227d).putString("schemeHead", aVar.f11231h).putString("shareCallbackUrl", aVar.f11228e).putString("contentType", aVar.f11224a).putInt("containerNo", aVar.f11226c).putInt("officialNo", aVar.f11225b).putString("version", aVar.f11229f);
        Set<String> set = aVar.f11230g;
        if (set != null && !set.isEmpty()) {
            putString.putStringSet(SocialOperation.GAME_SIGNATURE, aVar.f11230g);
        }
        putString.apply();
    }
}
