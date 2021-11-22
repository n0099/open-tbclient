package b.a.p0.j.r;

import android.text.TextUtils;
import b.a.p0.a.d2.d;
import b.a.p0.a.d2.e;
import b.a.p0.a.k;
import b.a.p0.a.o2.g.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f11442e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f11443a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11444b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f11445c;

    /* renamed from: d  reason: collision with root package name */
    public String f11446d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-807689916, "Lb/a/p0/j/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-807689916, "Lb/a/p0/j/r/a;");
                return;
            }
        }
        f11442e = k.f6863a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = this.f11445c;
            boolean z2 = false;
            if (jSONObject == null) {
                return false;
            }
            int optInt = jSONObject.optInt("bbaspg_guide_count", 3);
            int optInt2 = this.f11445c.optInt("bbaspg_guide_interval", 72);
            long optLong = this.f11445c.optLong("bbaspg_guide_last_time", 0L);
            int optInt3 = this.f11445c.optInt("bbaspg_guide_shown_count", 0);
            int optInt4 = this.f11445c.optInt("bbaspg_guide_image_index", 0);
            boolean z3 = System.currentTimeMillis() - optLong > ((long) optInt2) * 3600000;
            String optString = this.f11445c.optString("filter_channelid");
            if (TextUtils.isEmpty(optString)) {
                z = true;
            } else {
                String[] split = optString.split(",");
                String T = d.J().r().V().T();
                z = true;
                for (String str : split) {
                    if (TextUtils.equals(T, str)) {
                        z = false;
                    }
                }
            }
            if (optInt3 < optInt && z3 && z) {
                z2 = true;
            }
            if (f11442e) {
                String str2 = "isShow:" + z2 + " maxCount" + optInt + " isOverInterval" + z3 + "imageUrl " + this.f11446d + "isShow" + z2;
            }
            if (z2) {
                d(this.f11445c, optInt4, "bbaspg_guide_images");
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? e.L() != null && TextUtils.equals(e.f0(), "7TxyeScrKPj02EATE68RBG5Z8f46a8So") : invokeV.booleanValue;
    }

    public final JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String string = h.a().getString("swan_game_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                if (k.f6863a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public final int d(JSONObject jSONObject, int i2, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, jSONObject, i2, str)) == null) {
            if (jSONObject == null || i2 < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i2 >= optJSONArray.length()) {
                i2 = 0;
            }
            this.f11446d = optJSONArray.optString(i2);
            return i2;
        }
        return invokeLIL.intValue;
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f11443a = false;
            this.f11444b = false;
            this.f11446d = null;
            this.f11445c = c();
            boolean b2 = b();
            this.f11443a = b2;
            if (b2) {
                return this;
            }
            this.f11444b = a();
            return this;
        }
        return (a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11443a || this.f11444b : invokeV.booleanValue;
    }
}
