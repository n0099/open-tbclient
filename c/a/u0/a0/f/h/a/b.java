package c.a.u0.a0.f.h.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.r.e2;
import c.a.u0.a0.f.a.e;
import c.a.u0.a0.f.h.d.d;
import c.a.u0.a0.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b extends c.a.d.o.e.a<c.a.u0.a0.f.h.b.b, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public d p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.u0.a0.f.h.b.b.f15079g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.m = tbPageContext;
    }

    public final void Z(c.a.u0.a0.f.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (bVar.f15080e != null) {
                c.a.u0.a0.f.e.a c2 = c.a.u0.a0.f.e.a.c();
                c.a.u0.a0.f.e.a c3 = c.a.u0.a0.f.e.a.c();
                int i3 = this.q;
                e eVar = bVar.f15080e;
                c2.a(c3.e(i3, "c12117", eVar.f14755e, eVar.f14756f, eVar.getThreadData()));
            }
            if (bVar.f15081f != null) {
                c.a.u0.a0.f.e.a c4 = c.a.u0.a0.f.e.a.c();
                c.a.u0.a0.f.e.a c5 = c.a.u0.a0.f.e.a.c();
                int i4 = this.q;
                e eVar2 = bVar.f15081f;
                c4.a(c5.e(i4, "c12117", eVar2.f14755e, eVar2.f14756f, eVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            e eVar3 = bVar.f15080e;
            if (eVar3 != null && eVar3.getThreadData() != null && bVar.f15080e.getThreadData().p1() != null) {
                e2 threadData = bVar.f15080e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.p1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.p1().appId).param("locate_type", bVar.f15080e.f14756f));
            }
            e eVar4 = bVar.f15081f;
            if (eVar4 == null || eVar4.getThreadData() == null || bVar.f15081f.getThreadData().p1() == null) {
                return;
            }
            e2 threadData2 = bVar.f15081f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.p1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.p1().appId).param("locate_type", bVar.f15081f.f14756f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public AlaSubListLiveDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new d(this.m, this.o);
            return new AlaSubListLiveDoubleViewHolder(this.p);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.u0.a0.f.h.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, alaSubListLiveDoubleViewHolder})) == null) {
            Z(bVar);
            alaSubListLiveDoubleViewHolder.mView.k(bVar);
            alaSubListLiveDoubleViewHolder.mView.q(this.n);
            return alaSubListLiveDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.r = i2;
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
        }
    }

    public void e0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }
}
