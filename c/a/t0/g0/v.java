package c.a.t0.g0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static v f17883b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<StatisticItem> a;

    public v() {
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

    public static v b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f17883b == null) {
                synchronized (v.class) {
                    if (f17883b == null) {
                        f17883b = new v();
                    }
                }
            }
            return f17883b;
        }
        return (v) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(statisticItem);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        int i2 = -1;
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null && i2 != statisticItem.getPosition()) {
                i2 = statisticItem.getPosition();
                statisticItem.delete(TiebaStatic.Params.OBJ_PARAM2);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, z ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || ListUtils.getCount(this.a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.a) {
            if (statisticItem != null) {
                if (statisticItem.getKey() != null && !statisticItem.getKey().equals("c13756") && !statisticItem.getKey().equals("c13750") && !statisticItem.getKey().equals("c13751")) {
                    statisticItem.param("obj_type", z ? 1 : 0);
                }
                TiebaStatic.log(statisticItem);
            }
        }
        this.a.clear();
    }
}
