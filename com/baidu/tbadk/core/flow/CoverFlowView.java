package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.a35;
import com.baidu.tieba.b35;
import com.baidu.tieba.c35;
import com.baidu.tieba.e35;
import com.baidu.tieba.y25;
import com.baidu.tieba.z25;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowView<T extends z25> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;
    public IndicatorView b;
    public b35 c;
    public View d;
    public CoverFlowAdapter<T> e;
    public y25 f;
    public CoverFlowView<T>.b g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public c35<T> l;
    public CoverFlowView<T>.d m;
    public CoverFlowView<T>.c n;
    public long o;
    public boolean p;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowView a;

        public b(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.a.B();
            }
        }

        public /* synthetic */ b(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ CoverFlowView b;

        public c(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = coverFlowView;
            this.a = false;
        }

        public /* synthetic */ c(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.b.a != null && this.b.e != null) {
                if (i != 0) {
                    if (i == 1) {
                        if (!this.b.i) {
                            this.b.D();
                            this.b.p();
                        }
                        this.a = true;
                        return;
                    }
                    return;
                }
                if (this.b.j || this.b.k) {
                    this.b.r();
                }
                this.a = false;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: com.baidu.tieba.c35 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.b.e == null) {
                return;
            }
            int count = this.b.e.getCount();
            if (i >= 0 && i < count) {
                if (this.b.h) {
                    this.b.setIndicatorSelected(i);
                }
                if (!this.b.p && !this.a) {
                    return;
                }
                this.b.p = false;
                this.b.l.a(i, this.b.e.b(i));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v28, resolved type: com.baidu.tieba.c35 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.b.b != null && this.b.e != null) {
                if (this.b.e.getCount() == 1 && i == 0 && this.b.l != null && this.b.p) {
                    this.b.p = false;
                    this.b.l.a(1, this.b.e.b(i));
                }
                if (this.b.b.getVisibility() == 0 && !this.b.h) {
                    int count = this.b.e.getCount();
                    if (i == 0) {
                        this.b.b.setPosition((count - 3) + f);
                    } else if (i == count - 1) {
                        this.b.b.setPosition(f);
                    } else {
                        this.b.b.setPosition((i - 1) + f);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowView a;

        public d(CoverFlowView coverFlowView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowView;
        }

        public /* synthetic */ d(CoverFlowView coverFlowView, a aVar) {
            this(coverFlowView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int intValue;
            z25 b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.l == null || !(view2.getTag() instanceof Integer) || (b = this.a.e.b((intValue = ((Integer) view2.getTag()).intValue()))) == null) {
                return;
            }
            if (this.a.e.getCount() <= 1) {
                this.a.l.b(1, b.getPicLinkUrl());
            } else if (intValue == 0) {
                this.a.l.b(this.a.e.getCount() - 2, b.getPicLinkUrl());
            } else if (intValue == this.a.e.getCount() - 1) {
                this.a.l.b(1, b.getPicLinkUrl());
            } else {
                this.a.l.b(intValue, b.getPicLinkUrl());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.m = new d(this, null);
        this.n = new c(this, null);
        this.o = 5000L;
        this.p = true;
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.m = new d(this, null);
        this.n = new c(this, null);
        this.o = 5000L;
        this.p = true;
        s(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.d = null;
        this.g = new b(this, null);
        this.h = false;
        this.i = true;
        this.j = true;
        this.m = new d(this, null);
        this.n = new c(this, null);
        this.o = 5000L;
        this.p = true;
        s(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i) == null) {
            int count = this.e.getCount();
            if (i == 0) {
                this.b.setPosition(0.0f);
            } else if (i == count - 1) {
                this.b.setPosition(i);
            } else {
                this.b.setPosition(i - 1);
            }
        }
    }

    public void E(e35 e35Var) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, e35Var) == null) && e35Var != null && (listViewPager = this.a) != null) {
            e35Var.b(listViewPager);
        }
    }

    public T q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.e;
            if (coverFlowAdapter == null) {
                return null;
            }
            return coverFlowAdapter.b(i);
        }
        return (T) invokeI.objValue;
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.j = z;
        }
    }

    public void setCallback(c35<T> c35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, c35Var) == null) {
            this.l = c35Var;
        }
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (listViewPager = this.a) != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.h = z;
        }
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (indicatorView = this.b) != null) {
            indicatorView.setVisibility(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.i = z;
        }
    }

    public void setMarqueenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.o = j;
            if (this.j) {
                A();
            }
        }
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (listViewPager = this.a) != null) {
            listViewPager.setPageMargin(i);
        }
    }

    public void setPagerAdapter(@NonNull CoverFlowAdapter coverFlowAdapter) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, coverFlowAdapter) == null) && (listViewPager = this.a) != null) {
            this.e = coverFlowAdapter;
            listViewPager.setAdapter(coverFlowAdapter);
            coverFlowAdapter.i(this.m);
            coverFlowAdapter.notifyDataSetChanged();
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) && (listViewPager = this.a) != null) {
            listViewPager.setSwipeControlInterface(cVar);
        }
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.b = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            this.a = new ListViewPager(context);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.e.e(z);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, this.o);
            this.k = true;
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.removeMessages(1);
            this.k = false;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.g.hasMessages(1)) {
            C();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && p()) {
            A();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.onDestroy();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.e.d();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.e.f();
        }
    }

    public final void B() {
        CoverFlowAdapter<T> coverFlowAdapter;
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a == null || (coverFlowAdapter = this.e) == null || (count = coverFlowAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.a.getCurrentItem();
        int i = count - 2;
        if (currentItem < 1) {
            this.a.setCurrentItem(i, false);
        } else if (currentItem > i) {
            this.a.setCurrentItem(1, false);
        } else {
            this.a.setCurrentItem(currentItem + 1);
        }
        this.a.invalidate();
    }

    public final boolean p() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            CoverFlowAdapter<T> coverFlowAdapter = this.e;
            if (coverFlowAdapter == null || (count = coverFlowAdapter.getCount()) <= 1) {
                return false;
            }
            int currentItem = this.a.getCurrentItem();
            int i = count - 2;
            if (currentItem < 1) {
                this.a.setCurrentItem(i, false);
                this.a.invalidate();
            } else if (currentItem > i) {
                this.a.setCurrentItem(1, false);
                this.a.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void v() {
        b35 b35Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.e.c();
            IndicatorView indicatorView = this.b;
            if (indicatorView != null && (b35Var = this.c) != null) {
                indicatorView.setDrawable(SkinManager.getDrawable(b35Var.a()));
                this.b.setSelector(SkinManager.getDrawable(this.c.b()));
            }
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            u(context);
            t(context);
            setCoverFlowFactory(new a35());
            addView(this.a);
            addView(this.b);
            CoverFlowAdapter<T> coverFlowAdapter = new CoverFlowAdapter<>(context);
            this.e = coverFlowAdapter;
            coverFlowAdapter.i(this.m);
            this.a.setAdapter(this.e);
            this.a.setOnPageChangeListener(this.n);
        }
    }

    public void setCoverFlowFactory(y25 y25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, y25Var) != null) || y25Var == null) {
            return;
        }
        this.f = y25Var;
        b35 a2 = y25Var.a();
        this.c = a2;
        a2.i(this.b);
        y25Var.c().b(this.a);
        View b2 = y25Var.b();
        this.d = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.a);
            addView(this.d);
            addView(this.b);
        }
    }

    public void setData(List<T> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, list) == null) && list != null && !list.isEmpty()) {
            this.p = true;
            this.e.h(list, this.f);
            int size = list.size();
            if (size > 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.b.setVisibility(0);
                this.b.setCount(size);
                this.a.setCurrentItem(1, false);
                this.b.setPosition(0.0f);
                if (this.j) {
                    C();
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
            this.b.setCount(size);
            this.a.setCurrentItem(1, false);
            this.b.setPosition(0.0f);
            D();
        }
    }
}
