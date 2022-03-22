package c.a.p0.c0.f.h.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.c0.f.a.c;
import c.a.p0.c0.f.h.d.d;
import c.a.p0.c0.f.h.d.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.alasquare.subtablist.view.AlaSubListLiveDoubleViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c.a.p0.c0.f.h.b.b, AlaSubListLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public f j;
    public boolean k;
    public d l;
    public int m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.p0.c0.f.h.b.b.f13115c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.i = tbPageContext;
    }

    public final void Z(c.a.p0.c0.f.h.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || bVar == null) {
            return;
        }
        int i = this.n;
        if (i == 1) {
            if (bVar.a != null) {
                c.a.p0.c0.f.e.a c2 = c.a.p0.c0.f.e.a.c();
                c.a.p0.c0.f.e.a c3 = c.a.p0.c0.f.e.a.c();
                int i2 = this.m;
                c cVar = bVar.a;
                c2.a(c3.e(i2, "c12117", cVar.a, cVar.f12863b, cVar.getThreadData()));
            }
            if (bVar.f13116b != null) {
                c.a.p0.c0.f.e.a c4 = c.a.p0.c0.f.e.a.c();
                c.a.p0.c0.f.e.a c5 = c.a.p0.c0.f.e.a.c();
                int i3 = this.m;
                c cVar2 = bVar.f13116b;
                c4.a(c5.e(i3, "c12117", cVar2.a, cVar2.f12863b, cVar2.getThreadData()));
            }
        } else if (i == 2) {
            c cVar3 = bVar.a;
            if (cVar3 != null && cVar3.getThreadData() != null && bVar.a.getThreadData().getThreadAlaInfo() != null) {
                ThreadData threadData = bVar.a.getThreadData();
                TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData.getThreadAlaInfo().appId).param("locate_type", bVar.a.f12863b));
            }
            c cVar4 = bVar.f13116b;
            if (cVar4 == null || cVar4.getThreadData() == null || bVar.f13116b.getThreadData().getThreadAlaInfo() == null) {
                return;
            }
            ThreadData threadData2 = bVar.f13116b.getThreadData();
            TiebaStatic.log(new StatisticItem("c12115").param("obj_id", threadData2.getThreadAlaInfo().live_id).param(TiebaStatic.Params.OBJ_PARAM3, threadData2.getThreadAlaInfo().appId).param("locate_type", bVar.f13116b.f12863b));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public AlaSubListLiveDoubleViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.l = new d(this.i, this.k);
            return new AlaSubListLiveDoubleViewHolder(this.l);
        }
        return (AlaSubListLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.c0.f.h.b.b bVar, AlaSubListLiveDoubleViewHolder alaSubListLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, alaSubListLiveDoubleViewHolder})) == null) {
            Z(bVar);
            alaSubListLiveDoubleViewHolder.a.l(bVar);
            alaSubListLiveDoubleViewHolder.a.s(this.j);
            return alaSubListLiveDoubleViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.n = i;
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.m = i;
        }
    }

    public void e0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }
}
