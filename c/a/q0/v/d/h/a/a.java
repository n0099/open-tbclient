package c.a.q0.v.d.h.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
import c.a.q0.v.d.a.c;
import c.a.q0.v.d.h.d.f;
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
/* loaded from: classes3.dex */
public class a extends c.a.e.l.e.a<c.a.q0.v.d.h.b.a, AlaSubListGameDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public f n;
    public boolean o;
    public c.a.q0.v.d.h.d.a p;
    public int q;
    public int r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.q0.v.d.h.b.a.f25379g);
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

    public final void h0(c.a.q0.v.d.h.b.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (aVar.f25380e != null) {
                c.a.q0.v.d.e.a c2 = c.a.q0.v.d.e.a.c();
                c.a.q0.v.d.e.a c3 = c.a.q0.v.d.e.a.c();
                int i3 = this.q;
                c cVar = aVar.f25380e;
                c2.a(c3.e(i3, "c12117", cVar.f24988e, cVar.f24989f, cVar.getThreadData()));
            }
            if (aVar.f25381f != null) {
                c.a.q0.v.d.e.a c4 = c.a.q0.v.d.e.a.c();
                c.a.q0.v.d.e.a c5 = c.a.q0.v.d.e.a.c();
                int i4 = this.q;
                c cVar2 = aVar.f25381f;
                c4.a(c5.e(i4, "c12117", cVar2.f24988e, cVar2.f24989f, cVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            c cVar3 = aVar.f25380e;
            if (cVar3 != null && cVar3.getThreadData() != null && aVar.f25380e.getThreadData().j1() != null) {
                c2 threadData = aVar.f25380e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.j1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.j1().appId).param("locate_type", aVar.f25380e.f24989f));
            }
            c cVar4 = aVar.f25381f;
            if (cVar4 == null || cVar4.getThreadData() == null || aVar.f25381f.getThreadData().j1() == null) {
                return;
            }
            c2 threadData2 = aVar.f25381f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.j1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.j1().appId).param("locate_type", aVar.f25381f.f24989f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public AlaSubListGameDoubleViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new c.a.q0.v.d.h.d.a(this.m, this.o);
            return new AlaSubListGameDoubleViewHolder(this.p);
        }
        return (AlaSubListGameDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.v.d.h.b.a aVar, AlaSubListGameDoubleViewHolder alaSubListGameDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaSubListGameDoubleViewHolder})) == null) {
            h0(aVar);
            alaSubListGameDoubleViewHolder.mView.k(aVar);
            alaSubListGameDoubleViewHolder.mView.q(this.n);
            return alaSubListGameDoubleViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.r = i2;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
        }
    }

    public void m0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.n = fVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }
}
