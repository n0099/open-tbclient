package c.a.y;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f31137a;

    /* renamed from: b  reason: collision with root package name */
    public McnVideoAdView f31138b;

    /* renamed from: c  reason: collision with root package name */
    public McnVideoAdView.c f31139c;

    /* loaded from: classes4.dex */
    public class a implements McnVideoAdView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void a(c.a.y.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || StringUtils.isNull(aVar.f31129d)) {
                return;
            }
            b.b().c(aVar.f31129d);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void b(c.a.y.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13405");
            statisticItem.param("tid", aVar.f31130e);
            statisticItem.param("fid", aVar.f31131f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f31132g);
            TiebaStatic.log(statisticItem);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void c(c.a.y.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13404");
            statisticItem.param("tid", aVar.f31130e);
            statisticItem.param("fid", aVar.f31131f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f31132g);
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31139c = new a(this);
        this.f31137a = context;
        McnVideoAdView mcnVideoAdView = new McnVideoAdView(context);
        this.f31138b = mcnVideoAdView;
        mcnVideoAdView.setIMcnStatListener(this.f31139c);
    }

    public void a() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mcnVideoAdView = this.f31138b) == null) {
            return;
        }
        mcnVideoAdView.dismiss();
    }

    public void b() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mcnVideoAdView = this.f31138b) == null) {
            return;
        }
        mcnVideoAdView.hideMcnVideoAdWithOutAnim();
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            McnVideoAdView mcnVideoAdView = this.f31138b;
            if (mcnVideoAdView != null) {
                return mcnVideoAdView.isShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mcnVideoAdView = this.f31138b) == null) {
            return;
        }
        mcnVideoAdView.reset();
    }

    public void e(c.a.y.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, aVar, viewGroup) == null) || (mcnVideoAdView = this.f31138b) == null) {
            return;
        }
        mcnVideoAdView.show(aVar, viewGroup);
    }

    public void f(c.a.y.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, viewGroup) == null) || (mcnVideoAdView = this.f31138b) == null) {
            return;
        }
        mcnVideoAdView.showMcnVideoAdWithOutAnim(aVar, viewGroup);
    }
}
