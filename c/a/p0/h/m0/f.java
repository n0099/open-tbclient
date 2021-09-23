package c.a.p0.h.m0;

import android.text.TextUtils;
import c.a.p0.a.k;
import c.a.p0.a.k2.g.h;
import c.a.p0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.videodownload.CyberVideoDownloader;
import com.baidu.searchbox.http.callback.StringResponseCallback;
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
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11352a;

    /* renamed from: b  reason: collision with root package name */
    public static String f11353b;

    /* renamed from: c  reason: collision with root package name */
    public static String f11354c;

    /* renamed from: d  reason: collision with root package name */
    public static String f11355d;

    /* renamed from: e  reason: collision with root package name */
    public static String f11356e;

    /* renamed from: f  reason: collision with root package name */
    public static String f11357f;

    /* renamed from: g  reason: collision with root package name */
    public static String f11358g;

    /* renamed from: h  reason: collision with root package name */
    public static String f11359h;

    /* renamed from: i  reason: collision with root package name */
    public static String f11360i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                if (200 != i2 || TextUtils.isEmpty(str)) {
                    boolean unused = f.f11352a;
                    return;
                }
                try {
                    if (f.f11352a) {
                        String str2 = "回访引导配置信息 = " + str;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("errno") != 0) {
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    JSONObject i3 = f.i();
                    if (optJSONObject == null || optJSONObject.length() == 0) {
                        return;
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray(f.f11360i);
                    if (optJSONArray != null) {
                        h.a().putString(f.f11360i, optJSONArray.toString());
                    }
                    if (i3 == null) {
                        f.k(optJSONObject.toString());
                    } else if (TextUtils.equals(i3.optString("version"), optJSONObject.optString("version"))) {
                    } else {
                        f.g(optJSONObject, i3);
                        f.h(optJSONObject, i3);
                        f.k(optJSONObject.toString());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && f.f11352a) {
                String str = "请求配置信息失败，err = " + exc.getMessage();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11361e;

        public b(String str) {
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
            this.f11361e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h.a().putString("swan_game_guide_toast", this.f11361e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1553784079, "Lc/a/p0/h/m0/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1553784079, "Lc/a/p0/h/m0/f;");
                return;
            }
        }
        f11352a = k.f7085a;
        f11353b = "bbaspg_guide_";
        f11354c = "custom_guide_list";
        f11355d = "appid";
        f11356e = "shown_count";
        f11357f = "image_index";
        f11358g = "last_time";
        f11359h = "reset";
        f11360i = "duration_permission_list";
    }

    public static void g(JSONObject jSONObject, JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            if (!TextUtils.equals(jSONObject.optString(f11353b + f11359h, "0"), jSONObject2.optString(f11353b + f11359h, "-1"))) {
                jSONObject.put(f11353b + f11356e, "0");
                jSONObject.put(f11353b + f11358g, "0");
                jSONObject.put(f11353b + f11357f, "0");
            } else {
                jSONObject.put(f11353b + f11356e, jSONObject2.optString(f11353b + f11356e, "0"));
                jSONObject.put(f11353b + f11358g, jSONObject2.optString(f11353b + f11358g, "0"));
            }
        } catch (JSONException e2) {
            if (f11352a) {
                e2.printStackTrace();
            }
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, jSONObject, jSONObject2) == null) || jSONObject == null || jSONObject2 == null || (optJSONArray = jSONObject2.optJSONArray(f11354c)) == null || optJSONArray.length() <= 0 || (optJSONArray2 = jSONObject.optJSONArray(f11354c)) == null || optJSONArray2.length() <= 0) {
            return;
        }
        int length = optJSONArray2.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
            String optString = optJSONObject.optString(f11355d, "");
            String optString2 = optJSONObject.optString(f11359h, "0");
            int length2 = optJSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    String optString3 = optJSONObject2.optString(f11355d, "-1");
                    String optString4 = optJSONObject2.optString(f11359h, "0");
                    if (TextUtils.equals(optString3, optString)) {
                        try {
                            if (!TextUtils.equals(optString4, optString2)) {
                                optJSONObject.put(f11356e, "0");
                                optJSONObject.put(f11358g, "0");
                                optJSONObject.put(f11357f, "0");
                            } else {
                                optJSONObject.put(f11356e, jSONObject2.optString(f11356e, "0"));
                                optJSONObject.put(f11358g, jSONObject2.optString(f11358g, "0"));
                                optJSONObject.put(f11357f, jSONObject2.optString(f11357f, "0"));
                            }
                        } catch (JSONException e2) {
                            if (f11352a) {
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

    public static JSONObject i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            String string = h.a().getString("swan_game_guide_toast", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                return new JSONObject(string);
            } catch (JSONException e2) {
                if (f11352a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void j() {
        c.a.p0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, null) == null) || (i2 = c.a.p0.a.a2.e.i()) == null) {
            return;
        }
        i2.X().getRequest().url(c.a.p0.h.t.a.b().q()).cookieManager(c.a.p0.a.c1.a.p().a()).requestFrom(16).requestFrom(CyberVideoDownloader.DMDownloadError.Sys05).build().executeAsync(new a());
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f11352a) {
            String str2 = "回访引导配置信息存入 = " + str;
        }
        q.j(new b(str), "swanGameGuideUpdateRunnable");
    }
}
