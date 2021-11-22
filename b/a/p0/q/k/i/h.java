package b.a.p0.q.k.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f11915c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile h f11916d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f11917a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Set<String> f11918b;

    /* loaded from: classes4.dex */
    public static class a extends b.a.p0.w.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_nohistoryapps");
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(313667779, "Lb/a/p0/q/k/i/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(313667779, "Lb/a/p0/q/k/i/h;");
                return;
            }
        }
        f11915c = new HashSet();
        f11916d = null;
        f11915c.add("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
        f11915c.add("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D");
        f11915c.add("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk");
        f11915c.add("pjwYb22xF6hUcKpZKsiqvnhUhsoUvLfT");
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11918b = null;
        this.f11917a = new a();
        d();
    }

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f11916d == null) {
                synchronized (h.class) {
                    if (f11916d == null) {
                        f11916d = new h();
                    }
                }
            }
            return f11916d;
        }
        return (h) invokeV.objValue;
    }

    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Set<String> set = f11915c;
            if (this.f11918b != null) {
                set = this.f11918b;
            }
            String[] strArr = new String[set.size()];
            int i2 = 0;
            for (String str : set) {
                strArr[i2] = str;
                i2++;
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11917a.getString("version", "0") : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f11917a.getString("appids", "");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    hashSet.add(jSONArray.optString(i2));
                }
                this.f11918b = hashSet;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONArray = optJSONObject.optJSONArray("appids")) == null) {
            return;
        }
        f(optJSONArray, optString);
    }

    public final void f(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONArray, str) == null) || jSONArray == null || TextUtils.isEmpty(str)) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.optString(i2));
        }
        this.f11918b = hashSet;
        SharedPreferences.Editor edit = this.f11917a.edit();
        edit.clear();
        edit.putString("version", str);
        edit.putString("appids", jSONArray.toString());
        edit.apply();
    }
}
