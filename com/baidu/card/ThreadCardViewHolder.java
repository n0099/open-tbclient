package com.baidu.card;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
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
import d.a.j.b0;
import d.a.j.c;
import d.a.j.d0;
import d.a.j.f;
import d.a.j.j;
import d.a.j.k0;
import d.a.j.l0;
import d.a.j.m0;
import d.a.j.r0;
import d.a.j.u;
import d.a.o0.b.d;
import d.a.o0.r.q.a;
import d.a.o0.r.q.b2;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f4374e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f4375f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f4376g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f4377h;

    /* renamed from: i  reason: collision with root package name */
    public u f4378i;
    public k0 j;
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
        this.f4375f = l0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4375f.j() : (View) invokeV.objValue;
    }

    public l0<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f4375f : (l0) invokeV.objValue;
    }

    public final TbPageContext c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.f4375f.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void d(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || cVar == null || cVar.b() == null) {
            return;
        }
        this.f4375f.n(cVar);
    }

    public final boolean e(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) ? (b2Var == null || b2Var.H() == null || !b2Var.X1 || !d.h() || b2Var.H().hadConcerned() || ThreadCardUtils.isSelf(b2Var)) ? false : true : invokeL.booleanValue;
    }

    public void f(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            if (t == null) {
                this.f4375f.j().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().n1();
            }
            if (t.getThreadData() != null && t.getThreadData().H() != null) {
                t.getThreadData().H().getName_show();
            }
            boolean z = false;
            this.f4375f.j().setVisibility(0);
            b0 b0Var = this.f4376g;
            if (b0Var != null && b0Var.f42633i != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.f4376g.m(t);
                    this.f4376g.a(t.getNegFeedBackData());
                    this.f4376g.f42633i.setVisibility(0);
                    z = true;
                } else {
                    b0 b0Var2 = this.f4376g;
                    if (b0Var2 != null && (nEGFeedBackView = b0Var2.f42633i) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.f4377h != null) {
                if (e(t.getThreadData())) {
                    d(this.f4377h);
                } else {
                    this.f4377h.l(t);
                    this.f4377h.a(t.getThreadData());
                }
            }
            k0 k0Var = this.j;
            if (k0Var != null) {
                k0Var.n(z);
                this.j.a(t.getThreadData());
            }
            u uVar = this.f4378i;
            if (uVar != null) {
                uVar.a(t.getThreadData());
            }
            d0 d0Var = this.k;
            if (d0Var != null) {
                d0Var.n(t);
                this.k.a(t.getThreadData());
            }
            j jVar = this.l;
            if (jVar != null) {
                jVar.k(t, z);
                this.l.a(t.getThreadData());
            }
            if (this.m != null) {
                if (e(t.getThreadData())) {
                    this.m.a(t.getThreadData());
                } else {
                    d(this.m);
                }
            }
            this.f4375f.l(t);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f4375f.n(this.j);
        }
    }

    public void h(int i2, m0 m0Var) {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i2, m0Var) == null) || (uVar = this.f4378i) == null) {
            return;
        }
        uVar.t(i2, m0Var);
    }

    public void i(d.a.p0.a0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b0Var) == null) {
            this.f4375f.p(b0Var);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.f4374e = bdUniqueId;
        }
    }

    public f k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.m == null) {
                this.m = new f(c());
            }
            this.f4375f.b(this.m);
            return this.m;
        }
        return (f) invokeV.objValue;
    }

    public void l(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, aVar) == null) {
            if (!z) {
                d(this.l);
                return;
            }
            if (this.l == null) {
                j jVar = new j(c(), d.f0());
                this.l = jVar;
                jVar.q(aVar);
            }
            this.l.r(this.f4374e);
            this.f4375f.b(this.l);
        }
    }

    public u m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? n(true) : (u) invokeV.objValue;
    }

    public u n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            if (this.f4378i == null) {
                this.f4378i = new u(this.f4375f.g());
            }
            this.f4378i.s(this.f4374e);
            this.f4378i.q(z);
            this.f4375f.b(this.f4378i);
            return this.f4378i;
        }
        return (u) invokeZ.objValue;
    }

    public b0 o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.f4376g == null) {
                b0 b0Var = new b0(c(), z);
                this.f4376g = b0Var;
                b0Var.f42633i.setUniqueId(this.f4374e);
            }
            this.f4375f.b(this.f4376g);
            return this.f4376g;
        }
        return (b0) invokeZ.objValue;
    }

    public void p(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                d(this.f4376g);
                return;
            }
            if (this.f4376g == null) {
                b0 b0Var = new b0(c(), align);
                this.f4376g = b0Var;
                b0Var.f42633i.setUniqueId(this.f4374e);
                this.f4376g.u(bVar);
            }
            this.f4376g.l(align);
            this.f4375f.b(this.f4376g);
        }
    }

    public d0 q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.k == null) {
                d0 d0Var = new d0(this.f4375f.j().getContext(), i2);
                this.k = d0Var;
                d0Var.q(this.f4374e);
            }
            this.f4375f.b(this.k);
            return this.k;
        }
        return (d0) invokeI.objValue;
    }

    public k0 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.j == null) {
                k0 k0Var = new k0(c());
                this.j = k0Var;
                k0Var.o(this.f4374e);
            }
            this.f4375f.b(this.j);
            return this.j;
        }
        return (k0) invokeV.objValue;
    }

    public void s(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048594, this, z, align) == null) {
            if (!z) {
                d(this.f4377h);
                return;
            }
            if (this.f4377h == null) {
                this.f4377h = new r0(c(), align);
            }
            this.f4377h.k(align);
            this.f4375f.b(this.f4377h);
        }
    }
}
