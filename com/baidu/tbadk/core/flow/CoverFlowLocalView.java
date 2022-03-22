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
import c.a.o0.r.x.b.a;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class CoverFlowLocalView<T extends c.a.o0.r.x.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ListViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public IndicatorView f29893b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.o0.r.x.b.c f29894c;

    /* renamed from: d  reason: collision with root package name */
    public View f29895d;

    /* renamed from: e  reason: collision with root package name */
    public CoverFlowLocalAdapter<T> f29896e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.o0.r.x.a f29897f;

    /* renamed from: g  reason: collision with root package name */
    public CoverFlowLocalView<T>.b f29898g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29899h;
    public boolean i;
    public boolean j;
    public c.a.o0.r.x.b.d<T> k;
    public CoverFlowLocalView<T>.d l;
    public CoverFlowLocalView<T>.c m;
    public boolean n;
    public long o;

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

    /* loaded from: classes4.dex */
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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.a == null || this.a.f29896e == null) {
                return;
            }
            if (i != 0) {
                if (i == 1 && !this.a.i) {
                    this.a.u();
                    this.a.m();
                }
            } else if (this.a.j) {
                this.a.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v29, resolved type: c.a.o0.r.x.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.a.f29893b == null || this.a.f29896e == null) {
                return;
            }
            if (this.a.f29896e.getCount() == 1 && i == 0 && this.a.k != null) {
                this.a.k.a(1, this.a.f29896e.b(i));
            }
            if (this.a.f29893b.getVisibility() != 0 || this.a.f29899h) {
                return;
            }
            if (this.a.n) {
                int count = this.a.f29896e.getCount();
                if (i == 0) {
                    this.a.f29893b.setPosition((count - 3) + f2);
                    return;
                } else if (i == count - 1) {
                    this.a.f29893b.setPosition(f2);
                    return;
                } else {
                    this.a.f29893b.setPosition((i - 1) + f2);
                    return;
                }
            }
            this.a.f29893b.setPosition(i + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: c.a.o0.r.x.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.a.f29896e == null) {
                return;
            }
            int count = this.a.f29896e.getCount();
            if (i < 0 || i >= count) {
                return;
            }
            if (this.a.f29899h) {
                this.a.setIndicatorSelected(i);
            }
            if (this.a.k == null) {
                return;
            }
            this.a.k.a(i, this.a.f29896e.b(i));
        }

        public /* synthetic */ c(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes4.dex */
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            c.a.o0.r.x.b.a b2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.k == null || !(view.getTag() instanceof Integer) || (b2 = this.a.f29896e.b((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.a.k.b(intValue, b2.b());
        }

        public /* synthetic */ d(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
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
        this.f29895d = null;
        this.f29898g = new b(this, null);
        this.f29899h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.i : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            if (this.n) {
                int count = this.f29896e.getCount();
                if (i == 0) {
                    this.f29893b.setPosition(0.0f);
                    return;
                } else if (i == count - 1) {
                    this.f29893b.setPosition(i);
                    return;
                } else {
                    this.f29893b.setPosition(i - 1);
                    return;
                }
            }
            this.f29893b.setPosition(i);
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f29896e;
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

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && m()) {
            r();
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new c.a.o0.r.x.b.b());
            addView(this.a);
            addView(this.f29893b);
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
            this.f29896e = coverFlowLocalAdapter;
            coverFlowLocalAdapter.f(this.l);
            this.a.setAdapter(this.f29896e);
            this.a.setOnPageChangeListener(this.m);
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f29893b = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.a = new ListViewPager(context);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29898g.removeMessages(1);
            this.f29898g.sendEmptyMessageDelayed(1, this.o);
        }
    }

    public final void s() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a == null || (coverFlowLocalAdapter = this.f29896e) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
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

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.j = z;
        }
    }

    public void setCallback(c.a.o0.r.x.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.n = z;
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f29896e;
            if (coverFlowLocalAdapter != null) {
                coverFlowLocalAdapter.d(z);
            }
        }
    }

    public void setCoverFlowFactory(c.a.o0.r.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f29897f = aVar;
        c.a.o0.r.x.b.c a2 = aVar.a();
        this.f29894c = a2;
        a2.i(this.f29893b);
        aVar.c().b(this.a);
        View b2 = aVar.b();
        this.f29895d = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.a);
            addView(this.f29895d);
            addView(this.f29893b);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f29896e.e(list, this.f29897f);
        int size = list.size();
        if (size > 1) {
            this.f29893b.setVisibility(0);
            this.f29893b.setCount(size);
            this.a.setCurrentItem(0, false);
            this.f29893b.setPosition(0.0f);
            if (this.j) {
                t();
                return;
            }
            return;
        }
        this.f29893b.setVisibility(8);
        this.f29893b.setCount(size);
        this.a.setCurrentItem(0, false);
        this.f29893b.setPosition(0.0f);
        u();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f29899h = z;
        }
    }

    public void setIndicatorVisible(int i) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (indicatorView = this.f29893b) == null) {
            return;
        }
        indicatorView.setVisibility(i);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i = z;
        }
    }

    public void setMarqueenTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.o = j;
            r();
        }
    }

    public void setPageMargin(int i) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setPageMargin(i);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) || (listViewPager = this.a) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            r();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f29898g.removeMessages(1);
        }
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
        this.f29895d = null;
        this.f29898g = new b(this, null);
        this.f29899h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
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
        this.f29895d = null;
        this.f29898g = new b(this, null);
        this.f29899h = false;
        this.i = true;
        this.j = true;
        this.l = new d(this, null);
        this.m = new c(this, null);
        this.o = 5000L;
        o(context);
    }
}
