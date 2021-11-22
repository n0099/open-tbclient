package b.a.f0.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean I;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public int H;

    /* renamed from: a  reason: collision with root package name */
    public int f2949a;

    /* renamed from: b  reason: collision with root package name */
    public String f2950b;

    /* renamed from: c  reason: collision with root package name */
    public String f2951c;

    /* renamed from: d  reason: collision with root package name */
    public String f2952d;

    /* renamed from: e  reason: collision with root package name */
    public String f2953e;

    /* renamed from: f  reason: collision with root package name */
    public int f2954f;

    /* renamed from: g  reason: collision with root package name */
    public String f2955g;

    /* renamed from: h  reason: collision with root package name */
    public int f2956h;

    /* renamed from: i  reason: collision with root package name */
    public int f2957i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String[] p;
    public String[] q;
    public long r;
    public long s;
    public int t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public String y;
    public int z;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, hVar) == null) {
                try {
                    hVar.f2949a = jSONObject.optInt("advisible");
                    hVar.f2950b = jSONObject.optString("id");
                    hVar.f2951c = jSONObject.optString("ukey");
                    hVar.f2952d = jSONObject.optString("extra");
                    hVar.f2953e = jSONObject.optString("layout");
                    hVar.f2954f = jSONObject.optInt("type");
                    hVar.k = jSONObject.optString("jump_url");
                    hVar.o = jSONObject.optString("action");
                    hVar.l = jSONObject.optString("flag_name");
                    hVar.m = jSONObject.optInt("logo_type");
                    hVar.n = jSONObject.optInt("display");
                    if (hVar.i()) {
                        b.a(jSONObject, hVar);
                    } else {
                        c.a(jSONObject, hVar);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        hVar.p = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            hVar.p[i2] = optJSONArray.optString(i2);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        hVar.q = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            hVar.q[i3] = optJSONArray2.optString(i3);
                        }
                    }
                    hVar.r = jSONObject.optLong("start");
                    hVar.s = jSONObject.optLong("end");
                    hVar.t = jSONObject.optInt("expose_interval");
                    hVar.u = jSONObject.optInt("expose_times");
                    hVar.v = jSONObject.optInt("preload_type");
                    hVar.y = jSONObject.optString("click_float_lottie_url");
                    hVar.z = jSONObject.optInt("float_bar_show", 1);
                    hVar.A = jSONObject.optInt("click_float_opt", 1);
                    hVar.B = jSONObject.optString("style_desc");
                    hVar.w = jSONObject.optInt("curRate");
                    hVar.D = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    hVar.E = jSONObject.optInt("ad_sort");
                    hVar.F = jSONObject.optInt("gesture_lottie_type");
                    hVar.G = jSONObject.optString("gesture_lottie_url");
                    hVar.H = jSONObject.optInt("gesture_lottie_sensitivity");
                } catch (Exception e2) {
                    if (h.I) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, hVar) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray != null) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                        if (optJSONObject2 == null) {
                            return;
                        }
                        hVar.f2949a = optJSONObject2.optInt("advisible", 1);
                        hVar.f2950b = optJSONObject2.optString("id");
                        hVar.f2951c = optJSONObject2.optString("ukey");
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("extra");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= optJSONArray2.length()) {
                                    break;
                                }
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    String optString = optJSONObject3.optString("k");
                                    String optString2 = optJSONObject3.optString("v");
                                    if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                        hVar.f2952d = optString2;
                                        break;
                                    }
                                }
                                i2++;
                            }
                        }
                        JSONArray optJSONArray3 = optJSONObject2.optJSONArray("material");
                        if (optJSONArray3 == null || (optJSONObject = optJSONArray3.optJSONObject(0)) == null) {
                            return;
                        }
                        JSONArray optJSONArray4 = optJSONObject.optJSONArray("info");
                        if (optJSONArray4 == null) {
                            String optString3 = optJSONObject.optString("info");
                            if (!TextUtils.isEmpty(optString3)) {
                                optJSONArray4 = new JSONArray(optString3);
                            }
                        }
                        if (optJSONArray4 != null) {
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                            hVar.f2953e = optJSONObject4.optString("layout");
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                hVar.f2954f = optJSONObject5.optInt("type");
                                hVar.k = optJSONObject5.optString("jump_url");
                                hVar.o = optJSONObject5.optString("action");
                                hVar.l = optJSONObject5.optString("flag_name");
                                hVar.m = optJSONObject5.optInt("logo_type");
                                hVar.n = optJSONObject5.optInt("display");
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                hVar.y = optJSONObject5.optString("click_float_lottie_url");
                                hVar.D = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                hVar.E = optJSONObject5.optInt("ad_sort");
                                hVar.F = optJSONObject5.optInt("gesture_lottie_type");
                                hVar.G = optJSONObject5.optString("gesture_lottie_url");
                                hVar.H = optJSONObject5.optInt("gesture_lottie_sensitivity");
                                if (hVar.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), hVar);
                                } else {
                                    c.a(optJSONObject5, hVar);
                                }
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                hVar.p = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    hVar.p[i3] = optJSONArray6.optString(i3);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                hVar.q = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i4 = 0; i4 < length2; i4++) {
                                    hVar.q[i4] = optJSONArray7.optString(i4);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                hVar.r = jSONObject2.optLong("start");
                                hVar.s = jSONObject2.optLong("end");
                                hVar.t = optJSONObject6.optInt("expose_interval");
                                hVar.u = optJSONObject6.optInt("expose_times");
                                hVar.v = optJSONObject6.optInt("preload_type");
                                hVar.z = optJSONObject6.optInt("float_bar_show", 1);
                                hVar.A = optJSONObject6.optInt("click_float_opt", 1);
                                hVar.B = optJSONObject6.optString("style_desc");
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (h.I) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public static void c(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, hVar) == null) {
                try {
                    jSONObject.put("advisible", hVar.f2949a);
                    jSONObject.put("id", hVar.f2950b);
                    jSONObject.put("ukey", hVar.f2951c);
                    jSONObject.put("extra", hVar.f2952d);
                    jSONObject.put("layout", hVar.f2953e);
                    jSONObject.put("type", hVar.f2954f);
                    jSONObject.put("jump_url", hVar.k);
                    jSONObject.put("action", hVar.o);
                    jSONObject.put("flag_name", hVar.l);
                    jSONObject.put("logo_type", hVar.m);
                    jSONObject.put("display", hVar.n);
                    jSONObject.put("start", hVar.r);
                    jSONObject.put("end", hVar.s);
                    jSONObject.put("expose_times", hVar.u);
                    jSONObject.put("expose_interval", hVar.t);
                    jSONObject.put("preload_type", hVar.v);
                    jSONObject.put("curRate", hVar.w);
                    jSONObject.put("click_float_lottie_url", hVar.y);
                    jSONObject.put("float_bar_show", hVar.z);
                    jSONObject.put("click_float_opt", hVar.A);
                    jSONObject.put("style_desc", hVar.B);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, hVar.D);
                    jSONObject.put("ad_sort", hVar.E);
                    jSONObject.put("gesture_lottie_type", hVar.F);
                    jSONObject.put("gesture_lottie_url", hVar.G);
                    jSONObject.put("gesture_lottie_sensitivity", hVar.H);
                    if (hVar.p != null) {
                        if (b.a.f0.a.c.d.a()) {
                            jSONObject.put("show_urls", new JSONArray(hVar.p));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(hVar.p)));
                        }
                    }
                    if (hVar.q != null) {
                        if (b.a.f0.a.c.d.a()) {
                            jSONObject.put("click_urls", new JSONArray(hVar.q));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(hVar.q)));
                        }
                    }
                    if (hVar.i()) {
                        b.b(jSONObject, hVar);
                    } else {
                        c.b(jSONObject, hVar);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public static void d(h hVar, h hVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, hVar, hVar2) == null) {
                hVar.f2949a = hVar2.f2949a;
                hVar.f2950b = hVar2.f2950b;
                hVar.f2951c = hVar2.f2951c;
                hVar.f2952d = hVar2.f2952d;
                hVar.f2953e = hVar2.f2953e;
                hVar.f2954f = hVar2.f2954f;
                hVar.f2955g = hVar2.f2955g;
                hVar.f2956h = hVar2.f2956h;
                hVar.f2957i = hVar2.f2957i;
                hVar.j = hVar2.j;
                hVar.k = hVar2.k;
                hVar.l = hVar2.l;
                hVar.m = hVar2.m;
                hVar.n = hVar2.n;
                hVar.o = hVar2.o;
                hVar.p = hVar2.p;
                hVar.q = hVar2.q;
                hVar.r = hVar2.r;
                hVar.s = hVar2.s;
                hVar.t = hVar2.t;
                hVar.u = hVar2.u;
                hVar.w = hVar2.w;
                hVar.y = hVar2.y;
                hVar.z = hVar2.z;
                hVar.A = hVar2.A;
                hVar.B = hVar2.B;
                hVar.D = hVar2.D;
                hVar.E = hVar2.E;
                hVar.F = hVar2.F;
                hVar.G = hVar2.G;
                hVar.H = hVar2.H;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, hVar) == null) || jSONObject == null) {
                return;
            }
            try {
                hVar.f2955g = jSONObject.optString("url");
                hVar.f2956h = jSONObject.optInt("width");
                hVar.f2957i = jSONObject.optInt("height");
                hVar.j = jSONObject.optString("imageMd5");
            } catch (Exception e2) {
                if (h.I) {
                    e2.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, hVar) == null) {
                try {
                    jSONObject.put("url", hVar.f2955g);
                    jSONObject.put("imageMd5", hVar.j);
                    jSONObject.put("width", hVar.f2956h);
                    jSONObject.put("height", hVar.f2957i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, hVar) == null) || jSONObject == null) {
                return;
            }
            try {
                hVar.f2955g = jSONObject.optString("url");
                hVar.f2956h = jSONObject.optInt("width");
                hVar.f2957i = jSONObject.optInt("height");
                hVar.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception e2) {
                if (h.I) {
                    e2.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, hVar) == null) {
                try {
                    jSONObject.put("url", hVar.f2955g);
                    jSONObject.put(PackageTable.MD5, hVar.j);
                    jSONObject.put("width", hVar.f2956h);
                    jSONObject.put("height", hVar.f2957i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-142375162, "Lb/a/f0/b/g/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-142375162, "Lb/a/f0/b/g/h;");
                return;
            }
        }
        I = b.a.f0.a.a.a.f2872a;
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
        this.w = 0;
        this.x = false;
    }

    public static boolean a(h hVar) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hVar)) == null) {
            if (TextUtils.isEmpty(hVar.f2952d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(hVar.f2955g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > hVar.s) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new b.a.f0.b.g.b(hVar).e(hVar.i() ? "BC0263" : "BC0265", str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static h b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            h hVar = new h();
            try {
                a.a(jSONObject, hVar);
                if (I) {
                    String str = "createFromJson() item.toString(): " + hVar.toString();
                }
                return hVar;
            } catch (Exception e2) {
                if (I) {
                    e2.printStackTrace();
                }
                return hVar;
            }
        }
        return (h) invokeL.objValue;
    }

    public static h c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            try {
                h hVar = new h();
                a.b(jSONObject, hVar);
                if (I) {
                    String str = "createFromJson() item.toString(): " + hVar.toString();
                }
                return hVar;
            } catch (Exception e2) {
                if (I) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (h) invokeL.objValue;
    }

    public static List<h> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        h c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    c2 = c((JSONObject) jSONArray.get(i2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    if (I) {
                        e2.printStackTrace();
                    }
                }
                if (c2 == null) {
                    break;
                }
                if (c2.f2949a != 0 && a(c2)) {
                    arrayList.add(c2);
                    if (I) {
                        String str = "splashDataItem:  i=" + i2 + ",content" + c2.toString();
                    }
                }
                if (I) {
                    String str2 = "空订单|物料不合法抛弃： splashDataItem:  i=" + i2 + ",content" + c2.toString();
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void l(h hVar, h hVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, hVar, hVar2) == null) {
            a.d(hVar, hVar2);
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.B)) {
                try {
                    return new JSONObject(this.B);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return new JSONObject();
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.f2953e, "splash_image") ? "image" : TextUtils.equals(this.f2953e, "splash_video") ? "video" : "" : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D == 3 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2954f == 1 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.D;
            return i2 == 0 || i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.f2953e, "splash_image") : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
