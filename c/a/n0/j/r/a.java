package c.a.n0.j.r;

import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.t1.d;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8924e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8925b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f8926c;

    /* renamed from: d  reason: collision with root package name */
    public String f8927d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781151293, "Lc/a/n0/j/r/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781151293, "Lc/a/n0/j/r/a;");
                return;
            }
        }
        f8924e = c.a.n0.a.a.a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            JSONObject jSONObject = this.f8926c;
            boolean z2 = false;
            if (jSONObject == null) {
                return false;
            }
            int optInt = jSONObject.optInt("bbaspg_guide_count", 3);
            int optInt2 = this.f8926c.optInt("bbaspg_guide_interval", 72);
            long optLong = this.f8926c.optLong("bbaspg_guide_last_time", 0L);
            int optInt3 = this.f8926c.optInt("bbaspg_guide_shown_count", 0);
            int optInt4 = this.f8926c.optInt("bbaspg_guide_image_index", 0);
            boolean z3 = System.currentTimeMillis() - optLong > ((long) optInt2) * 3600000;
            String optString = this.f8926c.optString("filter_channelid");
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
            if (f8924e) {
                Log.i("SwanGameGuideDialogChecker", "isShow:" + z2 + " maxCount" + optInt + " isOverInterval" + z3 + "imageUrl " + this.f8927d + UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY + z2);
            }
            if (z2) {
                d(this.f8926c, optInt4, "bbaspg_guide_images");
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
                if (c.a.n0.a.a.a) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public final int d(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, jSONObject, i, str)) == null) {
            if (jSONObject == null || i < 0 || TextUtils.isEmpty(str) || (optJSONArray = jSONObject.optJSONArray(str)) == null || optJSONArray.length() == 0) {
                return 0;
            }
            if (i >= optJSONArray.length()) {
                i = 0;
            }
            this.f8927d = optJSONArray.optString(i);
            return i;
        }
        return invokeLIL.intValue;
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.a = false;
            this.f8925b = false;
            this.f8927d = null;
            this.f8926c = c();
            boolean b2 = b();
            this.a = b2;
            if (b2) {
                return this;
            }
            this.f8925b = a();
            return this;
        }
        return (a) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a || this.f8925b : invokeV.booleanValue;
    }
}
