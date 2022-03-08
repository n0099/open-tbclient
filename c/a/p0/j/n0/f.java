package c.a.p0.j.n0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.e2.g.h;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
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
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static String f10572b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10573c;

    /* renamed from: d  reason: collision with root package name */
    public static String f10574d;

    /* renamed from: e  reason: collision with root package name */
    public static String f10575e;

    /* renamed from: f  reason: collision with root package name */
    public static String f10576f;

    /* renamed from: g  reason: collision with root package name */
    public static String f10577g;

    /* renamed from: h  reason: collision with root package name */
    public static String f10578h;

    /* renamed from: i  reason: collision with root package name */
    public static String f10579i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
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
                    JSONArray optJSONArray = optJSONObject.optJSONArray(f.f10579i);
                    if (optJSONArray != null) {
                        h.a().putString(f.f10579i, optJSONArray.toString());
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

    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f10580e;

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
            this.f10580e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f10580e.put("version", f.p(this.f10580e.optString("version")));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                h.a().putString("swan_game_guide_toast", this.f10580e.toString());
                f.k(this.f10580e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(222146804, "Lc/a/p0/j/n0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(222146804, "Lc/a/p0/j/n0/f;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f10572b = "bbaspg_guide_";
        f10573c = "custom_guide_list";
        f10574d = "appid";
        f10575e = "shown_count";
        f10576f = "image_index";
        f10577g = "last_time";
        f10578h = "reset";
        f10579i = "duration_permission_list";
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = jSONObject.optString(f10572b + f10578h, "0");
            jSONObject2.optString(f10572b + f10578h, "-1");
            if (TextUtils.equals(optString, "1")) {
                jSONObject.put(f10572b + f10575e, 0);
                jSONObject.put(f10572b + f10577g, 0);
                jSONObject.put(f10572b + f10576f, 0);
            } else {
                jSONObject.put(f10572b + f10575e, jSONObject2.optInt(f10572b + f10575e, 0));
                jSONObject.put(f10572b + f10577g, jSONObject2.optLong(f10572b + f10577g, 0L));
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
        if (!(interceptable == null || interceptable.invokeLL(65546, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray(f10573c)) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray(f10573c)) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString(f10574d, "");
            String optString2 = optJSONObject.optString(f10578h, "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString(f10574d, "-1");
                    String optString4 = optJSONObject2.optString(f10578h, "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put(f10575e, "0");
                                optJSONObject.put(f10577g, "0");
                                optJSONObject.put(f10576f, "0");
                            } else {
                                optJSONObject.put(f10575e, jSONObject2.optString(f10575e, "0"));
                                optJSONObject.put(f10577g, jSONObject2.optString(f10577g, "0"));
                                optJSONObject.put(f10576f, jSONObject2.optString(f10576f, "0"));
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
        if (TextUtils.isEmpty(jSONObject.optString(f10572b + StatConstants.VALUE_TYPE_ZIP))) {
            return;
        }
        String optString = jSONObject.optString(f10572b + StatConstants.VALUE_TYPE_ZIP);
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
        c.a.p0.w.d.L(file);
        c.a.p0.j.u.a.f().b(AppRuntime.getAppContext(), optString, m, l());
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return c.a.p0.j.t.a.d() + File.separator + "guide_res";
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
        c.a.p0.a.t1.e L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, null) == null) || (L = c.a.p0.a.t1.e.L()) == null) {
            return;
        }
        L.h0().getRequest().url(c.a.p0.j.u.a.b().t()).cookieManager(c.a.p0.a.s0.a.q().a()).requestFrom(16).requestFrom(CyberVideoDownloader.DMDownloadError.Sys05).build().executeAsync(new a());
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
