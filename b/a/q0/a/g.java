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
    public static String A = "schemefrom";
    public static String B = "from";
    public static String C = "token";
    public static String D = "tab_name";
    public static String E = "maintablocate";
    public static String F = "maintab_subtab";
    public static String G = "newgod_from";
    public static String H = "field_id";
    public static String I = "chushou_third_live_type";
    public static String J = "chuchou_third_room_id";
    public static String K = "yy_url";
    public static String L = "hotTrend";
    public static String M = "tab_id";
    public static String N = "param_uri";
    public static String O = "forumId";
    public static String P = "item_id";
    public static String Q = "itemId";
    public static String R = "sortType";
    public static String S = "rankType";
    public static String T = "rankCode";
    public static String U = "homeTabName";
    public static String V = "tabId";
    public static String W = "query";
    public static String X = "source";
    public static String Y = "forumName";
    public static String Z = "useMainState";

    /* renamed from: a  reason: collision with root package name */
    public static String f11777a = "com.baidu.tieba";
    public static String a0 = "from_tb_token";

    /* renamed from: b  reason: collision with root package name */
    public static String f11778b = "unidispatch";

    /* renamed from: c  reason: collision with root package name */
    public static String f11779c = "/homepage";

    /* renamed from: d  reason: collision with root package name */
    public static String f11780d = "/enterforum";

    /* renamed from: e  reason: collision with root package name */
    public static String f11781e = "/recommendforum";

    /* renamed from: f  reason: collision with root package name */
    public static String f11782f = "/frs";

    /* renamed from: g  reason: collision with root package name */
    public static String f11783g = "/pb";

    /* renamed from: h  reason: collision with root package name */
    public static String f11784h = "/tbwebview";

    /* renamed from: i  reason: collision with root package name */
    public static String f11785i = "/usercenter";
    public static String j = "/topicdetail";
    public static String k = "/tiebachushou";
    public static String l = "/tiebayy";
    public static String m = "/activitypage";
    public static String n = "/minePage";
    public static String o = "/messageCenter";
    public static String p = "/videotab";
    public static String q = "extdata";
    public static String r = "kw";
    public static String s = "tid";
    public static String t = "ori_ugc_nid";
    public static String u = "ori_ugc_tid";
    public static String v = "ori_ugc_type";
    public static String w = "ori_ugc_vid";
    public static String x = "portrait";
    public static String y = "topic_id";
    public static String z = "url";
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
        public static final g f11786a;
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
            f11786a = new g(null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.f11786a : (g) invokeV.objValue;
    }

    public static boolean c(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? uri != null && f11777a.equals(uri.getScheme()) && f11778b.equals(uri.getHost()) : invokeL.booleanValue;
    }

    public final void a(String str, Uri uri, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, uri, str2) == null) {
            if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !StringHelper.equals(str2, a0)) {
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
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, bVar) == null) && uri != null && c(uri) && f11782f.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = r;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = M;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = s;
            hashMap.put(str3, uri.getQueryParameter(str3));
            l(uri.getQueryParameter(B));
            String queryParameter = uri.getQueryParameter(q);
            String queryParameter2 = uri.getQueryParameter(A);
            k(queryParameter, queryParameter2, uri.getQueryParameter(C), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uri, bVar) == null) && uri != null && c(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(q);
            String queryParameter2 = uri.getQueryParameter(A);
            String queryParameter3 = uri.getQueryParameter(C);
            String queryParameter4 = uri.getQueryParameter(D);
            k(queryParameter, queryParameter2, queryParameter3, uri);
            l(uri.getQueryParameter(B));
            a("", uri, queryParameter2);
            w.c(uri);
            if (f11779c.equals(uri.getPath())) {
                hashMap.put(E, 2);
                String str = G;
                hashMap.put(str, uri.getQueryParameter(str));
                String str2 = H;
                hashMap.put(str2, uri.getQueryParameter(str2));
                hashMap.put(D, queryParameter4);
            } else if (f11780d.equals(uri.getPath())) {
                hashMap.put(E, 1);
                hashMap.put(F, queryParameter4);
            } else if (f11781e.equals(uri.getPath())) {
                hashMap.put(E, 1);
                hashMap.put(F, "1_recommend");
            } else if (m.equals(uri.getPath())) {
                hashMap.put(E, 2);
                hashMap.put(D, queryParameter4);
            } else if (n.equals(uri.getPath())) {
                hashMap.put(E, 8);
            } else if (o.equals(uri.getPath())) {
                hashMap.put(E, 3);
            } else if (p.equals(uri.getPath())) {
                hashMap.put(E, 22);
                hashMap.put(F, "22_recommend");
            }
            bVar.onCallBack(hashMap);
        }
    }

    public void f(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, uri, bVar) == null) && uri != null && c(uri) && f11783g.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = s;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = t;
            hashMap.put(str2, uri.getQueryParameter(str2));
            String str3 = u;
            hashMap.put(str3, uri.getQueryParameter(str3));
            String str4 = v;
            hashMap.put(str4, uri.getQueryParameter(str4));
            String str5 = w;
            hashMap.put(str5, uri.getQueryParameter(str5));
            l(uri.getQueryParameter(B));
            String queryParameter = uri.getQueryParameter(q);
            String queryParameter2 = uri.getQueryParameter(A);
            k(queryParameter, queryParameter2, uri.getQueryParameter(C), uri);
            a("", uri, queryParameter2);
            bVar.onCallBack(hashMap);
        }
    }

    public void g(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, uri, bVar) == null) && uri != null && c(uri) && j.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = y;
            hashMap.put(str, uri.getQueryParameter(str));
            l(uri.getQueryParameter(B));
            k(uri.getQueryParameter(q), uri.getQueryParameter(A), uri.getQueryParameter(C), uri);
            bVar.onCallBack(hashMap);
        }
    }

    public void h(Uri uri, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, uri, bVar) == null) && uri != null && c(uri) && f11785i.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str = x;
            hashMap.put(str, uri.getQueryParameter(str));
            String str2 = Z;
            hashMap.put(str2, Boolean.valueOf(uri.getBooleanQueryParameter(str2, false)));
            k(uri.getQueryParameter(q), uri.getQueryParameter(A), uri.getQueryParameter(C), uri);
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
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, uri, bVar) == null) && uri != null && c(uri) && f11784h.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String str2 = z;
            hashMap.put(str2, uri.getQueryParameter(str2));
            hashMap.put(N, uri);
            l(uri.getQueryParameter(B));
            String queryParameter = uri.getQueryParameter(q);
            String queryParameter2 = uri.getQueryParameter(A);
            k(queryParameter, queryParameter2, uri.getQueryParameter(C), uri);
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
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, uri) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        b.a.q0.a.c cVar = new b.a.q0.a.c(str);
        cVar.l0(str3);
        if (cVar.d() == 0 || cVar.q() == 0) {
            return;
        }
        TbSingleton.getInstance().setInvokeSource(cVar.e());
        b.a.e.e.n.g.f(String.valueOf(cVar.d()));
        b.a.e.e.n.g.i(String.valueOf(cVar.q()));
        int i2 = StringHelper.equals(str2, a0) ? 2 : 1;
        String str8 = "";
        if (uri != null) {
            str8 = uri.getQueryParameter(r);
            str5 = uri.getQueryParameter(s);
            str6 = uri.getQueryParameter(W);
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
            b.a.q0.d1.h.m().v(true);
            b.a.q0.d1.h.m().k();
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
