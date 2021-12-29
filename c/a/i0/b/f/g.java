package c.a.i0.b.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.util.TiebaStatic;
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
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public int C;
    public int D;
    public int E;
    public int F;
    public String G;
    public int H;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f3839b;

    /* renamed from: c  reason: collision with root package name */
    public String f3840c;

    /* renamed from: d  reason: collision with root package name */
    public String f3841d;

    /* renamed from: e  reason: collision with root package name */
    public String f3842e;

    /* renamed from: f  reason: collision with root package name */
    public int f3843f;

    /* renamed from: g  reason: collision with root package name */
    public String f3844g;

    /* renamed from: h  reason: collision with root package name */
    public int f3845h;

    /* renamed from: i  reason: collision with root package name */
    public int f3846i;

    /* renamed from: j  reason: collision with root package name */
    public String f3847j;

    /* renamed from: k  reason: collision with root package name */
    public String f3848k;
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

        public static void a(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, gVar) == null) {
                try {
                    gVar.a = jSONObject.optInt("advisible");
                    gVar.f3839b = jSONObject.optString("id");
                    gVar.f3840c = jSONObject.optString("ukey");
                    gVar.f3841d = jSONObject.optString("extra");
                    gVar.f3842e = jSONObject.optString("layout");
                    gVar.f3843f = jSONObject.optInt("type");
                    gVar.f3848k = jSONObject.optString("jump_url");
                    gVar.o = jSONObject.optString("action");
                    gVar.l = jSONObject.optString("flag_name");
                    gVar.m = jSONObject.optInt("logo_type");
                    gVar.n = jSONObject.optInt("display");
                    if (gVar.i()) {
                        b.a(jSONObject, gVar);
                    } else {
                        c.a(jSONObject, gVar);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        gVar.p = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            gVar.p[i2] = optJSONArray.optString(i2);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        gVar.q = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            gVar.q[i3] = optJSONArray2.optString(i3);
                        }
                    }
                    gVar.r = jSONObject.optLong("start");
                    gVar.s = jSONObject.optLong("end");
                    gVar.t = jSONObject.optInt("expose_interval");
                    gVar.u = jSONObject.optInt("expose_times");
                    gVar.v = jSONObject.optInt("preload_type");
                    gVar.y = jSONObject.optString("click_float_lottie_url");
                    gVar.z = jSONObject.optInt("float_bar_show", 1);
                    gVar.A = jSONObject.optInt("click_float_opt", 1);
                    gVar.B = jSONObject.optString("style_desc");
                    gVar.w = jSONObject.optInt("curRate");
                    gVar.D = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    gVar.E = jSONObject.optInt("ad_sort");
                    gVar.F = jSONObject.optInt("gesture_lottie_type");
                    gVar.G = jSONObject.optString("gesture_lottie_url");
                    gVar.H = jSONObject.optInt("gesture_lottie_sensitivity");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, gVar) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray != null) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(0);
                        if (optJSONObject2 == null) {
                            return;
                        }
                        gVar.a = optJSONObject2.optInt("advisible", 1);
                        gVar.f3839b = optJSONObject2.optString("id");
                        gVar.f3840c = optJSONObject2.optString("ukey");
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
                                        gVar.f3841d = optString2;
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
                            gVar.f3842e = optJSONObject4.optString("layout");
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                gVar.f3843f = optJSONObject5.optInt("type");
                                gVar.f3848k = optJSONObject5.optString("jump_url");
                                gVar.o = optJSONObject5.optString("action");
                                gVar.l = optJSONObject5.optString("flag_name");
                                gVar.m = optJSONObject5.optInt("logo_type");
                                gVar.n = optJSONObject5.optInt("display");
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                gVar.y = optJSONObject5.optString("click_float_lottie_url");
                                gVar.D = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                gVar.E = optJSONObject5.optInt("ad_sort");
                                gVar.F = optJSONObject5.optInt("gesture_lottie_type");
                                gVar.G = optJSONObject5.optString("gesture_lottie_url");
                                gVar.H = optJSONObject5.optInt("gesture_lottie_sensitivity");
                                if (gVar.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), gVar);
                                } else {
                                    c.a(optJSONObject5, gVar);
                                }
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                gVar.p = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i3 = 0; i3 < length; i3++) {
                                    gVar.p[i3] = optJSONArray6.optString(i3);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                gVar.q = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i4 = 0; i4 < length2; i4++) {
                                    gVar.q[i4] = optJSONArray7.optString(i4);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                gVar.r = jSONObject2.optLong("start");
                                gVar.s = jSONObject2.optLong("end");
                                gVar.t = optJSONObject6.optInt("expose_interval");
                                gVar.u = optJSONObject6.optInt("expose_times");
                                gVar.v = optJSONObject6.optInt("preload_type");
                                gVar.z = optJSONObject6.optInt("float_bar_show", 1);
                                gVar.A = optJSONObject6.optInt("click_float_opt", 1);
                                gVar.B = optJSONObject6.optString("style_desc");
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, gVar) == null) {
                try {
                    jSONObject.put("advisible", gVar.a);
                    jSONObject.put("id", gVar.f3839b);
                    jSONObject.put("ukey", gVar.f3840c);
                    jSONObject.put("extra", gVar.f3841d);
                    jSONObject.put("layout", gVar.f3842e);
                    jSONObject.put("type", gVar.f3843f);
                    jSONObject.put("jump_url", gVar.f3848k);
                    jSONObject.put("action", gVar.o);
                    jSONObject.put("flag_name", gVar.l);
                    jSONObject.put("logo_type", gVar.m);
                    jSONObject.put("display", gVar.n);
                    jSONObject.put("start", gVar.r);
                    jSONObject.put("end", gVar.s);
                    jSONObject.put("expose_times", gVar.u);
                    jSONObject.put("expose_interval", gVar.t);
                    jSONObject.put("preload_type", gVar.v);
                    jSONObject.put("curRate", gVar.w);
                    jSONObject.put("click_float_lottie_url", gVar.y);
                    jSONObject.put("float_bar_show", gVar.z);
                    jSONObject.put("click_float_opt", gVar.A);
                    jSONObject.put("style_desc", gVar.B);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, gVar.D);
                    jSONObject.put("ad_sort", gVar.E);
                    jSONObject.put("gesture_lottie_type", gVar.F);
                    jSONObject.put("gesture_lottie_url", gVar.G);
                    jSONObject.put("gesture_lottie_sensitivity", gVar.H);
                    if (gVar.p != null) {
                        if (c.a.i0.a.c.d.a()) {
                            jSONObject.put("show_urls", new JSONArray(gVar.p));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(gVar.p)));
                        }
                    }
                    if (gVar.q != null) {
                        if (c.a.i0.a.c.d.a()) {
                            jSONObject.put("click_urls", new JSONArray(gVar.q));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(gVar.q)));
                        }
                    }
                    if (gVar.i()) {
                        b.b(jSONObject, gVar);
                    } else {
                        c.b(jSONObject, gVar);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public static void d(g gVar, g gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, gVar, gVar2) == null) {
                gVar.a = gVar2.a;
                gVar.f3839b = gVar2.f3839b;
                gVar.f3840c = gVar2.f3840c;
                gVar.f3841d = gVar2.f3841d;
                gVar.f3842e = gVar2.f3842e;
                gVar.f3843f = gVar2.f3843f;
                gVar.f3844g = gVar2.f3844g;
                gVar.f3845h = gVar2.f3845h;
                gVar.f3846i = gVar2.f3846i;
                gVar.f3847j = gVar2.f3847j;
                gVar.f3848k = gVar2.f3848k;
                gVar.l = gVar2.l;
                gVar.m = gVar2.m;
                gVar.n = gVar2.n;
                gVar.o = gVar2.o;
                gVar.p = gVar2.p;
                gVar.q = gVar2.q;
                gVar.r = gVar2.r;
                gVar.s = gVar2.s;
                gVar.t = gVar2.t;
                gVar.u = gVar2.u;
                gVar.w = gVar2.w;
                gVar.y = gVar2.y;
                gVar.z = gVar2.z;
                gVar.A = gVar2.A;
                gVar.B = gVar2.B;
                gVar.D = gVar2.D;
                gVar.E = gVar2.E;
                gVar.F = gVar2.F;
                gVar.G = gVar2.G;
                gVar.H = gVar2.H;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, gVar) == null) || jSONObject == null) {
                return;
            }
            try {
                gVar.f3844g = jSONObject.optString("url");
                gVar.f3845h = jSONObject.optInt("width");
                gVar.f3846i = jSONObject.optInt("height");
                gVar.f3847j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, gVar) == null) {
                try {
                    jSONObject.put("url", gVar.f3844g);
                    jSONObject.put("imageMd5", gVar.f3847j);
                    jSONObject.put("width", gVar.f3845h);
                    jSONObject.put("height", gVar.f3846i);
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

        public static void a(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, gVar) == null) || jSONObject == null) {
                return;
            }
            try {
                gVar.f3844g = jSONObject.optString("url");
                gVar.f3845h = jSONObject.optInt("width");
                gVar.f3846i = jSONObject.optInt("height");
                gVar.f3847j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, gVar) == null) {
                try {
                    jSONObject.put("url", gVar.f3844g);
                    jSONObject.put(PackageTable.MD5, gVar.f3847j);
                    jSONObject.put("width", gVar.f3845h);
                    jSONObject.put("height", gVar.f3846i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public g() {
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
        this.w = 0;
        this.x = false;
    }

    public static boolean a(g gVar) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gVar)) == null) {
            if (TextUtils.isEmpty(gVar.f3841d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(gVar.f3844g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > gVar.s) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(gVar).f(gVar.i() ? "BC0263" : "BC0265", str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static g b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            g gVar = new g();
            try {
                a.a(jSONObject, gVar);
            } catch (Exception unused) {
            }
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public static g c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                g gVar = new g();
                a.b(jSONObject, gVar);
                return gVar;
            } catch (Exception unused) {
                return null;
            }
        }
        return (g) invokeL.objValue;
    }

    public static List<g> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        g c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    c2 = c((JSONObject) jSONArray.get(i2));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (c2 == null) {
                    break;
                }
                if (c2.a != 0 && a(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void l(g gVar, g gVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, gVar, gVar2) == null) {
            a.d(gVar, gVar2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.f3842e, "splash_image") ? "image" : TextUtils.equals(this.f3842e, "splash_video") ? "video" : "" : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.D == 3 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f3843f == 1 : invokeV.booleanValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.f3842e, "splash_image") : invokeV.booleanValue;
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
