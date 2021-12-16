package c.a.r0.n0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f12786c;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f12787b;

    public e() {
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
        this.a = i(c.a.r0.s.g0.b.j().p("key_need_add_source_stat_list", ""));
        this.f12787b = i("c12897,c12896,c12895,c12894,c12893,c12892,c12891,c12890,c13274,c12905,c12003,c13271,c12899,c11244,c11032,c12904,c13273,c13433,c10295,c12320,c12835,c10297,c13136,c12910,c10734,c10735,common_click,c10730,c10731,c11439,c10705,c13147,c13388,c13389,c10756,c10296,c10755,c13407,c13406,c12590,c10751,c12888,c12889,consume_33,c11824,c11823,consume_34,c12902,c12898,consume_24,c12887,c12909,c12908,c12942,c12901,c12900,c12903,c13008,c13146,common_exp,c12907,c12906,c10750,consume_3,c11887,c11438,c10704,c10484,c10709,c10708,c12386,c12384");
    }

    public static void b(Context context, StatisticItem statisticItem, c.a.r0.p0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, statisticItem, dVar) == null) || dVar == null || statisticItem == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        c k2 = dVar.k();
        if (k2 == null || k2.e()) {
            k2 = TbPageExtraHelper.k(context);
        }
        if (k2 != null && !k2.e()) {
            c(statisticItem, k2);
        }
        TbPageExtraHelper.s(statisticItem.toString());
    }

    public static void c(StatisticItem statisticItem, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, statisticItem, cVar) == null) || statisticItem == null || cVar == null || TextUtils.isEmpty(statisticItem.getKey())) {
            return;
        }
        String a = cVar.a();
        if (!TextUtils.isEmpty(a) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a);
        }
        String a2 = d.a(cVar.c(), a, 6);
        if (TextUtils.isEmpty(a2) || statisticItem.hasParam("page_source")) {
            return;
        }
        statisticItem.param("page_source", a2);
    }

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f12786c == null) {
                synchronized (e.class) {
                    if (f12786c == null) {
                        f12786c = new e();
                    }
                }
            }
            return f12786c;
        }
        return (e) invokeV.objValue;
    }

    public final void a(StatisticItem statisticItem) {
        Activity currentActivity;
        c k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (k2 = TbPageExtraHelper.k(currentActivity)) == null) {
            return;
        }
        String a = k2.a();
        if (!TextUtils.isEmpty(a) && !statisticItem.hasParam("page_key")) {
            statisticItem.param("page_key", a);
        }
        ArrayList<String> c2 = k2.c();
        String a2 = d.a(c2, a, 6);
        if (statisticItem.getKey().equals("common_exp") && statisticItem.hasParam("common_exp_source_pb_comment") && c2.size() == 0 && (currentActivity instanceof c.a.r0.p0.a)) {
            List<String> currentPageSourceKeyList = ((c.a.r0.p0.a) currentActivity).getCurrentPageSourceKeyList();
            if (currentPageSourceKeyList instanceof ArrayList) {
                a2 = d.a((ArrayList) currentPageSourceKeyList, a, 6);
                statisticItem.delete("common_exp_source_pb_comment");
            }
        }
        if (!TextUtils.isEmpty(a2) && !statisticItem.hasParam("page_source")) {
            statisticItem.param("page_source", a2);
        }
        TbPageExtraHelper.s(statisticItem.toString());
    }

    public final <T> List<T> d(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tArr)) == null) {
            if (tArr == null || tArr.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(tArr.length);
            for (T t : tArr) {
                if (t != null && !TextUtils.isEmpty(t.toString())) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void e(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, statisticItem) == null) || statisticItem == null || statisticItem.hasParam("page_source")) {
            return;
        }
        if (h(statisticItem.getKey()) || g(statisticItem.getKey())) {
            a(statisticItem);
        }
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!ListUtils.isEmpty(this.f12787b) && !l.isEmpty(str)) {
                for (String str2 : this.f12787b) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (!ListUtils.isEmpty(this.a) && !l.isEmpty(str)) {
                for (String str2 : this.a) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final List<String> i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (l.isEmpty(str)) {
                return null;
            }
            return d(str.split(","));
        }
        return (List) invokeL.objValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.a = i(str);
            if (str == null) {
                str = "";
            }
            c.a.r0.s.g0.b.j().x("key_need_add_source_stat_list", str);
        }
    }
}
