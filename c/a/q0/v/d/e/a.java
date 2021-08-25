package c.a.q0.v.d.e;

import android.text.TextUtils;
import c.a.p0.s.q.c2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f25254b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f25255a;

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

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f25254b == null) {
                synchronized (a.class) {
                    if (f25254b == null) {
                        f25254b = new a();
                    }
                }
            }
            return f25254b;
        }
        return (a) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.f25255a == null) {
            this.f25255a = new ArrayList();
        }
        List<StatisticItem> list = this.f25255a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || str == null) {
            return;
        }
        if (this.f25255a == null) {
            this.f25255a = new ArrayList();
        }
        List<StatisticItem> list = this.f25255a;
        if (list != null) {
            list.add(new StatisticItem(str));
        }
    }

    public final long d(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var)) == null) {
            if (c2Var == null || c2Var.j1() == null) {
                return -1L;
            }
            return c2Var.j1().live_id;
        }
        return invokeL.longValue;
    }

    public StatisticItem e(int i2, String str, int i3, String str2, c2 c2Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, c2Var})) == null) {
            if (c2Var == null) {
                return null;
            }
            String str3 = (c2Var.j1() == null || StringUtils.isNull(c2Var.j1().appId)) ? "" : c2Var.j1().appId;
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_id", d(c2Var));
            statisticItem.param("tid", c2Var.f0());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str3);
            statisticItem.param("entryid", i3);
            statisticItem.param("name", str2);
            statisticItem.param("is_small_follow", i2);
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public void f(String str, int i2, int i3, String str2, long j2, String str3, AlaInfoData alaInfoData) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2, Long.valueOf(j2), str3, alaInfoData}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", i2);
            statisticItem.param("obj_type", i3);
            statisticItem.param("tid", str2);
            if (j2 > 0) {
                statisticItem.param("fid", j2);
            }
            if (!TextUtils.isEmpty(str3)) {
                statisticItem.param("fname", str3);
            }
            int calculateLiveType = YYLiveUtil.calculateLiveType(alaInfoData);
            if (alaInfoData == null || !alaInfoData.isLegalYYLiveData()) {
                str4 = "";
            } else {
                TiebaStaticHelper.addYYParam(statisticItem, alaInfoData.mYyExtData);
                str4 = TiebaStatic.YYValues.YY_LIVE;
            }
            statisticItem.param("obj_param1", calculateLiveType);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str4);
            TiebaStatic.log(statisticItem);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || ListUtils.getCount(this.f25255a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f25255a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f25255a.clear();
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || ListUtils.getCount(this.f25255a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f25255a) {
            if (statisticItem != null) {
                if (!statisticItem.getParams().contains(TiebaStatic.Params.OBJ_PARAM2)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.f25255a.clear();
    }
}
