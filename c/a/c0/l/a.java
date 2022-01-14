package c.a.c0.l;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.c0.y.b a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f2192b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Map<String, String>> f2193c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f2194d;

    public a() {
        String[] a;
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
        this.f2192b = new ConcurrentHashMap(128);
        this.f2193c = new ConcurrentHashMap(8);
        this.a = c.a.c0.y.e.a().b("nad.cold.launch.config");
        for (String str : h.a().a()) {
            String string = this.a.getString(str, null);
            if (string != null) {
                c.a.c0.x.c.e(this.f2192b, str, string);
            }
        }
    }

    @NonNull
    public Map<String, String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2192b : (Map) invokeV.objValue;
    }

    @NonNull
    public Map<String, Map<String, String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2193c : (Map) invokeV.objValue;
    }

    public final void c(@NonNull JSONObject jSONObject) {
        String[] a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.f2192b.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                c.a.c0.x.c.e(this.f2192b, next, jSONObject.optString(next));
            }
            SharedPreferences.Editor edit = this.a.edit();
            edit.clear();
            for (String str : h.a().a()) {
                String str2 = (String) c.a.c0.x.c.b(this.f2192b, str);
                if (str2 != null) {
                    edit.putString(str, str2);
                }
            }
            edit.apply();
            SharedPreferences.Editor edit2 = c.a.c0.y.e.a().b("nad.launch.config.global").edit();
            edit2.clear();
            for (String str3 : this.f2192b.keySet()) {
                String str4 = (String) c.a.c0.x.c.b(this.f2192b, str3);
                if (str4 != null) {
                    edit2.putString(str3, str4);
                }
            }
            edit2.apply();
        }
    }

    public final void d(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) {
            this.f2193c.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                HashMap hashMap = null;
                if (!TextUtils.isEmpty(optString)) {
                    hashMap = new HashMap(8);
                    JSONObject b2 = c.a.c0.x.b.b(optString);
                    Iterator<String> keys2 = b2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        c.a.c0.x.c.e(hashMap, next2, b2.optString(next2));
                    }
                }
                if (hashMap != null) {
                    c.a.c0.x.c.e(this.f2193c, next, hashMap);
                    c.a.c0.y.e a = c.a.c0.y.e.a();
                    SharedPreferences.Editor edit = a.b("nad.launch.config." + next).edit();
                    edit.clear();
                    for (String str : hashMap.keySet()) {
                        String str2 = (String) hashMap.get(str);
                        if (str2 != null) {
                            edit.putString(str, str2);
                        }
                    }
                    edit.apply();
                }
            }
        }
    }

    public void update(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            String optString = jSONObject.optString(NodeJS.GLOBAL);
            if (!TextUtils.isEmpty(optString)) {
                c(c.a.c0.x.b.b(optString));
            }
            String optString2 = jSONObject.optString("place_conf");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            d(c.a.c0.x.b.b(optString2));
        }
    }
}
