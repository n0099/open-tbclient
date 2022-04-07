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
import com.repackage.a00;
import com.repackage.b00;
import com.repackage.c00;
import com.repackage.h00;
import com.repackage.kz;
import com.repackage.qn4;
import com.repackage.rx5;
import com.repackage.rz;
import com.repackage.sy;
import com.repackage.tz;
import com.repackage.vy;
import com.repackage.zy;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends qn4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public b00<T> b;
    public rz c;
    public h00 d;
    public kz e;
    public a00 f;
    public tz g;
    public zy h;
    public vy i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(b00<T> b00Var) {
        super(b00Var.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b00Var};
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
        this.b = b00Var;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.j() : (View) invokeV.objValue;
    }

    public b00<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (b00) invokeV.objValue;
    }

    public final TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void e(sy syVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, syVar) == null) || syVar == null || syVar.b() == null) {
            return;
        }
        this.b.n(syVar);
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
            rz rzVar = this.c;
            if (rzVar != null && rzVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    rz rzVar2 = this.c;
                    if (rzVar2 != null && (nEGFeedBackView = rzVar2.e) != null) {
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
            a00 a00Var = this.f;
            if (a00Var != null) {
                a00Var.n(z);
                this.f.a(t.getThreadData());
            }
            kz kzVar = this.e;
            if (kzVar != null) {
                kzVar.a(t.getThreadData());
            }
            tz tzVar = this.g;
            if (tzVar != null) {
                tzVar.n(t);
                this.g.a(t.getThreadData());
            }
            zy zyVar = this.h;
            if (zyVar != null) {
                zyVar.k(t, z);
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

    public void i(int i, c00 c00Var) {
        kz kzVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, c00Var) == null) || (kzVar = this.e) == null) {
            return;
        }
        kzVar.t(i, c00Var);
    }

    public void j(rx5<T> rx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rx5Var) == null) {
            this.b.p(rx5Var);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public vy l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new vy(d());
            }
            this.b.c(this.i);
            return this.i;
        }
        return (vy) invokeV.objValue;
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
                zy zyVar = new zy(d(), UbsABTestHelper.showNewUI());
                this.h = zyVar;
                zyVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public kz o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? p(true) : (kz) invokeV.objValue;
    }

    public kz p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.e == null) {
                this.e = new kz(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (kz) invokeZ.objValue;
    }

    public rz r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.c == null) {
                rz rzVar = new rz(d(), z);
                this.c = rzVar;
                rzVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (rz) invokeZ.objValue;
    }

    public void s(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                e(this.c);
                return;
            }
            if (this.c == null) {
                rz rzVar = new rz(d(), align);
                this.c = rzVar;
                rzVar.e.setUniqueId(this.a);
                this.c.u(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public tz t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g == null) {
                tz tzVar = new tz(this.b.j().getContext(), i);
                this.g = tzVar;
                tzVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (tz) invokeI.objValue;
    }

    public a00 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f == null) {
                a00 a00Var = new a00(d());
                this.f = a00Var;
                a00Var.o(this.a);
            }
            this.b.c(this.f);
            return this.f;
        }
        return (a00) invokeV.objValue;
    }

    public void v(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                e(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new h00(d(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
