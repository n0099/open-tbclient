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
import c.a.o0.r.r.a;
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
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;

    /* renamed from: b  reason: collision with root package name */
    public l0<T> f25010b;

    /* renamed from: c  reason: collision with root package name */
    public b0 f25011c;

    /* renamed from: d  reason: collision with root package name */
    public r0 f25012d;

    /* renamed from: e  reason: collision with root package name */
    public u f25013e;

    /* renamed from: f  reason: collision with root package name */
    public k0 f25014f;

    /* renamed from: g  reason: collision with root package name */
    public d0 f25015g;

    /* renamed from: h  reason: collision with root package name */
    public j f25016h;
    public f i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(l0<T> l0Var) {
        super(l0Var.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l0Var};
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
        this.f25010b = l0Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25010b.j() : (View) invokeV.objValue;
    }

    public l0<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25010b : (l0) invokeV.objValue;
    }

    public final TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.f25010b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || cVar == null || cVar.b() == null) {
            return;
        }
        this.f25010b.n(cVar);
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
                this.f25010b.j().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().getTid();
            }
            if (t.getThreadData() != null && t.getThreadData().getAuthor() != null) {
                t.getThreadData().getAuthor().getName_show();
            }
            boolean z = false;
            this.f25010b.j().setVisibility(0);
            b0 b0Var = this.f25011c;
            if (b0Var != null && b0Var.f3401e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.f25011c.m(t);
                    this.f25011c.a(t.getNegFeedBackData());
                    this.f25011c.f3401e.setVisibility(0);
                    z = true;
                } else {
                    b0 b0Var2 = this.f25011c;
                    if (b0Var2 != null && (nEGFeedBackView = b0Var2.f3401e) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.f25012d != null) {
                if (f(t.getThreadData())) {
                    e(this.f25012d);
                } else {
                    this.f25012d.l(t);
                    this.f25012d.a(t.getThreadData());
                }
            }
            k0 k0Var = this.f25014f;
            if (k0Var != null) {
                k0Var.n(z);
                this.f25014f.a(t.getThreadData());
            }
            u uVar = this.f25013e;
            if (uVar != null) {
                uVar.a(t.getThreadData());
            }
            d0 d0Var = this.f25015g;
            if (d0Var != null) {
                d0Var.n(t);
                this.f25015g.a(t.getThreadData());
            }
            j jVar = this.f25016h;
            if (jVar != null) {
                jVar.k(t, z);
                this.f25016h.a(t.getThreadData());
            }
            if (this.i != null) {
                if (f(t.getThreadData())) {
                    this.i.a(t.getThreadData());
                } else {
                    e(this.i);
                }
            }
            this.f25010b.l(t);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f25010b.n(this.f25014f);
        }
    }

    public void i(int i, m0 m0Var) {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, m0Var) == null) || (uVar = this.f25013e) == null) {
            return;
        }
        uVar.t(i, m0Var);
    }

    public void j(c.a.p0.h0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b0Var) == null) {
            this.f25010b.p(b0Var);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public f l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new f(d());
            }
            this.f25010b.b(this.i);
            return this.i;
        }
        return (f) invokeV.objValue;
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
                e(this.f25016h);
                return;
            }
            if (this.f25016h == null) {
                j jVar = new j(d(), UbsABTestHelper.showNewUI());
                this.f25016h = jVar;
                jVar.r(aVar);
            }
            this.f25016h.s(this.a);
            this.f25016h.p(z2);
            this.f25010b.b(this.f25016h);
        }
    }

    public u o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? p(true) : (u) invokeV.objValue;
    }

    public u p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.f25013e == null) {
                this.f25013e = new u(this.f25010b.getContext());
            }
            this.f25013e.s(this.a);
            this.f25013e.q(z);
            this.f25010b.b(this.f25013e);
            return this.f25013e;
        }
        return (u) invokeZ.objValue;
    }

    public b0 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.f25011c == null) {
                b0 b0Var = new b0(d(), z);
                this.f25011c = b0Var;
                b0Var.f3401e.setUniqueId(this.a);
            }
            this.f25010b.b(this.f25011c);
            return this.f25011c;
        }
        return (b0) invokeZ.objValue;
    }

    public void r(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                e(this.f25011c);
                return;
            }
            if (this.f25011c == null) {
                b0 b0Var = new b0(d(), align);
                this.f25011c = b0Var;
                b0Var.f3401e.setUniqueId(this.a);
                this.f25011c.u(bVar);
            }
            this.f25011c.l(align);
            this.f25010b.b(this.f25011c);
        }
    }

    public d0 s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.f25015g == null) {
                d0 d0Var = new d0(this.f25010b.j().getContext(), i);
                this.f25015g = d0Var;
                d0Var.q(this.a);
            }
            this.f25010b.b(this.f25015g);
            return this.f25015g;
        }
        return (d0) invokeI.objValue;
    }

    public k0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f25014f == null) {
                k0 k0Var = new k0(d());
                this.f25014f = k0Var;
                k0Var.o(this.a);
            }
            this.f25010b.b(this.f25014f);
            return this.f25014f;
        }
        return (k0) invokeV.objValue;
    }

    public void u(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                e(this.f25012d);
                return;
            }
            if (this.f25012d == null) {
                this.f25012d = new r0(d(), align);
            }
            this.f25012d.k(align);
            this.f25010b.b(this.f25012d);
        }
    }
}
