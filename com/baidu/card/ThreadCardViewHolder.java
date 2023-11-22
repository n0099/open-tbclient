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
import com.baidu.tieba.au;
import com.baidu.tieba.bu;
import com.baidu.tieba.bw4;
import com.baidu.tieba.cu;
import com.baidu.tieba.hu;
import com.baidu.tieba.mt;
import com.baidu.tieba.ps;
import com.baidu.tieba.ss;
import com.baidu.tieba.tt;
import com.baidu.tieba.ws;
import com.baidu.tieba.xs;
import com.baidu.tieba.yl6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadCardViewHolder<T extends bw4> extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public bu<T> b;
    public NegFeedBackDecorItem c;
    public hu d;
    public mt e;
    public au f;
    public tt g;
    public xs h;
    public ws i;
    public ss j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadCardViewHolder(bu<T> buVar) {
        super(buVar.l());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buVar};
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
        this.b = buVar;
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

    public mt q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            if (this.e == null) {
                this.e = new mt(this.b.h());
            }
            this.e.i(this.a);
            this.e.g(z);
            this.b.c(this.e);
            return this.e;
        }
        return (mt) invokeZ.objValue;
    }

    public NegFeedBackDecorItem r(boolean z) {
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

    public tt t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.g == null) {
                tt ttVar = new tt(this.b.l().getContext(), i);
                this.g = ttVar;
                ttVar.f(this.a);
            }
            this.b.c(this.g);
            return this.g;
        }
        return (tt) invokeI.objValue;
    }

    public bu<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (bu) invokeV.objValue;
    }

    public final TbPageContext b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ((TbPageContextSupport) this.b.l().getContext()).getPageContext();
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.p(this.f);
        }
    }

    @Override // com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b.l();
        }
        return (View) invokeV.objValue;
    }

    public ss l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j == null) {
                this.j = new ss(b());
            }
            this.b.c(this.j);
            return this.j;
        }
        return (ss) invokeV.objValue;
    }

    public mt p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return q(true);
        }
        return (mt) invokeV.objValue;
    }

    public au u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new au(b());
            }
            this.b.c(this.f);
            return this.f;
        }
        return (au) invokeV.objValue;
    }

    public final void c(ps psVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, psVar) == null) && psVar != null && psVar.getDecorView() != null) {
            this.b.p(psVar);
        }
    }

    public void h(yl6<T> yl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yl6Var) == null) {
            this.b.r(yl6Var);
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
                this.b.l().setVisibility(8);
                return;
            }
            if (t.getThreadData() != null) {
                t.getThreadData().getTid();
            }
            if (t.getThreadData() != null && t.getThreadData().getAuthor() != null) {
                t.getThreadData().getAuthor().getName_show();
            }
            boolean z = false;
            this.b.l().setVisibility(0);
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
            au auVar = this.f;
            if (auVar != null) {
                auVar.d(z);
                this.f.onBindDataToView(t.getThreadData());
            }
            mt mtVar = this.e;
            if (mtVar != null) {
                mtVar.onBindDataToView(t.getThreadData());
            }
            tt ttVar = this.g;
            if (ttVar != null) {
                ttVar.autoAlignParent(t);
                this.g.onBindDataToView(t.getThreadData());
            }
            xs xsVar = this.h;
            if (xsVar != null) {
                xsVar.a(t, z);
                this.h.onBindDataToView(t.getThreadData());
            }
            ws wsVar = this.i;
            if (wsVar != null) {
                wsVar.onBindDataToView(t.getThreadData());
            }
            if (this.j != null) {
                if (d(t.getThreadData())) {
                    this.j.onBindDataToView(t.getThreadData());
                } else {
                    c(this.j);
                }
            }
            this.b.n(t);
        }
    }

    public void g(int i, cu cuVar) {
        mt mtVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048582, this, i, cuVar) == null) && (mtVar = this.e) != null) {
            mtVar.j(i, cuVar);
        }
    }

    public void n(boolean z, FollowUserButton.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, aVar) == null) {
            o(z, aVar, false);
        }
    }

    public void m(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.i);
                return;
            }
            if (this.i == null) {
                this.i = new ws(b());
            }
            this.i.t(z2);
            this.b.c(this.i);
        }
    }

    public void o(boolean z, FollowUserButton.a aVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), aVar, Boolean.valueOf(z2)}) == null) {
            if (!z) {
                c(this.h);
                return;
            }
            if (this.h == null) {
                xs xsVar = new xs(b());
                this.h = xsVar;
                xsVar.g(aVar);
            }
            this.h.h(this.a);
            this.h.e(z2);
            this.b.c(this.h);
        }
    }

    public void s(boolean z, Align align, NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
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

    public void x(boolean z, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, align) == null) {
            if (!z) {
                c(this.d);
                return;
            }
            if (this.d == null) {
                this.d = new hu(b(), align);
            }
            this.d.autoAlignParent(align);
            this.b.c(this.d);
        }
    }
}
