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
import com.baidu.tieba.cy;
import com.baidu.tieba.cz;
import com.baidu.tieba.ez;
import com.baidu.tieba.gy;
import com.baidu.tieba.hy;
import com.baidu.tieba.lz;
import com.baidu.tieba.mz;
import com.baidu.tieba.nz;
import com.baidu.tieba.sz;
import com.baidu.tieba.t15;
import com.baidu.tieba.up6;
import com.baidu.tieba.wy;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends t15> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public mz<T> b;
    public cz c;
    public sz d;
    public wy e;
    public lz f;
    public ez g;
    public hy h;
    public gy i;
    public cy j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(mz<T> mzVar) {
        super(mzVar.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mzVar};
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
        this.b = mzVar;
    }

    public final boolean e(ThreadData threadData) {
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

    public wy p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.e == null) {
                this.e = new wy(this.b.getContext());
            }
            this.e.s(this.a);
            this.e.q(z);
            this.b.c(this.e);
            return this.e;
        }
        return (wy) invokeZ.objValue;
    }

    public cz q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.c == null) {
                cz czVar = new cz(c(), z);
                this.c = czVar;
                czVar.e.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (cz) invokeZ.objValue;
    }

    public ez s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.g == null) {
                ez ezVar = new ez(this.b.k().getContext(), i);
                this.g = ezVar;
                ezVar.q(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (ez) invokeI.objValue;
    }

    public mz<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (mz) invokeV.objValue;
    }

    public final TbPageContext c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((TbPageContextSupport) this.b.k().getContext()).getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.o(this.f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b.k();
        }
        return (View) invokeV.objValue;
    }

    public cy k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j == null) {
                this.j = new cy(c());
            }
            this.b.c(this.j);
            return this.j;
        }
        return (cy) invokeV.objValue;
    }

    public wy o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return p(true);
        }
        return (wy) invokeV.objValue;
    }

    public lz t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new lz(c());
            }
            this.b.c(this.f);
            return this.f;
        }
        return (lz) invokeV.objValue;
    }

    public final void d(zx zxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zxVar) == null) && zxVar != null && zxVar.a() != null) {
            this.b.o(zxVar);
        }
    }

    public void i(up6<T> up6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, up6Var) == null) {
            this.b.q(up6Var);
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void f(T t) {
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
            cz czVar = this.c;
            if (czVar != null && czVar.e != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.m(t);
                    this.c.b(t.getNegFeedBackData());
                    this.c.e.setVisibility(0);
                    z = true;
                } else {
                    cz czVar2 = this.c;
                    if (czVar2 != null && (nEGFeedBackView = czVar2.e) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.d != null) {
                if (e(t.getThreadData())) {
                    d(this.d);
                } else {
                    this.d.l(t);
                    this.d.b(t.getThreadData());
                }
            }
            lz lzVar = this.f;
            if (lzVar != null) {
                lzVar.n(z);
                this.f.b(t.getThreadData());
            }
            wy wyVar = this.e;
            if (wyVar != null) {
                wyVar.b(t.getThreadData());
            }
            ez ezVar = this.g;
            if (ezVar != null) {
                ezVar.n(t);
                this.g.b(t.getThreadData());
            }
            hy hyVar = this.h;
            if (hyVar != null) {
                hyVar.k(t, z);
                this.h.b(t.getThreadData());
            }
            gy gyVar = this.i;
            if (gyVar != null) {
                gyVar.b(t.getThreadData());
            }
            if (this.j != null) {
                if (e(t.getThreadData())) {
                    this.j.b(t.getThreadData());
                } else {
                    d(this.j);
                }
            }
            this.b.m(t);
        }
    }

    public void h(int i, nz nzVar) {
        wy wyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, nzVar) == null) && (wyVar = this.e) != null) {
            wyVar.t(i, nzVar);
        }
    }

    public void m(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, aVar) == null) {
            n(z, aVar, false);
        }
    }

    public void l(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                d(this.i);
                return;
            }
            if (this.i == null) {
                this.i = new gy(c());
            }
            this.i.D(z2);
            this.b.c(this.i);
        }
    }

    public void n(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                d(this.h);
                return;
            }
            if (this.h == null) {
                hy hyVar = new hy(c());
                this.h = hyVar;
                hyVar.r(aVar);
            }
            this.h.s(this.a);
            this.h.p(z2);
            this.b.c(this.h);
        }
    }

    public void r(boolean z, Align align, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), align, bVar}) == null) {
            if (!z) {
                d(this.c);
                return;
            }
            if (this.c == null) {
                cz czVar = new cz(c(), align);
                this.c = czVar;
                czVar.e.setUniqueId(this.a);
                this.c.s(bVar);
            }
            this.c.l(align);
            this.b.c(this.c);
        }
    }

    public void u(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, align) == null) {
            if (!z) {
                d(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new sz(c(), align);
            }
            this.d.k(align);
            this.b.c(this.d);
        }
    }
}
