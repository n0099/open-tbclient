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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by;
import com.repackage.cy;
import com.repackage.dy;
import com.repackage.iy;
import com.repackage.jy5;
import com.repackage.lx;
import com.repackage.nn4;
import com.repackage.sw;
import com.repackage.sx;
import com.repackage.ux;
import com.repackage.vw;
import com.repackage.zw;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends nn4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public cy<T> b;
    public sx c;
    public iy d;
    public lx e;
    public by f;
    public ux g;
    public zw h;
    public vw i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(cy<T> cyVar) {
        super(cyVar.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cyVar};
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
        this.b = cyVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.j() : (View) invokeV.objValue;
    }

    public cy<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (cy) invokeV.objValue;
    }

    public final TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void e(sw swVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, swVar) == null) || swVar == null || swVar.b() == null) {
            return;
        }
        this.b.n(swVar);
    }

    public final boolean f(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) ? (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) ? false : true : invokeL.booleanValue;
    }

    public void g(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
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
            sx sxVar = this.c;
            if (sxVar != null && sxVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    sx sxVar2 = this.c;
                    if (sxVar2 != null && (nEGFeedBackView = sxVar2.e) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.d != null) {
                if (f(t.getThreadData())) {
                    e(this.d);
                } else {
                    this.d.l(t);
                    this.d.a(t.getThreadData());
                }
            }
            by byVar = this.f;
            if (byVar != null) {
                byVar.n(z);
                this.f.a(t.getThreadData());
            }
            lx lxVar = this.e;
            if (lxVar != null) {
                lxVar.a(t.getThreadData());
            }
            ux uxVar = this.g;
            if (uxVar != null) {
                uxVar.n(t);
                this.g.a(t.getThreadData());
            }
            zw zwVar = this.h;
            if (zwVar != null) {
                zwVar.k(t, z);
                this.h.a(t.getThreadData());
            }
            if (this.i != null) {
                if (f(t.getThreadData())) {
                    this.i.a(t.getThreadData());
                } else {
                    e(this.i);
                }
            }
            this.b.l(t);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.n(this.f);
        }
    }

    public void i(int i, dy dyVar) {
        lx lxVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, dyVar) == null) || (lxVar = this.e) == null) {
            return;
        }
        lxVar.t(i, dyVar);
    }

    public void j(jy5<T> jy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jy5Var) == null) {
            this.b.p(jy5Var);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public vw l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new vw(d());
            }
            this.b.c(this.i);
            return this.i;
        }
        return (vw) invokeV.objValue;
    }

    public void m(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, aVar) == null) {
            n(z, aVar, false);
        }
    }

    public void n(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                e(this.h);
                return;
            }
            if (this.h == null) {
                zw zwVar = new zw(d(), UbsABTestHelper.showNewUI());
                this.h = zwVar;
                zwVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public lx o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? p(true) : (lx) invokeV.objValue;
    }

    public lx p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.e == null) {
                this.e = new lx(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (lx) invokeZ.objValue;
    }

    public sx q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.c == null) {
                sx sxVar = new sx(d(), z);
                this.c = sxVar;
                sxVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (sx) invokeZ.objValue;
    }

    public void r(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                e(this.c);
                return;
            }
            if (this.c == null) {
                sx sxVar = new sx(d(), align);
                this.c = sxVar;
                sxVar.e.setUniqueId(this.a);
                this.c.u(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public ux s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g == null) {
                ux uxVar = new ux(this.b.j().getContext(), i);
                this.g = uxVar;
                uxVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (ux) invokeI.objValue;
    }

    public by t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f == null) {
                by byVar = new by(d());
                this.f = byVar;
                byVar.o(this.a);
            }
            this.b.c(this.f);
            return this.f;
        }
        return (by) invokeV.objValue;
    }

    public void u(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                e(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new iy(d(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
