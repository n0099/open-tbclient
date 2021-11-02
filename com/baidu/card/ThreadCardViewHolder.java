package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.l.b0;
import b.a.l.c;
import b.a.l.d0;
import b.a.l.f;
import b.a.l.j;
import b.a.l.k0;
import b.a.l.l0;
import b.a.l.m0;
import b.a.l.r0;
import b.a.l.u;
import b.a.q0.b.d;
import b.a.q0.s.q.a;
import b.a.q0.s.q.d2;
import b.a.r0.b0.c0;
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
/* loaded from: classes7.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f36632e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f36633f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f36634g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f36635h;

    /* renamed from: i  reason: collision with root package name */
    public u f36636i;
    public k0 j;
    public d0 k;
    public j l;
    public f m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(l0<T> l0Var) {
        super(l0Var.i());
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
        this.f36633f = l0Var;
    }

    public final TbPageContext a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((TbPageContextSupport) this.f36633f.i().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        this.f36633f.m(cVar);
    }

    public final boolean c(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var)) == null) ? (d2Var == null || d2Var.J() == null || !d2Var.b2 || !d.i() || d2Var.J().hadConcerned() || ThreadCardUtils.isSelf(d2Var)) ? false : true : invokeL.booleanValue;
    }

    public l0<T> getCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f36633f : (l0) invokeV.objValue;
    }

    public u getMultiDelDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f36636i : (u) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36633f.i() : (View) invokeV.objValue;
    }

    public void onBindDataToView(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            if (t == null) {
                this.f36633f.i().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().s1();
            }
            if (t.getThreadData() != null && t.getThreadData().J() != null) {
                t.getThreadData().J().getName_show();
            }
            boolean z = false;
            this.f36633f.i().setVisibility(0);
            b0 b0Var = this.f36634g;
            if (b0Var != null && b0Var.f3222i != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.f36634g.l(t);
                    this.f36634g.onBindDataToView(t.getNegFeedBackData());
                    this.f36634g.f3222i.setVisibility(0);
                    z = true;
                } else {
                    b0 b0Var2 = this.f36634g;
                    if (b0Var2 != null && (nEGFeedBackView = b0Var2.f3222i) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.f36635h != null) {
                if (c(t.getThreadData())) {
                    b(this.f36635h);
                } else {
                    this.f36635h.k(t);
                    this.f36635h.onBindDataToView(t.getThreadData());
                }
            }
            k0 k0Var = this.j;
            if (k0Var != null) {
                k0Var.m(z);
                this.j.onBindDataToView(t.getThreadData());
            }
            u uVar = this.f36636i;
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
                if (c(t.getThreadData())) {
                    this.m.onBindDataToView(t.getThreadData());
                } else {
                    b(this.m);
                }
            }
            this.f36633f.k(t);
        }
    }

    public void removeThemeAndStarDecorItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f36633f.m(this.j);
        }
    }

    public void setData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            this.f36633f.k(t);
        }
    }

    public void setDelDecorWeightSum(int i2, m0 m0Var) {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, m0Var) == null) || (uVar = this.f36636i) == null) {
            return;
        }
        uVar.s(i2, m0Var);
    }

    public void setOnSubCardClickListener(c0<T> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, c0Var) == null) {
            this.f36633f.o(c0Var);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f36632e = bdUniqueId;
        }
    }

    public f showConcernForumDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.m == null) {
                this.m = new f(a());
            }
            this.f36633f.b(this.m);
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
            if (this.f36634g == null) {
                b0 b0Var = new b0(a(), z);
                this.f36634g = b0Var;
                b0Var.f3222i.setUniqueId(this.f36632e);
            }
            this.f36633f.b(this.f36634g);
            return this.f36634g;
        }
        return (b0) invokeZ.objValue;
    }

    public void showNEGFeedBackViewIfNeed(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                b(this.f36634g);
                return;
            }
            if (this.f36634g == null) {
                b0 b0Var = new b0(a(), align);
                this.f36634g = b0Var;
                b0Var.f3222i.setUniqueId(this.f36632e);
                this.f36634g.t(bVar);
            }
            this.f36634g.k(align);
            this.f36633f.b(this.f36634g);
        }
    }

    public d0 showPrivateDecorItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            if (this.k == null) {
                d0 d0Var = new d0(this.f36633f.i().getContext(), i2);
                this.k = d0Var;
                d0Var.p(this.f36632e);
            }
            this.f36633f.b(this.k);
            return this.k;
        }
        return (d0) invokeI.objValue;
    }

    public k0 showThemeAndStarDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.j == null) {
                k0 k0Var = new k0(a());
                this.j = k0Var;
                k0Var.n(this.f36632e);
            }
            this.f36633f.b(this.j);
            return this.j;
        }
        return (k0) invokeV.objValue;
    }

    public void showUnfollowedDecorItemIfNeed(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048597, this, z, align) == null) {
            if (!z) {
                b(this.f36635h);
                return;
            }
            if (this.f36635h == null) {
                this.f36635h = new r0(a(), align);
            }
            this.f36635h.j(align);
            this.f36633f.b(this.f36635h);
        }
    }

    public void showFollowUserDecorItemIfNeed(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                b(this.l);
                return;
            }
            if (this.l == null) {
                j jVar = new j(a(), d.l0());
                this.l = jVar;
                jVar.q(aVar);
            }
            this.l.r(this.f36632e);
            this.l.o(z2);
            this.f36633f.b(this.l);
        }
    }

    public u showMultiDelDecorItem(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.f36636i == null) {
                this.f36636i = new u(this.f36633f.getContext());
            }
            this.f36636i.r(this.f36632e);
            this.f36636i.p(z);
            this.f36633f.b(this.f36636i);
            return this.f36636i;
        }
        return (u) invokeZ.objValue;
    }
}
