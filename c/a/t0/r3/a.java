package c.a.t0.r3;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import c.a.s0.q0.d;
import c.a.t0.r3.b.b;
import c.a.t0.r3.b.e;
import c.a.t0.r3.b.f;
import c.a.t0.r3.b.g;
import c.a.t0.r3.d.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.t0.r3.b.a f21852b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.t0.r3.b.a f21853c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.r3.b.a f21854d;

    /* renamed from: e  reason: collision with root package name */
    public long f21855e;

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
        this.f21855e = -3L;
    }

    public d a(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            if (dVar != null) {
                dVar.r(this.a.getAdSource());
            }
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public void b(@NonNull BaseFragment baseFragment, @NonNull ViewGroup viewGroup, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{baseFragment, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || baseFragment.getActivity() == null) {
            return;
        }
        this.f21855e = j2;
        c(baseFragment, viewGroup, i2);
        d();
    }

    public final void c(@NonNull BaseFragment baseFragment, @NonNull ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, baseFragment, viewGroup, i2) == null) {
            f fVar = new f(baseFragment, viewGroup, i2, this.f21855e);
            this.a = fVar;
            g gVar = new g(fVar);
            this.f21852b = new c.a.t0.r3.g.b(this.a, gVar);
            this.f21853c = new c(this.a, gVar);
            this.f21854d = new c.a.t0.r3.e.b(this.a, gVar);
            viewGroup.setBackgroundResource(R.drawable.pic_splash_logo);
            c.a.t0.v3.c.g().i(this.a.getUniqueId());
            baseFragment.registerListener(new e(this.a, gVar));
            baseFragment.registerListener(new c.a.t0.r3.d.a(this.f21854d));
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", TbadkCoreApplication.getInst().isNeedBearAd(c.a.s0.s.h0.b.k().l("splash_ad_strategy_key", 0)) ? 1 : 0).param("pid", c.a.s0.s.h0.b.k().l("splash_origin_ad_strategy_key", 1) != 0 ? 1 : 0).param("obj_param1", this.a.i() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.f21855e).eventStat();
            if (this.f21852b.b() || this.f21853c.b()) {
                return;
            }
            this.f21854d.b();
        }
    }

    public void e(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) {
            c.a.t0.r3.b.a aVar = this.f21853c;
            if (aVar != null) {
                aVar.onConfigurationChanged(configuration);
            }
            c.a.t0.r3.b.a aVar2 = this.f21854d;
            if (aVar2 != null) {
                aVar2.onConfigurationChanged(configuration);
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.t0.r3.b.a aVar = this.f21852b;
            if (aVar != null) {
                aVar.onPause();
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(false);
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.t0.r3.b.a aVar = this.f21852b;
            if (aVar != null) {
                aVar.onResume();
            }
            b bVar = this.a;
            if (bVar != null) {
                bVar.b(true);
                if (this.a.g()) {
                    c.a.t0.r3.c.a.g(this.a).b();
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.t0.r3.b.a aVar = this.f21852b;
            if (aVar != null) {
                aVar.a();
            }
            c.a.t0.r3.b.a aVar2 = this.f21853c;
            if (aVar2 != null) {
                aVar2.a();
            }
            c.a.t0.r3.b.a aVar3 = this.f21854d;
            if (aVar3 != null) {
                aVar3.a();
            }
            MessageManager.getInstance().runTask(2921555, (Class) null);
        }
    }
}
