package c.a.s0.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = "topic_id";
    public static String B = "url";
    public static String C = "schemefrom";
    public static String D = "from";
    public static String E = "token";
    public static String F = "tab_name";
    public static String G = "maintablocate";
    public static String H = "maintab_subtab";
    public static String I = "newgod_from";
    public static String J = "field_id";
    public static String K = "chushou_third_live_type";
    public static String L = "chuchou_third_room_id";
    public static String M = "yy_url";
    public static String N = "hotTrend";
    public static String O = "tab_id";
    public static String P = "param_uri";
    public static String Q = "forumId";
    public static String R = "item_id";
    public static String S = "itemId";
    public static String T = "sortType";
    public static String U = "rankType";
    public static String V = "rankCode";
    public static String W = "homeTabName";
    public static String X = "tabId";
    public static String Y = "query";
    public static String Z = "source";
    public static String a = "com.baidu.tieba";
    public static String a0 = "forumName";

    /* renamed from: b  reason: collision with root package name */
    public static String f12411b = "unidispatch";
    public static String b0 = "useMainState";

    /* renamed from: c  reason: collision with root package name */
    public static String f12412c = "/homepage";
    public static String c0 = "tabCode";

    /* renamed from: d  reason: collision with root package name */
    public static String f12413d = "/enterforum";
    public static String d0 = "expanddata";

    /* renamed from: e  reason: collision with root package name */
    public static String f12414e = "/recommendforum";
    public static String e0 = "taskInfo";

    /* renamed from: f  reason: collision with root package name */
    public static String f12415f = "/frs";
    public static String f0 = "actionid";

    /* renamed from: g  reason: collision with root package name */
    public static String f12416g = "/pb";
    public static String g0 = "shipin";

    /* renamed from: h  reason: collision with root package name */
    public static String f12417h = "/tbwebview";
    public static String h0 = "wise";

    /* renamed from: i  reason: collision with root package name */
    public static String f12418i = "/usercenter";
    public static String i0 = "shoubai";

    /* renamed from: j  reason: collision with root package name */
    public static String f12419j = "/topicdetail";
    public static String j0 = "tbShareH5";

    /* renamed from: k  reason: collision with root package name */
    public static String f12420k = "/tiebachushou";
    public static String k0 = "QQ";
    public static String l = "/tiebayy";
    public static String l0 = "from_tb_token";
    public static String m = "/activitypage";
    public static String n = "/minePage";
    public static String o = "/messageCenter";
    public static String p = "/videotab";
    public static String q = "/videoSynthesisPage";
    public static String r = "/hometab";
    public static String s = "extdata";
    public static String t = "kw";
    public static String u = "tid";
    public static String v = "ori_ugc_nid";
    public static String w = "ori_ugc_tid";
    public static String x = "ori_ugc_type";
    public static String y = "ori_ugc_vid";
    public static String z = "portrait";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1808477711, "Lc/a/s0/a/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1808477711, "Lc/a/s0/a/g$c;");
                    return;
                }
            }
            a = new g(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(252160942, "Lc/a/s0/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(252160942, "Lc/a/s0/a/g;");
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static final g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a : (g) invokeV.objValue;
    }

    public static boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? uri != null && a.equals(uri.getScheme()) && f12411b.equals(uri.getHost()) : invokeL.booleanValue;
    }

    public final void a(String str, Uri uri, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, uri, str2) == null) {
            if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, l0)) {
                TiebaStatic.log(new StatisticItem("c13391").param("obj_type", uri.getQueryParameter("obj_type")).param("obj_source", uri.getQueryParameter("obj_source")));
            }
            if (str == null || str.contains("tbwebview") || uri == null) {
                return;
            }
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
                return;
            }
            UtilHelper.clearClipBoard();
        }
    }

    public void d(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, bVar) == null) && uri != null && c(uri) && f12415f.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = t;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = O;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = u;
            hashMap.put(str3, uri.getQueryParameter(str3));
            l(uri.getQueryParameter(D));
            String queryParameter = uri.getQueryParameter(s);
            String queryParameter2 = uri.getQueryParameter(C);
            k(queryParameter, queryParameter2, uri.getQueryParameter(E), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bVar) == null) && uri != null && c(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(s);
            String queryParameter2 = uri.getQueryParameter(C);
            String queryParameter3 = uri.getQueryParameter(E);
            String queryParameter4 = uri.getQueryParameter(F);
            String queryParameter5 = uri.getQueryParameter(c0);
            k(queryParameter, queryParameter2, queryParameter3, uri);
            l(uri.getQueryParameter(D));
            a("", uri, queryParameter2);
            w.c(uri);
            if (f12412c.equals(uri.getPath())) {
                hashMap.put(G, 2);
                String str = I;
                hashMap.put(str, uri.getQueryParameter(str));
                String str2 = J;
                hashMap.put(str2, uri.getQueryParameter(str2));
                hashMap.put(F, queryParameter4);
            } else if (f12413d.equals(uri.getPath())) {
                hashMap.put(G, 1);
                hashMap.put(H, queryParameter4);
            } else if (f12414e.equals(uri.getPath())) {
                hashMap.put(G, 1);
                hashMap.put(H, "1_recommend");
            } else if (m.equals(uri.getPath())) {
                hashMap.put(G, 2);
                hashMap.put(F, queryParameter4);
            } else if (n.equals(uri.getPath())) {
                hashMap.put(G, 8);
            } else if (o.equals(uri.getPath())) {
                hashMap.put(G, 3);
            } else if (p.equals(uri.getPath())) {
                hashMap.put(G, 22);
                hashMap.put(H, "22_recommend");
            } else if (r.equals(uri.getPath())) {
                hashMap.put(G, 2);
                hashMap.put(c0, queryParameter5);
            }
            bVar.onCallBack(hashMap);
        }
    }

    public void f(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uri, bVar) == null) && uri != null && c(uri) && f12416g.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = u;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = v;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = w;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = x;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = y;
            hashMap.put(str5, uri.getQueryParameter(str5));
            l(uri.getQueryParameter(D));
            String queryParameter = uri.getQueryParameter(s);
            String queryParameter2 = uri.getQueryParameter(C);
            k(queryParameter, queryParameter2, uri.getQueryParameter(E), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void g(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uri, bVar) == null) && uri != null && c(uri) && f12419j.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = A;
            hashMap.put(str, uri.getQueryParameter(str));
            l(uri.getQueryParameter(D));
            k(uri.getQueryParameter(s), uri.getQueryParameter(C), uri.getQueryParameter(E), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void h(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, uri, bVar) == null) && uri != null && c(uri) && f12418i.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = z;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = b0;
            hashMap.put(str2, Boolean.valueOf(uri.getBooleanQueryParameter(str2, false)));
            k(uri.getQueryParameter(s), uri.getQueryParameter(C), uri.getQueryParameter(E), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void i(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("is_new_schema");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return;
        }
        UtilHelper.clearClipBoard();
    }

    public void j(String str, Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, bVar) == null) && uri != null && c(uri) && f12417h.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = B;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(P, uri);
            l(uri.getQueryParameter(D));
            String queryParameter = uri.getQueryParameter(s);
            String queryParameter2 = uri.getQueryParameter(C);
            k(queryParameter, queryParameter2, uri.getQueryParameter(E), uri);
            a(str, uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public final void k(String str, String str2, String str3, Uri uri) {
        String str4;
        String str5;
        String str6;
        String str7;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, uri) == null) {
            c.a.s0.a.e0.c.f().i(uri);
            if (c.a.d.f.p.m.isEmpty(str)) {
                return;
            }
            c.a.s0.a.c cVar = new c.a.s0.a.c(str);
            cVar.l0(str3);
            if (cVar.d() == 0 || cVar.q() == 0) {
                return;
            }
            TbSingleton.getInstance().setInvokeSource(cVar.e());
            c.a.d.f.n.g.f(String.valueOf(cVar.d()));
            c.a.d.f.n.g.i(String.valueOf(cVar.q()));
            int i2 = StringHelper.equals(str2, l0) ? 2 : 1;
            String str8 = "";
            if (uri != null) {
                str8 = uri.getQueryParameter(t);
                str5 = uri.getQueryParameter(u);
                str6 = uri.getQueryParameter(Y);
                str7 = uri.getQueryParameter("hightlight_anchor_pid");
                str4 = uri.getQueryParameter(TiebaStatic.Params.REFER);
            } else {
                str4 = "";
                str5 = str4;
                str6 = str5;
                str7 = str6;
            }
            if (cVar.d() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                if (currentActivity instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                } else if (currentActivity instanceof BaseActivity) {
                    ((BaseActivity) currentActivity).showFloatingWindow();
                }
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_NEW_SCHEME_PULL_UP).param("obj_source", cVar.e()).param("obj_type", cVar.d()).param("obj_param1", cVar.q()).param(TiebaStatic.Params.OBJ_PARAM2, i2).param(TiebaStatic.Params.OBJ_PARAM3, cVar.s()).param("extra", cVar.v()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fname", str8).param("tid", str5).param("query", str6).param("pid", str7).param(TiebaStatic.Params.REFER, str4).param("obj_locate", TbadkCoreApplication.getInst().getStartType()).param("obj_name", 1));
            d.y().m(cVar);
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            c.a.s0.e1.j.m().v(true);
            c.a.s0.e1.j.m().k();
        }
    }

    public g() {
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
}
