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
import com.baidu.tieba.bz;
import com.baidu.tieba.dz;
import com.baidu.tieba.fy;
import com.baidu.tieba.gy;
import com.baidu.tieba.kz;
import com.baidu.tieba.l15;
import com.baidu.tieba.lz;
import com.baidu.tieba.mz;
import com.baidu.tieba.qo6;
import com.baidu.tieba.rz;
import com.baidu.tieba.vy;
import com.baidu.tieba.yx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends l15> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public lz<T> b;
    public bz c;
    public rz d;
    public vy e;
    public kz f;
    public dz g;
    public gy h;
    public fy i;
    public by j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(lz<T> lzVar) {
        super(lzVar.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lzVar};
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
        this.b = lzVar;
    }

    public final boolean d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null || !threadData.isFromConcern || !UbsABTestHelper.isConcernForumCardShow() || threadData.getAuthor().hadConcerned() || ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public vy o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.e == null) {
                this.e = new vy(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (vy) invokeZ.objValue;
    }

    public bz p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.c == null) {
                bz bzVar = new bz(b(), z);
                this.c = bzVar;
                bzVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (bz) invokeZ.objValue;
    }

    public dz r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.g == null) {
                dz dzVar = new dz(this.b.k().getContext(), i);
                this.g = dzVar;
                dzVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (dz) invokeI.objValue;
    }

    public lz<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (lz) invokeV.objValue;
    }

    public final TbPageContext b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((TbPageContextSupport) this.b.k().getContext()).getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.o(this.f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.k();
        }
        return (View) invokeV.objValue;
    }

    public by j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j == null) {
                this.j = new by(b());
            }
            this.b.c(this.j);
            return this.j;
        }
        return (by) invokeV.objValue;
    }

    public vy n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return o(true);
        }
        return (vy) invokeV.objValue;
    }

    public kz s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new kz(b());
            }
            this.b.c(this.f);
            return this.f;
        }
        return (kz) invokeV.objValue;
    }

    public final void c(yx yxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yxVar) == null) && yxVar != null && yxVar.b() != null) {
            this.b.o(yxVar);
        }
    }

    public void h(qo6<T> qo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qo6Var) == null) {
            this.b.q(qo6Var);
        }
    }

    public void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void e(T t) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            if (t == null) {
                this.b.k().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().getTid();
            }
            if (t.getThreadData() != null && t.getThreadData().getAuthor() != null) {
                t.getThreadData().getAuthor().getName_show();
            }
            boolean z = false;
            this.b.k().setVisibility(0);
            bz bzVar = this.c;
            if (bzVar != null && bzVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.a(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    bz bzVar2 = this.c;
                    if (bzVar2 != null && (nEGFeedBackView = bzVar2.e) != null) {
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
            kz kzVar = this.f;
            if (kzVar != null) {
                kzVar.n(z);
                this.f.a(t.getThreadData());
            }
            vy vyVar = this.e;
            if (vyVar != null) {
                vyVar.a(t.getThreadData());
            }
            dz dzVar = this.g;
            if (dzVar != null) {
                dzVar.n(t);
                this.g.a(t.getThreadData());
            }
            gy gyVar = this.h;
            if (gyVar != null) {
                gyVar.k(t, z);
                this.h.a(t.getThreadData());
            }
            fy fyVar = this.i;
            if (fyVar != null) {
                fyVar.a(t.getThreadData());
            }
            if (this.j != null) {
                if (d(t.getThreadData())) {
                    this.j.a(t.getThreadData());
                } else {
                    c(this.j);
                }
            }
            this.b.m(t);
        }
    }

    public void g(int i, mz mzVar) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, mzVar) == null) && (vyVar = this.e) != null) {
            vyVar.t(i, mzVar);
        }
    }

    public void l(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, aVar) == null) {
            m(z, aVar, false);
        }
    }

    public void k(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.i);
                return;
            }
            if (this.i == null) {
                this.i = new fy(b());
            }
            this.i.F(z2);
            this.b.c(this.i);
        }
    }

    public void m(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.h);
                return;
            }
            if (this.h == null) {
                gy gyVar = new gy(b());
                this.h = gyVar;
                gyVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public void q(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                c(this.c);
                return;
            }
            if (this.c == null) {
                bz bzVar = new bz(b(), align);
                this.c = bzVar;
                bzVar.e.setUniqueId(this.a);
                this.c.s(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public void t(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, align) == null) {
            if (!z) {
                c(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new rz(b(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
