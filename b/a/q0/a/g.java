package b.a.q0.a;

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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = "url";
    public static String B = "schemefrom";
    public static String C = "from";
    public static String D = "token";
    public static String E = "tab_name";
    public static String F = "maintablocate";
    public static String G = "maintab_subtab";
    public static String H = "newgod_from";
    public static String I = "field_id";
    public static String J = "chushou_third_live_type";
    public static String K = "chuchou_third_room_id";
    public static String L = "yy_url";
    public static String M = "hotTrend";
    public static String N = "tab_id";
    public static String O = "param_uri";
    public static String P = "forumId";
    public static String Q = "item_id";
    public static String R = "itemId";
    public static String S = "sortType";
    public static String T = "rankType";
    public static String U = "rankCode";
    public static String V = "homeTabName";
    public static String W = "tabId";
    public static String X = "query";
    public static String Y = "source";
    public static String Z = "forumName";

    /* renamed from: a  reason: collision with root package name */
    public static String f12528a = "com.baidu.tieba";
    public static String a0 = "useMainState";

    /* renamed from: b  reason: collision with root package name */
    public static String f12529b = "unidispatch";
    public static String b0 = "tabCode";

    /* renamed from: c  reason: collision with root package name */
    public static String f12530c = "/homepage";
    public static String c0 = "from_tb_token";

    /* renamed from: d  reason: collision with root package name */
    public static String f12531d = "/enterforum";

    /* renamed from: e  reason: collision with root package name */
    public static String f12532e = "/recommendforum";

    /* renamed from: f  reason: collision with root package name */
    public static String f12533f = "/frs";

    /* renamed from: g  reason: collision with root package name */
    public static String f12534g = "/pb";

    /* renamed from: h  reason: collision with root package name */
    public static String f12535h = "/tbwebview";

    /* renamed from: i  reason: collision with root package name */
    public static String f12536i = "/usercenter";
    public static String j = "/topicdetail";
    public static String k = "/tiebachushou";
    public static String l = "/tiebayy";
    public static String m = "/activitypage";
    public static String n = "/minePage";
    public static String o = "/messageCenter";
    public static String p = "/videotab";
    public static String q = "/hometab";
    public static String r = "extdata";
    public static String s = "kw";
    public static String t = "tid";
    public static String u = "ori_ugc_nid";
    public static String v = "ori_ugc_tid";
    public static String w = "ori_ugc_type";
    public static String x = "ori_ugc_vid";
    public static String y = "portrait";
    public static String z = "topic_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final g f12537a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1421822348, "Lb/a/q0/a/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1421822348, "Lb/a/q0/a/g$c;");
                    return;
                }
            }
            f12537a = new g(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(274104939, "Lb/a/q0/a/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(274104939, "Lb/a/q0/a/g;");
        }
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static final g b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f12537a : (g) invokeV.objValue;
    }

    public static boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? uri != null && f12528a.equals(uri.getScheme()) && f12529b.equals(uri.getHost()) : invokeL.booleanValue;
    }

    public final void a(String str, Uri uri, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, uri, str2) == null) {
            if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, c0)) {
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
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, bVar) == null) && uri != null && c(uri) && f12533f.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = s;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = N;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = t;
            hashMap.put(str3, uri.getQueryParameter(str3));
            l(uri.getQueryParameter(C));
            String queryParameter = uri.getQueryParameter(r);
            String queryParameter2 = uri.getQueryParameter(B);
            k(queryParameter, queryParameter2, uri.getQueryParameter(D), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bVar) == null) && uri != null && c(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(r);
            String queryParameter2 = uri.getQueryParameter(B);
            String queryParameter3 = uri.getQueryParameter(D);
            String queryParameter4 = uri.getQueryParameter(E);
            String queryParameter5 = uri.getQueryParameter(b0);
            k(queryParameter, queryParameter2, queryParameter3, uri);
            l(uri.getQueryParameter(C));
            a("", uri, queryParameter2);
            w.c(uri);
            if (f12530c.equals(uri.getPath())) {
                hashMap.put(F, 2);
                String str = H;
                hashMap.put(str, uri.getQueryParameter(str));
                String str2 = I;
                hashMap.put(str2, uri.getQueryParameter(str2));
                hashMap.put(E, queryParameter4);
            } else if (f12531d.equals(uri.getPath())) {
                hashMap.put(F, 1);
                hashMap.put(G, queryParameter4);
            } else if (f12532e.equals(uri.getPath())) {
                hashMap.put(F, 1);
                hashMap.put(G, "1_recommend");
            } else if (m.equals(uri.getPath())) {
                hashMap.put(F, 2);
                hashMap.put(E, queryParameter4);
            } else if (n.equals(uri.getPath())) {
                hashMap.put(F, 8);
            } else if (o.equals(uri.getPath())) {
                hashMap.put(F, 3);
            } else if (p.equals(uri.getPath())) {
                hashMap.put(F, 22);
                hashMap.put(G, "22_recommend");
            } else if (q.equals(uri.getPath())) {
                hashMap.put(F, 2);
                hashMap.put(b0, queryParameter5);
            }
            bVar.onCallBack(hashMap);
        }
    }

    public void f(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uri, bVar) == null) && uri != null && c(uri) && f12534g.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = t;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = u;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = v;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = w;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = x;
            hashMap.put(str5, uri.getQueryParameter(str5));
            l(uri.getQueryParameter(C));
            String queryParameter = uri.getQueryParameter(r);
            String queryParameter2 = uri.getQueryParameter(B);
            k(queryParameter, queryParameter2, uri.getQueryParameter(D), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void g(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uri, bVar) == null) && uri != null && c(uri) && j.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = z;
            hashMap.put(str, uri.getQueryParameter(str));
            l(uri.getQueryParameter(C));
            k(uri.getQueryParameter(r), uri.getQueryParameter(B), uri.getQueryParameter(D), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void h(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, uri, bVar) == null) && uri != null && c(uri) && f12536i.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = y;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = a0;
            hashMap.put(str2, Boolean.valueOf(uri.getBooleanQueryParameter(str2, false)));
            k(uri.getQueryParameter(r), uri.getQueryParameter(B), uri.getQueryParameter(D), uri);
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
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, bVar) == null) && uri != null && c(uri) && f12535h.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = A;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(O, uri);
            l(uri.getQueryParameter(C));
            String queryParameter = uri.getQueryParameter(r);
            String queryParameter2 = uri.getQueryParameter(B);
            k(queryParameter, queryParameter2, uri.getQueryParameter(D), uri);
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
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, uri) == null) || b.a.e.f.p.k.isEmpty(str)) {
            return;
        }
        b.a.q0.a.c cVar = new b.a.q0.a.c(str);
        cVar.l0(str3);
        if (cVar.d() == 0 || cVar.q() == 0) {
            return;
        }
        TbSingleton.getInstance().setInvokeSource(cVar.e());
        b.a.e.f.n.g.f(String.valueOf(cVar.d()));
        b.a.e.f.n.g.i(String.valueOf(cVar.q()));
        int i2 = StringHelper.equals(str2, c0) ? 2 : 1;
        String str8 = "";
        if (uri != null) {
            str8 = uri.getQueryParameter(s);
            str5 = uri.getQueryParameter(t);
            str6 = uri.getQueryParameter(X);
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

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && !TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            b.a.q0.c1.h.m().v(true);
            b.a.q0.c1.h.m().k();
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
