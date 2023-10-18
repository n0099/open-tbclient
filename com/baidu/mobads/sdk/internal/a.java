package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.util.FileMetaUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "none";
    public static final String b = "text";
    public static final String c = "static_image";
    public static final String d = "gif";
    public static final String e = "rich_media";
    public static final String f = "html";
    public static final String g = "hybrid";
    public static final String h = "video";
    public static final long i = 1750000;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public int D;
    public String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public String L;
    public String M;
    public List<String> N;
    public JSONObject O;
    public long P;
    public long Q;
    public String R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public String f1048T;
    public String U;
    public String V;
    public String W;
    public String X;
    public JSONObject Y;
    public int Z;
    public int aa;
    public int ab;
    public List<String> ac;
    public int ad;
    public String ae;
    public String af;
    public JSONObject ag;
    public JSONObject ah;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public String p;
    public long q;
    public int r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true : invokeI.booleanValue;
    }

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
                return;
            }
        }
        this.s = 1;
        this.M = "none";
        this.ad = 0;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.y;
        }
        return (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.Q;
        }
        return invokeV.longValue;
    }

    public List<String> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.N;
        }
        return (List) invokeV.objValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.O;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.V;
        }
        return (String) invokeV.objValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.X;
            if (str != null && str.length() > 4) {
                return "";
            }
            return this.X;
        }
        return (String) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.ab;
        }
        return invokeV.intValue;
    }

    public List<String> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.ac;
        }
        return (List) invokeV.objValue;
    }

    public JSONObject P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.Y;
        }
        return (JSONObject) invokeV.objValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.Z;
        }
        return invokeV.intValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.aa;
        }
        return invokeV.intValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.ad;
        }
        return invokeV.intValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.ae;
        }
        return (String) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.S;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.f1048T;
        }
        return (String) invokeV.objValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.E;
        }
        return (String) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.I;
        }
        return invokeV.intValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.J;
        }
        return invokeV.intValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.K;
        }
        return invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.M;
        }
        return (String) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.P;
        }
        return invokeV.longValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (!TextUtils.isEmpty(this.u)) {
                return this.u;
            }
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public static int a(JSONObject jSONObject, int i2, int i3) {
        InterceptResult invokeLII;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, jSONObject, i2, i3)) == null) {
            int i4 = 0;
            if (jSONObject != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("tp_id");
                        if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                            i4 = Integer.parseInt(split[0]);
                        }
                    }
                } catch (Throwable th) {
                    br.a().d(th.getMessage());
                }
            }
            if (a(i4)) {
                i2 = i4;
            } else if (!a(i2)) {
                i2 = i3;
            }
            if (i2 == 42) {
                return 41;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0150 A[Catch: all -> 0x017f, JSONException -> 0x0184, TryCatch #4 {JSONException -> 0x0184, all -> 0x017f, blocks: (B:7:0x0086, B:10:0x0098, B:12:0x00a9, B:13:0x00c0, B:15:0x00cc, B:17:0x00d7, B:19:0x00dd, B:20:0x00df, B:22:0x00e5, B:24:0x00eb, B:26:0x00f3, B:30:0x00fc, B:32:0x0106, B:33:0x0123, B:35:0x0129, B:36:0x012f, B:38:0x0137, B:40:0x013d, B:42:0x0147, B:45:0x0150, B:47:0x015e, B:49:0x0165, B:50:0x016d, B:52:0x0173), top: B:115:0x0086 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject != null) {
                a aVar = new a();
                aVar.ah = jSONObject;
                aVar.O = jSONObject.optJSONObject("remoteParams");
                aVar.j = jSONObject.optString("tit");
                aVar.k = jSONObject.optString("desc");
                aVar.l = jSONObject.optString("icon");
                aVar.m = jSONObject.optString("w_picurl");
                aVar.n = jSONObject.optInt("w");
                aVar.o = jSONObject.optInt("h");
                aVar.p = jSONObject.optString("appname");
                aVar.S = jSONObject.optString("adLogo");
                aVar.f1048T = jSONObject.optString("baiduLogo");
                aVar.Z = jSONObject.optInt("region_click", 2);
                aVar.aa = jSONObject.optInt("dl_dialog", 2);
                aVar.X = jSONObject.optString("btn");
                try {
                    String optString = jSONObject.optString("control_flags");
                    if (!TextUtils.isEmpty(optString)) {
                        String optString2 = new JSONObject(optString).optString("innovate");
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONObject jSONObject3 = new JSONObject(optString2);
                            aVar.U = jSONObject3.optString("gjico");
                            aVar.V = jSONObject3.optString("gjtxt");
                            aVar.W = jSONObject3.optString("gjurl");
                        }
                    }
                    String optString3 = jSONObject.optString("cloud_control");
                    if (!TextUtils.isEmpty(optString3)) {
                        JSONObject jSONObject4 = new JSONObject(optString3);
                        if (jSONObject4.has("cta") && jSONObject4.optInt("cta", 1) == 0) {
                            aVar.X = "";
                        }
                        if (jSONObject4.has("marketing")) {
                            int optInt = jSONObject4.optInt("marketing", 0);
                            if (optInt == 1) {
                                JSONArray optJSONArray = jSONObject4.optJSONArray("marketing_logo");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    int i2 = 0;
                                    for (int i3 = 2; i2 < i3; i3 = 2) {
                                        String optString4 = optJSONArray.optString(i2);
                                        if (!TextUtils.isEmpty(optString4)) {
                                            JSONObject jSONObject5 = new JSONObject(optString4);
                                            aVar.U = jSONObject5.optString("gjico", aVar.U);
                                            aVar.V = jSONObject5.optString("gjtxt", aVar.V);
                                            aVar.W = jSONObject5.optString("gjurl", aVar.W);
                                        }
                                        i2++;
                                    }
                                }
                            } else if (optInt == 0) {
                                aVar.U = "";
                                aVar.V = "";
                                aVar.W = "";
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject4.optJSONArray("btn_style");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            String optString5 = optJSONArray2.optString(0);
                            if (!TextUtils.isEmpty(optString5)) {
                                jSONObject2 = new JSONObject(optString5);
                                if (jSONObject2 != null) {
                                    aVar.ab = jSONObject2.optInt("type", 0);
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("colors");
                                    if (optJSONArray3 != null && optJSONArray3.length() == 4) {
                                        aVar.ac = new ArrayList();
                                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                            aVar.ac.add(optJSONArray3.optString(i4));
                                        }
                                    }
                                }
                            }
                        }
                        jSONObject2 = null;
                        if (jSONObject2 != null) {
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aVar.Y = jSONObject.optJSONObject("monitors");
                aVar.q = jSONObject.optLong("sz");
                aVar.r = jSONObject.optInt("auto_play", 0);
                aVar.s = jSONObject.optInt("auto_play_non_wifi", 1);
                aVar.v = jSONObject.optString(PushConstants.URI_PACKAGE_NAME);
                aVar.D = jSONObject.optInt("act");
                aVar.E = jSONObject.optString("apo", "");
                aVar.t = jSONObject.optString("bidlayer", "");
                aVar.u = jSONObject.optString("ads_bidlayer", "");
                aVar.F = jSONObject.optInt("container_width");
                aVar.G = jSONObject.optInt("container_height");
                aVar.H = jSONObject.optInt("size_type");
                int optInt2 = jSONObject.optInt("style_type");
                aVar.I = optInt2;
                aVar.J = a(jSONObject, optInt2, 29);
                aVar.w = jSONObject.optString("vurl", "");
                aVar.K = jSONObject.optInt("duration", 0);
                aVar.L = jSONObject.optString("type");
                aVar.x = jSONObject.optString("html", null);
                aVar.z = jSONObject.optString("app_version", "");
                aVar.y = jSONObject.optString("publisher", "");
                aVar.C = jSONObject.optString("permission_link", "");
                aVar.A = jSONObject.optString("privacy_link", "");
                aVar.B = jSONObject.optString("function_link", "");
                aVar.ad = jSONObject.optInt("media_player_render", 0);
                aVar.ae = jSONObject.optString("qk", "");
                aVar.af = jSONObject.optString("buyer", "");
                try {
                    String optString6 = jSONObject.optString("media_key");
                    if (!TextUtils.isEmpty(optString6)) {
                        aVar.ag = new JSONObject(optString6);
                    }
                } catch (Throwable th2) {
                    av.b(th2);
                }
                try {
                    JSONArray optJSONArray4 = jSONObject.optJSONArray("morepics");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        aVar.N = new ArrayList();
                        for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                            aVar.N.add(optJSONArray4.getString(i5));
                        }
                    }
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(aVar.x)) {
                    aVar.M = "html";
                } else {
                    String str2 = aVar.L;
                    if (str2 != null) {
                        if (str2.equals("text")) {
                            aVar.L = "text";
                        } else if (aVar.L.equals("image")) {
                            if (!TextUtils.isEmpty(aVar.m)) {
                                int lastIndexOf = aVar.m.toLowerCase(Locale.getDefault()).lastIndexOf(46);
                                if (lastIndexOf < 0) {
                                    str = "";
                                } else {
                                    str = aVar.m.toLowerCase(Locale.getDefault()).substring(lastIndexOf);
                                }
                                if (str.contains(".gif")) {
                                    aVar.M = "gif";
                                } else {
                                    aVar.M = c;
                                }
                            }
                        } else if (aVar.L.equals(com.kuaishou.weapon.p0.u.B)) {
                            aVar.M = e;
                        } else if (aVar.L.equals("video")) {
                            aVar.M = "video";
                        }
                    }
                }
                JSONObject jSONObject6 = aVar.O;
                if (jSONObject6 != null) {
                    aVar.P = jSONObject6.optLong(FileMetaUtil.CREATE_TIME, 0L);
                    aVar.Q = aVar.O.optLong("expireTime", i);
                    aVar.S = aVar.O.optString("adLogo", w.aI);
                    aVar.f1048T = aVar.O.optString("baiduLogo", w.aJ);
                    aVar.R = aVar.O.optString("uniqueId", "");
                }
                return aVar;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public static List<a> a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        arrayList.add(a(jSONArray.getJSONObject(i2)));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public JSONObject T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", this.R);
                jSONObject.put("tit", this.j);
                jSONObject.put("desc", this.k);
                jSONObject.put(PushConstants.URI_PACKAGE_NAME, this.v);
                jSONObject.put("appname", this.p);
                jSONObject.put("act", this.D);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (!TextUtils.isEmpty(this.af)) {
                try {
                    long parseLong = Long.parseLong(this.af);
                    int length = this.af.length();
                    if (parseLong > 100000 && length > 5) {
                        return this.af.substring(length - 4, length);
                    }
                    return "";
                } catch (Throwable th) {
                    av.b(th);
                    return "";
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (this.ag == null) {
                return null;
            }
            JSONObject jSONObject2 = this.ah;
            if (jSONObject2 != null) {
                jSONObject = jSONObject2.optJSONObject("apo");
            } else {
                jSONObject = null;
            }
            String optString = this.ag.optString(str);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (TextUtils.equals(optString, "fallback") && jSONObject != null) {
                return jSONObject.optString("fallback");
            }
            if (TextUtils.equals(optString, "page") && jSONObject != null) {
                return jSONObject.optString("page");
            }
            JSONObject jSONObject3 = this.ah;
            if (jSONObject3 == null) {
                return null;
            }
            return jSONObject3.optString(optString);
        }
        return (String) invokeL.objValue;
    }
}
