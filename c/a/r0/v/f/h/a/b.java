package c.a.r0.v.f.h.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import c.a.r0.v.f.a.c;
import c.a.r0.v.f.h.d.d;
import c.a.r0.v.f.h.d.f;
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
/* loaded from: classes4.dex */
public class b extends c.a.e.l.e.a<c.a.r0.v.f.h.b.b, AlaSubListLiveDoubleViewHolder> {
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
        super(tbPageContext.getPageActivity(), c.a.r0.v.f.h.b.b.f25883g);
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

    public final void h0(c.a.r0.v.f.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 1) {
            if (bVar.f25884e != null) {
                c.a.r0.v.f.e.a c2 = c.a.r0.v.f.e.a.c();
                c.a.r0.v.f.e.a c3 = c.a.r0.v.f.e.a.c();
                int i3 = this.q;
                c cVar = bVar.f25884e;
                c2.a(c3.e(i3, "c12117", cVar.f25489e, cVar.f25490f, cVar.getThreadData()));
            }
            if (bVar.f25885f != null) {
                c.a.r0.v.f.e.a c4 = c.a.r0.v.f.e.a.c();
                c.a.r0.v.f.e.a c5 = c.a.r0.v.f.e.a.c();
                int i4 = this.q;
                c cVar2 = bVar.f25885f;
                c4.a(c5.e(i4, "c12117", cVar2.f25489e, cVar2.f25490f, cVar2.getThreadData()));
            }
        } else if (i2 == 2) {
            c cVar3 = bVar.f25884e;
            if (cVar3 != null && cVar3.getThreadData() != null && bVar.f25884e.getThreadData().l1() != null) {
                d2 threadData = bVar.f25884e.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.l1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.l1().appId).param("locate_type", bVar.f25884e.f25490f));
            }
            c cVar4 = bVar.f25885f;
            if (cVar4 == null || cVar4.getThreadData() == null || bVar.f25885f.getThreadData().l1() == null) {
                return;
            }
            d2 threadData2 = bVar.f25885f.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.l1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.l1().appId).param("locate_type", bVar.f25885f.f25490f));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: i0 */
    public AlaSubListLiveDoubleViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.p = new d(this.m, this.o);
            return new AlaSubListLiveDoubleViewHolder(this.p);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.v.f.h.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, alaSubListLiveDoubleViewHolder})) == null) {
            h0(bVar);
            alaSubListLiveDoubleViewHolder.mView.k(bVar);
            alaSubListLiveDoubleViewHolder.mView.q(this.n);
            return alaSubListLiveDoubleViewHolder.getView();
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
