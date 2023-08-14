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
import com.baidu.tieba.bx;
import com.baidu.tieba.cn6;
import com.baidu.tieba.cy;
import com.baidu.tieba.fx;
import com.baidu.tieba.gx;
import com.baidu.tieba.jy;
import com.baidu.tieba.ky;
import com.baidu.tieba.ly;
import com.baidu.tieba.q05;
import com.baidu.tieba.qy;
import com.baidu.tieba.vx;
import com.baidu.tieba.yw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends q05> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public ky<T> b;
    public NegFeedBackDecorItem c;
    public qy d;
    public vx e;
    public jy f;
    public cy g;
    public gx h;
    public fx i;
    public bx j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(ky<T> kyVar) {
        super(kyVar.k());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kyVar};
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
        this.b = kyVar;
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

    public vx p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.e == null) {
                this.e = new vx(this.b.getContext());
            }
            this.e.i(this.a);
            this.e.g(z);
            this.b.c(this.e);
            return this.e;
        }
        return (vx) invokeZ.objValue;
    }

    public NegFeedBackDecorItem q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.c == null) {
                NegFeedBackDecorItem negFeedBackDecorItem = new NegFeedBackDecorItem(c(), z);
                this.c = negFeedBackDecorItem;
                negFeedBackDecorItem.mNegFeedBackView.setUniqueId(this.a);
            }
            this.b.c(this.c);
            return this.c;
        }
        return (NegFeedBackDecorItem) invokeZ.objValue;
    }

    public cy s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.g == null) {
                cy cyVar = new cy(this.b.k().getContext(), i);
                this.g = cyVar;
                cyVar.f(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (cy) invokeI.objValue;
    }

    public ky<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ky) invokeV.objValue;
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

    public bx k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j == null) {
                this.j = new bx(c());
            }
            this.b.c(this.j);
            return this.j;
        }
        return (bx) invokeV.objValue;
    }

    public vx o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return p(true);
        }
        return (vx) invokeV.objValue;
    }

    public jy t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new jy(c());
            }
            this.b.c(this.f);
            return this.f;
        }
        return (jy) invokeV.objValue;
    }

    public final void d(yw ywVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ywVar) == null) && ywVar != null && ywVar.getDecorView() != null) {
            this.b.o(ywVar);
        }
    }

    public void i(cn6<T> cn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cn6Var) == null) {
            this.b.q(cn6Var);
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
                if (e(t.getThreadData())) {
                    d(this.d);
                } else {
                    this.d.autoAlignParent(t);
                    this.d.onBindDataToView(t.getThreadData());
                }
            }
            jy jyVar = this.f;
            if (jyVar != null) {
                jyVar.d(z);
                this.f.onBindDataToView(t.getThreadData());
            }
            vx vxVar = this.e;
            if (vxVar != null) {
                vxVar.onBindDataToView(t.getThreadData());
            }
            cy cyVar = this.g;
            if (cyVar != null) {
                cyVar.autoAlignParent(t);
                this.g.onBindDataToView(t.getThreadData());
            }
            gx gxVar = this.h;
            if (gxVar != null) {
                gxVar.a(t, z);
                this.h.onBindDataToView(t.getThreadData());
            }
            fx fxVar = this.i;
            if (fxVar != null) {
                fxVar.onBindDataToView(t.getThreadData());
            }
            if (this.j != null) {
                if (e(t.getThreadData())) {
                    this.j.onBindDataToView(t.getThreadData());
                } else {
                    d(this.j);
                }
            }
            this.b.m(t);
        }
    }

    public void h(int i, ly lyVar) {
        vx vxVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, lyVar) == null) && (vxVar = this.e) != null) {
            vxVar.j(i, lyVar);
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
                this.i = new fx(c());
            }
            this.i.t(z2);
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
                gx gxVar = new gx(c());
                this.h = gxVar;
                gxVar.g(aVar);
            }
            this.h.h(this.a);
            this.h.e(z2);
            this.b.c(this.h);
        }
    }

    public void r(boolean z, Align align, NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), align, nEGFeedbackEventCallback}) == null) {
            if (!z) {
                d(this.c);
                return;
            }
            if (this.c == null) {
                NegFeedBackDecorItem negFeedBackDecorItem = new NegFeedBackDecorItem(c(), align);
                this.c = negFeedBackDecorItem;
                negFeedBackDecorItem.mNegFeedBackView.setUniqueId(this.a);
                this.c.setNegEventCallback(nEGFeedbackEventCallback);
            }
            this.c.autoAlignParent(align);
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
                this.d = new qy(c(), align);
            }
            this.d.autoAlignParent(align);
            this.b.c(this.d);
        }
    }
}
