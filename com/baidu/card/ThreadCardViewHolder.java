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
import com.repackage.az;
import com.repackage.by;
import com.repackage.cz;
import com.repackage.ey;
import com.repackage.iy;
import com.repackage.jz;
import com.repackage.kz;
import com.repackage.lz;
import com.repackage.qz;
import com.repackage.ty;
import com.repackage.ux5;
import com.repackage.zn4;
/* loaded from: classes.dex */
public class ThreadCardViewHolder<T extends zn4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public kz<T> b;
    public az c;
    public qz d;
    public ty e;
    public jz f;
    public cz g;
    public iy h;
    public ey i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(kz<T> kzVar) {
        super(kzVar.j());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kzVar};
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
        this.b = kzVar;
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.j() : (View) invokeV.objValue;
    }

    public kz<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (kz) invokeV.objValue;
    }

    public final TbPageContext d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((TbPageContextSupport) this.b.j().getContext()).getPageContext() : (TbPageContext) invokeV.objValue;
    }

    public final void e(by byVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, byVar) == null) || byVar == null || byVar.b() == null) {
            return;
        }
        this.b.n(byVar);
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
            az azVar = this.c;
            if (azVar != null && azVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    az azVar2 = this.c;
                    if (azVar2 != null && (nEGFeedBackView = azVar2.e) != null) {
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
            jz jzVar = this.f;
            if (jzVar != null) {
                jzVar.n(z);
                this.f.a(t.getThreadData());
            }
            ty tyVar = this.e;
            if (tyVar != null) {
                tyVar.a(t.getThreadData());
            }
            cz czVar = this.g;
            if (czVar != null) {
                czVar.n(t);
                this.g.a(t.getThreadData());
            }
            iy iyVar = this.h;
            if (iyVar != null) {
                iyVar.k(t, z);
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

    public void i(int i, lz lzVar) {
        ty tyVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, lzVar) == null) || (tyVar = this.e) == null) {
            return;
        }
        tyVar.t(i, lzVar);
    }

    public void j(ux5<T> ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ux5Var) == null) {
            this.b.p(ux5Var);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public ey l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.i == null) {
                this.i = new ey(d());
            }
            this.b.c(this.i);
            return this.i;
        }
        return (ey) invokeV.objValue;
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
                iy iyVar = new iy(d(), UbsABTestHelper.showNewUI());
                this.h = iyVar;
                iyVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public ty o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? q(true) : (ty) invokeV.objValue;
    }

    public ty q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
            if (this.e == null) {
                this.e = new ty(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (ty) invokeZ.objValue;
    }

    public az r(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.c == null) {
                az azVar = new az(d(), z);
                this.c = azVar;
                azVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (az) invokeZ.objValue;
    }

    public void s(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                e(this.c);
                return;
            }
            if (this.c == null) {
                az azVar = new az(d(), align);
                this.c = azVar;
                azVar.e.setUniqueId(this.a);
                this.c.u(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public cz t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            if (this.g == null) {
                cz czVar = new cz(this.b.j().getContext(), i);
                this.g = czVar;
                czVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (cz) invokeI.objValue;
    }

    public jz u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f == null) {
                jz jzVar = new jz(d());
                this.f = jzVar;
                jzVar.o(this.a);
            }
            this.b.c(this.f);
            return this.f;
        }
        return (jz) invokeV.objValue;
    }

    public void v(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048595, this, z, align) == null) {
            if (!z) {
                e(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new qz(d(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
