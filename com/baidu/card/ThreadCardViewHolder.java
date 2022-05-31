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
import com.repackage.dy;
import com.repackage.gx;
import com.repackage.nw5;
import com.repackage.nx;
import com.repackage.om4;
import com.repackage.ow;
import com.repackage.px;
import com.repackage.rw;
import com.repackage.vw;
import com.repackage.wx;
import com.repackage.xx;
import com.repackage.yx;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends om4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public xx<T> b;
    public nx c;
    public dy d;
    public gx e;
    public wx f;
    public px g;
    public vw h;
    public rw i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(xx<T> xxVar) {
        super(xxVar.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xxVar};
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
        this.b = xxVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.j() : (View) invokeV.objValue;
    }

    public xx<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (xx) invokeV.objValue;
    }

    public final TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void e(ow owVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, owVar) == null) || owVar == null || owVar.b() == null) {
            return;
        }
        this.b.n(owVar);
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
            nx nxVar = this.c;
            if (nxVar != null && nxVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    nx nxVar2 = this.c;
                    if (nxVar2 != null && (nEGFeedBackView = nxVar2.e) != null) {
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
            wx wxVar = this.f;
            if (wxVar != null) {
                wxVar.n(z);
                this.f.a(t.getThreadData());
            }
            gx gxVar = this.e;
            if (gxVar != null) {
                gxVar.a(t.getThreadData());
            }
            px pxVar = this.g;
            if (pxVar != null) {
                pxVar.n(t);
                this.g.a(t.getThreadData());
            }
            vw vwVar = this.h;
            if (vwVar != null) {
                vwVar.k(t, z);
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

    public void i(int i, yx yxVar) {
        gx gxVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, yxVar) == null) || (gxVar = this.e) == null) {
            return;
        }
        gxVar.t(i, yxVar);
    }

    public void j(nw5<T> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nw5Var) == null) {
            this.b.p(nw5Var);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public rw l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new rw(d());
            }
            this.b.c(this.i);
            return this.i;
        }
        return (rw) invokeV.objValue;
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
                vw vwVar = new vw(d(), UbsABTestHelper.showNewUI());
                this.h = vwVar;
                vwVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public gx o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? q(true) : (gx) invokeV.objValue;
    }

    public gx q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.e == null) {
                this.e = new gx(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (gx) invokeZ.objValue;
    }

    public nx r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.c == null) {
                nx nxVar = new nx(d(), z);
                this.c = nxVar;
                nxVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (nx) invokeZ.objValue;
    }

    public void s(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                e(this.c);
                return;
            }
            if (this.c == null) {
                nx nxVar = new nx(d(), align);
                this.c = nxVar;
                nxVar.e.setUniqueId(this.a);
                this.c.u(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public px t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g == null) {
                px pxVar = new px(this.b.j().getContext(), i);
                this.g = pxVar;
                pxVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (px) invokeI.objValue;
    }

    public wx u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f == null) {
                wx wxVar = new wx(d());
                this.f = wxVar;
                wxVar.o(this.a);
            }
            this.b.c(this.f);
            return this.f;
        }
        return (wx) invokeV.objValue;
    }

    public void v(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                e(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new dy(d(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
