package c.a.p0.a.v0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import c.a.p0.a.v2.q;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9197a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9198e;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9198e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a().putString("swan_guide_toast", this.f9198e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(831936373, "Lc/a/p0/a/v0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(831936373, "Lc/a/p0/a/v0/d;");
                return;
            }
        }
        f9197a = k.f7077a;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            if (!TextUtils.equals(jSONObject.optString("bbasp_guide_reset", "0"), jSONObject2.optString("bbasp_guide_reset", "-1"))) {
                jSONObject.put("bbasp_guide_shown_count", "0");
                jSONObject.put("bbasp_guide_last_time", "0");
                jSONObject.put("bbasp_guide_image_index", "0");
            } else {
                jSONObject.put("bbasp_guide_shown_count", jSONObject2.optString("bbasp_guide_shown_count", "0"));
                jSONObject.put("bbasp_guide_last_time", jSONObject2.optString("bbasp_guide_last_time", "0"));
            }
            if (!TextUtils.equals(jSONObject.optString("bbaspg_guide_reset", "0"), jSONObject2.optString("bbaspg_guide_reset", "-1"))) {
                jSONObject.put("bbaspg_guide_shown_count", "0");
                jSONObject.put("bbaspg_guide_last_time", "0");
                jSONObject.put("bbaspg_guide_image_index", "0");
                return;
            }
            jSONObject.put("bbaspg_guide_shown_count", jSONObject2.optString("bbaspg_guide_shown_count", "0"));
            jSONObject.put("bbaspg_guide_last_time", jSONObject2.optString("bbaspg_guide_last_time", "0"));
        } catch (JSONException e2) {
            if (f9197a) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray("custom_guide_list")) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray("custom_guide_list")) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString("appid", "");
            String optString2 = optJSONObject.optString("reset", "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString("appid", "-1");
                    String optString4 = optJSONObject2.optString("reset", "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put("shown_count", "0");
                                optJSONObject.put("last_time", "0");
                                optJSONObject.put("image_index", "0");
                            } else {
                                optJSONObject.put("shown_count", jSONObject2.optString("shown_count", "0"));
                                optJSONObject.put("last_time", jSONObject2.optString("last_time", "0"));
                                optJSONObject.put("image_index", jSONObject2.optString("image_index", "0"));
                            }
                        } catch (JSONException e2) {
                            if (f9197a) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        i3++;
                    }
                }
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "guide_pull_toast" : (String) invokeV.objValue;
    }

    public static JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String string = h.a().getString("swan_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                if (f9197a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String string = h.a().getString("guide_toast_version", "0");
            if (f9197a) {
                String str = "version = " + string;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static void f(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject) == null) {
            if (f9197a) {
                String str = "processGuide guideObject = " + jSONObject;
            }
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("version");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null || TextUtils.equals(e(), optString)) {
                return;
            }
            JSONObject d2 = d();
            if (d2 == null) {
                g(optJSONObject.toString());
                return;
            }
            a(optJSONObject, d2);
            b(optJSONObject, d2);
            g(optJSONObject.toString());
            h.a().putString("guide_toast_version", optString);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        q.j(new a(str), "swanGuideUpdateRunnable");
    }
}
