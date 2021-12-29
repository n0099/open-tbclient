package c.a.t0.a0.f.h.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.q.d2;
import c.a.t0.a0.f.a.e;
import c.a.t0.a0.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListGameDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.d.n.e.a<c.a.t0.a0.f.h.b.a, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public c.a.t0.a0.f.h.d.a p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.t0.a0.f.h.b.a.f15025g);
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

    public final void Z(c.a.t0.a0.f.h.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f15026e != null) {
                c.a.t0.a0.f.e.a c2 = c.a.t0.a0.f.e.a.c();
                c.a.t0.a0.f.e.a c3 = c.a.t0.a0.f.e.a.c();
                int i3 = this.q;
                e eVar = aVar.f15026e;
                c2.a(c3.e(i3, "c12117", eVar.f14690e, eVar.f14691f, eVar.getThreadData()));
            }
            if (aVar.f15027f != null) {
                c.a.t0.a0.f.e.a c4 = c.a.t0.a0.f.e.a.c();
                c.a.t0.a0.f.e.a c5 = c.a.t0.a0.f.e.a.c();
                int i4 = this.q;
                e eVar2 = aVar.f15027f;
                c4.a(c5.e(i4, "c12117", eVar2.f14690e, eVar2.f14691f, eVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            e eVar3 = aVar.f15026e;
            if (eVar3 != null && eVar3.getThreadData() != null && aVar.f15026e.getThreadData().o1() != null) {
                d2 threadData = aVar.f15026e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.o1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.o1().appId).param("locate_type", aVar.f15026e.f14691f));
            }
            e eVar4 = aVar.f15027f;
            if (eVar4 == null || eVar4.getThreadData() == null || aVar.f15027f.getThreadData().o1() == null) {
                return;
            }
            d2 threadData2 = aVar.f15027f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.o1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.o1().appId).param("locate_type", aVar.f15027f.f14691f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public AlaSubListGameDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new c.a.t0.a0.f.h.d.a(this.m, this.o);
            return new AlaSubListGameDoubleViewHolder(this.p);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.a0.f.h.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaSubListGameDoubleViewHolder})) == null) {
            Z(aVar);
            alaSubListGameDoubleViewHolder.mView.k(aVar);
            alaSubListGameDoubleViewHolder.mView.q(this.n);
            return alaSubListGameDoubleViewHolder.getView();
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
