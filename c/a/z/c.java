package c.a.z;

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
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public McnVideoAdView f27696b;

    /* renamed from: c  reason: collision with root package name */
    public McnVideoAdView.c f27697c;

    /* loaded from: classes9.dex */
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
        public void a(c.a.z.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || StringUtils.isNull(aVar.f27690d)) {
                return;
            }
            b.b().c(aVar.f27690d);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void b(c.a.z.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13405");
            statisticItem.param("tid", aVar.f27691e);
            statisticItem.param("fid", aVar.f27692f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f27693g);
            TiebaStatic.log(statisticItem);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void c(c.a.z.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13404");
            statisticItem.param("tid", aVar.f27691e);
            statisticItem.param("fid", aVar.f27692f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f27693g);
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
        this.f27697c = new a(this);
        this.a = context;
        McnVideoAdView mcnVideoAdView = new McnVideoAdView(context);
        this.f27696b = mcnVideoAdView;
        mcnVideoAdView.setIMcnStatListener(this.f27697c);
    }

    public void a() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mcnVideoAdView = this.f27696b) == null) {
            return;
        }
        mcnVideoAdView.dismiss();
    }

    public void b() {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mcnVideoAdView = this.f27696b) == null) {
            return;
        }
        mcnVideoAdView.hideMcnVideoAdWithOutAnim();
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            McnVideoAdView mcnVideoAdView = this.f27696b;
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (mcnVideoAdView = this.f27696b) == null) {
            return;
        }
        mcnVideoAdView.reset();
    }

    public void e(c.a.z.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, aVar, viewGroup) == null) || (mcnVideoAdView = this.f27696b) == null) {
            return;
        }
        mcnVideoAdView.show(aVar, viewGroup);
    }

    public void f(c.a.z.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, aVar, viewGroup) == null) || (mcnVideoAdView = this.f27696b) == null) {
            return;
        }
        mcnVideoAdView.showMcnVideoAdWithOutAnim(aVar, viewGroup);
    }
}
