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
import c.a.p0.b.d;
import c.a.p0.s.q.a;
import c.a.p0.s.q.c2;
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
/* loaded from: classes5.dex */
public class ThreadCardViewHolder<T extends a> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f38471e;

    /* renamed from: f  reason: collision with root package name */
    public l0<T> f38472f;

    /* renamed from: g  reason: collision with root package name */
    public b0 f38473g;

    /* renamed from: h  reason: collision with root package name */
    public r0 f38474h;

    /* renamed from: i  reason: collision with root package name */
    public u f38475i;

    /* renamed from: j  reason: collision with root package name */
    public k0 f38476j;
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
        this.f38472f = l0Var;
    }

    public final TbPageContext a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((TbPageContextSupport) this.f38472f.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null || cVar.a() == null) {
            return;
        }
        this.f38472f.n(cVar);
    }

    public final boolean c(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var)) == null) ? (c2Var == null || c2Var.J() == null || !c2Var.Y1 || !d.i() || c2Var.J().hadConcerned() || ThreadCardUtils.isSelf(c2Var)) ? false : true : invokeL.booleanValue;
    }

    public l0<T> getCardView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38472f : (l0) invokeV.objValue;
    }

    public u getMultiDelDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38475i : (u) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38472f.j() : (View) invokeV.objValue;
    }

    public void onBindDataToView(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            if (t == null) {
                this.f38472f.j().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().q1();
            }
            if (t.getThreadData() != null && t.getThreadData().J() != null) {
                t.getThreadData().J().getName_show();
            }
            boolean z = false;
            this.f38472f.j().setVisibility(0);
            b0 b0Var = this.f38473g;
            if (b0Var != null && b0Var.f3796i != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.f38473g.l(t);
                    this.f38473g.onBindDataToView(t.getNegFeedBackData());
                    this.f38473g.f3796i.setVisibility(0);
                    z = true;
                } else {
                    b0 b0Var2 = this.f38473g;
                    if (b0Var2 != null && (nEGFeedBackView = b0Var2.f3796i) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.f38474h != null) {
                if (c(t.getThreadData())) {
                    b(this.f38474h);
                } else {
                    this.f38474h.k(t);
                    this.f38474h.onBindDataToView(t.getThreadData());
                }
            }
            k0 k0Var = this.f38476j;
            if (k0Var != null) {
                k0Var.m(z);
                this.f38476j.onBindDataToView(t.getThreadData());
            }
            u uVar = this.f38475i;
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
            this.f38472f.l(t);
        }
    }

    public void removeThemeAndStarDecorItem() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f38472f.n(this.f38476j);
        }
    }

    public void setData(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            this.f38472f.l(t);
        }
    }

    public void setDelDecorWeightSum(int i2, m0 m0Var) {
        u uVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048585, this, i2, m0Var) == null) || (uVar = this.f38475i) == null) {
            return;
        }
        uVar.s(i2, m0Var);
    }

    public void setOnSubCardClickListener(c.a.q0.a0.b0<T> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, b0Var) == null) {
            this.f38472f.p(b0Var);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bdUniqueId) == null) {
            this.f38471e = bdUniqueId;
        }
    }

    public f showConcernForumDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.m == null) {
                this.m = new f(a());
            }
            this.f38472f.b(this.m);
            return this.m;
        }
        return (f) invokeV.objValue;
    }

    public void showFollowUserDecorItemIfNeed(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048589, this, z, aVar) == null) {
            if (!z) {
                b(this.l);
                return;
            }
            if (this.l == null) {
                j jVar = new j(a(), d.w0());
                this.l = jVar;
                jVar.p(aVar);
            }
            this.l.q(this.f38471e);
            this.f38472f.b(this.l);
        }
    }

    public u showMultiDelDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? showMultiDelDecorItem(true) : (u) invokeV.objValue;
    }

    public b0 showNEGFeedBackView(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.f38473g == null) {
                b0 b0Var = new b0(a(), z);
                this.f38473g = b0Var;
                b0Var.f3796i.setUniqueId(this.f38471e);
            }
            this.f38472f.b(this.f38473g);
            return this.f38473g;
        }
        return (b0) invokeZ.objValue;
    }

    public void showNEGFeedBackViewIfNeed(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                b(this.f38473g);
                return;
            }
            if (this.f38473g == null) {
                b0 b0Var = new b0(a(), align);
                this.f38473g = b0Var;
                b0Var.f3796i.setUniqueId(this.f38471e);
                this.f38473g.t(bVar);
            }
            this.f38473g.k(align);
            this.f38472f.b(this.f38473g);
        }
    }

    public d0 showPrivateDecorItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (this.k == null) {
                d0 d0Var = new d0(this.f38472f.j().getContext(), i2);
                this.k = d0Var;
                d0Var.p(this.f38471e);
            }
            this.f38472f.b(this.k);
            return this.k;
        }
        return (d0) invokeI.objValue;
    }

    public k0 showThemeAndStarDecorItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f38476j == null) {
                k0 k0Var = new k0(a());
                this.f38476j = k0Var;
                k0Var.n(this.f38471e);
            }
            this.f38472f.b(this.f38476j);
            return this.f38476j;
        }
        return (k0) invokeV.objValue;
    }

    public void showUnfollowedDecorItemIfNeed(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, align) == null) {
            if (!z) {
                b(this.f38474h);
                return;
            }
            if (this.f38474h == null) {
                this.f38474h = new r0(a(), align);
            }
            this.f38474h.j(align);
            this.f38472f.b(this.f38474h);
        }
    }

    public u showMultiDelDecorItem(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.f38475i == null) {
                this.f38475i = new u(this.f38472f.g());
            }
            this.f38475i.r(this.f38471e);
            this.f38475i.p(z);
            this.f38472f.b(this.f38475i);
            return this.f38475i;
        }
        return (u) invokeZ.objValue;
    }
}
