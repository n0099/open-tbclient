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
import com.baidu.tieba.b15;
import com.baidu.tieba.cx;
import com.baidu.tieba.fx;
import com.baidu.tieba.gy;
import com.baidu.tieba.jx;
import com.baidu.tieba.kx;
import com.baidu.tieba.mp6;
import com.baidu.tieba.ny;
import com.baidu.tieba.oy;
import com.baidu.tieba.py;
import com.baidu.tieba.uy;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends b15> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public oy<T> b;
    public NegFeedBackDecorItem c;
    public uy d;
    public zx e;
    public ny f;
    public gy g;
    public kx h;
    public jx i;
    public fx j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(oy<T> oyVar) {
        super(oyVar.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oyVar};
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
        this.b = oyVar;
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

    public zx o(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.e == null) {
                this.e = new zx(this.b.getContext());
            }
            this.e.i(this.a);
            this.e.g(z);
            this.b.c(this.e);
            return this.e;
        }
        return (zx) invokeZ.objValue;
    }

    public NegFeedBackDecorItem p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.c == null) {
                NegFeedBackDecorItem negFeedBackDecorItem = new NegFeedBackDecorItem(b(), z);
                this.c = negFeedBackDecorItem;
                negFeedBackDecorItem.mNegFeedBackView.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (NegFeedBackDecorItem) invokeZ.objValue;
    }

    public gy r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.g == null) {
                gy gyVar = new gy(this.b.k().getContext(), i);
                this.g = gyVar;
                gyVar.f(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (gy) invokeI.objValue;
    }

    public oy<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (oy) invokeV.objValue;
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

    public fx j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j == null) {
                this.j = new fx(b());
            }
            this.b.c(this.j);
            return this.j;
        }
        return (fx) invokeV.objValue;
    }

    public zx n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return o(true);
        }
        return (zx) invokeV.objValue;
    }

    public ny s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new ny(b());
            }
            this.b.c(this.f);
            return this.f;
        }
        return (ny) invokeV.objValue;
    }

    public final void c(cx cxVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cxVar) == null) && cxVar != null && cxVar.getDecorView() != null) {
            this.b.o(cxVar);
        }
    }

    public void h(mp6<T> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mp6Var) == null) {
            this.b.q(mp6Var);
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
            NegFeedBackDecorItem negFeedBackDecorItem = this.c;
            if (negFeedBackDecorItem != null && negFeedBackDecorItem.mNegFeedBackView != null) {
                if (!t.isSelf() && t.getNegFeedBackData() != null) {
                    this.c.autoAlignParent(t);
                    this.c.onBindDataToView(t.getNegFeedBackData());
                    this.c.mNegFeedBackView.setVisibility(0);
                    z = true;
                } else {
                    NegFeedBackDecorItem negFeedBackDecorItem2 = this.c;
                    if (negFeedBackDecorItem2 != null && (nEGFeedBackView = negFeedBackDecorItem2.mNegFeedBackView) != null) {
                        nEGFeedBackView.setVisibility(8);
                    }
                }
            }
            if (this.d != null) {
                if (d(t.getThreadData())) {
                    c(this.d);
                } else {
                    this.d.autoAlignParent(t);
                    this.d.onBindDataToView(t.getThreadData());
                }
            }
            ny nyVar = this.f;
            if (nyVar != null) {
                nyVar.d(z);
                this.f.onBindDataToView(t.getThreadData());
            }
            zx zxVar = this.e;
            if (zxVar != null) {
                zxVar.onBindDataToView(t.getThreadData());
            }
            gy gyVar = this.g;
            if (gyVar != null) {
                gyVar.autoAlignParent(t);
                this.g.onBindDataToView(t.getThreadData());
            }
            kx kxVar = this.h;
            if (kxVar != null) {
                kxVar.a(t, z);
                this.h.onBindDataToView(t.getThreadData());
            }
            jx jxVar = this.i;
            if (jxVar != null) {
                jxVar.onBindDataToView(t.getThreadData());
            }
            if (this.j != null) {
                if (d(t.getThreadData())) {
                    this.j.onBindDataToView(t.getThreadData());
                } else {
                    c(this.j);
                }
            }
            this.b.m(t);
        }
    }

    public void g(int i, py pyVar) {
        zx zxVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, pyVar) == null) && (zxVar = this.e) != null) {
            zxVar.j(i, pyVar);
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
                this.i = new jx(b());
            }
            this.i.t(z2);
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
                kx kxVar = new kx(b());
                this.h = kxVar;
                kxVar.g(aVar);
            }
            this.h.h(this.a);
            this.h.e(z2);
            this.b.c(this.h);
        }
    }

    public void q(boolean z, Align align, NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), align, nEGFeedbackEventCallback}) == null) {
            if (!z) {
                c(this.c);
                return;
            }
            if (this.c == null) {
                NegFeedBackDecorItem negFeedBackDecorItem = new NegFeedBackDecorItem(b(), align);
                this.c = negFeedBackDecorItem;
                negFeedBackDecorItem.mNegFeedBackView.setUniqueId(this.a);
                this.c.setNegEventCallback(nEGFeedbackEventCallback);
            }
            this.c.autoAlignParent(align);
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
                this.d = new uy(b(), align);
            }
            this.d.autoAlignParent(align);
            this.b.c(this.d);
        }
    }
}
