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
import c.a.s0.s.w.b.a;
import c.a.s0.s.w.b.e;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes11.dex */
public class CoverFlowLocalView<T extends c.a.s0.s.w.b.a> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ListViewPager f41660e;

    /* renamed from: f  reason: collision with root package name */
    public IndicatorView f41661f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.s0.s.w.b.c f41662g;

    /* renamed from: h  reason: collision with root package name */
    public View f41663h;

    /* renamed from: i  reason: collision with root package name */
    public CoverFlowLocalAdapter<T> f41664i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.s0.s.w.a f41665j;

    /* renamed from: k  reason: collision with root package name */
    public CoverFlowLocalView<T>.b f41666k;
    public boolean l;
    public boolean m;
    public boolean n;
    public c.a.s0.s.w.b.d<T> o;
    public CoverFlowLocalView<T>.d p;
    public CoverFlowLocalView<T>.c q;
    public boolean r;
    public long s;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.r();
            }
        }

        public /* synthetic */ b(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes11.dex */
    public class c implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f41667e;

        public c(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41667e = coverFlowLocalView;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f41667e.f41660e == null || this.f41667e.f41664i == null) {
                return;
            }
            if (i2 != 0) {
                if (i2 == 1 && !this.f41667e.m) {
                    this.f41667e.stopMarqueen();
                    this.f41667e.m();
                }
            } else if (this.f41667e.n) {
                this.f41667e.n();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v29, resolved type: c.a.s0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f41667e.f41661f == null || this.f41667e.f41664i == null) {
                return;
            }
            if (this.f41667e.f41664i.getCount() == 1 && i2 == 0 && this.f41667e.o != null) {
                this.f41667e.o.a(1, this.f41667e.f41664i.getItem(i2));
            }
            if (this.f41667e.f41661f.getVisibility() != 0 || this.f41667e.l) {
                return;
            }
            if (this.f41667e.r) {
                int count = this.f41667e.f41664i.getCount();
                if (i2 == 0) {
                    this.f41667e.f41661f.setPosition((count - 3) + f2);
                    return;
                } else if (i2 == count - 1) {
                    this.f41667e.f41661f.setPosition(f2);
                    return;
                } else {
                    this.f41667e.f41661f.setPosition((i2 - 1) + f2);
                    return;
                }
            }
            this.f41667e.f41661f.setPosition(i2 + f2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: c.a.s0.s.w.b.d */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f41667e.f41664i == null) {
                return;
            }
            int count = this.f41667e.f41664i.getCount();
            if (i2 < 0 || i2 >= count) {
                return;
            }
            if (this.f41667e.l) {
                this.f41667e.setIndicatorSelected(i2);
            }
            if (this.f41667e.o == null) {
                return;
            }
            this.f41667e.o.a(i2, this.f41667e.f41664i.getItem(i2));
        }

        public /* synthetic */ c(CoverFlowLocalView coverFlowLocalView, a aVar) {
            this(coverFlowLocalView);
        }
    }

    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverFlowLocalView f41668e;

        public d(CoverFlowLocalView coverFlowLocalView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverFlowLocalView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41668e = coverFlowLocalView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            c.a.s0.s.w.b.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41668e.o == null || !(view.getTag() instanceof Integer) || (item = this.f41668e.f41664i.getItem((intValue = ((Integer) view.getTag()).intValue()))) == null) {
                return;
            }
            this.f41668e.o.b(intValue, item.b());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41663h = null;
        this.f41666k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
        o(context);
    }

    private boolean getAutoPlayPlayDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.m : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndicatorSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            if (this.r) {
                int count = this.f41664i.getCount();
                if (i2 == 0) {
                    this.f41661f.setPosition(0.0f);
                    return;
                } else if (i2 == count - 1) {
                    this.f41661f.setPosition(i2);
                    return;
                } else {
                    this.f41661f.setPosition(i2 - 1);
                    return;
                }
            }
            this.f41661f.setPosition(i2);
        }
    }

    public void checkAndStartMarqueen() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41666k.hasMessages(1)) {
            return;
        }
        startMarqueen();
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41664i.clear();
        }
    }

    public T getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f41664i;
            if (coverFlowLocalAdapter == null) {
                return null;
            }
            return coverFlowLocalAdapter.getItem(i2);
        }
        return (T) invokeI.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f41664i;
            if (coverFlowLocalAdapter == null || !this.r || (count = coverFlowLocalAdapter.getCount()) <= 1) {
                return false;
            }
            int currentItem = this.f41660e.getCurrentItem();
            int i2 = count - 2;
            if (currentItem < 1) {
                this.f41660e.setCurrentItem(i2, false);
                this.f41660e.invalidate();
            } else if (currentItem > i2) {
                this.f41660e.setCurrentItem(1, false);
                this.f41660e.invalidate();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && m()) {
            resetMarqueen();
        }
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            q(context);
            p(context);
            setCoverFlowFactory(new c.a.s0.s.w.b.b());
            addView(this.f41660e);
            addView(this.f41661f);
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = new CoverFlowLocalAdapter<>(context);
            this.f41664i = coverFlowLocalAdapter;
            coverFlowLocalAdapter.setOnClickListener(this.p);
            this.f41660e.setAdapter(this.f41664i);
            this.f41660e.setOnPageChangeListener(this.q);
        }
    }

    public void onChangeSkinType() {
        c.a.s0.s.w.b.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f41664i.onChangeSkinType();
            IndicatorView indicatorView = this.f41661f;
            if (indicatorView == null || (cVar = this.f41662g) == null) {
                return;
            }
            indicatorView.setDrawable(SkinManager.getDrawable(cVar.a()));
            this.f41661f.setSelector(SkinManager.getDrawable(this.f41662g.b()));
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            IndicatorView indicatorView = new IndicatorView(context);
            this.f41661f = indicatorView;
            indicatorView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            this.f41660e = new ListViewPager(context);
        }
    }

    public final void r() {
        CoverFlowLocalAdapter<T> coverFlowLocalAdapter;
        int count;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f41660e == null || (coverFlowLocalAdapter = this.f41664i) == null || (count = coverFlowLocalAdapter.getCount()) <= 1) {
            return;
        }
        int currentItem = this.f41660e.getCurrentItem();
        int i2 = count - 2;
        if (currentItem < 1) {
            this.f41660e.setCurrentItem(i2, false);
        } else if (currentItem > i2) {
            this.f41660e.setCurrentItem(1, false);
        } else {
            this.f41660e.setCurrentItem(currentItem + 1);
        }
        this.f41660e.invalidate();
    }

    public void resetMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f41666k.removeMessages(1);
            this.f41666k.sendEmptyMessageDelayed(1, this.s);
        }
    }

    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    public void setCallback(c.a.s0.s.w.b.d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.o = dVar;
        }
    }

    public void setCanRepeat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.r = z;
            CoverFlowLocalAdapter<T> coverFlowLocalAdapter = this.f41664i;
            if (coverFlowLocalAdapter != null) {
                coverFlowLocalAdapter.setCanRepeat(z);
            }
        }
    }

    public void setCoverFlowFactory(c.a.s0.s.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f41665j = aVar;
        c.a.s0.s.w.b.c a2 = aVar.a();
        this.f41662g = a2;
        a2.i(this.f41661f);
        aVar.c().b(this.f41660e);
        View b2 = aVar.b();
        this.f41663h = b2;
        if (b2 != null) {
            removeAllViews();
            addView(this.f41660e);
            addView(this.f41663h);
            addView(this.f41661f);
        }
    }

    public void setData(List<T> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.f41664i.setData(list, this.f41665j);
        int size = list.size();
        if (size > 1) {
            this.f41661f.setVisibility(0);
            this.f41661f.setCount(size);
            this.f41660e.setCurrentItem(0, false);
            this.f41661f.setPosition(0.0f);
            if (this.n) {
                startMarqueen();
                return;
            }
            return;
        }
        this.f41661f.setVisibility(8);
        this.f41661f.setCount(size);
        this.f41660e.setCurrentItem(0, false);
        this.f41661f.setPosition(0.0f);
        stopMarqueen();
    }

    public void setDisableParentEvent(boolean z) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (listViewPager = this.f41660e) == null) {
            return;
        }
        listViewPager.setDisableParentEvent(z);
    }

    public void setIndicatorNoOffet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.l = z;
        }
    }

    public void setIndicatorVisible(int i2) {
        IndicatorView indicatorView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (indicatorView = this.f41661f) == null) {
            return;
        }
        indicatorView.setVisibility(i2);
    }

    public void setIsAutoPlayDragging(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.m = z;
        }
    }

    public void setMarqueenTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j2) == null) {
            this.s = j2;
            resetMarqueen();
        }
    }

    public void setPageMargin(int i2) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (listViewPager = this.f41660e) == null) {
            return;
        }
        listViewPager.setPageMargin(i2);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) || (listViewPager = this.f41660e) == null) {
            return;
        }
        listViewPager.setSwipeControlInterface(cVar);
    }

    public void startMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            resetMarqueen();
        }
    }

    public void stopMarqueen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f41666k.removeMessages(1);
        }
    }

    public void updateViewPager(e eVar) {
        ListViewPager listViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) || eVar == null || (listViewPager = this.f41660e) == null) {
            return;
        }
        eVar.b(listViewPager);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverFlowLocalView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41663h = null;
        this.f41666k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41663h = null;
        this.f41666k = new b(this, null);
        this.l = false;
        this.m = true;
        this.n = true;
        this.p = new d(this, null);
        this.q = new c(this, null);
        this.s = 5000L;
        o(context);
    }
}
