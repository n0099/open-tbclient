package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.l.b0;
import c.a.l.c;
import c.a.l.d0;
import c.a.l.f;
import c.a.l.j;
import c.a.l.k0;
import c.a.l.l0;
import c.a.l.m0;
import c.a.l.r0;
import c.a.l.u;
import c.a.s0.b.d;
import c.a.s0.s.q.a;
import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f33110e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f33111f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f33112g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f33113h;

    /* renamed from: i  reason: collision with root package name */
    public u f33114i;

    /* renamed from: j  reason: collision with root package name */
    public k0 f33115j;
    public d0 k;
    public j l;
    public f m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(l0<T> l0Var) {
        super(l0Var.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33111f = l0Var;
    }

    public final TbPageContext b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((TbPageContextSupport) this.f33111f.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void c(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        this.f33111f.n(cVar);
    }

    public final boolean d(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e2Var)) == null) ? (e2Var == null || e2Var.J() == null || !e2Var.b2 || !d.i() || e2Var.J().hadConcerned() || ThreadCardUtils.isSelf(e2Var)) ? false : true : invokeL.booleanValue;
    }

    public l0<T> getCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33111f : (l0) invokeV.objValue;
    }

    public u getMultiDelDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33114i : (u) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33111f.j() : (View) invokeV.objValue;
    }

    public void onBindDataToView(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            if (t == null) {
                this.f33111f.j().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().w1();
            }
            if (t.getThreadData() != null && t.getThreadData().J() != null) {
                t.getThreadData().J().getName_show();
            }
            boolean z = false;
            this.f33111f.j().setVisibility(0);
            b0 b0Var = this.f33112g;
            if (b0Var != null && b0Var.f4292i != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.f33112g.l(t);
                    this.f33112g.onBindDataToView(t.getNegFeedBackData());
                    this.f33112g.f4292i.setVisibility(0);
                    z = true;
                } else {
                    b0 b0Var2 = this.f33112g;
                    if (b0Var2 != null && (nEGFeedBackView = b0Var2.f4292i) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.f33113h != null) {
                if (d(t.getThreadData())) {
                    c(this.f33113h);
                } else {
                    this.f33113h.k(t);
                    this.f33113h.onBindDataToView(t.getThreadData());
                }
            }
            k0 k0Var = this.f33115j;
            if (k0Var != null) {
                k0Var.m(z);
                this.f33115j.onBindDataToView(t.getThreadData());
            }
            u uVar = this.f33114i;
            if (uVar != null) {
                uVar.onBindDataToView(t.getThreadData());
            }
            d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.m(t);
                this.k.onBindDataToView(t.getThreadData());
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.j(t, z);
                this.l.onBindDataToView(t.getThreadData());
            }
            if (this.m != null) {
                if (d(t.getThreadData())) {
                    this.m.onBindDataToView(t.getThreadData());
                } else {
                    c(this.m);
                }
            }
            this.f33111f.l(t);
        }
    }

    public void removeThemeAndStarDecorItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f33111f.n(this.f33115j);
        }
    }

    public void setData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            this.f33111f.l(t);
        }
    }

    public void setDelDecorWeightSum(int i2, m0 m0Var) {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, m0Var) == null) || (uVar = this.f33114i) == null) {
            return;
        }
        uVar.s(i2, m0Var);
    }

    public void setOnSubCardClickListener(c.a.t0.g0.d0<T> d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, d0Var) == null) {
            this.f33111f.p(d0Var);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f33110e = bdUniqueId;
        }
    }

    public f showConcernForumDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.m == null) {
                this.m = new f(b());
            }
            this.f33111f.b(this.m);
            return this.m;
        }
        return (f) invokeV.objValue;
    }

    public void showFollowUserDecorItemIfNeed(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, aVar) == null) {
            showFollowUserDecorItemIfNeed(z, aVar, false);
        }
    }

    public u showMultiDelDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? showMultiDelDecorItem(true) : (u) invokeV.objValue;
    }

    public b0 showNEGFeedBackView(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            if (this.f33112g == null) {
                b0 b0Var = new b0(b(), z);
                this.f33112g = b0Var;
                b0Var.f4292i.setUniqueId(this.f33110e);
            }
            this.f33111f.b(this.f33112g);
            return this.f33112g;
        }
        return (b0) invokeZ.objValue;
    }

    public void showNEGFeedBackViewIfNeed(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                c(this.f33112g);
                return;
            }
            if (this.f33112g == null) {
                b0 b0Var = new b0(b(), align);
                this.f33112g = b0Var;
                b0Var.f4292i.setUniqueId(this.f33110e);
                this.f33112g.t(bVar);
            }
            this.f33112g.k(align);
            this.f33111f.b(this.f33112g);
        }
    }

    public d0 showPrivateDecorItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (this.k == null) {
                d0 d0Var = new d0(this.f33111f.j().getContext(), i2);
                this.k = d0Var;
                d0Var.p(this.f33110e);
            }
            this.f33111f.b(this.k);
            return this.k;
        }
        return (d0) invokeI.objValue;
    }

    public k0 showThemeAndStarDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f33115j == null) {
                k0 k0Var = new k0(b());
                this.f33115j = k0Var;
                k0Var.n(this.f33110e);
            }
            this.f33111f.b(this.f33115j);
            return this.f33115j;
        }
        return (k0) invokeV.objValue;
    }

    public void showUnfollowedDecorItemIfNeed(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048597, this, z, align) == null) {
            if (!z) {
                c(this.f33113h);
                return;
            }
            if (this.f33113h == null) {
                this.f33113h = new r0(b(), align);
            }
            this.f33113h.j(align);
            this.f33111f.b(this.f33113h);
        }
    }

    public void showFollowUserDecorItemIfNeed(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.l);
                return;
            }
            if (this.l == null) {
                j jVar = new j(b(), d.A0());
                this.l = jVar;
                jVar.q(aVar);
            }
            this.l.r(this.f33110e);
            this.l.o(z2);
            this.f33111f.b(this.l);
        }
    }

    public u showMultiDelDecorItem(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.f33114i == null) {
                this.f33114i = new u(this.f33111f.getContext());
            }
            this.f33114i.r(this.f33110e);
            this.f33114i.p(z);
            this.f33111f.b(this.f33114i);
            return this.f33114i;
        }
        return (u) invokeZ.objValue;
    }
}
