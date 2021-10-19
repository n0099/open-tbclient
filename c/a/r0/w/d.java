package c.a.r0.w;

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
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static d f25656b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<StatisticItem> f25657a;

    public d() {
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

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f25656b == null) {
                synchronized (d.class) {
                    if (f25656b == null) {
                        f25656b = new d();
                    }
                }
            }
            return f25656b;
        }
        return (d) invokeV.objValue;
    }

    public void a(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, statisticItem) == null) || statisticItem == null) {
            return;
        }
        if (this.f25657a == null) {
            this.f25657a = new ArrayList();
        }
        List<StatisticItem> list = this.f25657a;
        if (list != null) {
            list.add(statisticItem);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.getCount(this.f25657a) == 0) {
            return;
        }
        for (StatisticItem statisticItem : this.f25657a) {
            if (statisticItem != null) {
                TiebaStatic.log(statisticItem);
            }
        }
        this.f25657a.clear();
    }
}
