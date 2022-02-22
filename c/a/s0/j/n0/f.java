package c.a.s0.j.n0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.s0.a.k;
import c.a.s0.a.o2.g.h;
import c.a.s0.a.z2.q;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f11347b;

    /* renamed from: c  reason: collision with root package name */
    public static String f11348c;

    /* renamed from: d  reason: collision with root package name */
    public static String f11349d;

    /* renamed from: e  reason: collision with root package name */
    public static String f11350e;

    /* renamed from: f  reason: collision with root package name */
    public static String f11351f;

    /* renamed from: g  reason: collision with root package name */
    public static String f11352g;

    /* renamed from: h  reason: collision with root package name */
    public static String f11353h;

    /* renamed from: i  reason: collision with root package name */
    public static String f11354i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i2) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (200 != i2 || TextUtils.isEmpty(str)) {
                    boolean unused = f.a;
                    return;
                }
                try {
                    if (f.a) {
                        String str2 = "回访引导配置信息 = " + str;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.length() == 0) {
                        return;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray(f.f11354i);
                    if (optJSONArray != null) {
                        h.a().putString(f.f11354i, optJSONArray.toString());
                    }
                    String optString = optJSONObject.optString("version");
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    JSONObject n = f.n();
                    if (n == null) {
                        f.r(optJSONObject);
                    } else if (TextUtils.equals(n.optString("version"), f.p(optString))) {
                        f.k(n);
                    } else {
                        f.i(optJSONObject, n);
                        f.j(optJSONObject, n);
                        f.r(optJSONObject);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && f.a) {
                String str = "请求配置信息失败，err = " + exc.getMessage();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f11355e;

        public b(JSONObject jSONObject) {
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
            this.f11355e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f11355e.put("version", f.p(this.f11355e.optString("version")));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                h.a().putString("swan_game_guide_toast", this.f11355e.toString());
                f.k(this.f11355e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-367393711, "Lc/a/s0/j/n0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-367393711, "Lc/a/s0/j/n0/f;");
                return;
            }
        }
        a = k.a;
        f11347b = "bbaspg_guide_";
        f11348c = "custom_guide_list";
        f11349d = "appid";
        f11350e = "shown_count";
        f11351f = "image_index";
        f11352g = "last_time";
        f11353h = "reset";
        f11354i = "duration_permission_list";
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = jSONObject.optString(f11347b + f11353h, "0");
            jSONObject2.optString(f11347b + f11353h, "-1");
            if (TextUtils.equals(optString, "1")) {
                jSONObject.put(f11347b + f11350e, 0);
                jSONObject.put(f11347b + f11352g, 0);
                jSONObject.put(f11347b + f11351f, 0);
            } else {
                jSONObject.put(f11347b + f11350e, jSONObject2.optInt(f11347b + f11350e, 0));
                jSONObject.put(f11347b + f11352g, jSONObject2.optLong(f11347b + f11352g, 0L));
            }
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
    }

    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray(f11348c)) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray(f11348c)) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString(f11349d, "");
            String optString2 = optJSONObject.optString(f11353h, "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString(f11349d, "-1");
                    String optString4 = optJSONObject2.optString(f11353h, "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put(f11350e, "0");
                                optJSONObject.put(f11352g, "0");
                                optJSONObject.put(f11351f, "0");
                            } else {
                                optJSONObject.put(f11350e, jSONObject2.optString(f11350e, "0"));
                                optJSONObject.put(f11352g, jSONObject2.optString(f11352g, "0"));
                                optJSONObject.put(f11351f, jSONObject2.optString(f11351f, "0"));
                            }
                        } catch (JSONException e2) {
                            if (a) {
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

    public static void k(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (TextUtils.isEmpty(jSONObject.optString(f11347b + StatConstants.VALUE_TYPE_ZIP))) {
            return;
        }
        String optString = jSONObject.optString(f11347b + StatConstants.VALUE_TYPE_ZIP);
        String m = m(optString);
        if (TextUtils.isEmpty(m)) {
            return;
        }
        File file = new File(o(m));
        if (file.exists() && file.isDirectory() && file.length() > 0) {
            if (a) {
                String str = optString + " 资源文件夹已存在";
                return;
            }
            return;
        }
        c.a.s0.w.d.L(file);
        c.a.s0.j.u.a.f().b(AppRuntime.getAppContext(), optString, m, l());
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return c.a.s0.j.t.a.d() + File.separator + "guide_res";
        }
        return (String) invokeV.objValue;
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.contains(".zip")) {
                return null;
            }
            return lastPathSegment.replace(".zip", "");
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            String string = h.a().getString("swan_game_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static String o(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return l() + File.separator + str;
        }
        return (String) invokeL.objValue;
    }

    public static String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            return q0.D() + "-" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void q() {
        c.a.s0.a.d2.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, null) == null) || (L = c.a.s0.a.d2.e.L()) == null) {
            return;
        }
        L.h0().getRequest().url(c.a.s0.j.u.a.b().t()).cookieManager(c.a.s0.a.c1.a.q().a()).requestFrom(16).requestFrom(CyberVideoDownloader.DMDownloadError.Sys05).build().executeAsync(new a());
    }

    public static void r(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (a) {
            String str = "回访引导配置信息存入 = " + jSONObject;
        }
        q.k(new b(jSONObject), "swanGameGuideUpdateRunnable");
    }
}
