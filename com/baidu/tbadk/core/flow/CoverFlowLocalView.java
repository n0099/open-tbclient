package com.baidu.tbadk.core.flow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.fx4;
import com.baidu.tieba.gx4;
import com.baidu.tieba.hx4;
import com.baidu.tieba.ix4;
import com.baidu.tieba.jx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class CoverFlowLocalView<T extends gx4> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;
    public IndicatorView b;
    public ix4 c;
    public View d;
    public CoverFlowLocalAdapter<T> e;
    public fx4 f;
    public CoverFlowLocalView<T>.b g;
    public boolean h;
    public boolean i;
    public boolean j;
    public jx4<T> k;
    public CoverFlowLocalView<T>.d l;
    public CoverFlowLocalView<T>.c m;
    public boolean n;
    public long o;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowLocalView a;

        public b(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowLocalView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                this.a.s();
            }
        }

        public /* synthetic */ b(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowLocalView a;

        public c(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowLocalView;
        }

        public /* synthetic */ c(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.a != null && this.a.e != null) {
                if (i != 0) {
                    if (i == 1 && !this.a.i) {
                        this.a.u();
                        this.a.m();
                    }
                } else if (!this.a.j) {
                } else {
                    this.a.n();
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v29, resolved type: com.baidu.tieba.jx4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && this.a.b != null && this.a.e != null) {
                if (this.a.e.getCount() == 1 && i == 0 && this.a.k != null) {
                    this.a.k.a(1, this.a.e.b(i));
                }
                if (this.a.b.getVisibility() == 0 && !this.a.h) {
                    if (this.a.n) {
                        int count = this.a.e.getCount();
                        if (i == 0) {
                            this.a.b.setPosition((count - 3) + f);
                            return;
                        } else if (i == count - 1) {
                            this.a.b.setPosition(f);
                            return;
                        } else {
                            this.a.b.setPosition((i - 1) + f);
                            return;
                        }
                    }
                    this.a.b.setPosition(i + f);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: com.baidu.tieba.jx4 */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.a.e == null) {
                return;
            }
            int count = this.a.e.getCount();
            if (i >= 0 && i < count) {
                if (this.a.h) {
                    this.a.setIndicatorSelected(i);
                }
                if (this.a.k == null) {
                    return;
                }
                this.a.k.a(i, this.a.e.b(i));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverFlowLocalView a;

        public d(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverFlowLocalView;
        }

        public /* synthetic */ d(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int intValue;
            gx4 b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.k == null || !(view2.getTag() instanceof Integer) || (b = this.a.e.b((intValue = ((Integer) view2.getTag()).intValue()))) == null) {
                return;
            }
            this.a.k.b(intValue, b.getPicLinkUrl());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context) {
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
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, list) == null) && list != null && !list.isEmpty()) {
            this.e.e(list, this.f);
            int size = list.size();
            boolean z = true;
            if (size <= 1) {
                z = false;
            }
            if (z) {
                this.b.setVisibility(0);
                this.b.setCount(size);
                this.a.setCurrentItem(0, false);
                this.b.setPosition(0.0f);
                if (this.j) {
                    t();
                    return;
                }
                return;
            }
            this.b.setVisibility(8);
            this.b.setCount(size);
            this.a.setCurrentItem(0, false);
            this.b.setPosition(0.0f);
            u();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context, AttributeSet attributeSet) {
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
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i) {
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
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.b = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = new ListViewPager(context);
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.j = z;
        }
    }

    public void setCallback(jx4<T> jx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jx4Var) == null) {
            this.k = jx4Var;
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.n = z;
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.e;
            if (coverFlowLocalAdapter != null) {
                coverFlowLocalAdapter.d(z);
            }
        }
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (listViewPager = this.a) != null) {
            listViewPager.setDisableParentEvent(z);
        }
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.h = z;
        }
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && (indicatorView = this.b) != null) {
            indicatorView.setVisibility(i);
        }
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) && (listViewPager = this.a) != null) {
            listViewPager.setSwipeControlInterface(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65551, this, i) == null) {
            if (this.n) {
                int count = this.e.getCount();
                if (i == 0) {
                    this.b.setPosition(0.0f);
                    return;
                } else if (i == count - 1) {
                    this.b.setPosition(i);
                    return;
                } else {
                    this.b.setPosition(i - 1);
                    return;
                }
            }
            this.b.setPosition(i);
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new hx4());
            addView(this.a);
            addView(this.b);
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
            this.e = coverFlowLocalAdapter;
            coverFlowLocalAdapter.f(this.l);
            this.a.setAdapter(this.e);
            this.a.setOnPageChangeListener(this.m);
        }
    }

    public void setCoverFlowFactory(fx4 fx4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, fx4Var) != null) || fx4Var == null) {
            return;
        }
        this.f = fx4Var;
        ix4 a2 = fx4Var.a();
        this.c = a2;
        a2.i(this.b);
        fx4Var.c().b(this.a);
        View b2 = fx4Var.b();
        this.d = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.a);
            addView(this.d);
            addView(this.b);
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.e;
            if (coverFlowLocalAdapter == null || !this.n || (count = coverFlowLocalAdapter.getCount()) <= 1) {
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

    public final void s() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || this.a == null || (coverFlowLocalAdapter = this.e) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
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

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && m()) {
            r();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g.removeMessages(1);
            this.g.sendEmptyMessageDelayed(1, this.o);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            r();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.g.removeMessages(1);
        }
    }
}
