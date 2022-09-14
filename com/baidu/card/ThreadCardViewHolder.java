package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.by;
import com.baidu.tieba.ix;
import com.baidu.tieba.iy;
import com.baidu.tieba.ky;
import com.baidu.tieba.lq4;
import com.baidu.tieba.lx;
import com.baidu.tieba.px;
import com.baidu.tieba.ry;
import com.baidu.tieba.sy;
import com.baidu.tieba.ty;
import com.baidu.tieba.v16;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends lq4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public sy<T> b;
    public iy c;
    public yy d;
    public by e;
    public ry f;
    public ky g;
    public px h;
    public lx i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(sy<T> syVar) {
        super(syVar.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {syVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = syVar;
    }

    public sy<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (sy) invokeV.objValue;
    }

    public final TbPageContext b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((TbPageContextSupport) this.b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void c(ix ixVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ixVar) == null) || ixVar == null || ixVar.b() == null) {
            return;
        }
        this.b.n(ixVar);
    }

    public final boolean d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) ? false : true : invokeL.booleanValue;
    }

    public void e(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            if (t == null) {
                this.b.j().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().getTid();
            }
            if (t.getThreadData() != null && t.getThreadData().getAuthor() != null) {
                t.getThreadData().getAuthor().getName_show();
            }
            boolean z = false;
            this.b.j().setVisibility(0);
            iy iyVar = this.c;
            if (iyVar != null && iyVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    iy iyVar2 = this.c;
                    if (iyVar2 != null && (nEGFeedBackView = iyVar2.e) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.d != null) {
                if (d(t.getThreadData())) {
                    c(this.d);
                } else {
                    this.d.l(t);
                    this.d.a(t.getThreadData());
                }
            }
            ry ryVar = this.f;
            if (ryVar != null) {
                ryVar.n(z);
                this.f.a(t.getThreadData());
            }
            by byVar = this.e;
            if (byVar != null) {
                byVar.a(t.getThreadData());
            }
            ky kyVar = this.g;
            if (kyVar != null) {
                kyVar.n(t);
                this.g.a(t.getThreadData());
            }
            px pxVar = this.h;
            if (pxVar != null) {
                pxVar.k(t, z);
                this.h.a(t.getThreadData());
            }
            if (this.i != null) {
                if (d(t.getThreadData())) {
                    this.i.a(t.getThreadData());
                } else {
                    c(this.i);
                }
            }
            this.b.l(t);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.n(this.f);
        }
    }

    public void g(int i, ty tyVar) {
        by byVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, tyVar) == null) || (byVar = this.e) == null) {
            return;
        }
        byVar.t(i, tyVar);
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b.j() : (View) invokeV.objValue;
    }

    public void h(v16<T> v16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v16Var) == null) {
            this.b.p(v16Var);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public lx j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new lx(b());
            }
            this.b.c(this.i);
            return this.i;
        }
        return (lx) invokeV.objValue;
    }

    public void k(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, aVar) == null) {
            l(z, aVar, false);
        }
    }

    public void l(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.h);
                return;
            }
            if (this.h == null) {
                px pxVar = new px(b(), UbsABTestHelper.showNewUI());
                this.h = pxVar;
                pxVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public by m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? n(true) : (by) invokeV.objValue;
    }

    public by n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.e == null) {
                this.e = new by(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (by) invokeZ.objValue;
    }

    public iy o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.c == null) {
                iy iyVar = new iy(b(), z);
                this.c = iyVar;
                iyVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (iy) invokeZ.objValue;
    }

    public void p(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                c(this.c);
                return;
            }
            if (this.c == null) {
                iy iyVar = new iy(b(), align);
                this.c = iyVar;
                iyVar.e.setUniqueId(this.a);
                this.c.u(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public ky q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g == null) {
                ky kyVar = new ky(this.b.j().getContext(), i);
                this.g = kyVar;
                kyVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (ky) invokeI.objValue;
    }

    public ry r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f == null) {
                ry ryVar = new ry(b());
                this.f = ryVar;
                ryVar.o(this.a);
            }
            this.b.c(this.f);
            return this.f;
        }
        return (ry) invokeV.objValue;
    }

    public void s(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                c(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new yy(b(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
